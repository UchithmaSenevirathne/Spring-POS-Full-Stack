package lk.ijse.posbackend.controller;

import lk.ijse.posbackend.customobj.ItemResponse;
import lk.ijse.posbackend.dto.ItemDTO;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.exception.ItemNotFoundException;
import lk.ijse.posbackend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class Item {

    @Autowired
    private final ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                itemService.saveItem(itemDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItrById(@PathVariable("id") String id) {
        return itemService.getItemById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("id") String id, @RequestBody ItemDTO itemDTO) {
        try {
            if (itemDTO == null && (id == null || itemDTO.equals(""))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(id, itemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") String id) {
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
