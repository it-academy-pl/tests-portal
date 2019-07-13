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
import pl.itacademy.testsportal.model.Group;
import pl.itacademy.testsportal.model.Student;
import pl.itacademy.testsportal.service.GroupService;
import pl.itacademy.testsportal.service.StudentService;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
@Transactional
public class StudentController {

    public static final int ROW_START_NUMBER = 17;
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
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

        try {
//            Workbook wb = new HSSFWorkbook(new FileInputStream("/Users/sebastianpakula/Dropbox/Java/tests-portal/src/main/resources/external_files/uzupelnianieOcen_Mechanika 1_Cwiczenia audytoryjne_GA07.xls"));
            Workbook wb = new HSSFWorkbook(new FileInputStream("/Users/sebastianpakula/Dropbox/Java/tests-portal/src/main/resources/external_files/przyklad.xls"));
            Sheet sheet = wb.getSheetAt(0);
            Row row;
            Group group;
            Cell cell;
            String surname;
            long index;
            logger.info("Getting group name and subject name from file");
            String groupName = sheet.getRow(13).getCell(2).getStringCellValue();
            String subjectName = sheet.getRow(10).getCell(2).getStringCellValue();

            logger.info("Group is: " + groupName + " and subject is: " + subjectName);
            logger.debug("Checking if group " + groupName + " exists in database");
            group = groupService.getByName(groupName);
            if (group == null) {
                logger.info("Group " + groupName + " doesn't exist in database");
                group = new Group(groupName, subjectName);
                groupService.addGroup(group);
            } else {
                logger.info("Group " + groupName + " exists in database!");
            }
            Student student = new Student();
            for (int i = ROW_START_NUMBER; i < sheet.getLastRowNum(); i++) {

                row = sheet.getRow(i);
                String[] names = row.getCell(1).getStringCellValue().split(" ");
                String name = names[1];
                // if name has more than 1 word
                for (int k = 2; k < names.length; k++) { // if name has more than 1 word
                    name = name + " " + names[k];
                }
                student.setName(name);
                student.setSurname(names[0]);
                if (row.getCell(2).getCellType() == CellType.STRING) {
                    student.setIndex(Long.parseLong(row.getCell(2).getStringCellValue()));
                } else if (row.getCell(2).getCellType() == CellType.NUMERIC) {
                    student.setIndex((long) row.getCell(2).getNumericCellValue());
                }
                student.setEmail("");
                student.setPassword(String.valueOf(student.getIndex()));
                student.setRepeatPassword(student.getPassword());
                student.setGroup(group);

                logger.info("Adding student: " + student + " Password: " + student.getPassword() + "(" + student.getGroup() + ")" + ":" + student.getRepeatPassword());
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