package mk.ukim.lab.repository.jpa;

import mk.ukim.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepositoryJpa extends JpaRepository<Album,Long> {

}
