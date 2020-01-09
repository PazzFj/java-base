package com.pazz.java.workbook;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: 彭坚
 * @create: 2020/1/9 21:28
 * @description: excel 创建
 */
public class $_Main {

    public static void main(String[] args) throws Exception {
        Workbook workbook = new SXSSFWorkbook();
        // 设置压缩文件
        ((SXSSFWorkbook) workbook).setCompressTempFiles(true);
        // 创建cell(单元格)样式  (blue蓝色)
        CellStyle cellStyle = createHeadCellStyle(workbook, HSSFColor.SKY_BLUE.index);
        // head 显示数据
        Map<String, String> headMap = createHeadMap();

        // 创建sheet 工作空间
        Sheet sheet = workbook.createSheet("工作表Sheet");
        sheet.setDefaultColumnWidth(20); //默认列宽

        // row 代表行对象 0表示第一行
        Row headRow = sheet.createRow(0);
        // 给头填充数据和格式
        createHeadCell(headRow, cellStyle, headMap);

        //默认五条数据
        for (int i = 1; i <= 50; i++) {
            Row rowData = sheet.createRow(i);
            for (int j = 0; j < headMap.size(); j++) {
                Cell dataCell = rowData.createCell(j);
                dataCell.setCellValue("PJ- AlienWare" + i);
                dataCell.setCellStyle(createHeadCellStyle(workbook, HSSFColor.PLUM.index));
            }
        }

        File file = new File("F:/测试.xlsx");
        // 文件不存在就创建
        file.createNewFile();
        // 获取文件得写入流
        OutputStream os = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(os);

        // 将写进流
        workbook.write(bos);
        workbook.close();
        bos.close();
        os.close();
    }

    public static void createHeadCell(Row row, CellStyle cellStyle, Map<String, String> map) {
        Set<String> setK = map.keySet();
        Iterator<String> iterator = setK.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Cell cell = row.createCell(index);
            cell.setCellValue(map.get(iterator.next()));
            cell.setCellStyle(cellStyle);
            index++;
        }
    }

    public static CellStyle createHeadCellStyle(Workbook workbook, short color) {
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

    public static Map<String, String> createHeadMap() {
        Map<String, String> map = new LinkedHashMap<>();//有序
        map.put("property1", "名称");
        map.put("property2", "性别");
        map.put("property3", "年龄");
        map.put("property4", "身高");
        return map;
    }

}
