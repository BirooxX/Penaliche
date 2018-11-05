/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.bind.annotation.RestController
 *  penaliche.bll.PhraseBLO
 *  penaliche.dto.Phrase
 *  penaliche.rsl.ServicePhrases
 */
package penaliche.penaliche.rsl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import penaliche.penaliche.bll.PhraseBLO;
import penaliche.penaliche.dto.Phrase;
import penaliche.penaliche.dto.RequetePhrase;
import penaliche.penaliche.rsl.ServicePhrases;

@RestController
public class ServicePhraseImpl
implements ServicePhrases {
    @Autowired
    PhraseBLO PhraseBLO;

    @CrossOrigin
    @RequestMapping(value={"/phrase"}, method={RequestMethod.POST}, produces={"application/json"}, consumes={"application/json"})
    public String soumettrePhrase(@RequestBody RequetePhrase reqPhrase) {
        Phrase phrase = new Phrase();
        phrase.setPhraseLabel(reqPhrase.getPhraseLabel());
        phrase.setAuteur(reqPhrase.getAuteur());
        phrase.setDenonceur(reqPhrase.getDenonceur());
        phrase.setCategorie(reqPhrase.getCategorie());
        return this.PhraseBLO.soumettrePhrase(phrase);

    }

    @CrossOrigin
    @RequestMapping(value={"/phrase"}, method={RequestMethod.GET}, produces={"application/json"})
    @ResponseBody
    public List<Phrase> recupererPhrase() {
        return this.PhraseBLO.recupererPhrase();

    }
}
