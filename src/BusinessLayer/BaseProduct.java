package BusinessLayer;

public class BaseProduct implements MenuItem{
    private int id;
    private String title ;
    private float rating ;
    private int calories;
    private int protein ;
    private int fat ;
    private int sodium ;
    private int price ;
    private int timeSelected = 0 ;

    public BaseProduct(int id ,String title , float rating , int calories , int protein , int fat , int sodium , int price){
        this.id = id ;
        this.title = title ;
        this.rating = rating ;
        this.calories = calories ;
        this.protein = protein ;
        this.fat = fat ;
        this.sodium = sodium ;
        this.price = price ;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                 "id="+ id +
                " title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                ", times=" + timeSelected +
                '}';
    }

    public int getId() {
        return id;
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

    @Override
    public int computePrice() {
        return price;
    }

}
