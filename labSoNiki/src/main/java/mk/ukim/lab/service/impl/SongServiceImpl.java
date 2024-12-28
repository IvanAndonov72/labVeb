package mk.ukim.lab.service.impl;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import org.springframework.stereotype.Service;
import mk.ukim.lab.repository.ArtistRepository;
import mk.ukim.lab.repository.SongRepository;
import mk.ukim.lab.service.SongService;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
       return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
