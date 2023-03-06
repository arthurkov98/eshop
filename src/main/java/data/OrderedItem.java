package data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedItem {

    private final Item item;
    private Integer quantityOrdered;

    @Override
    public String toString() {
        return "item=" + item +
                ", ordered quantity=" + quantityOrdered;
    }

}
