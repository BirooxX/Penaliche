package penaliche.penaliche.rsl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import penaliche.penaliche.bll.PhraseBLO;
import penaliche.penaliche.dto.Phrase;
import penaliche.penaliche.dto.RequetePhrase;

@RestController
public class PhraseService {

    @Autowired
    PhraseBLO PhraseBLO;

    @CrossOrigin
    @PostMapping(value={"/phrase"}, produces={"application/json"}, consumes={"application/json"})
    public String soumettrePhrase(@RequestBody RequetePhrase reqPhrase) {

        return this.PhraseBLO.soumettrePhrase(reqPhrase);

    }

    @CrossOrigin
    @GetMapping(value={"/phrase"}, produces={"application/json"})
    @ResponseBody
    public List<Phrase> recupererPhrase() {
        return this.PhraseBLO.recupererPhrase();

    }

    @CrossOrigin
    @GetMapping(value={"/phrase/last"}, produces={"application/json"})
    @ResponseBody
    public List<Phrase> recupererDernieresPhrases() {
        return this.PhraseBLO.recupererDernieresPhrases();

    }
}
