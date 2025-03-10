package Views;

import Controllers.AppointmentListController;
import Controllers.InvoiceController;
import Models.Doctor;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentsListView extends JFrame{
    public JComboBox comboBox1;
    private JButton reserveAppointmentButton;
    private JPanel AList;
    public JLabel labeldoc;
    String drugss;
    AppointmentListController controller;
    public AppointmentsListView(Doctor d, Patient p, Drug[] dd, Appointment[] Allapps, double total, AppointmentListController controller){
        setContentPane(AList);
        this.controller = controller;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)(screenSize.width * 0.8),(int)(screenSize.height * 0.8));
        setLocationRelativeTo(null);
        for (Appointment a : Allapps){
            comboBox1.addItem("Doctor: "+d.getName() + ", Date: "+a.getDate());
        }
        labeldoc.setText(d.getName()+"'s Available Appointments");
        reserveAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<dd.length;i++){
                    drugss+=dd[i].getDrugName()+", ";
                }
                String datePart = comboBox1.getSelectedItem().toString().substring(comboBox1.getSelectedItem().toString().indexOf("Date:") + 6); // +6 to skip "Date: "
                controller.reserve(String.valueOf(total) , p , d , drugss, datePart);

                //InVoiceView i = new InVoiceView(d.getDRid(),p.getId());
//                i.textField3.setText(String.valueOf(total));
//                i.PatientTF.setText(p.getName());
//                i.DoctorTF.setText(d.getName());
//                i.PatientTF.setEnabled(false);
//                i.DoctorTF.setEnabled(false);
//                i.textField1.setEnabled(false);
//                i.textField3.setEnabled(false);
//                i.textField1.setText(drugss);
//                i.setVisible(true);
            }
        });
    }

}
