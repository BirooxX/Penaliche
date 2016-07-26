package penaliche.penaliche.rsl;

import java.util.List;
import penaliche.penaliche.dto.Phrase;

public interface ServicePhrases {
    public String soumettrePhrase(Phrase var1);

    public List<Phrase> recupererPhrase();
}