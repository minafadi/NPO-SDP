package Classes;

import GUI_Page.AppointmentsList;
import GUI_Page.DoctorsListPage;

import javax.print.Doc;

public class AppointmentController {
    private Appointment model;
    private AppointmentsList view;


    public AppointmentController(Appointment model, AppointmentsList view) {
        this.model = model;
        this.view = view;
    }
    public void updateAppointmentListView(){
        Appointment[] Allapps = model.ReadDoctorApps(model.getDoctorId());
        for (Appointment a : Allapps){
            view.comboBox1.addItem("Doctor: "+a.getDoctorNameById() + ", Date: "+a.getDate());
        }
        view.labeldoc.setText(model.getDoctorNameById()+"'s Available Appointments");
    }


}