/*
il dao ha solo una funzione logica, quella di separare la logica di business dalla logica di accesso ai dati
il dao conterrà tutte le istruzioni per accedere ai dati
la logica di business è la logica che si serve dei dati per prendere decisioni su come proseguire
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudenteDao {

    private EntityManager em;

    public StudenteDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();

    }

    public Studente () {}




    //dovrà salvare nel database lo studente che gli viene passato
    public void  salva(Studente studente) {

        em.getTransaction().begin();// inizio la transazione

        em.persist(studente); // dico al jpa di salvare lo studente sul database

        em.getTransaction().commit(); // il salvataggio effettivo avverrà solo al commit


    }

    public Studente getById(int matricola) {

       return em.find(Studente.class,matricola);
    }

    /*
    prende una matricola come parametro. Questa matricola verrà utilizzata per recuperare lo studente dal db
    attraverso il metodo getById
     */
    public void rimuovi(int matricola) {

        Studente s  = getById(matricola);

        if(s!=null){
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        }
    }
}
