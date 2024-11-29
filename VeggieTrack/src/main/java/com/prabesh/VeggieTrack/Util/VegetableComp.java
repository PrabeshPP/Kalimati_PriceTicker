package com.prabesh.VeggieTrack.Util;

import com.prabesh.VeggieTrack.DTO.VegetableDTO;

import java.util.Comparator;

/*
   This class sort the vegetable according to the date for finding the particular vegetable for a given date
 */
public class VegetableComp implements Comparator<VegetableDTO> {
    @Override
    public int compare(VegetableDTO o1, VegetableDTO o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
