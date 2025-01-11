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
    public String getSongDetails(@RequestParam(required = false) String trackId,@RequestParam(required = false) Long artistId, Model model){
        Optional<Song> optionalSong = songService.findByTrackId(trackId);
        Optional<Artist> optionalArtist = artistService.ArtistfindById(artistId);
        if(optionalSong.isPresent() && optionalArtist.isPresent()){
            Song song = optionalSong.get();
            Artist artist=optionalArtist.get();
            songService.addArtistToSong(artist,song);
            model.addAttribute("song", song);
            return "songDetails";
        }else{
            return "songDetails";
        }



    }
}
