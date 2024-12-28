package mk.ukim.lab.web;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import mk.ukim.lab.service.ArtistService;
import mk.ukim.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }


    @PostMapping
    public String getSongDetails(@RequestParam String trackId, Model model){
        Optional<Song> optionalSong = songService.findByTrackId(trackId);
        if(optionalSong.isPresent()){
            Song song = optionalSong.get();
            List<Artist> artists = artistService.listArtists();
            model.addAttribute("artists", artists);
            model.addAttribute("song", song);
            return "artistList";
        }else{
            return "artistList";
        }





    }
}
