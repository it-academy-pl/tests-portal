package pl.itacademy.testsportal.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.itacademy.testsportal.model.Student;

public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> arg0) {
        return Student.class.equals(arg0);
    }

    @Override
    public void validate(Object user, Errors e) {
        Student student = (Student) user;
        if (!student.getPassword().equals(student.getRepeatPassword())) {
            e.rejectValue("repeatPassword", "PasswordsDontMatch");
        }

    }
}
