package labolatorium;

import state.State;
import state.Wolny;
import vectors.IVector;
import vectors.Vector2D;

public class Pojazd {
    private String nazwa;

    public String getNazwa() {
        return nazwa;
    }

    public IVector getPolozenie() {
        return polozenie;
    }

    private IVector polozenie;

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    public Pojazd(String nazwa, IVector polozenie) {
        this.nazwa = nazwa;
        this.polozenie = polozenie;
        this.state = new Wolny();
    }

    public Pojazd(IVector polozenie) {
        nazwa = "[pusta nazwa]";
        this.polozenie = new Vector2D(polozenie.getX(),polozenie.getY());
        this.state = new Wolny();
    }


    public State getState(){return state;}
    public boolean czyWolny(){return state.czyJestWolny();}















    @Override
    public String toString() {
        return "Pojazd{" +
                "nazwa='" + nazwa + '\'' +
                ", polozenie=" + polozenie +
                ", state=" + state +
                '}';
    }
}
