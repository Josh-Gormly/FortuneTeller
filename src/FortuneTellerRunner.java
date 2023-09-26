import javax.swing.*;

public class FortuneTellerRunner
{
    public static void main(String[] args)
    {
       FortuneTellerFrame frame = new FortuneTellerFrame();

       frame.setTitle("Fortune Teller");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setVisible(true);
    }
}