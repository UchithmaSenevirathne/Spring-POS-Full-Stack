package lk.ijse.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsEntity {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private int qty;
    private double unitPrice;
    private double total;
}
