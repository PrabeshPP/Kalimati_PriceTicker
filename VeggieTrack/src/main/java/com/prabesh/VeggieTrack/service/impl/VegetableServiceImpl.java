package com.prabesh.VeggieTrack.service.impl;

import com.prabesh.VeggieTrack.DAO.VegetableRepository;
import com.prabesh.VeggieTrack.DTO.VegetableDTO;
import com.prabesh.VeggieTrack.model.Vegetable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class VegetableServiceImpl implements com.prabesh.VeggieTrack.service.VegetableService {

    private final VegetableRepository vegetableRepository;
    public VegetableServiceImpl(VegetableRepository vegetableRepository){
            this.vegetableRepository = vegetableRepository;
    }
    @Override
    public List<VegetableDTO> getAllVegetables() {

        LocalDate localDate = LocalDate.now();
        List<Vegetable> vegetables = vegetableRepository.findAll();
        List<VegetableDTO> vegetableDTOS = new ArrayList<>();

        for(Vegetable vegetable : vegetables){

            //This function converts the date from the Database to the local database where the user is located
            // in-order to provide the price ticker for the vegetables in a particular given day

            LocalDate date = vegetable.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if(date.isEqual(localDate)){
                vegetableDTOS.add(new VegetableDTO(vegetable.getId(),vegetable.getEngName(),vegetable.getNepName(),
                        vegetable.getMaxPrice(),vegetable.getMinPrice(),vegetable.getAvgPrice(),vegetable.getDate()));
            }
        }

        System.out.println(Arrays.toString(vegetableDTOS.toArray()));

        return vegetableDTOS;
    }


}
