package com.prabesh.VeggieTrack.service.impl;

import com.prabesh.VeggieTrack.DAO.VegetableRepository;
import com.prabesh.VeggieTrack.DTO.VegetableDTO;
import com.prabesh.VeggieTrack.Util.VegetableComp;
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


        return vegetableDTOS;
    }

    @Override
    public List<VegetableDTO> getAllVegetablesByName(String name) {
        List<Vegetable> vegetables = vegetableRepository.findAll();
        List<VegetableDTO> vegetableDTOS = new ArrayList<>();

        for(Vegetable vegetable : vegetables) {
            String currName = vegetable.getEngName();

            if(currName.equals(name)){
                vegetableDTOS.add(new VegetableDTO(vegetable.getId(),vegetable.getEngName(),vegetable.getNepName(),
                        vegetable.getMaxPrice(),vegetable.getMinPrice(),vegetable.getAvgPrice(),vegetable.getDate()));
            }
        }

        return vegetableDTOS;
    }

    @Override
    public VegetableDTO findVegetablePrice(String name) {
        LocalDate localDate = LocalDate.now();
        List<Vegetable> vegetables = vegetableRepository.findAll();
        List<VegetableDTO> vegetableDTOS = new ArrayList<>();

        for(Vegetable vegetable: vegetables){

            String currName = vegetable.getEngName();

            if(currName.equals(name)){
                vegetableDTOS.add(new VegetableDTO(vegetable.getId(),vegetable.getEngName(),vegetable.getNepName(),
                        vegetable.getMaxPrice(),vegetable.getMinPrice(),vegetable.getAvgPrice(),vegetable.getDate()));
            }
        }

        if(vegetableDTOS.isEmpty()){
            return null;
        }


            VegetableDTO[] vegetableDTOSArr = new VegetableDTO[vegetableDTOS.size()];

            for(int i = 0; i<vegetableDTOS.size(); i++){
                vegetableDTOSArr[i] = vegetableDTOS.get(i);
            }


            Arrays.sort(vegetableDTOSArr,new VegetableComp());

            //implementing binary search Algorithm
            //This will give me the time Complexity of O(n)
            int start = 0;
            int end = vegetableDTOSArr.length-1;


            while(start<=end){
                int mid = start+(end-start)/2;
                //to convert the Date class to the local Variable
                LocalDate date =
                        vegetableDTOSArr[mid].getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if(date.isEqual(localDate)){
                    return vegetableDTOSArr[mid];
                }else if(date.isAfter(localDate)){
                    end--;
                }else{
                    start++;
                }



            }

            return null;

    }



    // this method uses another method as a helper method, it helps in reducing the overhead calculation
    //saving the computation power.
    @Override
    public List<String> getAverageVegetablePrices(String name) {
        List<VegetableDTO> vegetableDTOS = getAllVegetablesByName(name);
        if(vegetableDTOS == null){
            return  null;
        }
        List<String> avgPrices = new ArrayList<>();
        for(VegetableDTO currVegetable : vegetableDTOS){
                avgPrices.add(currVegetable.getAvgPrice());
        }

        return  avgPrices;
    }

    @Override
    public List<String> getMaxVegetablePrices(String productName) {
        List<VegetableDTO> vegetableDTOS = getAllVegetablesByName(productName);
        if(vegetableDTOS == null){
            return  null;
        }
        List<String> maxPrices = new ArrayList<>();
        for(VegetableDTO currVegetable : vegetableDTOS){
            maxPrices.add(currVegetable.getMaxPrice());
        }

        return  maxPrices;
    }

    @Override
    public List<String> getMinVegetablePrices(String productName) {
        List<VegetableDTO> vegetableDTOS = getAllVegetablesByName(productName);
        if(vegetableDTOS == null){
            return  null;
        }
        List<String> minPrices = new ArrayList<>();
        for(VegetableDTO currVegetable : vegetableDTOS){
            minPrices.add(currVegetable.getMinPrice());
        }

        return  minPrices;
    }


}
