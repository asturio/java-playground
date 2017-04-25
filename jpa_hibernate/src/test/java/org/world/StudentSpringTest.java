package org.world;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.world.entity.Student;
import org.world.spring.StudentService;
import org.world.spring.StudentSpringConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StudentSpringConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class StudentSpringTest {
    @Autowired
    private StudentService studentService;

    @Test
    public final void whenContextIsBootstrapped_thenNoException() {
        Assert.assertNotNull("No StudentService injected", studentService);
        //
    }

    @Test
    public final void whenEntityIsCreated_thenNoExceptions() {
        final Student student = new Student();
        student.setName("DJ");
        student.setFirstName("Bobo");
        student.setId(1);
        studentService.create(student);

        final List<Student> all = studentService.findAll();
        Assert.assertFalse("The Student wasn't saved", all.isEmpty());

        for (Student s : all) {
            System.out.println(s);
        }
    }

}