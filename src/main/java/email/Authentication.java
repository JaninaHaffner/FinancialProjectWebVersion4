package email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* Sets username and password for authentication */
public class Authentication extends Authenticator {

    String userName;
    String password;

    public Authentication (String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public javax.mail.PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }
}
