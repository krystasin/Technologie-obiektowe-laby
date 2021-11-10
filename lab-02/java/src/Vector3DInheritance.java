import java.lang.Math;

public class Vector3DInheritance extends  Vector2D{

    private double z;

    public Vector3DInheritance(double x, double y, double z ) {
        super(x, y);
        this.z = z;
    }
    public Vector3DInheritance(double x, double y ) {
        super(x, y);
        this.z = 0;
    }

    public double getZ() {
        return z;
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }


    @Override
    public double abs() {
        return Math.sqrt( super.abs() * super.abs() + z * z);
    }


    @Override
    public double cdot(IVector vec) {
        return super.cdot(vec) + z * vec.getComponents()[2];
    }

    @Override
    public double[] getComponents() {
        double[] tab = { super.getComponents()[0], super.getComponents()[1], z };
        return tab;
    }



    public Vector3DInheritance cross(IVector iVector){
        double a[] = this.getComponents();
        double b[] = { iVector.getComponents()[0], iVector.getComponents()[1], 0.0 } ;
        if(iVector.getComponents().length == 3) b[2] = iVector.getComponents()[2];
        return new Vector3DInheritance(a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2], a[0] * b[1] - a[1] * b[0]);
    }

    public IVector getSrcV(){

        return new Vector2D(getX(), getY());
    }


}
