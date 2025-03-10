package Views;

import Controllers.AddDoctorController;
import Controllers.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddDoctorView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField textField3;
    private JTextField textField4;
    private SpinnerNumberModel gradYear = new SpinnerNumberModel(2024, 1940, 2031, 1);
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton addButton;
    private JPanel addDoctor;
    private JLabel errorMessage;
    private JLabel idlabel;
    private JTextField textField5;
    private JButton deleteDoctorButton;


    public AddDoctorView() {
        spinner1.setModel(gradYear);
        setContentPane(addDoctor);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Arrays.toString(passwordField1.getPassword()).equals(Arrays.toString(passwordField2.getPassword()))){
                    errorMessage.setText("Passwords do not match");
                    return;
                }
                String name = textField1.getText();
                String phoneNumeber = textField2.getText();
                String password = Arrays.toString(passwordField1.getPassword());
                String specialization = textField3.getText();
                String degree = textField4.getText();
                int graduationYear = (int) spinner1.getValue();
                double salary = (int) spinner2.getValue();

                //Adding new Doctor using Static Function
                String docID = AddDoctorController.AddNewDoctor(name, phoneNumeber, specialization, degree, graduationYear, salary, password);
                idlabel.setText("New Doctor Added with ID: "+ docID);
            }
        });
        deleteDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.DeleteDoctor(Integer.parseInt(textField5.getText()));
            }
        });
    }
}
