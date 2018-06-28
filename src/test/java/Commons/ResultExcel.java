package Commons;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultExcel {

    private static String[] columns = {"TC_ID","TC_Summary","TC_Result","Note"};
    public static void SaveResultExcels(String Sheet_Name,String TC_ID, String TC_Summary, String TC_Result) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper =workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet(Sheet_Name);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(TC_ID);
        row.createCell(1).setCellValue(TC_Summary);
        row.createCell(2).setCellValue(TC_Result);


        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\test\\Data\\ResultTCs.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
    }
}


