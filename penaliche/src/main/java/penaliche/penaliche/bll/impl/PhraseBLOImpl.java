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

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import penaliche.penaliche.bll.PhraseBLO;
import penaliche.penaliche.dto.Phrase;
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
     * @param phrase La phrase à enregistrer
     * @return OK si tout s'est bien passé, le message d'erreur sinon.
     */
    public String soumettrePhrase(Phrase phrase) {
        try {
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
        return ObjectifyService.ofy().load().type((Class<Phrase>)Phrase.class).list();
    }
}
