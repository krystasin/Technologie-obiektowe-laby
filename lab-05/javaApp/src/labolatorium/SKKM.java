package labolatorium;

import java.util.*;

import iterator.Aggregate;
import iterator.Iterator;
import iterator.JednostkaIterator;
import state.Wolny;
import state.Zajety;
import strategy.IStrategy;
import strategy.PZ;
import vectors.Vector2D;

import static java.lang.Thread.activeCount;
import static java.lang.Thread.sleep;


public class SKKM {
    private boolean bool_rozsylaj = true;
    private String miasto;
    private List<Jednostka> jednostki = new ArrayList<>();
    private TreeMap<Double, Jednostka> odleglosci = new TreeMap<>();
    private Aggregate aggregate = new JednostkaAggregate();


    public SKKM(String miasto) {
        this.miasto = miasto;
        this.initializeJednostki();
    }

    public void start() {
        generateEventsInLoop();
    }

    private void generateEventsInLoop() {
        Random random = new Random();
        int randomDelay = random.nextInt(4) * 1000 + 500;

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                noweZdarzenie();
                if (bool_rozsylaj)
                    generateEventsInLoop();
                timer.cancel();

            }
        }, randomDelay);
        znajdzWolnePojazdy(new PZ());
    }

    private void znajdzWolnePojazdy(IStrategy strategy) {

    }


    private void noweZdarzenie() {

        Zdarzenie zdarzenie = new Zdarzenie();
        List<Pojazd> pojazdyDoWyslania = wyslijPowiadomienia(zdarzenie);

        pojazdyDoWyslania.forEach(p -> zdarzenie.dodajPojazd(p));


        zdarzenie.execute();

    }


    private List<Pojazd> wyslijPowiadomienia(Zdarzenie z) {
        List<Pojazd> pojazdyDoWyslania = new ArrayList<>();
        int liczbaPotrzebnychPojazdow = z.getStrategy().getLiczbaPotrzebnychPojazdow();

        odleglosci.clear();     // stworzenie TreeMap-y
        jednostki.forEach((j) -> odleglosci.put(j.distance(z.getPolozenie()), j));
        int i = 0;
        Iterator it = aggregate.iterator();
        while (it.hasNext() && liczbaPotrzebnychPojazdow > 0) {

            Jednostka jednostka = (Jednostka) it.next();
            pojazdyDoWyslania.addAll(jednostka.otrzymajPowiadomienie(liczbaPotrzebnychPojazdow));
            liczbaPotrzebnychPojazdow = z.getStrategy().getLiczbaPotrzebnychPojazdow() - pojazdyDoWyslania.size();
        }
//todo alternatywne rozwiązanie
/*            while(it.hasNext() || liczbaPotrzebnychPojazdow > 0){
                try{
                    Jednostka jednostka = (Jednostka) it.next();
                    pojazdyDoWyslania.addAll(jednostka.otrzymajPowiadomienie(liczbaPotrzebnychPojazdow));
                }
                catch (Exception e){
                    i++;
                    System.out.println("brak aut " + i);
                    it = aggregate.iterator();
                    if(i==100){
                        i=0;
                        jednostki.forEach((jednostka -> jednostka.getPojazdy().forEach(pojazd -> pojazd.setState(new Wolny()))));
                    }
                }
            }*/


        System.out.println(z.toString());
        pojazdyDoWyslania.forEach((p) -> {
            System.out.println(" -> " + p.getNazwa()  );
        });
        System.out.println("\n");

        return pojazdyDoWyslania;
    }


    private void initializeJednostki() {
        jednostki.add(new Jednostka("JRG-2", new Vector2D(50.03341506191434, 19.935861796848272)));
        jednostki.add(new Jednostka("JRG-3", new Vector2D(50.07572598831536, 19.887307026459375)));
        jednostki.add(new Jednostka("JRG-4", new Vector2D(50.03886690486807, 20.00572924790332)));
        jednostki.add(new Jednostka("JRG-5", new Vector2D(50.09248536037272, 19.92225148427759)));
        jednostki.add(new Jednostka("JRG-6", new Vector2D(50.01652717056048, 20.015524956751246)));
        jednostki.add(new Jednostka("JRG-7", new Vector2D(50.09413472088974, 19.977464982135483)));
        jednostki.add(new Jednostka("JRG Skawina", new Vector2D(49.96835064053052, 19.79952867750824)));
        jednostki.add(new Jednostka("Szkoła Aspirantów PSP", new Vector2D(50.077085105831465, 20.032650739414546)));
        jednostki.add(new Jednostka("LSP w Balicach", new Vector2D(50.07325705653451, 19.78584625529576)));
    }


    public class JednostkaAggregate implements Aggregate {

        @Override
        public Iterator iterator() {
            if (odleglosci.size() == 0) return null;
            return new JednostkaIterator(odleglosci);
        }
    }


}
