// Vijay Kuruvilla 10-28
import java.io.IOException;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class Driver
{
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame("Virginia Tech Sailbot");
        frame.setSize(1000 , 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI a = new GUI();
        frame.setContentPane(a);
        frame.setVisible(true);
        // a.runSim();
    }
}