package htwberlin.backend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class ItemSet {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primKey;

    private String title;
    @ElementCollection
    private List<Integer> associatedMaps = new ArrayList<>();
    @ElementCollection
    private List<Integer> associatedChampions = new ArrayList<>();
    ;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private static final List<ItemBlock> blocks = new ArrayList<>();


    public ItemSet() {
    }

    public ItemSet(String title) {
        this.title = title;
        associatedChampions = Arrays.asList(1);
        associatedMaps = Arrays.asList(11, 12);
        blocks.add(new ItemBlock());
    }

    public Long getPrimKey() {
        return primKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //TODO
    // Allow setters for adding/changing one/multiple maps/champions afterwards

    public List<Integer> getAssociatedMaps() {
        return associatedMaps;
    }

    public List<Integer> getAssociatedChampions() {
        return associatedChampions;
    }

    public List<ItemBlock> getBlocks() {
        return blocks;
    }

    public void addBlock() {
        blocks.add(new ItemBlock());
    }

    public void removeBlock() {
        blocks.remove(blocks.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSet itemSet = (ItemSet) o;
        return Objects.equals(primKey, itemSet.primKey) && Objects.equals(title, itemSet.title) && Objects.equals(associatedMaps, itemSet.associatedMaps) && Objects.equals(associatedChampions, itemSet.associatedChampions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primKey, title, associatedMaps, associatedChampions);
    }

    @Override
    public String toString() {
        return "ItemSet{" +
                "primKey=" + primKey +
                ", title='" + title + '\'' +
                ", associatedMaps=" + associatedMaps +
                ", associatedChampions=" + associatedChampions +
                '}';
    }
}
