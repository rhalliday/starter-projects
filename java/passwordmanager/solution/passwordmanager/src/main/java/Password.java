import java.io.Serializable;

public class Password implements Serializable {

    public String identifier;
    public String username;
    public String password;

    public Password (String identifier, String username, String password) {
        this.identifier = identifier;
        this.password = password;
        this.username = username;
    }

    public String toString() {
        return identifier + "\n\tusername: " + username + "\n\tpassword: " + password;
    }
}
