package PresentationLayer.Controller;

import BusinessLayer.DeliveryService;
import BusinessLayer.Login;
import DataLayer.Serializator;
import PresentationLayer.View.*;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * The type Main controller.
 */
public class MainController {
    private MainView mainView ;
    private DeliveryService deliveryService ;
    private Serializator serializator = new Serializator();
    /**
     * Instantiates a new Main controller.
     */
    public MainController(){

        mainView = new MainView();
        //deliveryService = new DeliveryService(); /// create a new delivery service
        try {
            deliveryService = serializator.deserialize("serialize.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainView.addAdmButtonListener(new AdminListener());
        mainView.addClientButtonListener(new ClientListener());
        mainView.addEmployeeButtonListener(new EmployeeListener());
        mainView.addRegisterButtonListener(new RegisterListener());
        mainView.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("  EXIT MAIN FRAME  ");
                serializator.serialize(deliveryService,"serialize.txt");
            }
        });
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
                EmployeeView emp = new EmployeeView();
                emp.setFrameVisible(true);
                EmployeeController employeeController = new EmployeeController();
                deliveryService.addObserver(employeeController);
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
