package inc.race.industrial_revolution_40;

/**
 * Created by Saad on 2016-10-18.
 * This class will be for getters and setters for the login page
 * (Username, Password)
 */

public class LoginCred {

    private int id;
    private String username;
    private String password;

    public LoginCred(){

    }


    public LoginCred(String User, String Pass){

        this.username = User;
        this.password = Pass;

    }
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String User){

        this.username = User;
    }

    public void setPassword(String Pass){

        this.password = Pass;
    }


    public int getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }



}