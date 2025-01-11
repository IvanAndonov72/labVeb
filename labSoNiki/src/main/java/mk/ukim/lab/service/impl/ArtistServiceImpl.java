package mk.ukim.lab.service.impl;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.repository.jpa.ArtistRepositoryJpa;
import mk.ukim.lab.service.ArtistService;
import org.springframework.stereotype.Service;
import mk.ukim.lab.repository.impl.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepositoryJpa artistRepository;

    public ArtistServiceImpl(ArtistRepositoryJpa artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> ArtistfindById(Long id) {
        return artistRepository.findById(id);
    }
}
