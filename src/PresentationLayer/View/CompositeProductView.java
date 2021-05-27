package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Composite product view.
 */
public class CompositeProductView extends JFrame {

    private JButton addButton = new JButton("Add Product") ;
    private JButton doneButton = new JButton("Done") ;
    private JTextField userText = new JTextField();
    private JTextField nameText = new JTextField();

    /**
     * Instantiates a new Composite product view.
     */
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

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getnameText() {
        return nameText.getText();
    }

    /**
     * Gets user txt.
     *
     * @return the user txt
     */
    public String getUserTxt() {
        return userText.getText();
    }

    /**
     * Add btn.
     *
     * @param act the act
     */
    public void addBtn(ActionListener act){
        addButton.addActionListener(act);
    }

    /**
     * Add done btn.
     *
     * @param act the act
     */
    public void addDoneBtn(ActionListener act){
        doneButton.addActionListener(act);
    }
}
