package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Login.
 */
public class Login implements Serializable {
    private HashMap<String , String> adminMap = new HashMap<>();
    private HashMap<String , String> clientMap = new HashMap<>();
    private HashMap<String , String> employeeMap = new HashMap<>();
    private HashMap<String , Integer> clientIDMap = new HashMap<>();
    private List<Client> clientsList ;
    private List<Administrator> adminList ;
    private List<Employee> employeeList ;
    private static Integer currentId = 0 ;

    /**
     * Instantiates a new Login.
     */
    public Login(){
        clientsList = new ArrayList<>();
        adminMap.put("a","ab");

        Client client = new Client("b" ,"b",currentId);
        clientMap.put("b","b");
        clientsList.add(client);
        currentId++;

        Client client1 = new Client("ac" ,"ac",currentId);
        clientsList.add(client1);
        clientMap.put("ac","ac");
        currentId++;
        employeeMap.put("c","c");
    }

    /**
     * Add new person.
     *
     * @param userName the user name
     * @param password the password
     * @param type     the type
     */
    public void addNewPerson(String userName, String password, int type){
        if (type == 0){
            adminMap.put(userName , password);
        }
        else if (type == 1) {
            if (clientMap.containsKey(userName)){
                System.out.println("Username already used");
            }
            else{
                clientMap.put(userName,password);
                Client client = new Client(userName ,password,currentId);
                clientsList.add(client);
                currentId++;
            }
        }
        else{
            employeeMap.put(userName,password);
        }
    }

    /**
     * Add list client to map.
     *
     * @param listClients the list clients
     */
    public void addListClientToMap(List<Client> listClients) {
        for(Client c : listClients){
            clientMap.put(c.getUsername(),c.getPassword());
            System.out.println("adding " + c.getUsername() + " "+ c.getPassword() );
            clientsList.add(new Client(c.getUsername() , c.getPassword() , currentId));
            currentId++;
        }
        //Login.setCurrentId(currentId+1);
    }

    /**
     * Check if exist account boolean.
     *
     * @param username the username
     * @param password the password
     * @param type     the type
     * @return the boolean
     */
    public boolean checkIfExistAccount(String username, String password , int type){
        if (type == 0){
            if (adminMap.containsKey(username)){
                String pass = adminMap.get(username);
                if (pass.equals(password)){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else if (type == 1){
            if (clientMap.containsKey(username)){
                String pass = clientMap.get(username);
                if (pass.equals(password)){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else{
            if (employeeMap.containsKey(username)){
                String pass = employeeMap.get(username);
                if (pass.equals(password)){
                    return true;
                }
                else return false;
            }
            else return false;
        }
    }

    /**
     * Gets clients list.
     *
     * @return the clients list
     */
    public List<Client> getClientsList() {
        return clientsList;
    }

    /**
     * Sets current id.
     *
     * @param currentId the current id
     */
    public static void setCurrentId(Integer currentId) {
        Login.currentId = currentId;
    }
}
