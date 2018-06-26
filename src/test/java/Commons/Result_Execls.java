package Commons;

import Objects.Excel_Object;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Result_Execls {
    private static String[] columns = {"TC_ID", "TC_Summary", "TC_Result", "TC_Note"};
    public static void saveResultExcel (Excel_Object ob1) throws IOException {

        //public static void main(String[] args) throws IOException, InvalidFormatException {

        //Create Workbook
        Workbook workbook = new XSSFWorkbook();

        //Create Sheet
        Sheet sheet = workbook.createSheet("Result_Excel");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        //create row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i=0; i<columns.length ;i++) // create cells
        {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        // Create Other rows and cells with Account data
        int rowNum =1;
        {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(ob1.getTC_ID());
            row.createCell(1).setCellValue(ob1.getTC_Summary());
            row.createCell(2).setCellValue(ob1.getTC_Result());
            row.createCell(3).setCellValue(ob1.getTC_Note());
        }
        //Resize
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("D:\\Tester\\PROJECT\\Mock Project\\CRM_Project\\src\\test\\Data\\ResultExcel.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}
