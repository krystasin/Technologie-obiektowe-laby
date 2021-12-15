package strategy;

import com.sun.security.jgss.GSSUtil;
import labolatorium.Pojazd;
import state.Wolny;
import state.Zajety;
import strategy.state.AF;
import strategy.state.AP;
import strategy.state.State;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PZ implements IStrategy {
    int liczbaPotrzebnychPojazdow;
    State state;

    public PZ() {
        liczbaPotrzebnychPojazdow = 3;
        Random rand = new Random();
        if(rand.nextInt(20) == 0) state = new AF();
        else state = new AP();
    }

    public int getLiczbaPotrzebnychPojazdow() {
        return liczbaPotrzebnychPojazdow;
    }

    @Override
    public void execute(List<Pojazd> pojazdy) {

        for (Pojazd p : pojazdy)
            p.setState(new Zajety());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pojazdy.forEach(pojazd -> pojazd.setState(new Wolny()));
                pojazdy.forEach(pojazd -> System.out.println(" <- " + pojazd.getNazwa()));
                timer.cancel();
            }
        }, state.czasAkcjiIPowrotu());
    }


    @Override
    public String toString() {
        return "PZ";
    }
}
