package model;

/**
 * Created by Vojts on 19.10.2016.
 */
public class User {
    private int _id;
    private String login;
    private String password;

    public User(int _id, String login, String password){
        this._id = _id;
        this.login = login;
        this.password = password;
    }

    public int getId(){
        return _id;
    }

    public String getPassword(){
        return password;
    }

    public String getLogin(){
        return login;
    }
}
