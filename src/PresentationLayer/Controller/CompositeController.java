package PresentationLayer.Controller;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.DeliveryService;
import PresentationLayer.View.CompositeProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CompositeController {

    private CompositeProductView cview;
    private DeliveryService deliveryService;
    private List<BaseProduct> productList = new ArrayList<>();

    public CompositeController(DeliveryService d){
        cview= new CompositeProductView();
        this.deliveryService = d;
        cview.addBtn(new AddListener());
        cview.addDoneBtn(new DoneListener());
    }
    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Admin Composite product");
            int id = Integer.parseInt(cview.getUserTxt());
            BaseProduct newBp = deliveryService.getProductById(id);
            System.out.println("Added Item to list:" + newBp.toString());
            productList.add(newBp);
        }
    }
    class DoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Done Composite ADMIN");
            CompositeProduct cp = new CompositeProduct(DeliveryService.getCurrentID() , productList);
            BaseProduct compositeProduct = cp.createCompositeProduct(cview.getnameText());
            deliveryService.addProduct(compositeProduct);
            deliveryService.viewCurrentProducts();
        }
    }
}
