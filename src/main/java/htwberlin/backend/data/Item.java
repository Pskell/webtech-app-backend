package htwberlin.backend.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primKey;

    @NotNull
    private String id;
    private int count;

    public Item() {
    }

    /* Current list of items loaded inside the front-end only allow a count value of 1,
       but technically possible to save Items with count>1, if correctly implemented in the front-end.
    */
    public Item(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public Long getPrimKey() {
        return primKey;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return count == item.count && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
