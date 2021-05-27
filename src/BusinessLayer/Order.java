package BusinessLayer;

import java.util.Arrays;
import java.util.Calendar;

/**
 * The type Order.
 */
public class Order {
    private int orderID ;
    private int clientID ;
    private int[] orderDate = new int[3];
    private int totalPrice=0 ;
    private static  int counterIDorder = 1;

    /**
     * Instantiates a new Order.
     *
     * @param orderID   the order id
     * @param clientID  the client id
     * @param orderDate the order date
     */
    public Order(int orderID , int clientID ,Calendar orderDate){
        this.orderID = counterIDorder ;
        counterIDorder++;
        this.clientID = clientID;
        this.orderDate[0] = orderDate.getTime().getDate();
        this.orderDate[1] = orderDate.getTime().getHours();
        this.orderDate[2] = orderDate.getTime().getMinutes();
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID() {
        return this.orderID;
    }

    /**
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Sets client id.
     *
     * @param clientID the client id
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Get hour int.
     *
     * @return the int
     */
    public int getHour(){
        return orderDate[1];
    }

    /**
     * Get day int.
     *
     * @return the int
     */
    public int getDay(){
        return orderDate[0];
    }

    /**
     * Print order date.
     */
    public void printOrderDate(){
        System.out.println("Day:" + orderDate[0] + " h:" + orderDate[1] + " min:" + orderDate[2]);
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int hashCode(){
        return this.orderID;
    }

    //@Override
    public boolean equals(Object obj) {
        Order o = (Order) obj;
        if (o.orderID == orderID
            && clientID == o.clientID
            && orderDate[0] == o.orderDate[0]
            && orderDate[1] == o.orderDate[1]
            && orderDate[2] == o.orderDate[2]){
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", orderDate=" + "Day:" + orderDate[0] + " h:" + orderDate[1] + " min:" + orderDate[2] +
                '}';
    }

    /**
     * Sets counter i dorder.
     *
     * @param counterIDorder the counter i dorder
     */
    public static void setCounterIDorder(int counterIDorder) {
        Order.counterIDorder = counterIDorder;
    }
}
