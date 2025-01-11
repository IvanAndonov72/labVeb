package mk.ukim.lab.repository.impl;

import mk.ukim.lab.bootstrap.DataHolder;
import mk.ukim.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }

}
