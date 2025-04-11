package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReportGeneratorFromXML {

    public static void main(String[] args) throws Exception {
        // Charger et analyser le fichier XML
        File xmlFile = new File("C:\\Users\\oouyaz\\IdeaProjects\\Mini-Projet-BPI\\target\\cucumber-report.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Créer un classeur Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Cucumber Test Results");

        // Styles pour les en-têtes
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // Styles pour les statuts
        Font statusFont = workbook.createFont();
        statusFont.setBold(true);

        CellStyle passStyle = workbook.createCellStyle();
        passStyle.setFont(statusFont);
        passStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle failStyle = workbook.createCellStyle();
        failStyle.setFont(statusFont);
        failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Ligne d’en-tête des test cases
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Test Case Name");
        titleRow.createCell(1).setCellValue("Status");
        titleRow.createCell(2).setCellValue("Time");
        for (int i = 0; i < 3; i++) {
            titleRow.getCell(i).setCellStyle(headerStyle);
        }

        int rowNum = 5; // Commencer après l'en-tête

        // Parcourir les test cases
        NodeList testcaseList = doc.getElementsByTagName("testcase");

        for (int i = 0; i < testcaseList.getLength(); i++) {
            Node testcaseNode = testcaseList.item(i);

            if (testcaseNode.getNodeType() == Node.ELEMENT_NODE) {
                Element testcaseElement = (Element) testcaseNode;

                String testcaseName = testcaseElement.getAttribute("name");
                String time = testcaseElement.getAttribute("time");

                String systemOut = "";
                if (testcaseElement.getElementsByTagName("system-out").getLength() > 0) {
                    systemOut = testcaseElement.getElementsByTagName("system-out").item(0).getTextContent().trim();
                }

                String status = "Not Executed";
                if (testcaseElement.getElementsByTagName("failure").getLength() > 0) {
                    status = "Failed";
                } else if (testcaseElement.getElementsByTagName("system-out").getLength() > 0) {
                    status = "Passed";
                }

                // Ligne principale du test case
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(testcaseName);
                row.createCell(1).setCellValue(status);
                row.createCell(2).setCellValue(time);

                // Style pour le statut
                Cell statusCell = row.getCell(1);
                if ("Passed".equals(status)) {
                    statusCell.setCellStyle(passStyle);
                } else if ("Failed".equals(status)) {
                    statusCell.setCellStyle(failStyle);
                }

                // Lignes des étapes
                String[] steps = systemOut.split("\n");
                Row stepHeaderRow = sheet.createRow(rowNum++);
                stepHeaderRow.createCell(0).setCellValue("Step");
                stepHeaderRow.createCell(1).setCellValue("Step Status");
                for (int j = 0; j < 2; j++) {
                    stepHeaderRow.getCell(j).setCellStyle(headerStyle);
                }

                for (String step : steps) {
                    if (step.trim().isEmpty()) continue;

                    String stepText = step.trim();
                    String stepStatus = "";

                    // Nettoyage pour séparer le texte du statut
                    if (stepText.matches(".*\\.{3,}(passed|failed|skipped)$")) {
                        int lastDots = stepText.lastIndexOf("...");
                        stepStatus = stepText.substring(lastDots + 3).trim();
                        stepText = stepText.substring(0, lastDots).trim();
                    }

                    Row stepRow = sheet.createRow(rowNum++);
                    stepRow.createCell(0).setCellValue(stepText);
                    stepRow.createCell(1).setCellValue(stepStatus);
                }

                rowNum++; // espace entre test cases
            }
        }

        // Ajuster la largeur des colonnes
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Créer le répertoire si nécessaire
        File reportDirectory = new File("C:\\Users\\oouyaz\\IdeaProjects\\Mini-Projet-BPI\\target\\cucumber-reports");
        if (!reportDirectory.exists()) {
            reportDirectory.mkdirs();
        }

        // Écrire le fichier
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\oouyaz\\IdeaProjects\\Mini-Projet-BPI\\target\\cucumber-reports\\cucumber-report.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        System.out.println("✅ Rapport Excel généré avec succès !");
    }
}
