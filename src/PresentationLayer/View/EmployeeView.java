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
    private JTextField order    = new JTextField();
    public EmployeeView(){
        this.setTitle("Employee Frame");
        this.setSize(450,450);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setLayout(null);
        JPanel allPanels = new JPanel();
        order.setPreferredSize      (new Dimension(300, 100));
        order.setEditable(false);
        allPanels.add(new JLabel("Waiting for a order"));
        allPanels.add(order);
        this.setContentPane(allPanels);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));
    }

    public void setOrder(String order) {
        this.order.setText(order);
    }
    public void setFrameVisible(boolean bool){
        this.setVisible(bool);
    }
}
