package lk.ijse.posbackend.service;

import lk.ijse.posbackend.dto.OrderDTO;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDTO);
}
