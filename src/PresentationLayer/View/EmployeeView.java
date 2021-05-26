package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
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
