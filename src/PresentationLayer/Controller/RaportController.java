package PresentationLayer.Controller;

import BusinessLayer.DeliveryService;
import PresentationLayer.View.RaportView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaportController {
    RaportView raportView ;
    DeliveryService deliveryService ;
    public RaportController(DeliveryService deliveryService){
        raportView = new RaportView();
        this.deliveryService = deliveryService;
        raportView.generateRepBtn(new GenerateListener());
    }
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
            deliveryService.generateReports(intervalMin , intervalMax , productsOrdered , clientsOrdered , valueHigher , day);

            System.out.println(intervalMin +" "+ intervalMax+ " "+ productsOrdered +" "+ clientsOrdered +" "+ valueHigher +" "+ day);

        }
    }
}
