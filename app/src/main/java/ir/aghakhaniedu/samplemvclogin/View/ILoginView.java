package ir.aghakhaniedu.samplemvclogin.View;

public interface ILoginView {
    void onLoginSuccess(String message);
    void onLoginFailed(String message);
    void initView();
    void setupListener();
}
