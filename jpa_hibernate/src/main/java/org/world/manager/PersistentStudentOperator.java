package org.world.manager;

import org.world.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistentStudentOperator {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample");
    EntityManager em;

    public static void main(String[] args) {
        PersistentStudentOperator po = new PersistentStudentOperator();

        po.insert();
    }

    public void insert() {

        //--------------Sample data --------------
        Student student = new Student();
        student.setFirstName("Claudio");
        student.setName("Clemens");
        student.setId(123);
        //--------------Sample data --------------

        em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        try {
            entityTransaction.begin();

            em.persist(student);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        }
    }
}