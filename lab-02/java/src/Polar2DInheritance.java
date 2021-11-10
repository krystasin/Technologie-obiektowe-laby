import java.lang.Math;
public class Polar2DInheritance extends Vector2D{


    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle(){
        Vector2D ox = new Vector2D(1,0);
        double cosA = this.cdot(ox) / (this.abs() * ox.abs());
        return Math.toDegrees(Math.acos(cosA));
    }
}
