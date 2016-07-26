package penaliche.penaliche.helper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import penaliche.penaliche.dto.Phrase;

/**
 * Service Objectify pour gérer la BDD GAE.
 * @author ebironne
 *
 */
public class OfyService implements ServletContextListener {
    
	public void contextDestroyed(ServletContextEvent arg0) {
		//ObjectifyService.register((Class<Phrase>)Phrase.class);
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register((Class<Phrase>)Phrase.class);
	}
}
