package htwberlin.backend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.print.DocFlavor;
import java.util.Objects;

@Entity
public class ChampionFromSource {


    @Id
    @Column(name = "champion_key")
    private int key;
    private String name;
    private String image;

    public ChampionFromSource() {
    }

    public ChampionFromSource(int key, String name, String image) {
        this.key = key;
        this.name = name;
        this.image = image;
    }

    public int getKey() {
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
        ChampionFromSource that = (ChampionFromSource) o;
        return Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, image);
    }
}
