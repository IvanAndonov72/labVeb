package mk.ukim.lab.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mk.ukim.lab.model.Album;
import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import mk.ukim.lab.repository.jpa.AlbumRepositoryJpa;
import mk.ukim.lab.repository.jpa.ArtistRepositoryJpa;
import mk.ukim.lab.repository.jpa.SongRepositoryJpa;
import org.springframework.stereotype.Service;
import mk.ukim.lab.service.SongService;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final SongRepositoryJpa songRepository;
    private final ArtistRepositoryJpa artistRepository;

    private final AlbumRepositoryJpa albumRepository;

    public SongServiceImpl(EntityManager entityManager, SongRepositoryJpa songRepository, ArtistRepositoryJpa artistRepository, AlbumRepositoryJpa albumRepository) {
        this.entityManager = entityManager;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
       return songRepository.findAll();
    }

    @Override
    @Transactional
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().removeIf(r->r.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Optional<Song> findById(Long id){
        return songRepository.findById(id);
    }

    @Override
    public void save(Long id,String title, String trackId, String genre, int releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow();
        if (id==null){
            Song newSong = new Song(trackId,title,genre,releaseYear);
            newSong.setAlbum(album);
            songRepository.save(newSong);
        }else {
            Song song = songRepository.findById(id).orElseThrow();
            song.setAlbum(album);
            song.setTitle(title);
            song.setTrackId(trackId);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            boolean isManaged = entityManager.contains(song);
            System.out.println("Is entity managed? " + isManaged);
            songRepository.save(song);
        }
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
