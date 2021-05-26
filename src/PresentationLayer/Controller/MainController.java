package PresentationLayer.Controller;

import BusinessLayer.DeliveryService;
import BusinessLayer.Login;
import PresentationLayer.View.*;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView ;
    private DeliveryService deliveryService ;
    private Login login ;
    public MainController(){
        mainView = new MainView();
        deliveryService = new DeliveryService(); /// create a new delivery service
        mainView.addAdmButtonListener(new AdminListener());
        mainView.addClientButtonListener(new ClientListener());
        mainView.addEmployeeButtonListener(new EmployeeListener());
    }

    class ClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String username , password;
            username = mainView.getUserText();
            password = mainView.getPasswordText();
            if (deliveryService.checkIfUserExist(username,password,1)){
                new ClientController(deliveryService , deliveryService.returnClientID(username));
            }
            else{
                new ErrorView();
            }
        }
    }
    class AdminListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String username , password;
            username = mainView.getUserText();
            password = mainView.getPasswordText();
            System.out.println(username + " " + password);
            if (deliveryService.checkIfUserExist(username,password,0) == true)
            {
                new AdminController(deliveryService);
            }
            else{
                new ErrorView();
            }
        }
    }
    class EmployeeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {String username , password;
            username = mainView.getUserText();
            password = mainView.getPasswordText();
            if (deliveryService.checkIfUserExist(username,password,3)){
                EmployeeView employeeView = new EmployeeView();
            }
            else{
                new ErrorView();
            }
        }
    }
}
