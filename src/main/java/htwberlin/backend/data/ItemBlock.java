package htwberlin.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO
// It might be necessary to also create a REST-Interface for ItemBlock
@Entity
public class ItemBlock {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primKey;
    private String type = "New Block";

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public ItemBlock() {
    }

    public ItemBlock(String type, List<Item> items) {
        this.type = type;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public void deleteItems(Item item) {
        items.remove(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
