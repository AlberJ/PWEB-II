package br.edu.ifpb.memoriam.listener;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.ifpb.memoriam.dao.PersistenceUtil;

@WebListener
public class MemoriamContextListener implements ServletContextListener {
	private EntityManagerFactory emf;

    public void contextDestroyed(ServletContextEvent e)  {
    	if (emf != null && emf.isOpen()) {
    		emf.close();
    	}
    }

    public void contextInitialized(ServletContextEvent e)  { 
         emf = PersistenceUtil.createEntityManagerFactory("memoriam");
         System.out.println("Fábrica de EntityManagers construída!");
         
         // Carrega o arquivo que mapeia operações em classes de comandos
         Properties p = new Properties();
 		try {
 			p.load(e.getServletContext().getResourceAsStream("/WEB-INF/comandos.properties"));
 			e.getServletContext().setAttribute("comandos", p);
 			System.out.println("Arquivo de comandos carregado!");
 		} catch (IOException e1) {
 			System.out.println("Erro ao carregar arquivo de comandos!");
 		}
         
    }
	
}
