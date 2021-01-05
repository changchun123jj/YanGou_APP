package com.example.demo.entity.vo;

import java.io.Serializable;

/**
 * Excel单元格对象(适用于ExcelUtil)
 *
 * @author liaoc
 */
public class ExcelCell implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 值
     */
    private String text;
    /**
     * 字体大小
     */
    private int fontSize = 13;
    /**
     * 对齐方式(left,center,right)
     */
    private String align = "center";
    /**
     * 跨列数
     */
    private int col;
    /**
     * 宽度
     */
    private int width;
    /**
     * 是否加粗
     */
    private boolean bold;
    /**
     * 单元格格式(1:文本;2:数值)
     */
    private int textType = 1;
    /**
     * 单元格格式化(如#0.000)
     */
    private String textFormat = "";

    public ExcelCell() {
    }

    public ExcelCell(String text) {
        this.text = text;
    }

    public ExcelCell(String text, int col) {
        this.text = text;
        this.col = col - 1;
    }

    public ExcelCell(String text, int col, int fontSize, boolean bold) {
        this.text = text;
        this.col = col - 1;
        this.fontSize = fontSize;
        this.bold = bold;
    }

    public ExcelCell(String text, int col, boolean bold) {
        this.text = text;
        this.col = col - 1;
        this.bold = bold;
    }

    public ExcelCell(String text, boolean bold) {
        this.text = text;
        this.bold = bold;
    }

    public String getText() {
        return text;
    }

    public ExcelCell setText(String text) {
        this.text = text;
        return this;
    }

    public int getFontSize() {
        return fontSize;
    }

    public ExcelCell setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public String getAlign() {
        return align;
    }

    public ExcelCell setAlign(String align) {
        this.align = align;
        return this;
    }

    public int getCol() {
        return col;
    }

    public ExcelCell setCol(int col) {
        this.col = col;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public ExcelCell setWidth(int width) {
        this.width = width;
        return this;
    }

    public boolean isBold() {
        return bold;
    }

    public ExcelCell setBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public int getTextType() {
        return textType;
    }

    public ExcelCell setTextType(int textType) {
        this.textType = textType;
        return this;
    }

    public String getTextFormat() {
        return textFormat;
    }

    public ExcelCell setTextFormat(String textFormat) {
        this.textFormat = textFormat;
        return this;
    }
}
