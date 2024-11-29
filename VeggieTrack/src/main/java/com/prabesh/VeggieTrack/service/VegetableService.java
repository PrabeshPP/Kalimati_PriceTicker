package com.prabesh.VeggieTrack.service;

import com.prabesh.VeggieTrack.DTO.VegetableDTO;

import java.util.List;

public interface VegetableService {

    public List<VegetableDTO> getAllVegetables();

    public List<VegetableDTO> getAllVegetablesByName(String name);

    public VegetableDTO findVegetablePrice(String name);
}
