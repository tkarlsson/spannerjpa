package eu.flexiverse.spannerdemos.spannerjpa.controllers;

import eu.flexiverse.spannerdemos.spannerjpa.entities.Artist;
import eu.flexiverse.spannerdemos.spannerjpa.entities.Record;
import eu.flexiverse.spannerdemos.spannerjpa.repos.ArtistsRepo;
import eu.flexiverse.spannerdemos.spannerjpa.repos.RecordsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class SpannerJpaWebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpannerJpaWebController.class);

    @Autowired
    private ArtistsRepo artistsRepo;

    @Autowired
    private RecordsRepo recordsRepo;

    @GetMapping("")
    public String componentInformation(Model model) {
        List<Artist> artists = artistsRepo.findAll();

        model.addAttribute("artists", artists);

        return "index";
    }

    @GetMapping("loaddata")
    public String loadData(Model model) {
        loadBaseData(model);

        return "loaddata";
    }

    public void loadBaseData(final Model model) {
        LOGGER.info("Populating base data");

        // Populate some base data
        Artist artist = new Artist();
        artist.setId(UUID.randomUUID().toString());
        artist.setName("Artist " + artist.getId());

        artistsRepo.save(artist);

        Record record = new Record();

        record.setId(UUID.randomUUID().toString());
        record.setArtistId(artist.getId());
        record.setTitle("Record title " + record.getId());

        recordsRepo.save(record);

        model.addAttribute("totArtists", artistsRepo.count());
        model.addAttribute("totRecords", recordsRepo.count());
    }
}
