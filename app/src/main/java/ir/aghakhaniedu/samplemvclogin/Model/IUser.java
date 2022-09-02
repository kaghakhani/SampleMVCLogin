package ir.aghakhaniedu.samplemvclogin.Model;

public interface IUser {
    String getUsername();
    String getPassword();
    int isValid();
    String getDataUsername();
    String getDatapassword();
}
