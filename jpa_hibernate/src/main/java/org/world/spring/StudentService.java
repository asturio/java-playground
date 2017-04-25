package org.world.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.world.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void create(final Student student) {
        studentDao.create(student);
    }

    public Student findOne(final long id) {
        return studentDao.findeOne(id);
    }

    public List<Student> findAll() {
        return studentDao.findAll();

    }

}

