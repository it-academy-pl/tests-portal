package pl.itacademy.testsportal.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import pl.itacademy.testsportal.model.Student;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static pl.itacademy.testsportal.model.ExcelConfigurator.FILENAME;
import static pl.itacademy.testsportal.model.IndexHeaders.*;


public class ReadExcelService {




        public List<Student> readStudents() throws Exception {
            Path path = Paths.get(FILENAME);
            List<Student> listOfStudents = new ArrayList<>();

            if (!Files.exists(path)) {
                throw new Exception("No file");
            }

            InputStream inp = new FileInputStream(FILENAME);
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet("User");

            for (int rowNum = 1; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
                Row row = sheet.getRow(rowNum);
                Student student = new Student();

                student.setIndexNumber((long)row.getCell(INDEX_NUMBER.ordinal()).getNumericCellValue());
                student.setName(row.getCell(NAME.ordinal()).getStringCellValue());
                student.setSurname(row.getCell(SURNAME.ordinal()).getStringCellValue());

                listOfStudents.add(student);
            }


            return listOfStudents;
        }

    public static void main(String[] args) throws Exception {

            /*
            Student student1 = new Student("Rafal", "Szczotka", null, null, 1234);
            Student student2 = new Student("Marian", "Kowalski", null, null, 5678);

            WriteScheduleService writeScheduleService = new WriteScheduleService();
            writeScheduleService.generateSchedule(student1);

            */
            ReadExcelService readExcelService = new ReadExcelService();

            List<Student> studentList = readExcelService.readStudents();

            for (Student student : studentList) {
                System.out.println(student.getIndexNumber() + student.getName() + student.getSurname());

            }

    }
}
