package mk.ukim.lab.web;

import mk.ukim.lab.model.Album;
import mk.ukim.lab.model.Song;
import mk.ukim.lab.repository.jpa.SongRepositoryJpa;
import mk.ukim.lab.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mk.ukim.lab.service.SongService;

import java.util.List;
import java.util.Optional;


@Controller
public class SongListController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongListController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }


    @GetMapping("/songs")
    public String getListOfSongs(Model model) {
        model.addAttribute("songs", songService.listSongs());

        return "listSongs";
    }

    @PostMapping("/songs/add")
    public String saveOrUpdateSong(@RequestParam(required = false) Long id,
                                    String title,
                                    String trackId,
                                    String genre,
                                  int releaseYear,
                                   Long albumId){

        //id = null ako pesnata e nova   14to baranjeeee
        songService.save(id,title,trackId,genre,releaseYear,albumId);
        return "redirect:/songs";
    }

    @GetMapping("/songs/add-form")
    public String getAddSongPage(Model model){
        model.addAttribute("albums",albumService.findALL());
        return "add-song";
    }


    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId,Model model){
        Optional<Song> songToEdit = songService.findById(songId);

        if(songToEdit.isEmpty()) return "redirect:/songs?error=choose a valid song to edit";

        model.addAttribute("song",songToEdit.get());
        model.addAttribute("albums",albumService.findALL());
        return "add-song";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.deleteById(id);
        return "redirect:/songs";
    }
}

