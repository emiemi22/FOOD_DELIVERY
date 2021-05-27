package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Main view.
 */
public class MainView extends JFrame{
    private JButton clientButton = new JButton("Client") ;
    private JButton administratorButton= new JButton("Administrator") ;
    private JButton employeeButton = new JButton("Employee") ;
    private JButton registerButton = new JButton("Register") ;
    private JTextField userText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();


    /**
     * Instantiates a new Main view.
     */
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
        panelOne.add(registerButton);
        panelOne.setLayout(new FlowLayout());
     //   panelOne.setBackground(new Color(45,25,25));
        panelOne.setBounds(75,250,300,70);

        JPanel allPanels = new JPanel();
        allPanels.add(panelUser);
        allPanels.add(panelPass);
        allPanels.add(panelOne);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }

    /**
     * Gets user text.
     *
     * @return the user text
     */
    public String getUserText() {
        return userText.getText();
    }

    /**
     * Gets password text.
     *
     * @return the password text
     */
    public String getPasswordText() {
        return passwordText.getText();
    }

    /**
     * Add adm button listener.
     *
     * @param adm the adm
     */
    public void addAdmButtonListener(ActionListener adm) {
        administratorButton.addActionListener(adm);
    }

    /**
     * Add client button listener.
     *
     * @param adm the adm
     */
    public void addClientButtonListener(ActionListener adm) {
        clientButton.addActionListener(adm);
    }

    /**
     * Add employee button listener.
     *
     * @param adm the adm
     */
    public void addEmployeeButtonListener(ActionListener adm) {
        employeeButton.addActionListener(adm);
    }

    /**
     * Add register button listener.
     *
     * @param adm the adm
     */
    public void addRegisterButtonListener(ActionListener adm){ registerButton.addActionListener(adm);

    }


}
