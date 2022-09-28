import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class OnlineBankingApp {
    public static void main(String[] args) {
        //Set-Up GUI Visual Appearance
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> new BankFrame().setVisible(true));
    }
}
