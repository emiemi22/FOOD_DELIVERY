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
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(deliveryService);
            out.close();
            file.close();
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
        DeliveryService deliveryService  = new DeliveryService();
        try
        {
            FileInputStream file = new FileInputStream(filename);
            if(file.getChannel().size() != 0){
                ObjectInputStream in = new ObjectInputStream(file);
                deliveryService = (DeliveryService)in.readObject();
                in.close();
                file.close();
            }
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return deliveryService;
    }
}
