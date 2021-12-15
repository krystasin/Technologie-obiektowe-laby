package com.company;

import com.sun.security.jgss.GSSUtil;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class NamePart implements Serializable, Comparable<NamePart>{

    private String name;
    private TreeSet<NamePart> nextPart = new TreeSet<>();
    private List<Position> positions = new ArrayList<>();





    public NamePart(List<String> names, Position position) {

        this.name = names.get(0);
        names.remove(0);

        if(names.size() == 0)
            this.positions.add(position);
        else
            this.addNames(names, position);
    }

    public void addNames(List<String> names, Position position)
    {

        if(names.size() == 0){
            positions.add(position);
            return;
        }


        NamePart pasujacy = this.findName(names.get(0));

        if( pasujacy == null){
            NamePart np = new NamePart(names,position);
            nextPart.add( np);

        }
        else{
            names.remove(0);
            pasujacy.addNames(names, position);
        }
    }

    private NamePart findName(String newName){
        for ( NamePart np : nextPart)
            if(np.getName().equals(newName))   return np;
        return null;
    }




    public String getName() {
        return name;
    }

    @Override
    public int compareTo(NamePart o) {
        return name.compareTo(o.getName());
    }

/*    @Override
    public String toString() {
   //     String pozycje = positions.forEach(position -> { "[" + position.getX() + "," + position.getY() + "]"});
*//*        String pozycje = positions.stream()
                .forEach(position -> position.toString());*//*
        String poz = "";
        String namesTemp = "";
        for (Position p: positions             ) {
            poz = poz + p + ", ";
        }
        for (NamePart np: nextPart ) {
            namesTemp = name + np;
        }

        return name + poz;
    }*/

    @Override
    public String toString() {

        return  "{" + name +
                "," + positions +
                ",\n" + nextPart +
                '}';
    }

    public void wypisz(List<String> root) {
        root.add(this.name);
        if(positions.size() > 0){
            root.forEach(r -> System.out.print(r + " "));
            positions.forEach(position -> System.out.print(position + " "));
        System.out.println();
        }


        nextPart.forEach(next -> next.wypisz(root));
        root.remove(root.size()-1);
    }


    public void szukajPoImieniu(List<String> names, int i) {
        if (names.size() == i+1) // brak kolejnych imion
        {
            if(positions.size() > 0) {
                names.forEach(n-> System.out.print(n + " "));
                positions.forEach(p-> System.out.print(p + ", "));
                return;
            }
            else {
                System.out.println("wprowasz dokładniejsze dane");
                System.out.println("[propozycje kolejnych imion]:");
                nextPart.forEach(np -> System.out.println("-" + np.getName()));
                return;
            }
        }


        NamePart pasujacy = this.findName(names.get(i+1));

        if(pasujacy==null){
            System.out.println("brak takie osoby"); return;
        }
        pasujacy.szukajPoImieniu(names, i+1);
    }
}
