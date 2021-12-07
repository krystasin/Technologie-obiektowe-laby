package strategy;

import labolatorium.Pojazd;
import state.Wolny;
import state.Zajety;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PZ implements IStrategy {
    int liczbaPotrzebnychPojazdow;

    public PZ() {
        liczbaPotrzebnychPojazdow = 3;
    }

    public int getLiczbaPotrzebnychPojazdow() {
        return liczbaPotrzebnychPojazdow;
    }

    @Override
    public void execute(List<Pojazd> pojazdy) {
        Random rand = new Random();
        Timer timer = new Timer();
        int czasPowrotu = rand.nextInt(3) * 1000;
        int czasTrwaniaAkcji = 0;

        if (rand.nextInt(20) > 0)  // alarm fałszywy
            czasPowrotu = 5 + rand.nextInt(20) * 1000;


        for (Pojazd p : pojazdy)
            p.setState(new Zajety());

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pojazdy.forEach(pojazd -> pojazd.setState(new Wolny()));
                pojazdy.forEach(pojazd -> System.out.println("powrócił: " + pojazd.getNazwa()));
                timer.cancel();
            }
        }, czasPowrotu + czasTrwaniaAkcji);
    }


    @Override
    public String toString() {
        return "PZ";
    }
}
