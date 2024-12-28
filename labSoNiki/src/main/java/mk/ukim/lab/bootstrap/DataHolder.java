package mk.ukim.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists;

    public static List<Song> songs;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist("Ivan","Andonov","legenda"));
        artists.add(new Artist("Niki","Golubovski","mlitkavec"));
        artists.add(new Artist("Bale","balevski","legenda"));
        artists.add(new Artist("Simon","Simonov","glupco"));
        artists.add(new Artist("Viktor","Viktorov","smotko"));

        songs=new ArrayList<>();
        songs.add(new Song("1", "Imagine", "Rock", 1971, List.of(new Artist( "John", "Lennon", "Famous musician"))));
        songs.add(new Song("2", "Bohemian Rhapsody", "Rock", 1975, List.of(new Artist( "Freddie", "Mercury", "Lead singer of Queen"))));
        songs.add(new Song("3", "Yesterday", "Pop", 1965, List.of(new Artist("John", "Lennon", "Famous musician"))));
        songs.add(new Song("4", "Shape of You", "Pop", 2017, List.of(new Artist( "Ed", "Sheeran", "Famous pop singer"))));
        songs.add(new Song("5", "Rolling in the Deep", "Soul", 2010, List.of(new Artist( "Adele", "Adkins", "Famous singer-songwriter"))));
    }
}
