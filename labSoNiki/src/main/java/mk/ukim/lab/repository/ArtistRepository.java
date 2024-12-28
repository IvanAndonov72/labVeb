package mk.ukim.lab.repository;

import mk.ukim.lab.bootstrap.DataHolder;
import mk.ukim.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    public List<Artist> findAll(){
        return DataHolder.artists;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artists.stream().filter(r->r.getId().equals(id)).findFirst();
    }

}
