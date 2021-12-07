package iterator;

import labolatorium.Jednostka;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class JednostkaIterator implements Iterator {
    private int currentPosition;
    private TreeMap<Double, Jednostka> jednostki;


    public JednostkaIterator(TreeMap<Double, Jednostka> jednostki) {
        this.currentPosition = -1 ;
        this.jednostki = jednostki;
    }


    @Override
    public boolean hasNext() {
        return currentPosition < jednostki.size() -1;
    }

    @Override
    public Object next() {
        Set<Map.Entry<Double, Jednostka>> entrySet = jednostki.entrySet();
        Map.Entry<Double, Jednostka>[] entryArray = entrySet.toArray( new Map.Entry[entrySet.size()]);

        if(this.hasNext()){
            double i = entryArray[++currentPosition].getKey();
            return entryArray[currentPosition].getValue();
        }
        return null;
    }


    @Override
    public void doSomething(){};
}
