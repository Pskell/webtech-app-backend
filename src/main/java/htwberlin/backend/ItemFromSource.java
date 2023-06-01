package htwberlin.backend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ItemFromSource {
   @Id
   @Column(name = "item_key")
   private Long key;
   private String name;
   private String image;
   private int gold;

   @ElementCollection
   private Set <String> tags = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "item_stats_mapping", joinColumns = @JoinColumn(name = "item_key"))
    @MapKeyColumn(name = "stat_key")
    @Column(name = "stat_value")
   private HashMap <String, Double > stats = new HashMap<>();

   public ItemFromSource() {

   }

   public ItemFromSource(Long key, String name, String image, int gold, Set<String> tags, HashMap<String, Double> stats, String description) {
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

   public HashMap<String, Double> getStats() {
      return stats;
   }

   public void setStats(HashMap<String, Double> stats) {
      this.stats = stats;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ItemFromSource that = (ItemFromSource) o;
      return gold == that.gold && Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(tags, that.tags) && Objects.equals(stats, that.stats);
   }

   @Override
   public int hashCode() {
      return Objects.hash(key, name, image, gold, tags, stats);
   }

   @Override
   public String toString() {
      return "ItemFromSource{" +
              "key='" + key + '\'' +
              ", name='" + name + '\'' +
              ", image='" + image + '\'' +
              ", gold=" + gold +
              ", tags=" + tags +
              ", stats=" + stats + '\'' +
              '}';
   }

}
