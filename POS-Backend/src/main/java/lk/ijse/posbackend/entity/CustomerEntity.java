package lk.ijse.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {
    String id;
    String name;
    String address;
    String email;
    String contact;
}
