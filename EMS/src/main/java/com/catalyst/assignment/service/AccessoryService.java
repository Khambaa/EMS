package com.catalyst.assignment.service;

import com.catalyst.assignment.entities.Accessory;
import com.catalyst.assignment.entities.AccessoryCategory;
import com.catalyst.assignment.repositories.AccessoryCategoryRepository;
import com.catalyst.assignment.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    AccessoryRepository accessoryRepository;

    @Autowired
    AccessoryCategoryRepository accessoryCategoryRepository;

    public List<Accessory> getAllAccessories() {
        return accessoryRepository.findAll();
    }

    public Accessory update(Accessory accessory) {

        Accessory existing=accessoryRepository.findById(accessory.getId()).get();
        copyNonNullAttributes(existing,accessory);
        return accessoryRepository.save(existing);
    }

    private void copyNonNullAttributes(Accessory existing, Accessory accessory) {

        if(accessory.getName()!=null)
            existing.setName(accessory.getName());
        if(accessory.getDescription()!=null)
            existing.setDescription(accessory.getDescription());
        if(accessory.getPrice()!=null)
            existing.setPrice(accessory.getPrice());
        if(accessory.getQuantity()!=null)
            existing.setQuantity(accessory.getQuantity());
        if(accessory.getCategory()!=null){
            AccessoryCategory category=accessoryCategoryRepository.findById(accessory.getCategory().getId()).get();
            existing.setCategory(category);
        }


    }

    public void delete(Accessory accessory) {
        accessoryRepository.delete(accessory);
    }

    public Accessory add(Accessory accessory) {
        return accessoryRepository.save(accessory);
    }
}
