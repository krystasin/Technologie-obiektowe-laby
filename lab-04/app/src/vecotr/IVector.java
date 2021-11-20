package vecotr;

public interface IVector {

    double abs();
    double cdot( IVector iVector);
    double[] getComponents();
    double getX();
    double getY();

}
