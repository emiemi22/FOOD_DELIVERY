package PresentationLayer.Controller;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import PresentationLayer.View.AdminView;
import PresentationLayer.View.TableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

/**
 * The type Admin controller.
 */
public class AdminController {
    private AdminView adminView;
    private DeliveryService deliveryService ;

    /**
     * Instantiates a new Admin controller.
     *
     * @param deliveryService the delivery service
     */
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

    /**
     * The type View products listener.
     */
    class ViewProductsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new TableView(deliveryService);
        }
    }

    /**
     * The type Import listener.
     */
    class ImportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Import ADMIN");
            deliveryService.importProducts();
        }
    }

    /**
     * The type Add product listener.
     */
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

    /**
     * The type Manage product listener.
     */
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

    /**
     * The type Delete product listener.
     */
    class DeleteProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Delete ADMIN");
            int id = Integer.parseInt(adminView.getid());
            deliveryService.deleteProduct(id);
            //deliveryService.viewCurrentProducts();
        }
    }

    /**
     * The type Create compose products.
     */
    class CreateComposeProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Composite Product");
            new CompositeController(deliveryService);
        }
    }

    /**
     * The type Generate rep.
     */
    class GenerateRep implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed generate Admin");
            new RaportController(deliveryService);
        }
    }
}
