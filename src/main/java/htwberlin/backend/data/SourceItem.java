package htwberlin.backend.data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.*;

@Entity
public class SourceItem {
    @Id
    @Column(name = "item_key")
    private Long key;
    private String name;
    private String image;
    private int gold;

    @ElementCollection
    private Set<String> tags = new HashSet<>();
    @ElementCollection
    private Map<String, Double> stats = new HashMap<>();

    public SourceItem() {

    }

    public SourceItem(Long key, String name, String image, int gold, Set<String> tags, HashMap<String, Double> stats, String description) {
        this.key = key;
        this.name = name;
        this.image = image;
        this.gold = gold;
        this.tags = tags;
        this.stats = stats;

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Map<String, Double> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Double> stats) {

        this.stats.putAll(stats);
    }

    @JsonAnySetter
    public void addStats(String key, Double value) {
        stats.put(key, value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceItem that = (SourceItem) o;
        return gold == that.gold && Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(tags, that.tags) && Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, image, gold, tags, stats);
    }

    @Override
    public String toString() {
        return "SourceItem{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", gold=" + gold +
                ", tags=" + tags +
                ", stats=" + stats + '\'' +
                '}';
    }

}
