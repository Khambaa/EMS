package com.catalyst.assignment.controllers;

import com.catalyst.assignment.entities.Accessory;
import com.catalyst.assignment.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessory")
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @GetMapping("/getAll")
    List<Accessory> getAllAccessory(){
        return accessoryService.getAllAccessories();
    }

    @PutMapping("/update")
    Accessory update(@RequestBody Accessory accessory){
        return accessoryService.update(accessory);
    }

    @PostMapping("/add")
    Accessory add(@RequestBody Accessory accessory){
        return accessoryService.add(accessory);
    }

    @DeleteMapping("/delete")
    void deleteAccessory(@RequestBody Accessory accessory){
        accessoryService.delete(accessory);
    }


}
