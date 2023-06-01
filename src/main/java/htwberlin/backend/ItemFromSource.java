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
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long key;
   private String name;
   private String image;
   private int gold;
   private Set <String> tags = new HashSet<>();
   private HashMap <String, Double > stats = new HashMap<>();
   private String description;

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

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ItemFromSource that = (ItemFromSource) o;
      return gold == that.gold && Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(tags, that.tags) && Objects.equals(stats, that.stats) && Objects.equals(description, that.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(key, name, image, gold, tags, stats, description);
   }

   @Override
   public String toString() {
      return "ItemFromSource{" +
              "key='" + key + '\'' +
              ", name='" + name + '\'' +
              ", image='" + image + '\'' +
              ", gold=" + gold +
              ", tags=" + tags +
              ", stats=" + stats +
              ", description='" + description + '\'' +
              '}';
   }

}
