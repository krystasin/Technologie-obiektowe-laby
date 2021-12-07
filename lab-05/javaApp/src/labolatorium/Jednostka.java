package labolatorium;

import iterator.Aggregate;
import iterator.Iterator;
import iterator.JednostkaIterator;
import iterator.PojazdIterator;
import vectors.IVector;
import vectors.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class Jednostka {
    private String nazwa;
    private IVector polozenie;
    private List<Pojazd> pojazdy;
    private Aggregate aggregate = new PojazdAggregate();


    public Jednostka(String nazwa, IVector polozenie) {
        this.nazwa = nazwa;
        this.polozenie = polozenie;
        this.pojazdy = new ArrayList<>();
        this.initializePojazdy();
    }


    private void initializePojazdy() {

        pojazdy.add(new Pojazd(nazwa + "#1",new Vector2D(polozenie)));
        pojazdy.add(new Pojazd(nazwa + "#2",new Vector2D(polozenie)));
        pojazdy.add(new Pojazd(nazwa + "#3",new Vector2D(polozenie)));
//        pojazdy.add(new Pojazd(nazwa + " 4",new Vector2D(polozenie)));
//        pojazdy.add(new Pojazd(nazwa + " 5",new Vector2D(polozenie)));
    }

    public List<Pojazd> wyslijPojazdy(int potrzebnaLiczbaPojazdow){
        Iterator it = aggregate.iterator();
        List<Pojazd> pojazdyDoWylsania = new ArrayList<>();

        while(potrzebnaLiczbaPojazdow > 0 && it.hasNext()){
            Pojazd p = (Pojazd) it.next();
            if(p.czyWolny())
                pojazdyDoWylsania.add(p);

        }
        return pojazdyDoWylsania;
    }

    public List<Pojazd> otrzymajPowiadomienie(int potrzebnaLiczbaPojazdow){

        Iterator it = aggregate.iterator();
        List<Pojazd> pojazdyDoWylsania = new ArrayList<>();

        while(potrzebnaLiczbaPojazdow > 0 && it.hasNext()){
            Pojazd p = (Pojazd) it.next();
            if(p.czyWolny()){
                pojazdyDoWylsania.add(p);
                potrzebnaLiczbaPojazdow--;
            }

        }
        return pojazdyDoWylsania;
    }

    public IVector getPolozenie() {
        return polozenie;
    }

    public int getLiczbaWolnychPojazdow(){
        int wolne = 0;
        Iterator it = aggregate.iterator();
        while (it.hasNext()){
            Pojazd p = (Pojazd) it.next();
            if(p.getState().czyJestWolny())
                wolne++;
        }

        return wolne;
    }

    public List<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public double distance(IVector vector){
        return polozenie.distance(vector);
    }
















    @Override
    public String toString() {
        return nazwa + " [" + polozenie.getX() + "," + polozenie.getY() + "]";
    }



    public class PojazdAggregate implements Aggregate {

        @Override
        public Iterator iterator() {
            if (pojazdy.size() == 0) return null;
            return new PojazdIterator(pojazdy);
        }
    }


}
