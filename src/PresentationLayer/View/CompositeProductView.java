package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompositeProductView extends JFrame {

    private JButton addButton = new JButton("Add Product") ;
    private JButton doneButton = new JButton("Done") ;
    private JTextField userText = new JTextField();
    private JTextField nameText = new JTextField();

    public CompositeProductView(){
        this.setTitle("Composite Product ");
        this.setSize(450,450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        userText.setPreferredSize(new Dimension(100, 30));
        nameText.setPreferredSize(new Dimension(100, 30));

        JPanel panelName = new JPanel() ;
        panelName.add(new JLabel(" Name:"));
        panelName.setBounds(10 , 100 , 400 , 50);
        panelName.add(nameText);

        JPanel panelUser = new JPanel() ;
        panelUser.add(new JLabel(" Add a product"));
        panelUser.setBounds(10 , 150 , 400 , 50);
        panelUser.add(userText);

        JPanel buttonsP = new JPanel() ;
        buttonsP.setBounds(10 , 200 , 400 , 50);
        buttonsP.add(addButton);
        buttonsP.add(doneButton);

        JPanel allPanels = new JPanel();
        allPanels.add(panelName);
        allPanels.add(panelUser);
        allPanels.add(buttonsP);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);

    }
    public String getnameText() {
        return nameText.getText();
    }

    public String getUserTxt() {
        return userText.getText();
    }

    public void addBtn(ActionListener act){
        addButton.addActionListener(act);
    }

    public void addDoneBtn(ActionListener act){
        doneButton.addActionListener(act);
    }
}
