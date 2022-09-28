import javax.swing.*;
import java.awt.*;

public class BankFrame extends JFrame {
    BankFrame(){
        this.add(new BankPanel());
        //Set basic window functionality
        ImageIcon logo = new ImageIcon("BankLogo.png");
        this.setTitle("G-Bank inc.");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setIconImage(logo.getImage());
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
