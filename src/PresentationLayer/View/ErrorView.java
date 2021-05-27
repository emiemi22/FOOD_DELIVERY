package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;

/**
 * The type Error view.
 */
public class ErrorView extends JFrame {
    /**
     * Instantiates a new Error view.
     */
    public ErrorView(){
        this.setTitle("Login Error");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(91, 206, 201, 111));

        this.add(new JLabel("Invalid username or password!"));

    }
}
