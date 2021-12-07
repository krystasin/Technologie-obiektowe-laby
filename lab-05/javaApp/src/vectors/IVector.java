package vectors;

public interface IVector {

    double abs();
    double cdot( IVector iVector);
    double[] getComponents();
    double getX();
    double getY();
    void setX(double x);
    void setY(double y);
    double distance(IVector v);

}
