import javax.swing.*;
import java.lang.String;
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
    private JTextArea textArea2;
    private JTextField textField1;
    private JTextArea textArea3;
    private JButton searchButton;
    private JTextField textField2;
    private JCheckBox eigenerArrayCheckBox;
    private int[] unsortiert;

    public Sorting() {
        textField2.setEnabled(false);
        comboBox1.setEnabled(true);
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        button1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                String input = comboBox1.getSelectedItem().toString();
                if (input.isEmpty()) {
                    textArea1.setText("Zahl auswählen");
                    return;
                }
                int index = Integer.parseInt(input);

                unsortiert = new int[index];

                Random rand = new Random();

                for (int i = 0; i < index; i++) {
                    unsortiert[i] = rand.nextInt(100);
                }
                textArea1.setText("");
                for (int i = 0; i < index; i++) {
                    textArea1.append(+unsortiert[i] + " ");
                    if ((i + 1) % 50 == 0) {
                        textArea1.append("\n");
                    }
                }

            }
        });
        eigenerArrayCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (eigenerArrayCheckBox.isSelected()) {
                        textField2.setEnabled(true);
                        comboBox1.setEnabled(false);
                }
                    else {
                            textField2.setEnabled(false);
                            comboBox1.setEnabled(true);
                            textField2.setText("");
                    }
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eigenerArrayCheckBox.isSelected()) {
                    try{
                        String text = textField2.getText();
                        String[] parts = text.split(" ");
                        unsortiert = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            unsortiert[i] = Integer.parseInt(parts[i].trim());
                        }
                    }catch(NumberFormatException ex){
                        for(int num :  unsortiert) {
                            textArea3.setText("Jede Zahl bitte mit einem Lerrzeichen trennen und nur Zahlen eigeben");
                        }
                    }

                }
                String input = comboBox2.getSelectedItem().toString();
                if (input.isEmpty()) {
                    textArea2.setText("Sorting Methode auswählen");
                    return;
                }
                if (input.equals("Bubble Sort")) {
                    for (int k = 0; k < unsortiert.length - 1; k++) {
                        for (int i = 0; i < unsortiert.length - k - 1; i++) {
                            if (unsortiert[i] > unsortiert[i+1]) {
                                int temp = unsortiert[i];
                                unsortiert[i] = unsortiert[i+1];
                                unsortiert[i+1] = temp;
                            }
                        }
                    }
                } else if (input.equals("Insertion Sort")) {
                    for (int i = 0; i < unsortiert.length - 1; i++) {
                        for (int j = 0; j < unsortiert.length - i - 1; j++) {
                            if (unsortiert[j] > unsortiert[j + 1]) {
                                int temp = unsortiert[j];
                                unsortiert[j] = unsortiert[j + 1];
                                unsortiert[j + 1] = temp;
                            }
                        }
                    }
                } else if (input.equals("Selection Sort")) {
                    for (int i = 0; i < unsortiert.length - 1; i++) {
                        int minIndex = i; // Index des kleinsten Elements
                        for (int j = i + 1; j < unsortiert.length; j++) {
                            if (unsortiert[j] < unsortiert[minIndex]) {
                                minIndex = j; // kleinsten Index merken
                            }
                        }
                        // Tauschen
                        int temp = unsortiert[minIndex];
                        unsortiert[minIndex] = unsortiert[i];
                        unsortiert[i] = temp;
                    }

                }
                textArea2.setText("");
                for (int b = 0; b < unsortiert.length; b++) {
                    textArea2.append(+unsortiert[b] + " ");
                    if ((b + 1) % 50 == 0) {
                        textArea2.append("\n");
                    }
                }
            }

        });


        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int search = Integer.parseInt(textField1.getText());
                    for (int i = 0; i < unsortiert.length; i++) {
                        if (unsortiert[i] == search) {
                            textArea3.setText("Dein gesuchter Wert befindet sich an der Stelle " + (i + 1) + " des Arrays");
                        }
                    }
                }catch(NumberFormatException ex){
                    textArea3.setText("Nur Zahlen eigeben!");
                }
            }
        });

    }

    public static void main(String[] args) {
        Sorting Frame = new Sorting();
        Frame.setContentPane(Frame.Main);
        Frame.setTitle("Sorting Maschien");
        Frame.setSize(1000, 500);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}