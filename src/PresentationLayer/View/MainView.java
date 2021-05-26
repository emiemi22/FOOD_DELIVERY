package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
    private JButton clientButton = new JButton("Client") ;
    private JButton administratorButton= new JButton("Administrator") ;
    private JButton employeeButton = new JButton("Employee") ;
    private JTextField userText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();


    public MainView(){
        this.setTitle("LOG IN");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        JPanel panelUser = new JPanel() ;
        panelUser.add(new JLabel("   User ID"));
        userText.setPreferredSize(new Dimension(100, 30));
        panelUser.setBounds(10 , 100 , 400 , 50);
      //  panelUser.setBackground(new Color(45,25,255));
        panelUser.add(userText);

        JPanel panelPass = new JPanel() ;
        panelPass.add(new JLabel("Password"));
        panelPass.setBounds(10 , 160 , 400 , 50);
     //   panelPass.setBackground(new Color(45,25,255));
        passwordText.setPreferredSize(new Dimension(100, 30));
        panelPass.add(passwordText);

        JPanel panelOne = new JPanel() ;
        panelOne.add(clientButton);
        panelOne.add(administratorButton);
        panelOne.add(employeeButton);
        panelOne.setLayout(new FlowLayout());
     //   panelOne.setBackground(new Color(45,25,25));
        panelOne.setBounds(75,250,300,50);

        JPanel allPanels = new JPanel();
        allPanels.add(panelUser);
        allPanels.add(panelPass);
        allPanels.add(panelOne);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }

    public String getUserText() {
        return userText.getText();
    }

    public String getPasswordText() {
        return passwordText.getText();
    }

    public void addAdmButtonListener(ActionListener adm) {
        administratorButton.addActionListener(adm);
    }
    public void addClientButtonListener(ActionListener adm) {
        clientButton.addActionListener(adm);
    }
    public void addEmployeeButtonListener(ActionListener adm) {
        employeeButton.addActionListener(adm);
    }


}
