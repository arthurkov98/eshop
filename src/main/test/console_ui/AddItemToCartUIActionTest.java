package console_ui;

import data.CartItem;
import data.Item;
import item_generator.HardcodedItemGenerator;
import org.junit.jupiter.api.Test;
import user_input.UserCommunication;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

// TODO MOAR
class AddItemToCartUIActionTest {

    private final List<Item> shopItems = new HardcodedItemGenerator().createItems();
    private final List<CartItem> mockCartItems = mock(List.class);
    private final UserCommunication mockUserCommunication = mock(UserCommunication.class);
    private final AddItemToCartUIAction action =
            new AddItemToCartUIAction(shopItems, mockCartItems, mockUserCommunication);

    @Test
    void shouldAddItemAndDecreaseAvailableQuantity() {
        doNothing().when(mockUserCommunication).requestInput(anyString());
        when(mockUserCommunication.getItem()).thenReturn("Slurm");
        when(mockUserCommunication.getQuantity()).thenReturn(10);
        action.execute();
        verify(mockCartItems).add(any(CartItem.class)); // TODO specific?
        assertEquals(20, shopItems.get(4).getQuantityAvailable());
    }

}
