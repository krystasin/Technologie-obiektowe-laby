package strategy.state;

import java.util.Random;
import java.util.Timer;

public class AF implements State{
    @Override
    public int czasAkcjiIPowrotu() {
        Random rand = new Random();
        int czasPowrotu = rand.nextInt(30) * 100;
        return czasPowrotu;
    }

    @Override
    public String toString() {
        return "AF";
    }
}
