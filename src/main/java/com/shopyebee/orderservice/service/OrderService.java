package com.shopyebee.orderservice.service;

import com.shopyebee.orderservice.dto.OrderLineItemsDto;
import com.shopyebee.orderservice.dto.OrderRequest;
import com.shopyebee.orderservice.model.Order;
import com.shopyebee.orderservice.model.OrderLineItems;
import com.shopyebee.orderservice.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    public void placeOrder(OrderRequest orderRequest){
        Order order = Order.builder().orderNo(UUID.randomUUID().toString()).
                orderLineItemsList(orderRequest.getOrderLineItemsDtoList().stream()
                        .map(orderLineItemsDto -> mapOLIDtoToOLIModel(orderLineItemsDto)).toList()).build();
         orderRepo.save(order);
    }

    private OrderLineItems mapOLIDtoToOLIModel(OrderLineItemsDto OLIDto) {
        return OrderLineItems.builder().id(OLIDto.getId()).price(OLIDto.getPrice()).skuCode(OLIDto.getSkuCode())
                .quantity(OLIDto.getQuantity()).build();
    }
}
