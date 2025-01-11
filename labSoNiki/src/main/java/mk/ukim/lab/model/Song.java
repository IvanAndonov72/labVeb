package mk.ukim.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;

    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Artist> performers;


    @ManyToOne
    @ToString.Exclude
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        album=null;
    }

    public Song() {

    }

}