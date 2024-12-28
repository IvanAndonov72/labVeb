package mk.ukim.lab.service;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Optional<Song> findByTrackId(String trackId);
}
