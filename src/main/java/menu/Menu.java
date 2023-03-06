package menu;

import user_input.UserCommunication;

public class Menu {
    private final MenuHandler handler;

    private final UserCommunication userCommunication = new UserCommunication();

    private static final String MENU_MESSAGE = "Program menu:";

    private static final String ERROR_NOT_INT_MESSAGE = "Please type number!";

    private static final String MENU_INPUT_MESSAGE = "Program menu:";

    public Menu(MenuHandler handler) {
        this.handler = handler;
    }

    public void run() {
        while (handler.isWorking) {

            printMenu();

            try {
                int userChoice = userCommunication.getNum();
                this.handler.handleChoice(userChoice);
            } catch (NumberFormatException e) {
                userCommunication.informUser(ERROR_NOT_INT_MESSAGE);
            } catch (RuntimeException e) {
                userCommunication.informUser(e.getMessage());
            }
            userCommunication.informUser("");
        }

    }

    private void printMenu(){
        userCommunication.informUser(MENU_MESSAGE);
        handler.getListMethod().forEach(userCommunication::informUser);
        userCommunication.informUser("");
        userCommunication.informUser(MENU_INPUT_MESSAGE);
    }
}
