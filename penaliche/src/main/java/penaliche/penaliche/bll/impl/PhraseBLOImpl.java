/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.googlecode.objectify.Objectify
 *  com.googlecode.objectify.ObjectifyService
 *  com.googlecode.objectify.Result
 *  com.googlecode.objectify.cmd.LoadType
 *  com.googlecode.objectify.cmd.Loader
 *  com.googlecode.objectify.cmd.Saver
 *  org.springframework.stereotype.Service
 *  penaliche.bll.PhraseBLO
 *  penaliche.dto.Phrase
 *  penaliche.helper.OfyService
 */
package penaliche.penaliche.bll.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import penaliche.penaliche.bll.PhraseBLO;
import penaliche.penaliche.dto.Phrase;
import penaliche.penaliche.dto.RequetePhrase;
import penaliche.penaliche.helper.OfyService;


/**
 * Implémentation de la aprtie métier pour ce qui concernent les Phrases.
 * @author ebironne
 *
 */
@Service
public class PhraseBLOImpl
implements PhraseBLO {
	
	/**
	 * Le logger.
	 */
    private static final Logger log = Logger.getLogger(PhraseBLOImpl.class.getName());

    
    /**
     * Permet d'enregistrer une Phraseen BDD.
     * @param reqPhrase La phrase à enregistrer
     * @return OK si tout s'est bien passé, le message d'erreur sinon.
     */
    public String soumettrePhrase(RequetePhrase reqPhrase) {
        try {

            Phrase phrase = new Phrase();
            phrase.setPhraseLabel(reqPhrase.getPhraseLabel());
            phrase.setAuteur(reqPhrase.getAuteur());
            phrase.setDenonceur(reqPhrase.getDenonceur());
            phrase.setCategorie(reqPhrase.getCategorie());

            //Si la darte n'est pas renseignée, on met la date du jour.
            if (StringUtils.isEmpty(phrase.getDate())) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formatDateTime = now.format(formatter);
                phrase.setDate(formatDateTime);
                phrase.setLocalDateTime(new Date());
            }

            Objectify objectify = ObjectifyService.ofy();
            objectify.save().entity((Object)phrase).now();
            return "OK";
        }
        catch (Exception e) {
            log.severe("Erreur lors de l'insertion en BDD : " + e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Permet de récupérer la liste des phrases.
     * @return La liste des phrases.
     */
    public List<Phrase> recupererPhrase() {
        return ObjectifyService.ofy().load().type((Class<Phrase>)Phrase.class).order("-localDateTime").list();
    }

    /**
     * Permet de récuperer les dernières phrases
     * @return
     */
    public List<Phrase> recupererDernieresPhrases() {
        return ObjectifyService.ofy().load().type((Class<Phrase>)Phrase.class).order("-localDateTime").limit(6).list();
    }
}
