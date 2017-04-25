package org.world.spring;

import org.springframework.stereotype.Repository;
import org.world.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
// // TODO: 25.04.17 : claudio.clemens: Can be Generic by Entity
public class StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Student student) {
        entityManager.persist(student);
    }

    public Student findeOne(long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("FROM " + Student.class.getName(), Student.class).getResultList();
    }
}
