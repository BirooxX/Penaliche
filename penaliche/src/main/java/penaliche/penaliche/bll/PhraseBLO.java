/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  penaliche.dto.Phrase
 */
package penaliche.penaliche.bll;

import java.util.List;

import penaliche.penaliche.dto.Phrase;


public interface PhraseBLO {
    public String soumettrePhrase(Phrase var1);

    public List<Phrase> recupererPhrase();
}
