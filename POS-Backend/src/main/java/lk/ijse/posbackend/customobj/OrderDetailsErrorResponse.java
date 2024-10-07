package lk.ijse.posbackend.customobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsErrorResponse implements Serializable , OrderDetailsResponse{
    private int errorCode;
    private String errorMessage;
}
