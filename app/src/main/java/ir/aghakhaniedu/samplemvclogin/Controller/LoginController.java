package ir.aghakhaniedu.samplemvclogin.Controller;

import ir.aghakhaniedu.samplemvclogin.Model.User;
import ir.aghakhaniedu.samplemvclogin.View.ILoginView;

public class LoginController implements ILoginController {

    ILoginView LoginView;

    public LoginController(ILoginView iLoginView) {
        this.LoginView = iLoginView;
    }

    @Override
    public void onlogin(String username, String password) {
        User user = new User(username, password);
        int loginCode = user.isValid();
        // 0 username is empty
        // 1 check for email match pattern
        // 2 password is empty
        // 3 password under 6
        if (loginCode == 0) {
            LoginView.onLoginFailed("Please enter Email!!");
        } else if (loginCode == 1) {
            LoginView.onLoginFailed("Please enter Valid Email!!");
        } else if (loginCode == 2) {
            LoginView.onLoginFailed("Please enter password!!");
        } else if (loginCode == 3) {
            LoginView.onLoginFailed("Please enter password uper 6 character!!");
        } else if (loginCode == 4) {
            LoginView.onLoginFailed("username incorrect");
        } else if (loginCode == 5) {
            LoginView.onLoginFailed("password incorrect");
        } else {
            LoginView.onLoginSuccess("Login is Success");

        }


    }
}
