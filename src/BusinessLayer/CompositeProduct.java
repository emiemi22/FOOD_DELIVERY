package BusinessLayer;

import java.awt.*;
import java.util.List;

public class CompositeProduct implements MenuItem{

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

    public CompositeProduct(int id,List<BaseProduct> menuItems){
        this.id = id  ;
        this.menuItems = menuItems;
    }

    public void addCompositeList(BaseProduct menuItem){
        menuItems.add(menuItem);
    }
    public void removeComposite(BaseProduct menuItem){
        menuItems.remove(menuItem);
    }

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
