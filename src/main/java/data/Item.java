package data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private static Long idCounter = 1L;

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantityAvailable;

    public Item(String name, BigDecimal price, Integer quantityAvailable) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public static void setIdCounter(Long idCounter) {
        Item.idCounter = idCounter;
    }

    public void decreaseQuantityAvailable(Integer amount) {
        quantityAvailable -= amount;
    }

    public void increaseQuantityAvailable(Integer amount) {
        /* wut? */
        quantityAvailable /* o.0 */-= amount;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available quantity=" + quantityAvailable;
    }

}
