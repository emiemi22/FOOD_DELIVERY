package DataLayer;

import BusinessLayer.DeliveryService;

import java.io.*;

/**
 * The type Serializator.
 */
public class Serializator {
    /**
     * * Instantiates a new Serializator.
     */

    public Serializator(){
    }

    /**
     * Serialize.
     *
     * @param deliveryService the delivery service
     * @param filename        the filename
     */
    public void serialize(DeliveryService deliveryService, String filename){
        try {

            deliveryService.setPreviousId(DeliveryService.getCurrentID());

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(deliveryService);
            out.close();
            file.close();
            System.out.println(" Serialization - Delivery service saved !");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize delivery service.
     *
     * @param filename the filename
     * @return the delivery service
     * @throws IOException the io exception
     */
    public DeliveryService deserialize(String filename) throws IOException {
        DeliveryService deliveryService  = null;
        try
        {
            FileInputStream file = new FileInputStream(filename);
            if(file.getChannel().size() != 0){
                System.out.println("Reading from file a deliveryService");
                ObjectInputStream in = new ObjectInputStream(file);
                deliveryService = (DeliveryService)in.readObject();
                DeliveryService.setCurrentID(deliveryService.getPreviousId());
                in.close();
                file.close();
            }
            else{
                System.out.println("Creating new Delivery Service");
                deliveryService = new DeliveryService();
                deliveryService.setPreviousId(0);
                DeliveryService.setCurrentID(deliveryService.getPreviousId());
            }
        }
        catch(IOException ex)
        {
            System.out.println("IOException");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException");
        }
        System.out.println("Deserialization successfully");
        return deliveryService;
    }
}
