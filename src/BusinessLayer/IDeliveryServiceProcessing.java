package BusinessLayer;

import java.util.List;

public interface IDeliveryServiceProcessing {
    void importProducts();
    void manageProducts(BaseProduct bp);
    void addProduct(BaseProduct bp);
    void deleteProduct(int id);
    void generateReports(int intervalMin , int intervalMax, int prodMore, int clientsNb , int highValue , int day);

    void clientCreateNewOrder(List<MenuItem> productsList ,int clientId,int totalPrice);
    List<MenuItem> searchingProducts(String title ,
            float rating ,
            int calories ,
            int protein ,
            int fat ,
            int sodium ,
            int price
    );

}
