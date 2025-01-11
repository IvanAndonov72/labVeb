package mk.ukim.lab.web;

import jakarta.annotation.PostConstruct;
import mk.ukim.lab.model.Song;
import mk.ukim.lab.repository.jpa.SongRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestFindAll {
    private final SongRepositoryJpa songRepository;

    public TestFindAll(SongRepositoryJpa songRepository) {
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void testFindAll() {
        List<Song> songs = songRepository.findAll();
        System.out.println("Songs: " + songs);
    }
}