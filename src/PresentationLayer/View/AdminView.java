package PresentationLayer.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Admin view.
 */
public class AdminView extends JFrame{
    private JTextField id     = new JTextField();
    private JTextField title  = new JTextField();
    private JTextField rating = new JTextField();
    private JTextField calories = new JTextField();
    private JTextField protein  = new JTextField();
    private JTextField fat      = new JTextField();
    private JTextField sodium   = new JTextField();
    private JTextField price    = new JTextField();

    private JButton importProductsBtn = new JButton("Import Products");
    private JButton manageProductsBtn = new JButton("Manage Products");
    private JButton addProductsBtn = new JButton("Add Product");
    private JButton deleteProductsBtn = new JButton("Delete Product");
    private JButton createComposeProductsBtn = new JButton("Create CProduct");
    private JButton generateRepBtn = new JButton("Generate Reports");
    private JButton viewProductsBtn = new JButton("View Products");


    /**
     * Instantiates a new Admin view.
     */
    public AdminView(){

        this.setTitle("Admin Frame");
        this.setSize(550,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(206, 91, 101, 111));

        id.setPreferredSize      (new Dimension(100, 30));
        title.setPreferredSize   (new Dimension(100, 30));
        rating.setPreferredSize  (new Dimension(100, 30));
        calories.setPreferredSize(new Dimension(100, 30));
        price.setPreferredSize   (new Dimension(100, 30));
        protein.setPreferredSize (new Dimension(100, 30));
        fat.setPreferredSize     (new Dimension(100, 30));
        sodium.setPreferredSize  (new Dimension(100, 30));

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0,0,200,50);
        titlePanel.add(new JLabel("   Title:"));
        titlePanel.add(title);

        JPanel ratingPanel = new JPanel();
        ratingPanel.setBounds(0,50,200,50);
        ratingPanel.add(new JLabel("  Rating:"));
        ratingPanel.add(rating);

        JPanel caloriesPanel = new JPanel();
        caloriesPanel.setBounds(0,100,200,50);
        caloriesPanel.add(new JLabel("Calories:"));
        caloriesPanel.add(calories);

        JPanel proteinPanel = new JPanel();
        proteinPanel.setBounds(0,150,200,50);
        proteinPanel.add(new JLabel(" Protein:"));
        proteinPanel.add(protein);

        JPanel fatPanel = new JPanel();
        fatPanel.setBounds(0,200,200,50);
        fatPanel.add(new JLabel("     Fat:"));
        fatPanel.add(fat);

        JPanel sodiumPanel = new JPanel();
        sodiumPanel.setBounds(0,250,200,50);
        sodiumPanel.add(new JLabel("Sodium:"));
        sodiumPanel.add(sodium);

        JPanel pricePanel = new JPanel();
        pricePanel.setBounds(0,300,200,50);
        pricePanel.add(new JLabel("  Price:"));
        pricePanel.add(price);

        JPanel idPanel = new JPanel();
        idPanel.setBounds(0,350,200,50);
        idPanel.add(new JLabel("    Id:"));
        idPanel.add(id);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0,400,300,200);

        buttonPanel.add(importProductsBtn);
        buttonPanel.add(addProductsBtn);
        buttonPanel.add(manageProductsBtn);
        buttonPanel.add(deleteProductsBtn);
        buttonPanel.add(createComposeProductsBtn);
        buttonPanel.add(generateRepBtn);
        buttonPanel.add(viewProductsBtn);
        buttonPanel.setLayout(new GridLayout(4,3));

        JPanel allPanels = new JPanel();
        allPanels.add(titlePanel);
        allPanels.add(ratingPanel);
        allPanels.add(caloriesPanel);
        allPanels.add(proteinPanel);
        allPanels.add(pricePanel);
        allPanels.add(sodiumPanel);
        allPanels.add(fatPanel);
        allPanels.add(buttonPanel);
        allPanels.add(idPanel);
        allPanels.setLayout(null);
        this.setContentPane(allPanels);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public String getRating() {
        return rating.getText();
    }

    /**
     * Gets calories.
     *
     * @return the calories
     */
    public String getCalories() {
        return calories.getText();
    }

    /**
     * Gets protein.
     *
     * @return the protein
     */
    public String getProtein() {
        return protein.getText();
    }

    /**
     * Gets fat.
     *
     * @return the fat
     */
    public String getFat() {
        return fat.getText();
    }

    /**
     * Gets sodium.
     *
     * @return the sodium
     */
    public String getSodium() {
        return sodium.getText();
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price.getText();
    }

    /**
     * Gets .
     *
     * @return the
     */
    public String getid() {
        return id.getText();
    }


    /**
     * Addimport products btn.
     *
     * @param act the act
     */
    public void addimportProductsBtn(ActionListener act){
        importProductsBtn.addActionListener(act);
    }

    /**
     * Addadd products btn.
     *
     * @param act the act
     */
    public void addaddProductsBtn(ActionListener act){
        addProductsBtn.addActionListener(act);
    }

    /**
     * Adddelete products btn.
     *
     * @param act the act
     */
    public void adddeleteProductsBtn(ActionListener act){
        deleteProductsBtn.addActionListener(act);
    }

    /**
     * Addmanage product btn.
     *
     * @param act the act
     */
    public void addmanageProductBtn(ActionListener act){
        manageProductsBtn.addActionListener(act);
    }

    /**
     * Addcreate compose products btn.
     *
     * @param act the act
     */
    public void addcreateComposeProductsBtn(ActionListener act){
        createComposeProductsBtn.addActionListener(act);
    }

    /**
     * Generate rep btn.
     *
     * @param act the act
     */
    public void generateRepBtn(ActionListener act){
        generateRepBtn.addActionListener(act);
    }

    /**
     * Add view p btn.
     *
     * @param act the act
     */
    public void addViewPBtn(ActionListener act){
        viewProductsBtn.addActionListener(act);
    }


}
