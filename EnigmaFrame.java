import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnigmaFrame extends JFrame {
    // to select rotor numbers
    static Integer[] rotorArray = { 1, 2, 3, 4, 5 };
    static JComboBox<Integer> rotorNum1;
    static JComboBox<Integer> rotorNum2;
    static JComboBox<Integer> rotorNum3;

    // input the three starting characters
    static JTextField initialPos;

    // used to provide input/output to the GUI
    private JTextArea input;
    private JTextArea output;

    // used to select encrypt and decrypt
    static JButton encryptButton;
    static JButton decryptButton;

    // label all fields shown in example (5)
    static JLabel inputLabel;
    static JLabel outputLabel;
    static JLabel inLabel;
    static JLabel outLabel;
    static JLabel midLabel;
    static JLabel initialPosLabel;

    // Jpanels to create visually please layout
    // organize different parts of your GUI,
    // like the settings and the input/output areas

    public EnigmaFrame() {
        setTitle("Enigma GUI)");
        // set the default close operation to exit the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // main panel
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(2, 1));

        // create labels for rotor selection
        rotorNum1 = new JComboBox<Integer>(rotorArray);
        rotorNum2 = new JComboBox<Integer>(rotorArray);
        rotorNum3 = new JComboBox<Integer>(rotorArray);

        initialPos = new JTextField("", 5);

        input = new JTextArea(10, 40);
        output = new JTextArea(10, 40);
        input.setLineWrap(true);
        output.setLineWrap(true);

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        // create action for encrypt button
        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int one = (int) rotorNum1.getSelectedItem();
                int two = (int) rotorNum2.getSelectedItem();
                int three = (int) rotorNum3.getSelectedItem();
                String startChar = initialPos.getText();
                Enigma enigma = new Enigma(one, two, three, startChar);
                String inputText = input.getText().trim();
                String encryptText = enigma.encrypt(inputText);
                output.setText(encryptText);
            }
        });


        // create action for decrypt button
        decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                int one = (int)rotorNum1.getSelectedItem();
                int two = (int)rotorNum2.getSelectedItem();
                int three = (int)rotorNum3.getSelectedItem();
                String startChar = initialPos.getText();
                Enigma enigma = new Enigma(one, two, three, startChar);
                String inputText = input.getText();
                String decryptText = enigma.decrypt(inputText);
                output.setText(decryptText);
            }
        });

        // create a jpanel to organize different parts of GUI and hole components
        JPanel setting = new JPanel();
        setting.setLayout(new FlowLayout());

        inLabel = new JLabel("Inner");
        outLabel = new JLabel("Out");
        midLabel = new JLabel("Middle");
        initialPosLabel = new JLabel("Initial Position");

        setting.add(inLabel);
        setting.add(rotorNum1);

        setting.add(outLabel);
        setting.add(rotorNum2);

        setting.add(midLabel);
        setting.add(rotorNum3);
        
        setting.add(initialPos);
        setting.add(initialPosLabel);

        // create input and output panel
        JPanel io = new JPanel();
        inputLabel = new JLabel("Input");
        outputLabel = new JLabel("Output");
        input = new JTextArea(10, 40);
        output = new JTextArea(10, 40);
        input.setLineWrap(true);
        output.setLineWrap(true);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        // adds functions to panels
        io.add(inputLabel);
        io.add(input);
        io.add(outputLabel);
        io.add(output);
        io.add(buttonPanel);

        // adds functions to panels
        main.add(setting);
        main.add(io);

        add(main);

        setVisible(true);
        pack();

    }
}
