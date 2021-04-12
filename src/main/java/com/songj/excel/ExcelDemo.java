package com.songj.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.util.ArrayList;

import java.util.List;


/**
 * @ClassName: ExcelDemo
 * @BelongPackage: com.songj.excel
 * @Description:
 * @Author: Jisai
 * @Date: 2021/4/12 下午5:18
 * @Version: v1.0
 */
public class ExcelDemo {


    public static void main(String[] args) {
        String filePath = "/Users/jisai/Downloads/test_data/test_excel.xlsx";
        File file = new File(filePath);
        readExcel(filePath);

    }

    public static List<String> readExcel(String filePath) {
      List<String> list = new ArrayList<>();
        try {
            /*
             *简单判断后缀名，如需通过文件流判断文件类型，
             * 请调用getFileTypeByStream方法
             * Excel( xls) 文件头：504B03
             * Excel( xlsx) 文件头：D0CF11
             * */
            boolean xls = filePath.endsWith(".xls");
            boolean xlsx = filePath.endsWith(".xlsx");
            Workbook book;
            Sheet sheet = null;
            InputStream inputStream = new FileInputStream(new File(filePath));
            if (xls) {
                // 解析excel
                POIFSFileSystem pSystem = new POIFSFileSystem(inputStream);
                // 获取整个excel
                book = new HSSFWorkbook(pSystem);
                //获取第一个表单sheet
                sheet = book.getSheetAt(0);
            }
            if (xlsx) {
                // 直接通过流获取整个excel
                book = new XSSFWorkbook(inputStream);
                // 获取第一个表单sheet
                sheet = book.getSheetAt(0);
            }
            if (sheet != null) {
                // 获取第一行
                int firstRow = sheet.getFirstRowNum();
                // 获取最后一行
                int lastRow = sheet.getLastRowNum();
                // 循环行数依次获取列数
                for (int i = firstRow; i < lastRow + 1; i++) {
                  List<String> rowList = new ArrayList<>();
                  // 获取第 i 行
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        // 获取此行的第一列
                        int firstCell = 0;
                        /*
                         *获取此行的存在数据的第一列
                         * int firstCell = row.getFirstCellNum();
                         * */
                        // 获取此行的存在数据的最后一列
                        int lastCell = row.getLastCellNum();
                        // 创建集合，保存每一行的每一列
                        for (int j = firstCell; j < lastCell; j++) {
                            // 获取第 j 列
                            Cell cell = row.getCell(j);
                            if (cell != null) {
                              rowList.add(cell.toString());
                            } else {
                              rowList.add("");
                            }
                        }
                      System.out.println(rowList);
                    }
                  list.add(String.join(",", rowList));
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
