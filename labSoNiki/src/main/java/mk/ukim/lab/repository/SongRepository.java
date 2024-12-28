package mk.ukim.lab.repository;

import mk.ukim.lab.bootstrap.DataHolder;
import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(String trackId){
        return DataHolder.songs.stream().filter(r->r.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song){
        song.getPerformers().removeIf(r->r.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
        return artist;
    }
}
