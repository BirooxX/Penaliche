package penaliche.penaliche.rsl;

import java.util.List;

import penaliche.penaliche.dto.Phrase;

/**
 * Web services exposés pour le traitememnt de phrase.
 * @author ebironne
 *
 */
public interface ServicePhrases {
	
	/**
	 * Permet de faire une demande d'ajout de phrase.
	 * @param reqPhrase la requete.
	 * @return une chaine
	 */
    String soumettrePhrase(Phrase reqPhrase);

    List<Phrase> recupererPhrase();
}