package lk.ijse.posbackend.dto;

import lk.ijse.posbackend.customobj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements SuperDTO, ItemResponse {
    private String id;
    private String name;
    private String description;
    private Double unit_price;
}
