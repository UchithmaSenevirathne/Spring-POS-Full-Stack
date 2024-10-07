package lk.ijse.posbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String oId;
    private String date;
    private double total;
    private String customerId;
    private List<OrderDetailsDTO> orderDetails;
}
