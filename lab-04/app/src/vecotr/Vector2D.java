package vecotr;

import static java.lang.Math.sqrt;

public class Vector2D implements IVector {

    private double x;
    private double y;
    public double getX() {        return x;    }
    public double getY() {        return y;    }

    public Vector2D(double x, double y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return sqrt(x * x + y * y);
    }


    @Override
    public double cdot(IVector vec){
        return (vec.getX() * x + vec.getY() * y);
    }

    @Override
    public double[] getComponents() {
        double[] tab = { x,y };
        return tab;
    }
}
