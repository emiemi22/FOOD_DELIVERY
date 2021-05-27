package BusinessLayer;

/**
 * The type Employee.
 */
public class Employee {
    private String username ;
    private String password;
    private int id ;

    /**
     * Instantiates a new Employee.
     *
     * @param username the username
     * @param pass     the pass
     * @param id       the id
     */
    public Employee(String username ,String pass, int id ){
        this.username = username;
        this.password = pass;
        this.id = id ;
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
}
