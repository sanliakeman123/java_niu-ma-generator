package com.common.util;

public class MuiltRow {
    private Integer firstRow;
    private Integer lastRow;
    private String value;

    public Integer getFirstRow() {
        return firstRow;
    }

    public MuiltRow setFirstRow(Integer firstRow) {
        this.firstRow = firstRow;
        return this;
    }

    public Integer getLastRow() {
        return lastRow;
    }

    public MuiltRow setLastRow(Integer lastRow) {
        this.lastRow = lastRow;
        return this;
    }

    public String getValue() {
        return value;
    }

    public MuiltRow setValue(String value) {
        this.value = value;
        return this;
    }
}
