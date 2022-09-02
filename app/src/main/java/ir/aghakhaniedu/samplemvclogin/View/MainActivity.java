package ir.aghakhaniedu.samplemvclogin.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.aghakhaniedu.samplemvclogin.Controller.ILoginController;
import ir.aghakhaniedu.samplemvclogin.Controller.LoginController;
import ir.aghakhaniedu.samplemvclogin.R;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    EditText edtUsename, edtPassword;
    Button btnLogin;
    ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupListener();
        loginController=new LoginController(this);

    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void initView() {
        edtUsename=findViewById(R.id.et_username);
        edtPassword=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btn_login);
    }

    @Override
    public void setupListener() {
        btnLogin.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if (view==btnLogin)
        {
            loginController.onlogin(edtUsename.getText().toString().trim(),edtPassword.getText().toString().trim());
        }
    }
}