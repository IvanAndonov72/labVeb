package mk.ukim.lab.service.impl;

import mk.ukim.lab.model.Album;
import mk.ukim.lab.repository.impl.AlbumRepository;
import mk.ukim.lab.repository.jpa.AlbumRepositoryJpa;
import mk.ukim.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepositoryJpa albumRepository;

    public AlbumServiceImpl(AlbumRepositoryJpa albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findALL() {
        return albumRepository.findAll();
    }
}
