import java.lang.Math;
public class Vector3DDecorator implements IVector {

    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }
    public Vector3DDecorator(IVector srcVector ){
        this.srcVector = srcVector;
        this.z = 0;
    }

    public Vector3DDecorator cross(IVector iVector){
        double[] a = this.getComponents();
        double[] b = { iVector.getComponents()[0], iVector.getComponents()[1], 0.0 } ;
        if(iVector.getComponents().length == 3)
            b[2] = iVector.getComponents()[2];
        return new Vector3DDecorator(new Vector2D(a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2]), a[0] * b[1] - a[1] * b[0]);
    }
    @Override
    public double getY() {
        return srcVector.getY();
    }

    @Override
    public double getX() {
        return srcVector.getX();
    }

    @Override
    public double abs() {
        return Math.sqrt(srcVector.abs() + z * z);
    }

    @Override
    public double cdot(IVector iVector) {
         return srcVector.cdot(iVector) + z * iVector.getComponents()[2];
    }

    @Override
    public double[] getComponents() {
        double[] tab = {srcVector.getX(), srcVector.getY(), z };
        return tab;
    }

    public IVector getSrcV(){
        return srcVector;
    }



}
