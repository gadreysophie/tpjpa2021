package dao;

import java.util.List;

import javax.persistence.EntityManager;

import domain.Departement;
import domain.Professionnel;

public class ProfessionnelDao {

    private EntityManager manager;

    public ProfessionnelDao (EntityManager manager) {
        this.manager = manager;
    }

    public void createProfessionnels() {
        int numOfEmployees = manager.createQuery("Select a From Professionnel a", Professionnel.class).getResultList().size();
        if (numOfEmployees == 0) {
            Departement departement = new Departement("java");
            manager.persist(departement);
            //Code
            manager.persist(new Professionnel("Professionnel 1",departement));
            manager.persist(new Professionnel("Professionnel 2",departement));
        }
    }

    public void listProfessionnels() {
        List<Professionnel> resultList = manager.createQuery("Select a From Professionnel a", Professionnel.class).getResultList();
        System.out.println("Nombre de professionnels : " + resultList.size());
        for (Professionnel next : resultList) {
            System.out.println("Professionnel suivant : " + next);
        }
    }


}
