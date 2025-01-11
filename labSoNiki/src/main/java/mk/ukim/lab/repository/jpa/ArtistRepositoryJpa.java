package mk.ukim.lab.repository.jpa;

import mk.ukim.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepositoryJpa extends JpaRepository<Artist, Long> {

}
