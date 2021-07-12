package com.catalyst.assignment.controllers;

import com.catalyst.assignment.entities.Accessory;
import com.catalyst.assignment.entities.Gadget;
import com.catalyst.assignment.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gadget")
public class GadgetController {

    @Autowired
    GadgetService gadgetService;

    @PutMapping("/update")
    Gadget update(@RequestBody Gadget gadget){
        return gadgetService.update(gadget);
    }

    @PostMapping("/add")
    Gadget add(@RequestBody Gadget gadget){
        return gadgetService.add(gadget);
    }


    @DeleteMapping("/delete")
    void deleteAccessory(@RequestBody Gadget gadget){
        gadgetService.delete(gadget);
    }
}
