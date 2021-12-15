package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameFactory {

    private TreeSet<NamePart> namesBase = new TreeSet<>();
    private TreeSet<NamePart> namesBase2 = new TreeSet<>();
    private String tmp; //todo








    public void zapiszDoPliku() {

        String fileName = "dataStream.bin";
        List<String> namesBaseString = namesBase.stream()
                .map(NamePart::toString)
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(fileName), namesBaseString);
        } catch (IOException e) {
            System.out.println("Unable to write out names" + e);
        }

/*

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(namesBase);
            os.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }








    public void zaladujDaneZPliku() {

        System.out.println("## POCZATEK ## wczytano plik ##");
        String fileName = "dataStream.bin";


        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> namePartsString = new ArrayList<>();
            stream.forEach(s -> namePartsString.add(s));
            namePartsString.forEach(n -> System.out.println("#" + n));
         //   List<String> nameParts3 = stream.collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("## KONIEC ## wczytano plik ##");


/*        String filename = "data.bin";
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            namesBase2 = (TreeSet<NamePart>) is.readObject();
            System.out.println("wczytano.");
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }

    public void addNames(List<String> names, Position position) {

        if (names.size() == 0) return;
        NamePart pasujacy = this.findName(names.get(0));
        if (pasujacy == null) {
            NamePart np = new NamePart(names, position);
            namesBase.add(np);
        } else {
            tmp = names.get(0); //todo
            names.remove(0);
            pasujacy.addNames(names, position);
        }

    }
    public void szukajPoImieniu(List<String> names) {
        if (names.size() == 0) {            System.out.println("## nie ma takiej osoby w rejestrze"); return;        }
        NamePart pasujacy = this.findName(names.get(0));
        if(pasujacy == null){
            System.out.println("brak takie osoby");
            return;
        }
        pasujacy.szukajPoImieniu(names, 0);

    }


    private NamePart findName(String name) {
        for (NamePart nP : namesBase) if (name.equals(nP.getName())) return nP;
        return null;
    }


    public void wypisz() {
        for (NamePart np : namesBase) np.wypisz(new ArrayList<>());
    }
    public void wypisz2() {
        for (NamePart np : namesBase2) np.wypisz(new ArrayList<>());
    }


}
