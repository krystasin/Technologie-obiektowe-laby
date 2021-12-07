package vectors;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector2D implements IVector {


    protected double x;
    protected double y;

    public Vector2D(IVector polozenie) {
        this.x = polozenie.getX();
        this.y = polozenie.getY();
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public double abs() {
        return sqrt(x * x + y * y);
    }

    @Override
    public double distance(IVector v) {
        return sqrt(pow(v.getX() - x, 2) + pow(v.getY() - y, 2));
    }



    @Override
    public double cdot(IVector vec) {
        return (vec.getX() * x + vec.getY() * y);
    }


    @Override
    public double[] getComponents() {
        double[] tab = {x, y};
        return tab;
    }


    @Override
    public String toString() {
        return "[" + x + "," + y +"]";
/*        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';*/
    }
}
