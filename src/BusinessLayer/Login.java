package BusinessLayer;

import java.util.HashMap;

public class Login {
    private HashMap<String , String> adminMap = new HashMap<>();
    private HashMap<String , String> clientMap = new HashMap<>();
    private HashMap<String , String> employeeMap = new HashMap<>();
    private HashMap<String , Integer> clientIDMap = new HashMap<>();
    private static Integer currentId = 0 ;
    public Login(){
        adminMap.put("a","ab");
        clientMap.put("b","b");
        clientIDMap.put("b" , currentId);
        currentId++;
        employeeMap.put("c","c");
    }
    public void addNewPerson(String userName, String password, int type){
        if (type == 0){
            adminMap.put(userName , password);
        }
        else if (type == 1) {
            clientMap.put(userName,password);
            clientIDMap.put(userName , currentId);
            currentId++;
        }
        else{
            employeeMap.put(userName,password);
        }
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
    public int returnClientID(String username){
        return clientIDMap.get(username);
    }
}
