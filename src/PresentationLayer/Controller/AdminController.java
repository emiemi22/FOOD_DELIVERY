package PresentationLayer.Controller;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import PresentationLayer.View.AdminView;
import PresentationLayer.View.TableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

public class AdminController {
    private AdminView adminView;
    private DeliveryService deliveryService ;

    public AdminController(DeliveryService deliveryService){
        adminView = new AdminView();
        this.deliveryService = deliveryService;
        adminView.addimportProductsBtn(new ImportListener());
        adminView.addaddProductsBtn(new AddProductListener());
        adminView.adddeleteProductsBtn(new DeleteProductListener());
        adminView.addcreateComposeProductsBtn(new CreateComposeProducts());
        adminView.generateRepBtn(new GenerateRep());
        adminView.addmanageProductBtn(new ManageProductListener());
        adminView.addViewPBtn(new ViewProductsListener());
    }
    class ViewProductsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new TableView(deliveryService);
        }
    }
    class ImportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Import ADMIN");
            deliveryService.importProducts();
        }
    }
    class AddProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Add new product ADMIN");
            String title = adminView.getTitle();
            float rating = Float.parseFloat(adminView.getRating());
            int calories = Integer.parseInt(adminView.getCalories());
            int protein = Integer.parseInt(adminView.getCalories());
            int fat = Integer.parseInt(adminView.getFat());
            int sodium = Integer.parseInt(adminView.getSodium());
            int price = Integer.parseInt(adminView.getPrice());
            //DeliveryService.setCurrentID(DeliveryService.getCurrentID()+1);
            BaseProduct newBaseProduct = new BaseProduct(DeliveryService.getCurrentID(),title , rating , calories , protein , fat , sodium , price);
            deliveryService.addProduct(newBaseProduct);
            System.out.println("Added new product" + " " + newBaseProduct.toString());
        }
    }
    class ManageProductListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            System.out.println("Manage product by ADMIN with id:" + adminView.getid() );
            String title = adminView.getTitle();
            float rating = Float.parseFloat(adminView.getRating());
            int calories = Integer.parseInt(adminView.getCalories());
            int protein = Integer.parseInt(adminView.getCalories());
            int fat = Integer.parseInt(adminView.getFat());
            int sodium = Integer.parseInt(adminView.getSodium());
            int price = Integer.parseInt(adminView.getPrice());
            //DeliveryService.setCurrentID(DeliveryService.getCurrentID()+1);
            BaseProduct newBaseProduct = new BaseProduct(Integer.parseInt(adminView.getid()),title , rating , calories , protein , fat , sodium , price);
            deliveryService.manageProducts(newBaseProduct);
        }
    }
    class DeleteProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Delete ADMIN");
            int id = Integer.parseInt(adminView.getid());
            deliveryService.deleteProduct(id);
            //deliveryService.viewCurrentProducts();
        }
    }
    class CreateComposeProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Composite Product");
            new CompositeController(deliveryService);
        }
    }
    class GenerateRep implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed generate Admin");
            new RaportController(deliveryService);
        }
    }
}
