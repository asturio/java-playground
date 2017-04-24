package org.world.manager;

import org.world.entity.Citizen;
import org.world.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistentOperator {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample");
    EntityManager em;

    public static void main(String[] args) {
        PersistentOperator po = new PersistentOperator();

        po.insert();
    }

    public void insert() {

        //--------------Sample data --------------
        Citizen citizen1 = new Citizen();
        Citizen citizen2 = new Citizen();
        Citizen citizen3 = new Citizen();
        Citizen citizen4 = new Citizen();

        Country country1 = new Country();
        country1.setCountry_id(123);
        country1.setName("Brazil");
        country1.setCurrency("Brazilian real");

        Country country2 = new Country();
        country2.setCountry_id(234);
        country2.setName("Ghana");
        country2.setCurrency("Ghana cedi");

        citizen1.setName("William");
        citizen1.setCitizen_id(345);
        citizen1.setCountry(country1);
        citizen1.setAddress("No 1, Street 1.");

        citizen2.setName("Sophie");
        citizen2.setCitizen_id(456);
        citizen2.setCountry(country1);
        citizen2.setAddress("No 2, Street 2.");

        citizen3.setName("Julia");
        citizen3.setCitizen_id(567);
        citizen3.setCountry(country2);
        citizen3.setAddress("No 3, Street 3.");

        citizen4.setName("Len");
        citizen4.setCitizen_id(678);
        citizen4.setCountry(country2);
        citizen4.setAddress("No 4, Street 4.");

        //--------------Sample data --------------

        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        try {
            entityTransaction.begin();

            em.persist(country1);
            em.persist(country2);
            em.persist(citizen1);
            em.persist(citizen2);
            em.persist(citizen3);
            em.persist(citizen4);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        }
    }
}