package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
            EventoDAO ed = new EventoDAO(em);

            LocalDate eventDate = LocalDate.of(1996, 1, 23);
            Evento evento1 = new Evento("Paperino e Squirtols", eventDate, "Una bella reimpatriata", TipoEvento.PRIVATO, 2);
            Evento evento2 = new Evento("Paperino e Alex", eventDate, "Una cena tranquilla", TipoEvento.PUBBLICO, 2);

            ed.save(evento1);
            ed.save(evento2);

            Evento eventFromDB = ed.getById(1);
            System.out.println(eventFromDB);


            ed.delete(evento2);


        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        } finally {

        }

    }
}
