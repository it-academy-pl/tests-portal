package pl.itacademy.testsportal.controllers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.StudentService;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


@Controller
@Transactional
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ModelAndView allStudents() {
        logger.debug("getting all students");
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }

    @GetMapping("/addStudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/addStudent")
    public String studentSubmit(@ModelAttribute @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "result";
        }

        studentService.addStudent(student);
        return "result";
    }

    @GetMapping("/addStudentFromFile")
    public ModelAndView addStudentsFromFile() {
        logger.info("Oppening file");
        Student student = new Student();
        try {
//            Workbook wb = new HSSFWorkbook(new FileInputStream("/Users/sebastianpakula/Dropbox/Java/tests-portal/src/main/resources/external_files/uzupelnianieOcen_Mechanika 1_Cwiczenia audytoryjne_GA07.xls"));
            Workbook wb = new HSSFWorkbook(new FileInputStream("/Users/sebastianpakula/Dropbox/Java/tests-portal/src/main/resources/external_files/przyklad.xls"));
            Sheet sheet = wb.getSheetAt(0);
            Row row;
            Cell cell;
            String name;
            String surname;
            long index;

            for (int i = 18; i < sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String[] names = row.getCell(1).getStringCellValue().split(" ");
                student.setName(names[0]);
                student.setSurname(names[1]);
                if (row.getCell(2).getCellType() == CellType.STRING) {
                    student.setIndex(Long.parseLong(row.getCell(2).getStringCellValue()));
                } else if (row.getCell(2).getCellType() == CellType.NUMERIC) {
                    student.setIndex((long)row.getCell(2).getNumericCellValue());
                }
                student.setEmail("");
                student.setPassword(String.valueOf(student.getIndex()));
                student.setRepeatPassword(student.getPassword());

                logger.info("Adding student: " + student+ " Password: "+student.getPassword() + ":" + student.getRepeatPassword());
                studentService.addStudent(student);
            }
            logger.info("Closing file.");
            wb.close();


        } catch (IOException e) {
            logger.error("File hasn't been opened!");
            e.printStackTrace();
        }
        List<Student> students = studentService.getAllStudents();
        return new ModelAndView("/students.html", "students", students);
    }

}