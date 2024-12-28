package mk.ukim.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mk.ukim.lab.service.SongService;


@Controller
public class SongListController {
    private final SongService songService;

    public SongListController(SongService songService) {
        this.songService = songService;
    }


    @GetMapping("/listSongs")
    public String getListOfSongs(Model model) {
        //System.out.println("lelwgf");
        // Додај ја листата на песни во моделот
        model.addAttribute("songs", songService.listSongs());

        return "listSongs";
    }
}

