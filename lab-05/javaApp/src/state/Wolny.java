package state;

public class Wolny implements  State{

    @Override
    public String toString() {
        return this.getClass().getName().toString();
    }

    @Override
    public boolean czyJestWolny() {
        return true;
    }
}
