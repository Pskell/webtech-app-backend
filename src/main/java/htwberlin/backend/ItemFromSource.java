package htwberlin.backend;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class ItemFromSource {
   @Id
   @Column(name = "item_key")
   private Long key;
   private String name;
   private String image;
   private Integer gold;

   @ElementCollection
   private Set <String> tags = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "stats", joinColumns = @JoinColumn(name = "item_key"))
    @MapKeyColumn(name = "set_key")
    @Column(name = "set_value")
   private Map<String, Double > stats=new HashMap<>();

   public ItemFromSource() {

   }

   public ItemFromSource(Long key, String name, String image, int gold, Set<String> tags, Map<String, Double> stats, String description) {
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
   public void addStats(String key, Double value) {
      stats.put(key,value);
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
