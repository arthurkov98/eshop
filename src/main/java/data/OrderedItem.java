package data;

import lombok.AllArgsConstructor;
import lombok.Data;

/* we wanted to rename this to CartItem */
/* also, @Data and @AllArgsConstructor are Lombok features */
/* our module in Viktor's project has no Lombok */
/* be cautious when moving this stuff to his project */
/* I'll try to get Lombok working there on Saturday */
@Data
@AllArgsConstructor
public class OrderedItem {

    private final Item item;
    private Integer quantityOrdered;

    @Override
    public String toString() {
        /* I personally don't think quantity available is needed there */
        /* also my OCD really does not like the fact that this one is formatted differently from Item.toString() */
        return "item=" + item +
                ", ordered quantity=" + quantityOrdered;
    }

    public Item getItem() {
        return item;
    }

}
