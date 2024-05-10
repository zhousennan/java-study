package com.zsn.shiro.config;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;


import static java.sql.Types.NUMERIC;
import static org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType.FORMULA;
import static org.apache.tomcat.util.bcel.classfile.ElementValue.STRING;
import static org.springframework.asm.Type.BOOLEAN;

/**
 * @Author: zsn
 * @Date: 2024/3/13 9:24
 * @Description: TODO Description of this class
 * @Version: 1.0
 */
public class test {


    public static void main(String[] args) {
        File rootDirectory = new File("E:\\readfile"); // 替换为你的目录路径
        listFiles(rootDirectory);

    }

    public static void listFiles(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file);
                } else {

                    System.out.println(file.getAbsolutePath());
                    if (file.getName().endsWith(".xlsx")) {
                        //读取Excel文件
                        readExcel(file.getAbsolutePath());
                    }
                   /* if (file.getName().endsWith(".doc")) {
                        //读取Excel文件
                        readExcel(file.getAbsolutePath());
                    }
*/
                    if (file.getName().endsWith(".docx")) {
                        //读取Word文件
                        readDocxWord(file.getAbsolutePath());
                    }
                   /* if (file.getName().endsWith(".xls")) {
                        //读取Word文件
                        readXlsExcel(file.getAbsolutePath());
                    }*/

                }
            }
        }
    }

/*    private static void readDocWord(String file) {
        try (FileInputStream fis = new FileInputStream("path_to_your_doc_document.doc")) {

            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(document);
            String text = extractor.getText();

            // 假设第一行在文档的开头，可以通过查找换行符来分割行
            int firstNewlineIndex = text.indexOf('\n');
            String firstLine = (firstNewlineIndex != -1) ? text.substring(0, firstNewlineIndex) : text;

            System.out.println("Word文档的第一行: " + firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private static void readXlsExcel(String file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new HSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表

            Row firstRow = sheet.getRow(0); // 获取第一行
            if (firstRow != null) {
                for (Cell cell : firstRow) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;

                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readDocxWord(String file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            XWPFDocument document = new XWPFDocument(fis);

            // 获取第一个段落
            XWPFParagraph paragraph = document.getParagraphs().iterator().next();

            // 遍历该段落中的所有文本运行（Run）
            StringBuilder firstLine = new StringBuilder();
            Iterator<XWPFRun> iterator = paragraph.getRuns().iterator();
            while (iterator.hasNext()) {
                XWPFRun run = iterator.next();
                firstLine.append(run.getText(0));
                if (iterator.hasNext()) {
                    firstLine.append(" "); // 添加空格以分隔不同的运行（Run）
                }
            }

            System.out.println("Word文档的第一行: " + firstLine.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void readExcel(String file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表

            Row firstRow = sheet.getRow(0); // 获取第一行
            if (firstRow != null) {
                Iterator<Cell> cellIterator = firstRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

