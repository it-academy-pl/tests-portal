package pl.itacademy.testsportal.model;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelConfigurator {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String EXCEL_PATH = PROJECT_PATH + "/Excel";
    public static final String FILENAME = EXCEL_PATH + "/listastudentow.xlsx";

    public CellStyle getCellStyle() {
        return cellStyle;
    }

    protected CellStyle cellStyle;

    protected void headerSetup(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        this.cellStyle = headerCellStyle;
    }
}
