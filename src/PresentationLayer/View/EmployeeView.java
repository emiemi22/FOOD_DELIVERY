package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;

/**
 * The type Employee view.
 */
public class EmployeeView extends JFrame {
    /**
     * Instantiates a new Employee view.
     */
    public EmployeeView(){
        this.setTitle("Employee Frame");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
    }
}
