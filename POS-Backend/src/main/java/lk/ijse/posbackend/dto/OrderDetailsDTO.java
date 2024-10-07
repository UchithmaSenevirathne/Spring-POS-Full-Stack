package lk.ijse.posbackend.dto;

import lk.ijse.posbackend.customobj.OrderDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO implements SuperDTO, OrderDetailsResponse {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;
}
