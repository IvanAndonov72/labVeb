package mk.ukim.lab.web;

import mk.ukim.lab.model.Artist;
import mk.ukim.lab.model.Song;
import mk.ukim.lab.service.ArtistService;
import mk.ukim.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/songDetails")
public class SongDetailsController {

    private final ArtistService artistService;
    private final SongService songService;

    public SongDetailsController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }


    @PostMapping
    public String getSongDetails(@RequestParam Long artistId, Model model){
        Optional<Artist> optionalArtist = artistService.ArtistfindById(artistId);
        if(optionalArtist.isPresent()){
            Artist artist
            model.addAttribute("song", song);
            return "songDetails";
        }else{
            return "songDetails";
        }



    }
}
