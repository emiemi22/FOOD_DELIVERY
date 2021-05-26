package BusinessLayer;

import DataLayer.CSVReader;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/// CONTRACT method
public class DeliveryService implements IDeliveryServiceProcessing{
    private List<MenuItem> menuItems = new ArrayList<>();
    private static int currentID = 0;
    private static int currentItemToBeDeleted = 0;
    private Set<String> checkDuplicates = new HashSet<>();
    private Map<Order,List<MenuItem>>productsMap = new HashMap<>();

    @Override
    public void importProducts() {
        List<BaseProduct> baseProducts = new ArrayList<>();
        CSVReader csv = new CSVReader(baseProducts , checkDuplicates);
        csv.setId(currentID);
        csv.readFromCSV();
        currentID+=csv.getId();
        for (BaseProduct bp : csv.getProductsList()){
            menuItems.add(bp);
        }
        System.out.println("The csv was imported successfully");
        menuItems.forEach(System.out::println);
    }

    @Override
    public void manageProducts(BaseProduct bp) {
        int index = bp.getId();
        menuItems.set(index, bp);
    }

    public void addProduct(BaseProduct baseProduct){
        menuItems.add(baseProduct);
        currentID++;
    }

    public BaseProduct getProductById(int id){
        return (BaseProduct) menuItems.get(id);
    }
    public void deleteProduct(int id){
        System.out.println(menuItems.get(id).toString());
        menuItems.remove(id-currentItemToBeDeleted);
        currentItemToBeDeleted++;
    }

    @Override
    public void clientCreateNewOrder(List<MenuItem> productsList, int clientId, int totalPrice) {
        /// Create an order
        Calendar date = Calendar.getInstance();
        Order newOrder = new Order(1,clientId,date);
        newOrder.setTotalPrice(totalPrice);
        /// check if it there
        if (productsMap.containsKey(newOrder)){
            System.out.println("Cannot have the same id");
        }
        else{
            System.out.print("New order added" + newOrder.toString() +" products:");
            productsList.forEach(System.out::print);
            productsMap.put(newOrder,productsList);
        }
    }

    @Override
    public List<MenuItem> searchingProducts(String title, float rating, int calories, int protein, int fat, int sodium, int price)
    {
        List<MenuItem> filteredMenuList = new ArrayList<>();
        if (title.equals("")){
            filteredMenuList = menuItems.stream()
                    .filter(filtered ->  filtered.getRating()>=rating)
                    .filter(filtered ->  filtered.getRating()<=calories)
                    .filter(filtered ->  filtered.getProtein()<=protein)
                    .filter(filtered ->  filtered.getFat()<=fat)
                    .filter(filtered ->  filtered.getSodium()<=sodium)
                    .filter(filtered ->  filtered.getPrice()<=price)
                    .collect(Collectors.toList());
        }
        else {
            filteredMenuList = menuItems.stream()
                    .filter(filtered ->  filtered.getTitle().contains(title))
                    .filter(filtered ->  filtered.getRating()>=rating)
                    .filter(filtered ->  filtered.getRating()<=calories)
                    .filter(filtered ->  filtered.getProtein()<=protein)
                    .filter(filtered ->  filtered.getFat()<=fat)
                    .filter(filtered ->  filtered.getSodium()<=sodium)
                    .filter(filtered ->  filtered.getPrice()<=price)
                    .collect(Collectors.toList());
        }
        return  filteredMenuList;

    }
    public void viewCurrentProducts(){
        menuItems.forEach(System.out::println);
    }
    public static int getCurrentID() {
        return currentID;
    }
    public static void setCurrentID(int currentID) {
        DeliveryService.currentID = currentID;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
