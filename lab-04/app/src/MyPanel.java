import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    MyPanel(){
        this.setPreferredSize(new Dimension(800,600));
    }

    public void paint(Graphics graphics2){
        Graphics2D g = (Graphics2D) graphics2;
        g.drawLine(0,0,400,500);
    }



}
