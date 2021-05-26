package BusinessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Login {
    private HashMap<String , String> adminMap = new HashMap<>();
    private HashMap<String , String> clientMap = new HashMap<>();
    private HashMap<String , String> employeeMap = new HashMap<>();
    private HashMap<String , Integer> clientIDMap = new HashMap<>();
    private List<Client> clientsList ;
    private List<Administrator> adminList ;
    private List<Employee> employeeList ;
    private static Integer currentId = 0 ;
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
    public void addListClientToMap(List<Client> listClients)
    {
        for(Client c : listClients){
            clientMap.put(c.getUsername(),c.getPassword());
            System.out.println("adding" + c.getUsername() + " "+ c.getPassword() );
            clientsList.add(new Client(c.getUsername() , c.getPassword() , currentId));
            currentId++;
        }
        //Login.setCurrentId(currentId+1);
    }
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

    public List<Client> getClientsList() {
        return clientsList;
    }

    public static void setCurrentId(Integer currentId) {
        Login.currentId = currentId;
    }
}
