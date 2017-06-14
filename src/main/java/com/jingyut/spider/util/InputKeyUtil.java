package com.jingyut.spider.util;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取输入的关键字工具类
 * 主要从Excel中获取值
 * Created by mmy on 2017/6/14.
 */
public class InputKeyUtil {
    public static List<String> getKeysFromEecel(String excelPath){
        List<String> keys = new ArrayList<>();
        try {
            InputStream inp = new FileInputStream(excelPath);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet1 = wb.getSheetAt(0);
            int rowNum = sheet1.getLastRowNum();
            for (int i=0; i <= rowNum; i++){//注意此处需要使用 <= 操作符
                keys.add(sheet1.getRow(i).getCell(0).toString());
            }
        } catch (Exception e) {
            System.out.println("请输出准确的excel文件的完整路径");
        }
        return keys;
    }

    public static void main(String[] args) throws Exception {
        InputKeyUtil.getKeysFromEecel(args[0]).forEach(s -> System.out.println(s));
    }
}
