import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class OnlineBankingApp {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> new BankFrame().setVisible(true));
    }
}
