package BusinessLayer;

import java.util.Arrays;
import java.util.Calendar;

public class Order {
    private int orderID ;
    private int clientID ;
    private int[] orderDate = new int[3];
    private int totalPrice=0 ;
    private static  int counterIDorder = 1;
    public Order(int orderID , int clientID ,Calendar orderDate){
        this.orderID = counterIDorder ;
        counterIDorder++;
        this.clientID = clientID;
        this.orderDate[0] = orderDate.getTime().getDate();
        this.orderDate[1] = orderDate.getTime().getHours();
        this.orderDate[2] = orderDate.getTime().getMinutes();
    }
    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getHour(){
        return orderDate[1];
    }
    public int getDay(){
        return orderDate[0];
    }
    public void printOrderDate(){
        System.out.println("Day:" + orderDate[0] + " h:" + orderDate[1] + " min:" + orderDate[2]);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int hashCode(){
        return this.orderID+this.clientID;
    }

    @Override
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
}
