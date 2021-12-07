package strategy;

import labolatorium.Pojazd;

import java.util.List;

public interface IStrategy {

     int getLiczbaPotrzebnychPojazdow();
     void execute(List<Pojazd> pojazd);

}
