package PresentationLayer.Controller;

import BusinessLayer.DeliveryService;
import PresentationLayer.View.RaportView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * The type Raport controller.
 */
public class RaportController {
    /**
     * The Raport view.
     */
    RaportView raportView ;
    /**
     * The Delivery service.
     */
    DeliveryService deliveryService ;

    /**
     * Instantiates a new Raport controller.
     *
     * @param deliveryService the delivery service
     */
    public RaportController(DeliveryService deliveryService){
        raportView = new RaportView();
        this.deliveryService = deliveryService;
        raportView.generateRepBtn(new GenerateListener());
    }

    /**
     * The type Generate listener.
     */
    class GenerateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Pressed Generate Report ADMIN");
            int intervalMin , intervalMax , valueHigher,day , clientsOrdered , productsOrdered;
            intervalMin = Integer.parseInt(raportView.getIntervalMin());
            intervalMax = Integer.parseInt(raportView.getIntervalMax());
            productsOrdered = Integer.parseInt(raportView.getProductsOrderedMore());
            clientsOrdered = Integer.parseInt(raportView.getClientsOrdered());
            valueHigher = Integer.parseInt(raportView.getValueHigher());
            day = Integer.parseInt(raportView.getIntervalDay());
            try {
                deliveryService.generateReports(intervalMin , intervalMax , productsOrdered , clientsOrdered , valueHigher , day);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(intervalMin +" "+ intervalMax+ " "+ productsOrdered +" "+ clientsOrdered +" "+ valueHigher +" "+ day);

        }
    }
}
