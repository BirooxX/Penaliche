/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  penaliche.dto.Phrase
 */
package penaliche.penaliche.bll;

import java.util.List;

import penaliche.penaliche.dto.Phrase;
import penaliche.penaliche.dto.RequetePhrase;


public interface PhraseBLO {
    public String soumettrePhrase(RequetePhrase var1);

    public List<Phrase> recupererPhrase();

    /**
     * Permet de récuperer les dernières phrases
     * @return
     */
    List<Phrase> recupererDernieresPhrases();
}
