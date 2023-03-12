package menu.actions;

import java.util.HashMap;
import java.util.Map;

/* why is this? */
public class ActionMap {
    private Map<Integer, Action> actionMap;

    public ActionMap() {
        this.actionMap = new HashMap<>();
        //actionMap.put(1, new AddItemToCartAction());
        //actionMap.put(2, new ListItemsAction());
        //actionMap.put(3, new RemoveFromCartAction());
        //actionMap.put(4, new ExitProgramAction());
    }

    public Action getAction(int userChoice) {
        return actionMap.get(userChoice);
    }
}
