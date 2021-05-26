package BusinessLayer;

public class Client {
    private String username ;
    private String password;
    private int orderPlaced = 0 ;
    private int id ;
    public Client(String username ,String pass, int id ){
        this.username = username;
        this.password = pass;
        this.id = id ;
    }

    public int getOrderPlaced() {
        return orderPlaced;
    }

    public void incremenetSetOrderPlaced() {
        this.orderPlaced ++;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
