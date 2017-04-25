package org.world.manager;

import org.world.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentJpaOperator {
    private EntityManagerFactory emf;

    public StudentJpaOperator() {
        emf = Persistence.createEntityManagerFactory("AsturioPU");
    }

    public static void main(String[] args) {
        StudentJpaOperator po = new StudentJpaOperator();

        po.insert();

        System.out.println("Finished");
        po.emf.close();
    }

    private void insert() {
        //--------------Sample data --------------
        Student s1 = new Student();
        s1.setFirstName("Papa");
        s1.setName("Schlumpf");
        s1.setId(123);

        Student s2 = new Student();
        s2.setFirstName("Kind");
        s2.setName("Schlumpf");
        s2.setId(124);

        Student s3 = new Student();
        s3.setFirstName("Mama");
        s3.setName("Schlumpf");
        s3.setId(125);
        //--------------Sample data --------------

        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        try {
            entityTransaction.begin();

            em.persist(s1);
            em.persist(s2);
            em.persist(s3);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        }

        final TypedQuery<Student> query = em.createQuery("SELECT s FROM student s", Student.class);
        final List<Student> resultList = query.getResultList();
        for (Student student1 : resultList) {
            System.out.println(student1.getFirstName() + " " + student1.getName());
        }
        em.close();
    }
}