package lk.ijse.posbackend.service;

import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;

import java.util.List;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDTO);

    List<OrderDetailsDTO> getOrderDetails();
}
