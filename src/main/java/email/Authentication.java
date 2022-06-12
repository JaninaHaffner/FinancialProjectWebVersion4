package email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Authentication extends Authenticator {

    String userName = "";
    String password = "";

    public Authentication (String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }
}
