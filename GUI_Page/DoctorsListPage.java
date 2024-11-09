package GUI_Page;
import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsListPage extends JFrame{
    public DefaultListModel<String> listModel = new DefaultListModel<>();
    public JComboBox DoctorCBox;
    private JButton SubmitButton;
    private JPanel DList;
    public JTextArea textArea1;
    private Patient p;
    public String [] Docs;
    public Doctor[] Alldocs;
    public DoctorsListPage(Patient p){
        this.p=p;
        this.setContentPane(DList);
        setSize(500,500);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor chosendoctor=new Doctor();
                for (Doctor d : Alldocs){
                    if(d.getName().equals(DoctorCBox.getSelectedItem())){
                        chosendoctor = d;
                    }
                }
                AppointmentsList AppList = new AppointmentsList(chosendoctor);
                AppointmentController cont = new AppointmentController(new Appointment(chosendoctor),AppList);
                cont.updateAppointmentListView();
                AppList.setVisible(true);
            }
        });
    }
    public DoctorsListPage() {
        this.setContentPane(DList);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });
    }
    public boolean ReadDocsList(String [] d){
        Docs=d;
        System.out.println(d[0]);
        return true;
    }
}
