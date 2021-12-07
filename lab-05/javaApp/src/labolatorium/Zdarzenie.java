package labolatorium;

import labolatorium.Pojazd;
import strategy.IStrategy;
import strategy.MZ;
import strategy.PZ;
import vectors.IVector;
import vectors.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zdarzenie {


    private IVector polozenie;
    private IStrategy strategy;
    private List<Pojazd> pojazdy = new ArrayList<>();


    public Zdarzenie() {
        Random rand = new Random();
        double x = 49.95855025648944 + rand.nextDouble() * 0.196013756852294;
        double y = 20.02470275868903 + rand.nextDouble() * 0.336410275946636;
        polozenie = new Vector2D(x, y);
        if (rand.nextInt(10) < 3) strategy = new PZ();
        else strategy = new MZ();
    }


    public void dodajPojazd(Pojazd pojazd) {

        try {
            pojazdy.add(pojazd);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void execute() {
        strategy.execute(pojazdy);
    }


    public IStrategy getStrategy() {
        return strategy;
    }

    public IVector getPolozenie() {
        return polozenie;
    }

    public double distance(IVector vector) {
        return polozenie.distance(vector);
    }

    @Override
    public String toString() {
        return "Zdarzenie " + strategy;
    }


}
