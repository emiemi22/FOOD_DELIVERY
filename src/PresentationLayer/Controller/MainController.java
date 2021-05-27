package PresentationLayer.Controller;

import BusinessLayer.DeliveryService;
import BusinessLayer.Login;
import PresentationLayer.View.*;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Main controller.
 */
public class MainController {
    private MainView mainView ;
    private DeliveryService deliveryService ;
    private Login login ;

    /**
     * Instantiates a new Main controller.
     */
    public MainController(){
        mainView = new MainView();
        deliveryService = new DeliveryService(); /// create a new delivery service
        mainView.addAdmButtonListener(new AdminListener());
        mainView.addClientButtonListener(new ClientListener());
        mainView.addEmployeeButtonListener(new EmployeeListener());
        mainView.addRegisterButtonListener(new RegisterListener());
    }

    /**
     * The type Client listener.
     */
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

    /**
     * The type Admin listener.
     */
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

    /**
     * The type Employee listener.
     */
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

    /**
     * The type Register listener.
     */
    class RegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String username , password;
            username = mainView.getUserText();
            password = mainView.getPasswordText();
            System.out.println("Register new person");
            deliveryService.addNewPerson(username,password,1);
        }
    }
}
