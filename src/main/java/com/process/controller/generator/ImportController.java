package com.process.controller.generator;


import com.common.Result;
import com.common.RowMedata;
import com.common.dict.ExcelDict;
import com.common.util.ExcelUtil;
import com.common.util.MuiltRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/import")
public class ImportController {

    @PostMapping("/test")
    public Result<String> importTest(@RequestParam MultipartFile file){
        try{
            // 获取文件输入流
            InputStream in = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(in);

            if(workbook != null){
                // 获取第一个sheet
                Sheet sheet = workbook.getSheetAt(0);

                // 如果列序相同 行序不同 说明单列多行行合并
                // 如果列序不同 行序相同 说明单行多列合并
                // 否则 多行多列
                int firstRowNum = sheet.getFirstRowNum();
                Row medataRow = sheet.getRow(firstRowNum);
                
                List<RowMedata> rowsMedata = ExcelUtil.getRows(medataRow, ExcelDict.stepImportMap, ExcelDict.stepImportRequiredMap);
                int column = -1;
                for (RowMedata rowMedata : rowsMedata) {
                    String field = rowMedata.getField();
                    if("taskCode".equals(field)){
                        column = rowMedata.getColumnIndex();
                    }
                }
                ExcelUtil taskExcel = new ExcelUtil();
                if(column == -1){
                    return new Result<>(-1,"没有找到taskCode");
                }
                List<MuiltRow> muiltRows = new ArrayList<>();
                while(taskExcel.getMuiltRows(sheet,column,1000)){
                    muiltRows = taskExcel.getMuiltRows();
                }


                System.out.println(muiltRows);

                System.out.println("123");
            }

            return new Result<>("");
        }
        catch (Exception e){
            return new Result<>(-1,e.getMessage());
        }
    }

}
