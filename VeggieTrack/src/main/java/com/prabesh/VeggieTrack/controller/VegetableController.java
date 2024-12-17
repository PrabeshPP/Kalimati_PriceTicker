package com.prabesh.VeggieTrack.controller;

import com.prabesh.VeggieTrack.DTO.VegetableDTO;
import com.prabesh.VeggieTrack.service.impl.VegetableServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VegetableController {

    private final VegetableServiceImpl vegetableServiceImpl;
    public VegetableController(VegetableServiceImpl vegetableServiceImpl){
        this.vegetableServiceImpl = vegetableServiceImpl;
    }


    //this api-end points generates vegetables prices at the present date
    @GetMapping("/vegetables")
    public ResponseEntity<List<VegetableDTO>> getAllVegetables(){
        return ResponseEntity.ok(vegetableServiceImpl.getAllVegetables());
    }

    //API-END point to get prices of only the vegetables that the users want
    @GetMapping("/vegetables/{engName}")
    public ResponseEntity<?> getVegetablesByName(@PathVariable String engName){

        List<VegetableDTO> vegetableDTOS = vegetableServiceImpl.getAllVegetablesByName(engName);

        if(vegetableDTOS.isEmpty()){
            return ResponseEntity.badRequest().body("The requested vegetable name does not exist in the database. We " +
                    "will soon add the request.");
        }
        return ResponseEntity.ok(vegetableDTOS);
    }

    //API-END point to get the price of a particular Vegetable in local time
    @GetMapping("/vegetables/price/{engName}")
    public ResponseEntity<?> getVegetablePrice(@PathVariable String engName){
        VegetableDTO vegetableDTO = vegetableServiceImpl.findVegetablePrice(engName);

        if(vegetableDTO == null){
           return ResponseEntity.badRequest().body("No match Found with the provided Vegetable Name");
        }


        return ResponseEntity.ok(vegetableDTO);
    }

    //API_END Point to get the price history of the average price of the vegetables
    @GetMapping("/vegetables/avgprice/{productName}")
    public ResponseEntity<?> getVegetableAveragePrice(@PathVariable String productName){
        List<String> avgPrices = vegetableServiceImpl.getAverageVegetablePrices(productName);

        if(avgPrices == null){
            return ResponseEntity.badRequest().body("No match found with the provided Vegetable Name");
        }

        return ResponseEntity.ok(avgPrices);
    }

    //API_END Point to get the price history of the max_price of the particular vegetables
    @GetMapping("/vegetables/maxprice/{productName}")
    public ResponseEntity<?> getVegetableMaxPrice(@PathVariable String productName){
        List<String> maxPrices = vegetableServiceImpl.getMaxVegetablePrices(productName);

        if(maxPrices == null){
            return ResponseEntity.badRequest().body("No match found with the provided Vegetable Name");
        }

        return ResponseEntity.ok(maxPrices);
    }


    //API_END Point to get the price history of the min_price of the particular vegetables
    @GetMapping("/vegetables/minprice/{productName}")
    public ResponseEntity<?> getVegetableMinPrice(@PathVariable String productName){
        List<String> minPrices = vegetableServiceImpl.getMinVegetablePrices(productName);

        if(minPrices == null){
            return ResponseEntity.badRequest().body("No match found with the provided Vegetable Name");
        }

        return ResponseEntity.ok(minPrices);
    }


    
}
