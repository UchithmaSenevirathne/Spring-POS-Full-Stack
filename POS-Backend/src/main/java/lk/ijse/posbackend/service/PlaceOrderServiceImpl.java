package lk.ijse.posbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackend.dao.OrderDAO;
import lk.ijse.posbackend.dao.OrderDetailsDAO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.util.AppUtil;
import lk.ijse.posbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOId(AppUtil.createOrderId());
        orderEntity.setDate(orderDTO.getDate());
        orderEntity.setTotal(orderDTO.getTotal());
        orderEntity.setCustomerId(orderDTO.getCustomerId());

        OrderEntity save = orderDAO.save(orderEntity);

        List<OrderDetailsDTO> orderDetailsDTOS = orderDTO.getOrderDetails();

        for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {

            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

            orderDetailsEntity.setItemId(orderDetailsDTO.getItemId());
            orderDetailsEntity.setItemName(orderDetailsDTO.getItemName());
            orderDetailsEntity.setItemDescription(orderDetailsDTO.getItemDescription());
            orderDetailsEntity.setQty(orderDetailsDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailsDTO.getUnitPrice());
            orderDetailsEntity.setTotal(orderDetailsDTO.getTotal());

            orderDetailsDAO.save(orderDetailsEntity);
        }

        if(save == null){
            throw  new DataPersistFailedException("order save failed");
        }


    }

    @Override
    public List<OrderDetailsDTO> getOrderDetails() {
        return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailsDAO.findAll());
    }
}
