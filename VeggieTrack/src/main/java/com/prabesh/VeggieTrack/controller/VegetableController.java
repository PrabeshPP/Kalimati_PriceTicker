package com.prabesh.VeggieTrack.controller;

import com.prabesh.VeggieTrack.DTO.VegetableDTO;
import com.prabesh.VeggieTrack.service.impl.VegetableServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VegetableController {

    private final VegetableServiceImpl vegetableServiceImpl;
    public VegetableController(VegetableServiceImpl vegetableServiceImpl){
        this.vegetableServiceImpl = vegetableServiceImpl;
    }
    //API-END point to get all the prices for vegetabeles

    //this api-end points generates vegetables prices at the present date
    @GetMapping("/vegetables")
    public List<VegetableDTO> getAllVegetables(){
        List<VegetableDTO> list = new ArrayList<>();
        return vegetableServiceImpl.getAllVegetables();
    }

    //API-END point to get prices of only the vegetables that the users want

    //API-END point to get the price History of a particular vegetables


    //API_END Point to get the price history of the average price of the vegetables

    //API_END Point to get the price history of the max_price of the particular vegetables

    //API_END Point to get the price history of the min_price of the particular vegetables

    //API_END Point to provide the Max_price of the vegetable  at any particular day


    //API-END Point to provide the vegetable with the min_price at an particular day

    
}
