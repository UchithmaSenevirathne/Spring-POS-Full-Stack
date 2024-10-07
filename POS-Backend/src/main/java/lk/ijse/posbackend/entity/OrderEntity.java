package lk.ijse.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity implements SuperEntity {
    private String oId;
    private String date;
    private double total;
    private String customerId;
}
