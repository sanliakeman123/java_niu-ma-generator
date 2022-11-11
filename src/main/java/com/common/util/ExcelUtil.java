package com.common.util;

import com.common.RowMedata;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
* excel操作
* */
public class ExcelUtil {
    // 根据输入流获取excel文件
    private Workbook _get(InputStream in) throws IOException {
        Workbook _workbook = WorkbookFactory.create(in);
        return _workbook;
    }

    /**
    * 根据 row 获取列元素据 导入使用
    * */
    public static List<RowMedata> getRows(Row rowMeta,Map<String,String> importMap, Map<String,Boolean> requireMap) {
        if (rowMeta == null) {
            return null;
        }
        List<RowMedata> rowMedataList = new ArrayList<>();
        Iterator<Cell> cellIterator = rowMeta.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String cellValue = getCellValue(cell,null);
            if(cellValue!=null){
                RowMedata rowMedata = new RowMedata();
                rowMedata.setDescribe(cellValue);
                rowMedata.setColumnIndex(cell.getColumnIndex());
                if(requireMap.containsKey(cellValue)){
                    rowMedata.setImportRequired(requireMap.get(cellValue));
                }else{
                    rowMedata.setImportRequired(false);
                }
                if(importMap.containsKey(cellValue)){
                    rowMedata.setField(importMap.get(cellValue));
                    rowMedataList.add(rowMedata);
                }
            }
        }
        if(rowMedataList.size()==0){
            return null;
        }
        return rowMedataList;
    }

    /**
     * 检查必填数据
     * */
    public static void checkRequired(Sheet sheet, List<RowMedata> rowsMedata) {
        if(rowsMedata != null){
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext()){
                Row curRow = rowIterator.next();
                if( curRow!=null ){
                    for (RowMedata rowMedata : rowsMedata) {
                        int columnIndex = rowMedata.getColumnIndex();
                        Cell cell = curRow.getCell(columnIndex);
                        if( cell==null && rowMedata.getImportRequired()){
                            throw new IllegalArgumentException(curRow.getRowNum()+1+"行"+rowMedata.getDescribe()+"为空");
                        }
                    }
                }
            }
        }
    }

    // 批量插入条数
    private static final int MAX_limit = 1700;

    // 迭代器 方便分组插入
    private Iterator<Row> _iterator;
    public void rowIterator(Sheet sheet){
        if(sheet!=null){
            this._iterator = sheet.rowIterator();
            if(_iterator.hasNext()){
                _iterator.next();
            }
        }else {
            throw new IllegalArgumentException("sheet为空");
        }

    }
    /**
     * 组装实体对象list
     * */
    public <T> List<T> makeList(List<RowMedata> rowsMedata, Class cls, SimpleDateFormat sdf){
        if(rowsMedata != null){
//            Iterator<Row> rowIterator = this._iterator;
            int i = 0;
            List<T> list = new ArrayList<>();
            while (this._iterator.hasNext()){
                if(i == MAX_limit){
                    return list;
                }
                Row curRow = this._iterator.next();

                if( curRow!=null ){
                    T t = null;
                    try {
                        t = (T) cls.newInstance();
                        i++;
                        for (RowMedata rowMedata : rowsMedata) {
                            int columnIndex = rowMedata.getColumnIndex();
                            Cell cell = curRow.getCell(columnIndex);
                            if(cell!=null){
                                String cellValue = getCellValue(cell,sdf);
                                Field field = cls.getDeclaredField(rowMedata.getField());
                                field.setAccessible(true);
                                field.set(t,cellValue);
                            }
                        }
                        list.add(t);
                    } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            }
            return list;
        }
        return null;
    }

    /**
     * 组装表头 导出使用
     *
     * */

    public static List<RowMedata> makeFirstRow(Map<String,String> exportMap , List<String> exportList){

        int size = exportList.size();
        if(size==0){
            return null;
        }
        List<RowMedata> rowMedataList = new ArrayList<>();
        for(int i = 0;i<size;i++){
            RowMedata rowMedata = new RowMedata();

            String field = exportList.get(i);
            if(exportMap.containsKey(field)){
                rowMedata.setDescribe(exportMap.get(field));
            }
            rowMedata.setField(field);
            rowMedata.setColumnIndex(i);
            rowMedataList.add(rowMedata);
        }

        return rowMedataList;
    }

    private static String getCellValue(Cell cell) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getCellValue(cell,sdf);
    }

    private static String getCellValue(Cell cell, SimpleDateFormat sdf) {
        switch (cell.getCellType()){
            case BOOLEAN:
                // 布尔数据类型
                // 得到Boolean 对象的方法
                return cell.getBooleanCellValue()+"";
            case NUMERIC:
                // 数字类型
                //先看是否是日期格式
                if (DateUtil.isCellDateFormatted(cell)) {
                    //读取日期格式
                    return sdf.format(cell.getDateCellValue());
                } else {
                    //读取数字
                    return cell.getNumericCellValue() + "";
                }
            case FORMULA:
                // 公式类型
                return cell.getCellFormula();
            case STRING:
                // 字符串类型
                return cell.getRichStringCellValue().toString() + "";
            default:
                return null;
        }
    }
    // 记录获取合并单元格下标
    private Integer _curNumMerged = 0;

    // 记录合并单元格单列多行集合

    private List<MuiltRow> muiltRows = new ArrayList<>();


    public List<MuiltRow> getMuiltRows() {
        return muiltRows;
    }

    // 总共合并单元数
    private Integer _countNumMerged;
    /**
     * 获取单列多行合并单元格
     * 最多获取maxCount个元素
     * */
    public boolean getMuiltRows(Sheet sheet,int column, int maxCount){

        int mergedRegions = sheet.getNumMergedRegions();
        if(mergedRegions == _curNumMerged){
            return false;
        }
        int count = 0;
        muiltRows.clear();
        for( ; _curNumMerged < mergedRegions && column <  maxCount ; count++,_curNumMerged++){
            CellRangeAddress mergedRegion = sheet.getMergedRegion(_curNumMerged);
            int firstColumn = mergedRegion.getFirstColumn();
            int lastColumn = mergedRegion.getLastColumn();
            int firstRow = mergedRegion.getFirstRow();
            int lastRow = mergedRegion.getLastRow();
            if( column == firstColumn && column == lastColumn){
                muiltRows.add( new MuiltRow().setFirstRow(firstRow).setLastRow(lastRow).setValue(getMergedRegionValue(sheet,firstRow,column)) );
            }
        }
        return true;
    }




    /**
     * 获取合并单元格的值
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }
        return null ;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     */
    public boolean isMergedRegion(Sheet sheet , int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++ ){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true ;
                }
            }
        }

        return false ;
    }


}


