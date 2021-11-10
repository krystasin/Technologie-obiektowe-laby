import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.Class;

public class app {

    public static void main(String[] args){

/*

        Polar2DInheritance v2dI = new Polar2DInheritance(4,4);
        double[] tab = v2dI.getComponents();
        System.out.println("v2dI: [" + tab[0] + "][" + tab[1] + "] ---  " + Math.round(v2dI.getAngle()) + "[stopni]," + Math.round(v2dI.abs()) + "[j]");

*/



        Polar2DAdapter v2dA = new Polar2DAdapter(new Vector2D(4,5));
        double[] tab = v2dA.getComponents();
        System.out.println("v2dA: [" + tab[0] + "][" + tab[1] + "] ---  (" + Math.round(v2dA.getAngle()) + "st," + Math.round(v2dA.abs()) + "j)");



        Vector3DInheritance v3dI = new Vector3DInheritance(3,2);
        tab = v3dI.getComponents();
        System.out.println("v3dI: ["+tab[0]+"]["+tab[1]+"]["+tab[2]+"]");

        IVector v3dD = new Vector3DDecorator(new Vector2D(2,3));
        tab = v3dD.getComponents();
        System.out.println("v3dD: ["+tab[0]+"]["+tab[1]+"]["+tab[2]+"]");

        System.out.println(" ---- il skalarne ---- ");
        System.out.println("v3dD i v3dI: "+v3dD.cdot(v3dI));
        System.out.println("v3dD i v3dI: "+v3dD.cdot(v3dI));
/*        System.out.println("v3dI i v2dI: "+v3dI.cdot(v2dI));
        System.out.println("v3dD i v2dI: "+v3dD.cdot(v2dI));*/



        System.out.println(" ---- il wektorowe ---- ");
        Vector3DInheritance vv = v3dI.cross(v3dD);
        tab = vv.getComponents();
        System.out.println("v3dI X v3dD: ["+tab[0]+"]["+tab[1]+"]["+tab[2]+"]");


        Vector3DInheritance vvA = v3dI.cross(v2dA);
        tab = vvA.getComponents();
        System.out.println("v3dI X v2dA: ["+tab[0]+"]["+tab[1]+"]["+tab[2]+"]");

        Vector3DDecorator vvD = ((Vector3DDecorator) v3dD).cross(v2dA);
        tab = vvD.getComponents();
        System.out.println("v3dD X v3dI: ["+tab[0]+"]["+tab[1]+"]["+tab[2]+"]");


        System.out.println("---");
    }
}