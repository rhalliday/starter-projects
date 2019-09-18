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
    }

    private void listPasswords() {
    }

    private void showPassword(String identifier) {
    }

    private void newPassword(String identifier, String username, String password) {
    }

    private void changePassword(String identifier, String attribute, String value) {
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
