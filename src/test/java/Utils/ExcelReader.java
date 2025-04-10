//package Utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelReader {
//
//    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
//        String cellValue = "";
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            if (sheet != null) {
//                Row row = sheet.getRow(rowNum);
//                if (row != null) {
//                    Cell cell = row.getCell(colNum);
//                    if (cell != null) {
//                        cellValue = switch (cell.getCellType()) {
//                            case STRING -> cell.getStringCellValue();
//                            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
//                            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
//                            default -> "";
//                        };
//                    }
//                }
//            }
//
//        } catch (IOException e) {
//            // Log the error using a logging framework
//            System.err.println("IOException occurred while reading Excel file: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return cellValue;
//    }
//
//    public static Object[][] getTableArray(String filePath, String sheetName) {
//        Object[][] tabArray = null;
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            if (sheet != null) {
//                int totalRows = sheet.getPhysicalNumberOfRows();
//                int totalCols = sheet.getRow(0).getLastCellNum();
//
//                tabArray = new Object[totalRows - 1][totalCols]; // skip header
//
//                for (int i = 1; i < totalRows; i++) {
//                    Row row = sheet.getRow(i);
//                    for (int j = 0; j < totalCols; j++) {
//                        Cell cell = row.getCell(j);
//                        tabArray[i - 1][j] = (cell != null) ? switch (cell.getCellType()) {
//                            case STRING -> cell.getStringCellValue();
//                            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
//                            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
//                            default -> "";
//                        } : "";
//                    }
//                }
//            }
//
//        } catch (IOException e) {
//            // Log the error using a logging framework
//            System.err.println("IOException occurred while reading Excel file: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return tabArray;
//    }
//}
