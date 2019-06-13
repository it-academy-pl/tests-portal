package pl.itacademy.testsportal.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.itacademy.testsportal.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Profile("h2hibernate")
public class StudentHibernateDao implements StudentDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> getAllStudents() {
//        return em.createQuery("Select s from STUDENT s ").getResultList();
        return em.createNamedQuery("Student.findAll").getResultList();
    }
    public Student getByEmail() {
        return (Student)em.createNamedQuery("Student.findByMail");
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }
}
