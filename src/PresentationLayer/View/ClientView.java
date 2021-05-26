package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {

    private JButton searchProductsBtn = new JButton("   Search   ");
    private JButton createNewOrderBtn = new JButton("Create Order");
    private JButton viewProductsBtn =   new JButton("View Products");
    private JButton addProductsBtn =   new JButton("Add");
    private JTextField priceText    = new JTextField();
    private JTextField idProductText    = new JTextField();

    private JTextField titleText    = new JTextField();
    private JTextField ratingText    = new JTextField();
    private JTextField caloriesText    = new JTextField();
    private JTextField proteinText    = new JTextField();
    private JTextField fatText    = new JTextField();
    private JTextField sodiumText    = new JTextField();
    private JTextField priceProductText    = new JTextField();





    public ClientView(){
        this.setTitle("Client Frame");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,750);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(245, 255, 255, 111));

        titleText.setPreferredSize(new Dimension(100, 30));
        ratingText.setPreferredSize(new Dimension(100, 30));
        caloriesText.setPreferredSize(new Dimension(100, 30));
        proteinText.setPreferredSize(new Dimension(100, 30));
        fatText.setPreferredSize(new Dimension(100, 30));
        sodiumText.setPreferredSize(new Dimension(100, 30));
        priceProductText.setPreferredSize(new Dimension(100, 30));

        priceText.setPreferredSize(new Dimension(100, 30));
        priceText.setEditable(false);
        idProductText.setPreferredSize(new Dimension(50 , 30));

        JPanel createOrderPanel = new JPanel();
        createOrderPanel.setBounds(0,50,450,100);
        createOrderPanel.add(new JLabel("Add a product "));
        createOrderPanel.add(idProductText);
        createOrderPanel.add(addProductsBtn);
        createOrderPanel.add(new JLabel("Total "));
        createOrderPanel.add(priceText);
        createOrderPanel.add(createNewOrderBtn);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(50,200,250,50);
        titlePanel.add(new JLabel("   title "));
        titlePanel.add(titleText);

        JPanel ratingPanel = new JPanel();
        ratingPanel.setBounds(50,250,250,50);
        ratingPanel.add(new JLabel("  rating"));
        ratingPanel.add(ratingText);

        JPanel caloriesPanel = new JPanel();
        caloriesPanel.setBounds(50,300,250,50);
        caloriesPanel.add(new JLabel("calories"));
        caloriesPanel.add(caloriesText);

        JPanel proteinPanel = new JPanel();
        proteinPanel.setBounds(50,350,250,50);
        proteinPanel.add(new JLabel(" protein"));
        proteinPanel.add(proteinText);

        JPanel fatPanel = new JPanel();
        fatPanel.setBounds(50,400,250,50);
        fatPanel.add(new JLabel("     fat  "));
        fatPanel.add(fatText);

        JPanel sodiumPanel = new JPanel();
        sodiumPanel.setBounds(50,450,250,50);
        sodiumPanel.add(new JLabel("  sodium"));
        sodiumPanel.add(sodiumText);

        JPanel priceProductPanel = new JPanel();
        priceProductPanel.setBounds(50,500,250,50);
        priceProductPanel.add(new JLabel("   price  "));
        priceProductPanel.add(priceProductText);


        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(0,550,200,50);
        //searchPanel.add(new JLabel("  Search  "));
        searchPanel.add(searchProductsBtn);

        JPanel viewPanel = new JPanel();
        viewPanel.setBounds(120,150,200,50);
        viewPanel.add(viewProductsBtn);

        JPanel allPanels = new JPanel();
        allPanels.add(createOrderPanel);
        allPanels.add(searchPanel);
        allPanels.add(titlePanel);
        allPanels.add(sodiumPanel);
        allPanels.add(ratingPanel);
        allPanels.add(caloriesPanel);
        allPanels.add(fatPanel);
        allPanels.add(priceProductPanel);
        allPanels.add(proteinPanel);
        allPanels.add(viewPanel);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }
    public void addsearchProductsBtn(ActionListener act){
        searchProductsBtn.addActionListener(act);
    }
    public void addViewProductBtn(ActionListener act){
        viewProductsBtn.addActionListener(act);
    }
    public void addAddProductBtn(ActionListener act){
        addProductsBtn.addActionListener(act);
    }
    public void addCreateOrderBtn(ActionListener act){
        createNewOrderBtn.addActionListener(act);
    }
    public String getPriceText() {
        return priceText.getText();
    }

    public void setPriceText(String priceText) {
        this.priceText.setText(priceText);
    }

    public String getIdProductText() {
        return idProductText.getText();
    }

    public String getTitleText() {
        return titleText.getText();
    }

    public String getRatingText() {
        return ratingText.getText();
    }

    public String getCaloriesText() {
        return caloriesText.getText();
    }

    public String getProteinText() {
        return proteinText.getText();
    }

    public String getFatText() {
        return fatText.getText();
    }

    public String getSodiumText() {
        return sodiumText.getText();
    }

    public String getPriceProductText() {
        return priceProductText.getText();
    }
}
