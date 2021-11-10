public class Polar2DAdapter implements IPolar2D, IVector {

    private Vector2D srcVector ;

    public Polar2DAdapter(Vector2D vector2D) {
        srcVector = vector2D;
    }


    @Override
    public double getAngle(){
        Vector2D ox = new Vector2D(1,0);
        double cosA = this.cdot(ox) / (this.abs() * ox.abs());
        return Math.toDegrees(Math.acos(cosA));
    }
    @Override
    public double abs() {
        return srcVector.abs();
    }

    public double cdot(IVector iVector) {
        return srcVector.cdot(iVector);
    }

    public double[] getComponents() {
        return srcVector.getComponents();
    }


    @Override
    public double getX() {
        return srcVector.getX();
    }

    @Override
    public double getY() {
        return srcVector.getY();
    }
}
