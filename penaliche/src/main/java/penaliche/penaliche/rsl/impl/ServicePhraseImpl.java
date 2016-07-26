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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import penaliche.penaliche.bll.PhraseBLO;
import penaliche.penaliche.dto.Phrase;
import penaliche.penaliche.rsl.ServicePhrases;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@RestController
public class ServicePhraseImpl
implements ServicePhrases {
    @Autowired
    PhraseBLO PhraseBLO;

    @RequestMapping(value={"/phrase"}, method={RequestMethod.POST}, produces={"application/json"}, consumes={"application/json"})
    public String soumettrePhrase(@RequestBody Phrase phrase) {
        return this.PhraseBLO.soumettrePhrase(phrase);
    }

    @RequestMapping(value={"/phrase"}, method={RequestMethod.GET}, produces={"application/json"})
    @ResponseBody
    public List<Phrase> recupererPhrase() {
        return this.PhraseBLO.recupererPhrase();
    }
}
