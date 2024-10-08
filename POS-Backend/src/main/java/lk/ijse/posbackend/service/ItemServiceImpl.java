package lk.ijse.posbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackend.customobj.ItemResponse;
import lk.ijse.posbackend.dao.ItemDAO;
import lk.ijse.posbackend.dto.ItemDTO;
import lk.ijse.posbackend.entity.ItemEntity;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.exception.ItemNotFoundException;
import lk.ijse.posbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity save = itemDAO.save(mapping.convertItemDTOToItemEntity(itemDTO));
        if (save == null){
            throw new DataPersistFailedException("cannot save item");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
       return mapping.convertItemEntityListToItemDTOList(itemDAO.findAll());
    }

    @Override
    public ItemResponse getItemById(String id) {
        if (itemDAO.existsById(id)) {
            return mapping.convertItemEntityToItemDTO(itemDAO.getReferenceById(id));
        }else {
            throw new ItemNotFoundException("item not found");
        }
    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<ItemEntity> tmp = itemDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new ItemNotFoundException("item not found");
        }else {
            tmp.get().setName(itemDTO.getName());
            tmp.get().setDescription(itemDTO.getDescription());
            tmp.get().setUnit_price(itemDTO.getUnit_price());
        }
    }

    @Override
    public void deleteItem(String id) {
        Optional<ItemEntity> tmp = itemDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new ItemNotFoundException("item not found");
        }else {
            itemDAO.deleteById(id);
        }
    }
}
