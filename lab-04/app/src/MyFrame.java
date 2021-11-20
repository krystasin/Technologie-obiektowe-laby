import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {


    MyPanel panel;


    public MyFrame() {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void draw(){
        panel.paint(getGraphics());
    }
}
