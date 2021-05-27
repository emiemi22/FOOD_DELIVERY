package PresentationLayer.Controller;

import PresentationLayer.View.EmployeeView;

import java.util.Observable;
import java.util.Observer;

/**
 * The type Employee controller.
 */
public class EmployeeController implements Observer {
    public EmployeeController(){

    }
    @Override
    public void update(Observable observable, Object o) {
        //employeeView.setOrder(Text);
        String text = (String) o ;
        EmployeeView employeeView = new EmployeeView();
        employeeView.setFrameVisible(true);
        employeeView.setOrder(text);
    }
}
