import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Application {

    private final String passwordFile = System.getenv("HOME") + "/.passwords";
    private HashMap<String, Password> passwords = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);


    Application() {
        loadPasswords();
    }

    public static void main(String[] args) {
        String initialQ = "Enter an action (list, add, show, change)";
        String action = getInput(initialQ);

        Application myApp = new Application();

        while(!action.isEmpty()) {
            switch (action) {
                case "list":
                    myApp.listPasswords();
                    break;
                case "add":
                    myApp.newPassword(getIdentifier(), getInput("Enter username"), getInput("Enter password"));
                    break;
                case "show":
                    myApp.showPassword(getIdentifier());
                    break;
                case "change":
                    myApp.changePassword(getIdentifier(), getInput("Enter field"), getInput("Enter value"));
                    break;
                default:
                    myApp.printError(action);
                    break;
            }
            action = getInput(initialQ);
        }

        myApp.savePasswords();
    }

    private static String getIdentifier() {
        return getInput("Enter identifier");
    }

    private static String getInput(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    private void listPasswords() {
        if (passwords.isEmpty()) {
            System.out.println("Nothing to list");
            return;
        }

        for(String id: passwords.keySet()) {
            System.out.println(id);
        }
    }

    private void showPassword(String identifier) {
        Password thisPass = passwords.get(identifier);
        if (thisPass != null) {
            System.out.println(thisPass.toString());
        } else {
            System.out.println("Unable to find identifier: " + identifier);
        }
    }

    private void newPassword(String identifier, String username, String password) {
        Password newPass = new Password(identifier, username, password);
        passwords.put(identifier, newPass);
    }

    private void changePassword(String identifier, String attribute, String value) {
        Password thisPass = passwords.get(identifier);
        if (thisPass != null) {
            switch (attribute) {
                case "username":    thisPass.username = value;
                                    break;
                case "password":    thisPass.password = value;
                                    break;
                default:
                    System.out.println("No such attribute" + attribute);
                    break;
            }
        } else {
            System.out.println("Unable to find identifier: " + identifier);
        }
    }

    private void printError(String option) {
        System.err.println("Unknown option: " + option);
    }

    private void loadPasswords() {
        try {
            FileInputStream fileIn = new FileInputStream(passwordFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            passwords = (HashMap<String, Password>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

    }

    private void savePasswords() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(passwordFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(passwords);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
