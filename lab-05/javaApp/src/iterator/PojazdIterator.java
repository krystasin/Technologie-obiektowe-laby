package iterator;

import labolatorium.Jednostka;
import labolatorium.Pojazd;

import java.util.List;

public class PojazdIterator implements Iterator {
    private int currentPosition;
    private List<Pojazd> pojazdy;

    public PojazdIterator(List<Pojazd> pojazdy) {
        this.currentPosition = -1;
        this.pojazdy = pojazdy;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < pojazdy.size()-1;
    }

    @Override
    public Object next() {
        if(this.hasNext())
            return pojazdy.get(++currentPosition);
        return null;
    }

    @Override
    public void doSomething(){};
}
