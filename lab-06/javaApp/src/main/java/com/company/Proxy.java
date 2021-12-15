package com.company;

import java.sql.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Proxy {
    NameFactory nameFactory;

    public Proxy(NameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }


    public void addNames(String fullName, Position position) {

        List<String> partsList = new ArrayList<>();
        String[] parts = fullName.split("\\s+");

        for (String name : parts)
            partsList.add(name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());


        nameFactory.addNames(partsList, position);
    }


    public void szukajPoImieniu(String fullName) {
        List<String> names = new ArrayList<>();
        try{
            String[] parts = fullName.split("\\s+");
            for (String name : parts)
                names.add(name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());

            nameFactory.szukajPoImieniu(names);
        }
        catch (Exception e){
         //   e.printStackTrace();
            return;
        }


    }
}
