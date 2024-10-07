package lk.ijse.posbackend.customobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemErrorResponse implements Serializable , ItemResponse{
    private int errorCode;
    private String errorMessage;
}
