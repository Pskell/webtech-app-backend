package htwberlin.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Champion {


    @Id
    @Column(name = "champion_key")
    private Long key;
    private String name;
    private String image;

    public Champion() {
    }

    public Champion(int key, String name, String image) {
        this.key = key;
        this.name = name;
        this.image = image;
    }

    public long getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ChampionFromSource{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion that = (Champion) o;
        return Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, image);
    }
}
