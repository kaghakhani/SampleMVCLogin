package ir.aghakhaniedu.samplemvclogin.Model;

import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import java.util.regex.Pattern;

public class User implements IUser {
    private String username, password, dataUsername, dataPassword;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValid() {
        // 0 username is empty
        // 1 check for email match pattern
        // 2 password is empty
        // 3 password under 6
        getDataUsername();
        getDatapassword();
        if (getUsername().isEmpty())
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUsername()).matches())
            return 1;
        else if (getPassword().isEmpty())
            return 2;
        else if (getPassword().length() < 6)
            return 3;
        else if (!(getUsername().equals(dataUsername)))
        { //Log.i("test",dataUsername);
            return 4;}
        else if (!(getPassword().equals(dataPassword)))
            return 5;

        else return -1;


    }

    @Override
    public String getDataUsername() {
        dataUsername = "ali@gmail.com";
        return dataUsername;
    }

    @Override
    public String getDatapassword() {
        dataPassword = "123456";
        return dataPassword;
    }
}
