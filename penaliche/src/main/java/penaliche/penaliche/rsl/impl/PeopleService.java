package penaliche.penaliche.rsl.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penaliche.penaliche.bll.PeopleBLO;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleService {

    @Autowired
    PeopleBLO peopleBLO;

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getPeople() {
        List<String> result = peopleBLO.getPeople();
        Collections.sort(result);
        return result;
    }

}
