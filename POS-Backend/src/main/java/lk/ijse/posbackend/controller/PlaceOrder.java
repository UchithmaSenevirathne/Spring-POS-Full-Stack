package lk.ijse.posbackend.controller;

import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.service.PlaceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("placeOrder")
@RequiredArgsConstructor
public class PlaceOrder {

    @Autowired
    private final PlaceOrderService placeOrderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrderDTO orderDTO) {
        if (orderDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                placeOrderService.saveOrder(orderDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getOrderDetails() {
        return placeOrderService.getOrderDetails();
    }
}
