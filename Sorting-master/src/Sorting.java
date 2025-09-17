import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class Sorting extends JFrame {
    private JPanel Main;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton sortButton;
    private JTextArea textArea1;

    public Sorting(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.getSelectedObjects();
                //System.out.println(Selec);
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Random rand = null;
                int index = Integer.parseInt(comboBox1.getSelectedObjects().toString());
                int[] unsortiert = new int[index];

                for(int i = 0; i<unsortiert.length; i++){
                    unsortiert[i] = rand.nextInt();
                    textArea1.setText();

                }

            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String index2 = comboBox2.getSelectedItem().toString();
            }
        });
    }

    public static void main(String[] args) {
        Sorting Frame = new Sorting();
        Frame.setContentPane(Frame.Main);
        Frame.setTitle("Sorting Maschien");
        Frame.setSize(1000,500);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

