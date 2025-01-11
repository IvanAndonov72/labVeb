package mk.ukim.lab.service;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
     Optional<Song> findByTrackId(String trackId);
     Optional<Song> findById(Long id);

    void save(Long id,String title, String trackId,String genre,int releaseYear, Long albumId);
    void deleteById(Long id);
}
