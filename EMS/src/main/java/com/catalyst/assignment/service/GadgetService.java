package com.catalyst.assignment.service;

import com.catalyst.assignment.entities.Accessory;
import com.catalyst.assignment.entities.Gadget;
import com.catalyst.assignment.entities.GadgetCategory;
import com.catalyst.assignment.repositories.AccessoryRepository;
import com.catalyst.assignment.repositories.GadgetCategoryRepository;
import com.catalyst.assignment.repositories.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GadgetService {

    @Autowired
    GadgetRepository gadgetRepository;

    @Autowired
    GadgetCategoryRepository gadgetCategoryRepository;

    @Autowired
    AccessoryRepository accessoryRepository;

    public Gadget update(Gadget gadget) {

            Gadget existing=gadgetRepository.findById(gadget.getId()).get();
            copyNonNullAttributes(gadget,existing);
            return gadgetRepository.save(existing);

    }

    private void copyNonNullAttributes(Gadget gadget, Gadget existing) {

        if(gadget.getName()!=null)
            existing.setName(gadget.getName());
        if(gadget.getMake()!=null)
            existing.setMake(gadget.getMake());
        if(gadget.getPrice()!=null)
            existing.setPrice(gadget.getPrice());
        if(gadget.getGadgetCategory()!=null){
            GadgetCategory category =gadgetCategoryRepository.findById(gadget.getGadgetCategory().getId()).get();
            existing.setGadgetCategory(category);
        }
        if(gadget.getAccessoryIds()!=null){
            Set<Accessory> accessorySet=new HashSet<Accessory>();
            gadget.getAccessoryIds().stream().forEach(x->{
                accessorySet.add(accessoryRepository.findById(new Long(x)).get());
            });
            existing.setAccessories(accessorySet);
        }

    }

    public void delete(Gadget gadget) {
        gadgetRepository.delete(gadget);
    }

    public Gadget add(Gadget gadget) {
        return gadgetRepository.save(gadget);
    }
}
