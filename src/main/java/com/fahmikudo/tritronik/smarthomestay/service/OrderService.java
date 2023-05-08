package com.fahmikudo.tritronik.smarthomestay.service;

import com.fahmikudo.tritronik.smarthomestay.entity.*;
import com.fahmikudo.tritronik.smarthomestay.exception.InvalidRequestException;
import com.fahmikudo.tritronik.smarthomestay.model.order.CheckInRequest;
import com.fahmikudo.tritronik.smarthomestay.model.order.OrderAdditionalRequest;
import com.fahmikudo.tritronik.smarthomestay.model.order.OrderRequest;
import com.fahmikudo.tritronik.smarthomestay.model.order.OrderResponse;
import com.fahmikudo.tritronik.smarthomestay.repository.*;
import com.fahmikudo.tritronik.smarthomestay.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderAdditionalRepository orderAdditionalRepository;

    private final OrderPaymentRepository orderPaymentRepository;
    private final RoomRepository roomRepository;
    private final AdditionalFacilitiesRepository additionalFacilitiesRepository;

    @Transactional(rollbackFor = Exception.class)
    public OrderResponse checkIn(CheckInRequest checkInRequest, User user) {

        Order newOrder = new Order();
        newOrder.setCheckInTime(checkInRequest.getCheckInTime());
        newOrder.setUser(user);
        newOrder.setNotes(checkInRequest.getNotes());

        Order order = orderRepository.save(newOrder);

        Integer totalQty = 0;
        BigDecimal totalPrice = BigDecimal.ZERO;

        List<OrderRequest> orderRequests = checkInRequest.getItemOrders();
        for (OrderRequest orderRequest : orderRequests) {
            Optional<Room> room = roomRepository.findById(orderRequest.getRoomId());
            if (!room.isPresent()) {
                throw new InvalidRequestException(ResponseStatus.INVALID_REQUEST.getMessage(), "room with id " + orderRequest.getRoomId() + " not found.");
            }

            OrderDetail newOrderDetail = new OrderDetail();
            newOrderDetail.setOrder(order);
            newOrderDetail.setRoom(room.get());
            newOrderDetail.setQty(orderRequest.getQty());
            newOrderDetail.setPrice(room.get().getPrice());
            newOrderDetail.setNotes(orderRequest.getNotes());
            OrderDetail orderDetail = orderDetailRepository.save(newOrderDetail);

            BigDecimal roomPrice = orderDetail.getPrice();
            BigDecimal sumRoomPrice = roomPrice.multiply(new BigDecimal(orderRequest.getQty()));
            BigDecimal totalRoomPrice = sumRoomPrice;
            totalQty = totalQty + orderRequest.getQty();

            List<OrderAdditionalRequest> additionalRequests = orderRequest.getAdditionalRequests();
            BigDecimal totalAdditionalPrice = BigDecimal.ZERO;
            if (!additionalRequests.isEmpty()) {
                for (OrderAdditionalRequest orderAdditionalRequest : additionalRequests) {
                    BigDecimal totalPriceAdditional = BigDecimal.ZERO;
                    Optional<AdditionalFacilities> additionalFacilities = additionalFacilitiesRepository.findById(orderAdditionalRequest.getAdditionalFacilityId());
                    if (!additionalFacilities.isPresent()) {
                        throw new InvalidRequestException(ResponseStatus.INVALID_REQUEST.getMessage(), "additional facility with id " + orderAdditionalRequest.getAdditionalFacilityId() + " not found.");
                    }
                    OrderAdditional newOrderAdditional = new OrderAdditional();
                    newOrderAdditional.setOrderDetail(orderDetail);
                    newOrderAdditional.setPrice(additionalFacilities.get().getPrice());
                    newOrderAdditional.setQty(orderAdditionalRequest.getQty());
                    newOrderAdditional.setAdditionalFacilities(additionalFacilities.get());
                    newOrderAdditional.setNotes(orderAdditionalRequest.getNotes());

                    totalPriceAdditional = additionalFacilities.get().getPrice().multiply(new BigDecimal(orderAdditionalRequest.getQty()));

                    totalAdditionalPrice = totalAdditionalPrice.add(totalPriceAdditional);

                    orderAdditionalRepository.save(newOrderAdditional);
                }
            }

            totalPrice = totalRoomPrice.add(totalAdditionalPrice);

        }

        order.setTotalPrice(totalPrice);
        order.setTotalQty(totalQty);

        orderRepository.saveAndFlush(order);

        OrderPayment newOrderPayment = new OrderPayment();
        newOrderPayment.setOrder(order);
        newOrderPayment.setPaymentStatus(checkInRequest.getOrderPayment().getPaymentStatus());
        newOrderPayment.setPaymentType(checkInRequest.getOrderPayment().getPaymentType());
        newOrderPayment.setTotalAmount(checkInRequest.getOrderPayment().getTotalAmount());

        orderPaymentRepository.save(newOrderPayment);

        return new OrderResponse(order.getId());
    }


}
