package penaliche.penaliche.dto;

import com.google.gson.Gson;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * DTO Phrase.
 * @author ebironne
 *
 */
@Entity
public class Phrase {
    
	@Id
    private Long id;
    private String date;
    private String auteur;
    private String denonceur;
    private String phraseLabel;
    private Categorie categorie;

    /**
     * Renvoi la phrase au format JSON.
     * @return la phrase au format JSON
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson((Object)this);
    }

   
    /**
     * Construit une phrase à parir d'un flux JSON.
     * @param json Le flux Json
     * @return l'objet Phrase.
     */
    public static Phrase constructFromJson(String json) {
        Gson gson = new Gson();
        return (Phrase)gson.fromJson(json, (Class<Phrase>)Phrase.class);
    }

    public Long getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public String getDenonceur() {
        return this.denonceur;
    }

    public String getPhraseLabel() {
        return this.phraseLabel;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDenonceur(String denonceur) {
        this.denonceur = denonceur;
    }

    public void setPhraseLabel(String phrase) {
        this.phraseLabel = phrase;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
