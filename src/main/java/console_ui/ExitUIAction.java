package console_ui;

import services.ExitService;

public class ExitUIAction implements UIAction {

    private static final String ACTION_NAME = "Exit";

    private static final String MESSAGE_EXIT = "Thank you for shopping at Planet Express.";

    private final UserCommunication userCommunication;
    private final ExitService exitService;

    public ExitUIAction(ExitService exitService, UserCommunication userCommunication) {
        this.userCommunication = userCommunication;
        this.exitService = exitService;
    }

    @Override
    public void execute() {
        userCommunication.informUser(MESSAGE_EXIT);
        exitService.execute();
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

}
