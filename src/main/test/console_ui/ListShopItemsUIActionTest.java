package console_ui;

import item_generator.HardcodedItemGenerator;
import org.junit.jupiter.api.Test;
import user_input.UserCommunication;

import static org.mockito.Mockito.*;

class ListShopItemsUIActionTest {

    private final UserCommunication mockUserCommunication = mock(UserCommunication.class);
    private final ListShopItemsUIAction action =
            new ListShopItemsUIAction(new HardcodedItemGenerator().createItems(), mockUserCommunication);

    @Test
    void shouldListHeaderAnd10Items() {
        doNothing().when(mockUserCommunication).informUser(anyString());
        action.execute();
        verify(mockUserCommunication, times(11)).informUser(anyString());
    }

}
