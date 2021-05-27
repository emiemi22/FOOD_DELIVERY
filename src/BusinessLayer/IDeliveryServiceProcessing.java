package BusinessLayer;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The interface Delivery service processing.
 */
public interface IDeliveryServiceProcessing {
    /**
     * Import products.
     */
    void importProducts();

    /**
     * Manage products.
     *
     * @param bp the bp
     */
    void manageProducts(BaseProduct bp);

    /**
     * Add product.
     *
     * @param bp the bp
     */
    void addProduct(BaseProduct bp);

    /**
     * Delete product.
     *
     * @param id the id
     */
    void deleteProduct(int id);

    /**
     * Generate reports.
     *
     * @param intervalMin the interval min
     * @param intervalMax the interval max
     * @param prodMore    the prod more
     * @param clientsNb   the clients nb
     * @param highValue   the high value
     * @param day         the day
     * @throws FileNotFoundException the file not found exception
     */
    void generateReports(int intervalMin , int intervalMax, int prodMore, int clientsNb , int highValue , int day) throws FileNotFoundException;

    /**
     * Client create new order.
     *
     * @param productsList the products list
     * @param clientId     the client id
     * @param totalPrice   the total price
     */
    void clientCreateNewOrder(List<MenuItem> productsList ,int clientId,int totalPrice);

    /**
     * Searching products list.
     *
     * @param title    the title
     * @param rating   the rating
     * @param calories the calories
     * @param protein  the protein
     * @param fat      the fat
     * @param sodium   the sodium
     * @param price    the price
     * @return the list
     */
    List<MenuItem> searchingProducts(String title ,
            float rating ,
            int calories ,
            int protein ,
            int fat ,
            int sodium ,
            int price
    );

}
