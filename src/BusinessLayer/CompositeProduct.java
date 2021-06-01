package BusinessLayer;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * The type Composite product.
 */
public class CompositeProduct implements MenuItem , Serializable {

    private  int id ;
    private List<BaseProduct> menuItems ;
    private String title ;

    private float rating=0;
    private int calories=0;
    private int protein=0;
    private int fat=0;
    private int sodium=0;
    private int price=0;
    private int timeSelected = 0 ;

    /**
     * Instantiates a new Composite product.
     *
     * @param id        the id
     * @param menuItems the menu items
     */
    public CompositeProduct(int id,List<BaseProduct> menuItems){
        this.id = id  ;
        this.menuItems = menuItems;
    }

    /**
     * Add composite list.
     *
     * @param menuItem the menu item
     */
    public void addCompositeList(BaseProduct menuItem){
        menuItems.add(menuItem);
    }

    /**
     * Remove composite.
     *
     * @param menuItem the menu item
     */
    public void removeComposite(BaseProduct menuItem){
        menuItems.remove(menuItem);
    }

    /**
     * Create composite product base product.
     *
     * @param name the name
     * @return the base product
     */
    public BaseProduct createCompositeProduct(String name){
        title = name;
        int id = this.id;
        int counter = 0 ;
        for (BaseProduct bp : menuItems) {
            rating += bp.getRating();
            counter++;
            calories+=bp.getCalories();
            protein+=bp.getProtein();
            sodium +=bp.getSodium();
            price+=bp.getPrice();
            fat+=bp.getPrice();
            title = title + " " + bp.getTitle() + " ";
        }
        rating = rating/counter;
        BaseProduct bs = new BaseProduct(id , title , rating , calories,protein,fat, sodium,price);
        return  bs;
    }

    @Override
    public int computePrice(){
        int sum = menuItems.stream().mapToInt(i->i.computePrice()).sum();
        return sum ;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int getTimeSelected() {
        return timeSelected;
    }
    @Override
    public void incrementTimeSelected() {
        this.timeSelected++;
    }
}
