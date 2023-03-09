package user_input;

import java.util.Scanner;

public class UserCommunication {

    private static final String PROMPT = "Please enter ";

    private final Scanner scanner = new Scanner(System.in);

    public void requestInput(String topic) {
        System.out.print(PROMPT + topic);
    }

    public void informUser(String message) {
        System.out.println(message);
    }

    public String getItem() {
        return scanner.nextLine();
    }

    public Integer getQuantity() {
        return scanner.nextInt();
    }

    /* what's this? */
    /* even git points this out before push */
    public String removeItem() {
        return scanner.nextLine();
    }

    public Integer getNum() {
        return Integer.parseInt(scanner.nextLine());
    }

}
