package com.company;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.*;
import java.util.Scanner;

public class Menager {
    private NameFactory nameFactory;
    private Proxy proxy;
    Scanner scanner;
    private static final String filepath="\\save";

    public Menager() {
        this.nameFactory = new NameFactory();
        this.proxy = new Proxy(nameFactory);
        scanner = new Scanner(System.in);
    }


    public void zapiszDoPliku(){
        nameFactory.zapiszDoPliku();
    }
    public void zaladujDaneZPliku(){
        nameFactory.zaladujDaneZPliku();
    }






    public void setRecord(String fullName, Position position) {
        proxy.addNames(fullName, position);
    }

    public void addRecord() {

        String fullName = this.readName();
        if(fullName == null )return;

        Double[] pos_D = readPosition();
        if( pos_D == null)   return;

        proxy.addNames(fullName, new Position(pos_D[0], pos_D[1]));
    }

    public void wypisz() {
        nameFactory.wypisz();
    }
    public void wypisz2() {
        nameFactory.wypisz2();
    }

    private String readName(){
        System.out.println("wprowadz pełne imie i nazwisko: ");
        String str = scanner.nextLine();
        if(str.equals("quit")) return null;
        return str;
    }

    private Double[] readPosition(){

        System.out.println("\n\nwprowadz współrzędne oddzielone przecinkiem: ");
        String pos_S = scanner.nextLine();

        if(pos_S.equals("quit")) return null;
        String[] pos_SS = pos_S.split(",", 2);
        Double[] pos_D = new Double[2];
        try {
            pos_D[0] = Double.parseDouble(pos_SS[0]);
            pos_D[1] = Double.parseDouble(pos_SS[1]);
            return pos_D;
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR - niepoprawne współżędne");
            return readPosition();
        }
    }

    public void saveToFile(){
        JSONObject obj = new JSONObject();
        obj.put(nameFactory);


    }


    public void start(){
        String input;
        while(true){

        System.out.println("\n\t ### MENU ###");
        System.out.println("1. dodaj nową pozycje");
        System.out.println("2. przeszukaj baze po imieniach");
        System.out.println("3. wyświetl wszystkich");
        //String input = scanner.nextLine();
        switch (scanner.nextLine()){
            case "quit": return;
            case "1": this.addRecord();
                break;
            case "2": this.szukajPoImieniu();
                break;
            case "3": this.wypisz();
                break;
        }


        }
    }

    private void szukajPoImieniu() {
        System.out.println("wprowadz pełne imie i nazwisko: ");
        String str = scanner.nextLine();
        if(str.equals("quit")) return;
        proxy.szukajPoImieniu(str);
    }


}
