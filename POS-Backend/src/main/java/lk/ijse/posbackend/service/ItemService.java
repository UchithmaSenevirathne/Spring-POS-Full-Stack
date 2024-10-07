package lk.ijse.posbackend.service;

import lk.ijse.posbackend.customobj.ItemResponse;
import lk.ijse.posbackend.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemResponse getItemById(String id);

    void updateItem(String id, ItemDTO itemDTO);

    void deleteItem(String id);
}
