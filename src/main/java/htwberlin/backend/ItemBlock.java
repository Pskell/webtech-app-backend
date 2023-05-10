package htwberlin.backend;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Objects;

//TODO
// It might be necessary to also create a REST-Interface for ItemBlock
@Entity
public class ItemBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primKey;
    private String type = "New Block";

    @ElementCollection
    private final HashMap<String, Integer> items = new HashMap<>();

    public ItemBlock() {
    }

    public ItemBlock(String type) {
        this.type = type;
    }

    public Long getPrimKey() {
        return primKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.merge(item, 1, Integer::sum);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemBlock itemBlock = (ItemBlock) o;
        return Objects.equals(primKey, itemBlock.primKey) && Objects.equals(type, itemBlock.type) && Objects.equals(items, itemBlock.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primKey, type, items);
    }

    @Override
    public String toString() {
        return "ItemBlock{" +
                "primKey=" + primKey +
                ", type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}
