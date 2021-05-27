package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Raport view.
 */
public class RaportView extends JFrame {

    private JTextField intervalMin = new JTextField();
    private JTextField intervalMax = new JTextField();
    private JTextField productsOrderedMore = new JTextField();
    private JTextField clientsOrdered = new JTextField();
    private JTextField valueHigher= new JTextField();
    private JTextField intervalDay = new JTextField();

    private JButton generateRepBtn = new JButton("Generate Reports");

    /**
     * Instantiates a new Raport view.
     */
    public RaportView(){
        this.setTitle("Admin Frame");
        this.setSize(550,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(206, 91, 101, 111));
        intervalMin.setPreferredSize      (new Dimension(50, 30));
        intervalMax.setPreferredSize      (new Dimension(50, 30));
        valueHigher.setPreferredSize      (new Dimension(50, 30));
        intervalDay.setPreferredSize      (new Dimension(50, 30));
        clientsOrdered.setPreferredSize    (new Dimension(50, 30));
        productsOrderedMore.setPreferredSize      (new Dimension(50, 30));

        JPanel intervalPanel = new JPanel();
        intervalPanel.setBounds(0,50,300,50);
        intervalPanel.add(new JLabel(" Interval hour between"));
        intervalPanel.add(intervalMin);
        intervalPanel.add(intervalMax);

        JPanel productsMorePanel = new JPanel();
        productsMorePanel.setBounds(0,100,300,50);
        productsMorePanel.add(new JLabel(" Products ordered more than"));
        productsMorePanel.add(productsOrderedMore);

        JPanel clientsOrderedPanel = new JPanel();
        clientsOrderedPanel.setBounds(0,150,450,50);
        clientsOrderedPanel.add(new JLabel(" Clients who ordered more than"));
        clientsOrderedPanel.add(clientsOrdered);
        clientsOrderedPanel.add(new JLabel(" and value higher than"));
        clientsOrderedPanel.add(valueHigher);

        JPanel dayPanel = new JPanel();
        dayPanel.setBounds(0,200,300,50);
        dayPanel.add(new JLabel(" Products ordered in day "));
        dayPanel.add(intervalDay);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(150,250,200,50);
        buttonPanel.add(generateRepBtn);

        JPanel allPanels = new JPanel();
        allPanels.add(intervalPanel);
        allPanels.add(productsMorePanel);
        allPanels.add(clientsOrderedPanel);
        allPanels.add(dayPanel);
        allPanels.add(buttonPanel);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }

    /**
     * Gets interval min.
     *
     * @return the interval min
     */
    public String getIntervalMin() {
        return intervalMin.getText();
    }

    /**
     * Gets interval max.
     *
     * @return the interval max
     */
    public String getIntervalMax() {
        return intervalMax.getText();
    }

    /**
     * Gets products ordered more.
     *
     * @return the products ordered more
     */
    public String getProductsOrderedMore() {
        return productsOrderedMore.getText();
    }

    /**
     * Gets clients ordered.
     *
     * @return the clients ordered
     */
    public String getClientsOrdered() {
        return clientsOrdered.getText();
    }

    /**
     * Gets value higher.
     *
     * @return the value higher
     */
    public String getValueHigher() {
        return valueHigher.getText();
    }

    /**
     * Gets interval day.
     *
     * @return the interval day
     */
    public String getIntervalDay() {
        return intervalDay.getText();
    }

    /**
     * Generate rep btn.
     *
     * @param act the act
     */
    public void generateRepBtn(ActionListener act){
        generateRepBtn.addActionListener(act);
    }

}
