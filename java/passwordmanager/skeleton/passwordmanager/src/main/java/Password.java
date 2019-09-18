import java.io.Serializable;

public class Password implements Serializable {

    public String identifier;
    public String username;
    public String password;

    public Password () {
    }

    public String toString() {
        return identifier + "\n\tusername: " + username + "\n\tpassword: " + password;
    }
}
