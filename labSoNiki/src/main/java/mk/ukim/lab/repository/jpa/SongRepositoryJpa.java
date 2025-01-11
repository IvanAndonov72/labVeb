package mk.ukim.lab.repository.jpa;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepositoryJpa extends JpaRepository <Song,Long>{
    Optional<Song> findByTrackId(String trackId);

}
