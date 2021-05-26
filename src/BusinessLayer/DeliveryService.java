package BusinessLayer;

import DataLayer.CSVReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/// CONTRACT method
public class DeliveryService implements IDeliveryServiceProcessing{

    private List<MenuItem> menuItems = new ArrayList<>();
    private Set<String> checkDuplicates = new HashSet<>();
    private Map<Order,List<MenuItem>>productsMap = new HashMap<>();
    private Login login ;

    private static int currentID = 0;
    private static int currentItemToBeDeleted = 0;
    private List<Client> clients = new ArrayList<>();
    public DeliveryService(){
        clients.add(new Client("user" , "asd" , 2));
        clients.add(new Client("user2" , "asd" , 3));
        login= new Login();
        login.addListClientToMap(clients);
        clients = login.getClientsList();
    }
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
    public MenuItem getItemById(int id){
        return  menuItems.get(id);
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
    public void generateReports(int intervalMin , int intervalMax, int prodMore, int orderPlaced , int highValue , int day) {
        //2
        System.out.println("GENERATING REPORTS");
        System.out.println(productsMap);
        List<MenuItem> productsOrdered = menuItems.stream().filter(product -> product.getTimeSelected() >= prodMore).collect(Collectors.toList());
        System.out.println("Products ordered more than " +prodMore +" time");
        productsOrdered.forEach(System.out::println);
        //1
        Map<Order,List<MenuItem>> result = productsMap.entrySet().stream()
                .filter(map -> map.getKey().getHour() >= intervalMin)
                .filter(map -> map.getKey().getHour() <= intervalMax)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        List<Order> result2 = new ArrayList<>();
        for(Order i : result.keySet())
            result2.add(i);
        System.out.println("Time interval of the orders");
        for(Order i : result2){
            System.out.println(i.toString());
        }

        //3

        List<Client> result3 = clients.stream()
                .filter(client -> client.getOrderPlaced() >= orderPlaced)
                .collect(Collectors.toList()); // select the clients that placed >= orders
        //result3.forEach(System.out::println);
        List<Client> finalRes = new ArrayList<>();
        for(Client client : result3) {
            Map<Order, List<MenuItem>> orderResult = productsMap.entrySet().stream()
                    .filter(map -> map.getKey().getClientID() == client.getId()) /// for each client select
                    .filter(map -> map.getKey().getTotalPrice() >= highValue) /// orders with >= value
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
            if(orderResult.size()>0)
                finalRes.add(client);
        }
        System.out.println("Clients that ordered more than " + orderPlaced +" and order value >=" + highValue);
        finalRes = finalRes.stream().distinct().collect(Collectors.toList());
        finalRes.forEach(System.out::println);

        //4

        System.out.println();
        System.out.print( "@@ ");
        productsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        //System.out.println(productsMap);
        Map<Order,List<MenuItem>> result4 = productsMap.entrySet().stream()
                .filter(map -> map.getKey().getDay() == day)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        for(Order key : result.keySet()) {
            System.out.println(key.toString() + " " );
        }

        List<MenuItem> finalRes4 = new ArrayList<>();
        for(Order key : result.keySet()){
            if (result4.get(key) == null)
                System.out.println("NULLL");
            finalRes4.addAll(result4.get(key));
        }

        //finalRes4 = finalRes4.stream().distinct().collect(Collectors.toList());
        System.out.println("\nProducts ordered in day:" +day);
        for (MenuItem itm : finalRes4){
            System.out.println(itm.getTitle() + " " + itm.getTimeSelected());
        }
    }

    public void incremenetSelectedItem(int id){
        menuItems.get(id).incrementTimeSelected();
    }
    @Override
    public void clientCreateNewOrder(List<MenuItem> productsList, int clientId, int totalPrice)  {
        /// Create an order
        Calendar date = Calendar.getInstance();
        Order newOrder = new Order(1,clientId,date);
        clients.get(clientId).incremenetSetOrderPlaced(); // incrementing for client i
        System.out.println("Client with id " +clientId + " ordered "+ clients.get(clientId).getOrderPlaced() +" times");
        newOrder.setTotalPrice(totalPrice);
        /// check if it there
        if (productsMap.containsKey(newOrder)){
            System.out.println("Cannot have the same id");
        }
        else{
            System.out.print("New order added " + newOrder.toString() +" products: ");
            productsList.forEach(System.out::println);
            productsMap.put(newOrder , productsList); // add in map the order(key) and menu List(value)

            String text = " New order added " + newOrder.toString() +" products:\n";
            for (MenuItem m : productsList){
                text =text+ " " + m.toString() + "\n";
            }
            text+= "Total:" + totalPrice+"\n";
            try {
                BillGenerator.getInstance().writeToFile(text);
                BillGenerator.getInstance().closeCurrentBill();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<MenuItem> searchingProducts(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        List<MenuItem> filteredMenuList = new ArrayList<>();
        if (title.equals("")){
            filteredMenuList = menuItems.stream()
                    .filter(filtered ->  filtered.getRating()>=rating)
                    .filter(filtered ->  filtered.getCalories()<=calories)
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
                    .filter(filtered ->  filtered.getCalories()<=calories)
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
    public boolean checkIfUserExist(String username, String password, int type){
        if (login.checkIfExistAccount(username,password , type)){
            return true;
        }
        else
            return false;
    }
    public int returnClientID(String username)
    {
        for (Client c : clients){
            if (c.getUsername().equals(username))
            {
                return  c.getId();
            }
        }
        return 0;
    }


}
