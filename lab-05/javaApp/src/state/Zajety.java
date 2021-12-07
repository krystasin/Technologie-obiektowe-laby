package state;

public class Zajety implements State{
    @Override
    public String toString() {

        return this.getClass().getName().toString();
    }

    @Override
    public boolean czyJestWolny() {
        return false;
    }
}
