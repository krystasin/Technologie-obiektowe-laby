package strategy.state;

import java.util.Random;
import java.util.Timer;

public class AP implements State{

    @Override
    public int czasAkcjiIPowrotu() {

        Random rand = new Random();
        Timer timer = new Timer();
        int czasPowrotu = rand.nextInt(30) * 100;
        int czasTrwaniaAkcji = 5000 + rand.nextInt(20) * 1000;
        int suma = czasPowrotu + czasTrwaniaAkcji;

        return suma;
    }
    @Override
    public String toString() {
        return "AP";
    }
}
