package PresentationLayer.View;


import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The type Table view.
 */
public class TableView extends JFrame {

    /**
     * Instantiates a new Table view.
     *
     * @param ds the ds
     */
    public TableView(DeliveryService ds){
        List<MenuItem> baseProductList = ds.getMenuItems();
        this.setTitle("List of products");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(91, 206, 201, 111));

        String[] columnNames = {"ID","Title", "Rating", "Calories", "Protein","Fat", "Sodium", "Price"};
        Object[][] products = new Object[baseProductList.size()][8];
        int index = 0 ;

        for(MenuItem item : baseProductList){
            products[index][0] = ((BaseProduct) item).getId();
            products[index][1] = ((BaseProduct) item).getTitle();
            products[index][2] = ((BaseProduct) item).getRating();
            products[index][3] = ((BaseProduct) item).getCalories();
            products[index][4] = ((BaseProduct) item).getProtein();
            products[index][5] = ((BaseProduct) item).getFat();
            products[index][6] = ((BaseProduct) item).getSodium();
            products[index][7] = ((BaseProduct) item).getPrice();
            index++;
        }
        JTable table = new JTable(products , columnNames);
        JScrollPane scroll =new JScrollPane(table) ;
        this.add(scroll);
    }

}
