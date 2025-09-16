import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorting extends JFrame {
    private JPanel Main;
    private JButton button1;

    public Sorting(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        Sorting Frame = new Sorting();
        Frame.setContentPane(Frame.Main);
        Frame.setTitle("Sorting Maschien");
        Frame.setSize(1000,1000);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

