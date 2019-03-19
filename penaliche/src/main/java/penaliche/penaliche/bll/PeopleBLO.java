package penaliche.penaliche.bll;

import com.googlecode.objectify.ObjectifyService;
import org.springframework.stereotype.Component;
import penaliche.penaliche.dto.Phrase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PeopleBLO {

    public List<String> getPeople() {
        List<Phrase> listePhrase = ObjectifyService.ofy().load().type((Class<Phrase>)Phrase.class).list();

        Set<String> set = new HashSet<>(listePhrase.size());
        listePhrase.stream().filter(p -> set.add(p.getAuteur())).collect(Collectors.toList());

        return new ArrayList<>(set);
    }
}
