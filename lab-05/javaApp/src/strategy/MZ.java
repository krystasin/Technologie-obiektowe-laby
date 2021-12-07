package strategy;

import labolatorium.Pojazd;
import state.Wolny;
import state.Zajety;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MZ implements  IStrategy{
    int liczbaPotrzebnychPojazdow = 0;
    public MZ() {
        liczbaPotrzebnychPojazdow = 2;
    }

    public int getLiczbaPotrzebnychPojazdow() {
        return liczbaPotrzebnychPojazdow;
    }

    @Override
    public void execute(List<Pojazd> pojazdy) {
        Random rand = new Random();
        Timer timer = new Timer();
        int czasPowrotu = rand.nextInt(30) * 100;
        int czasTrwaniaAkcji = 0;

        if (rand.nextInt(20) > 0)  // alarm fałszywy
            czasPowrotu = 5 + rand.nextInt(20) * 1000;


        for (Pojazd p : pojazdy)
            p.setState(new Zajety());

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pojazdy.forEach(pojazd -> pojazd.setState(new Wolny()));
                pojazdy.forEach(pojazd -> System.out.println(" <- powrócił: " + pojazd.getNazwa()));
                System.out.println();
                timer.cancel();
            }
        }, czasPowrotu + czasTrwaniaAkcji);
    }

    @Override
    public String toString() {
        return "MZ";
    }
}
