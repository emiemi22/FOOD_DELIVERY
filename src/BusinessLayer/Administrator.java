package BusinessLayer;

public class Administrator {
    private String username ;
    private String password;
    private int id ;
    public Administrator(String username ,String pass, int id ){
        this.username = username;
        this.password = pass;
        this.id = id ;
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
