import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Toolkit;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel iconPnl; //top
    JPanel displayPnl; //middle
    JPanel controlPnl; //bottom
    JLabel iconLbl;
    ImageIcon FTIcon;
    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn;
    JButton fortuneBtn;

    ArrayList<String> fortunes = new ArrayList<>();
    Random rnd;
    int i = -1;
    int randIndex;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);
        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);
        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(450,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        fortunes.add("You will get an 'A' on this assignment");
        fortunes.add("You will be rich");
        fortunes.add("Good future you wil have");
        fortunes.add("Do a good deed today");
        fortunes.add("A faithful friend is a a strong defense");
        fortunes.add("A fresh start will put you on your way");
        fortunes.add("Every good and perfect gift is from above");
        fortunes.add("Be careful who you trust");
        fortunes.add("The Bengals will win the super bowl");
        fortunes.add("You will have a great weekend");
        fortunes.add("Every new beginning comes from some other beginning's end");
        fortunes.add("Little by little, one travels far");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3 *(screenWidth / 4), 3 *(screenHeight / 4));
        setLocationRelativeTo(null);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);

        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            rnd = new Random();
            do
            {
                randIndex = rnd.nextInt(12);
            }
            while(randIndex == i);
            String fortune = fortunes.get(randIndex);
            i = randIndex;
            fortuneTA.append("Your fortune: " + fortune + "\n");
        });
        fortuneBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        controlPnl.add(quitBtn);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(20,60);
        fortuneTA.setFont(new Font("Times New Roman", Font.ITALIC,12));
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        FTIcon = new ImageIcon("src/FortuneTeller.jpg");
        Image image = FTIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        iconLbl = new JLabel("Fortune Teller", scaledIcon, JLabel.CENTER);
        iconLbl.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);
        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setVerticalAlignment(JLabel.CENTER);
        iconLbl.setHorizontalAlignment(JLabel.CENTER);
        iconPnl.add(iconLbl);
    }
}
