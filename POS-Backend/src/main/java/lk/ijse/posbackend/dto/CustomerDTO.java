package lk.ijse.posbackend.dto;

import lk.ijse.posbackend.customobj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO, CustomerResponse {
    String id;
    String name;
    String address;
    String email;
    String contact;
}
