package Commons;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Result2Excels {
    private static String[] columns = {"TC_ID", "TC_Summary", "TC_Result", "Note"};
    public static void saveResult2ExcelFile(String File_Name, String Sheet_Name, String TC_ID, String TC_Summary, String TC_Result) throws IOException {
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        //CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet(Sheet_Name);

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i <4 ; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create testcase result
        int rowNum = 1;

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(TC_ID);
            row.createCell(1).setCellValue(TC_Summary);
            row.createCell(2).setCellValue(TC_Result);


        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        String PathTillProject = System.getProperty("user.dir");
        FileOutputStream fileOut = new FileOutputStream(PathTillProject + "/src/test/Data/" + File_Name + ".xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();

    }
}
