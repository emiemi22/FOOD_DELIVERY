package BusinessLayer;

/**
 * The type Client.
 */
public class Client {
    private String username ;
    private String password;
    private int orderPlaced = 0 ;
    private int id ;

    /**
     * Instantiates a new Client.
     *
     * @param username the username
     * @param pass     the pass
     * @param id       the id
     */
    public Client(String username ,String pass, int id ){
        this.username = username;
        this.password = pass;
        this.id = id ;
    }

    /**
     * Gets order placed.
     *
     * @return the order placed
     */
    public int getOrderPlaced() {
        return orderPlaced;
    }

    /**
     * Incremenet set order placed.
     */
    public void incremenetSetOrderPlaced() {
        this.orderPlaced ++;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Client{" +
                "username='" + username + '\'' +
                ", orderPlaced=" + orderPlaced +
                ", id=" + id +
                '}';
    }
}
