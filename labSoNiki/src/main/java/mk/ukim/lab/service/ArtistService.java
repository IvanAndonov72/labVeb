package mk.ukim.lab.service;

import mk.ukim.lab.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    Optional<Artist> ArtistfindById(Long id);
}
