package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Menager menager = new Menager();


/*

        List<String> names = new ArrayList<>();
        names.add("adam");
        NamePart namePart = new NamePart(names, new Position(44,55));


        JSONObject obj = new JSONObject();


*/


/*

        final String filepath="save.bin";
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(namePart);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

*/







        menager.setRecord("Arek", new Position(1, 1));
        menager.setRecord("Arek", new Position(1, 2));
        menager.setRecord("Arek", new Position(1, 2));

        menager.setRecord("Arek Baret", new Position(1, 3));
        menager.setRecord("Darek", new Position(1, 2));
        menager.setRecord("Darek", new Position(1, 2));
        menager.setRecord("Darek Arek", new Position(1, 2));

     //   menager.setRecord("Arek Carek", new Position(1, 3));
        menager.setRecord("Arek Carek serek", new Position(5, 3));

/*
        menager.setRecord("Arek Tomasz", new Position(3, 3));

        menager.setRecord("Darek Arek", new Position(1, 2));
        menager.setRecord("Darek Olek Warek", new Position(6, 3));
        menager.setRecord("Darek Warek Warek", new Position(7, 3));

*/


        /*
        try {
            menager.addRecord();
        }
        catch (Exception e){

            System.out.println(e);
        }
*/

        System.out.println();

        menager.wypisz();
        menager.zapiszDoPliku();
   //     menager.zaladujDaneZPliku();
        menager.wypisz2();

        menager.start();
    }
}
