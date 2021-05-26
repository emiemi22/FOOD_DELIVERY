package PresentationLayer.Controller;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import PresentationLayer.View.ClientView;
import PresentationLayer.View.SearchView;
import PresentationLayer.View.TableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private ClientView clientView ;
    private DeliveryService deliveryService ;
    private int clientId ;
    private int currentTotal =0 ;
    private List<MenuItem> productList = new ArrayList<>();
    public ClientController(DeliveryService deliveryService, int clientID) {
        clientView = new ClientView();
        clientId = clientID ;
        this.deliveryService = deliveryService ;
        clientView.addsearchProductsBtn(new SearchProductListener());
        clientView.addViewProductBtn(new ViewProductListener());
        clientView.addAddProductBtn(new AddProductListener());
        clientView.addCreateOrderBtn(new CreateListener());
    }

    class SearchProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Search products by client");
            String title ;
            float rating ;
            int calories ;
            int protein ;
            int fat ;
            int sodium ;
            int price;

            title =    clientView.getTitleText();
            if (clientView.getRatingText().equals("")) {
                rating = 0 ;
            }
            else{
                rating =   Float.parseFloat(clientView.getRatingText());
            }

            if (clientView.getCaloriesText().equals("")){
                calories = Integer.MAX_VALUE;
            }
            else {
                calories = Integer.parseInt(clientView.getCaloriesText());
            }
            if (clientView.getProteinText().equals("")){
                protein = Integer.MAX_VALUE;
            }
            else{
                protein =  Integer.parseInt(clientView.getProteinText());
            }
            if (clientView.getFatText().equals("")){
                fat = Integer.MAX_VALUE;
            }
            else{
                fat = Integer.parseInt(clientView.getFatText());
            }
            if (clientView.getSodiumText().equals("")){
                sodium = Integer.MAX_VALUE;
            }
            else {
                sodium =   Integer.parseInt(clientView.getSodiumText());
            }
            if (clientView.getPriceProductText().equals("")){
                price = Integer.MAX_VALUE;
            }
            else{
                price =  Integer.parseInt(clientView.getPriceProductText());
            }
            List<MenuItem> resultList = deliveryService.searchingProducts(title , rating, calories , protein
            , fat , sodium , price);
            new SearchView(resultList);
        }
    }
    class ViewProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new TableView(deliveryService);
        }
    }
    class CreateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("create new order client");
            deliveryService.clientCreateNewOrder(productList,clientId,currentTotal);
            currentTotal = 0;
        }
    }
    class AddProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("add product client");
            int id = Integer.parseInt(clientView.getIdProductText());
            BaseProduct newBp = deliveryService.getProductById(id);
            currentTotal+=newBp.getPrice();
            clientView.setPriceText(String.valueOf(currentTotal));
            System.out.println("Added Item to list:" + newBp.toString());
            productList.add(newBp);
        }
    }
}
