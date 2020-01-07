package com.pazz.java.test;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * @author: 彭坚
 * @create: 2019/9/17 11:25
 * @description:
 */
public class TestWorkbook {

    public static void main(String[] args) throws IOException {
        Workbook workbook = new SXSSFWorkbook();
        File file = new File("F:/TestExcel.xlsx");
        // 文件不存在就创建
        file.createNewFile();
        // 获取文件得写入流
        OutputStream os = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        // 设置压缩文件
        ((SXSSFWorkbook) workbook).setCompressTempFiles(true);
        // 创建cell(单元格)样式
//        CellStyle cellStyle = createCellStyle(workbook, HSSFColor.SKY_BLUE.index);
        // 表头headx
//        String[] headAttribute = new String[]{"表头1", "表头2", "表头3", "表头4"};
        Map<String, String> map = createMap();

        // 创建sheet 工作空间
        Sheet sheet = workbook.createSheet("工作表Sheet");
        sheet.setDefaultColumnWidth(10); //默认列宽

        Row headRow = sheet.createRow(0); // row 代表行对象 0表示第一行
        createHead(headRow, createMap());
//        for (int i = 0; i < map.size(); i++) {
//            Cell cell = headRow.createCell(i);
//            cell.setCellValue(headAttribute[i]);
////            cell.setCellStyle(cellStyle);
//        }

        //默认五条数据
//        for (int i = 1; i <= 5; i++) {
//            Row rowData = sheet.createRow(i);
//            for (int j = 0; j < headAttribute.length; j++) {
//                Cell dataCell = rowData.createCell(j);
//                dataCell.setCellValue("PJ- AlienWare" + i);
////                dataCell.setCellStyle(createCellStyle(workbook, HSSFColor.PLUM.index));
//            }
//        }

        // 将写进流
        workbook.write(bos);
        bos.close();
        os.close();
    }

    public static void populateData(Row row, List<Node> nodes){

    }

    public static class Node{
        public String key;
        public String val;

        public Node(String key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void createHead(Row row, Map<String, String> map) {
        Set<String> setK = map.keySet();
        Iterator<String> iterator = setK.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Cell cell = row.createCell(index);
            cell.setCellValue(map.get(iterator.next()));
            index++;
        }
    }

    public static CellStyle createCellStyle(Workbook workbook, short color) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(color);//设置单元格着色
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置单元格
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);//设置下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//设置左边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//设置右边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//设置上边框
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
        return cellStyle;
    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new LinkedHashMap<>();//有序
        map.put("att1", "名称");
        map.put("att2", "性别");
        map.put("att3", "年龄");
        map.put("att4", "身高");
        return map;
    }

}
