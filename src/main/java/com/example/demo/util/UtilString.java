package com.example.demo.util;


/**
 * 字符串控件
 *
 */
public class UtilString {

    /**
     * 根据长度补齐字符串（左补齐）
     *
     * @param cont 待处理字符串
     * @param len  格式化后的长度
     * @param ch   填充的字符（可多位）
     * @return
     * @throws ServiceException
     */
    public static String formatLen(String cont, int len, String ch) throws ServiceException {
        //默认左补齐
        Position pos = Position.Left;
        //返回结果
        return UtilString.formatLen(cont, len, ch, pos);
    }

    /**
     * 根据长度补齐字符串
     *
     * @param cont 待处理字符串
     * @param len  格式化后的长度
     * @param ch   填充的字符（可多位）
     * @param pos  填充位置（枚举类型，左、右，默认左）
     * @return
     * @throws ServiceException
     */
    public static String formatLen(String cont, int len, String ch, Position pos) throws ServiceException {
        String result = null;
        //入参校验
        if (len <= 0) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "入参pos（" + pos + "）错误！");
        }
        if (null == ch || "".equals(ch.trim())) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "入参ch（" + ch + "）错误！");
        }
        if (null == cont) {
            cont = "";
        }
        if (null == pos) {
            pos = Position.Left;
        }
        //拼装补齐部分的字符串
        String strSupply = "";
        if (cont.toString().length() < len) {
            for (int i = 1; i <= len - cont.toString().length(); i++) {
                strSupply = (strSupply + ch);
            }
            //.. 避免ch.length>0，此处再次根据长度截取
            strSupply = strSupply.substring(0, len - cont.toString().length());
        }
        if (pos == Position.Left) {// 左侧
            result = strSupply + cont;
        } else {// 右侧
            result = cont + strSupply;
        }
        //返回结果
        return result;
    }

    /**
     * 根据长度补齐字符串(中文占2位,英文、字符占1位)
     *
     * @param cont 待处理字符串
     * @param len  格式化后的长度
     * @param ch   填充的字符（可多位）
     * @param pos  填充位置（枚举类型，左、右，默认左）
     * @return
     * @throws ServiceException
     */
    public static String formatLenWithCharTyle(String cont, int len, String ch, Position pos) throws ServiceException {
        String result = null;
        //入参校验
        if (len <= 0) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "入参pos（" + pos + "）错误！");
        }
        if (null == ch || "".equals(ch)) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "入参ch（" + ch + "）错误！");
        }
        if (null == cont) {
            cont = "";
        }
        if (null == pos) {
            pos = Position.Left;
        }
        //待处理串的长度
        int contLen = 0;
        for (int i = 0; i < cont.length(); i++) {
            contLen += charLen(cont.substring(i, i + 1));
        }
        //拼装补齐部分的字符串
        String strSupply = "";
        if (contLen < len) {
            for (int i = 1; i <= len - contLen; i++) {
                strSupply = (strSupply + ch);
            }
            //.. 避免ch.length>0，此处再次根据长度截取
            strSupply = strSupply.substring(0, len - contLen);
        }
        if (pos == Position.Left) {// 左侧
            result = strSupply + cont;
        } else {// 右侧
            result = cont + strSupply;
        }
        //返回结果
        return result;
    }

    /**
     * 通过占位符(如{0})的方式格式化字符串
     *
     * @param cont   待处理字符串
     * @param params 待占位的数据
     * @return
     */
    public static String formatPlaceHolder(String content, Object... params) {
        String result = content;
        if (content != null && !"".equals(content.trim())
                && params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                result = result.replaceAll(
                        ("{" + i + "}"),
                        params[i].toString()
                );
            }
        }
        return result;
    }

    /**
     * 判断字符长度(中文占2位,英文、字符占1位)
     *
     * @param str
     * @return
     */
    private static int charLen(String str) {
        int result = 0;
        switch (str) {
            // 小写英文
            case "a":
                result = 1;
                break;
            case "b":
                result = 1;
                break;
            case "c":
                result = 1;
                break;
            case "d":
                result = 1;
                break;
            case "e":
                result = 1;
                break;
            case "f":
                result = 1;
                break;
            case "g":
                result = 1;
                break;
            case "h":
                result = 1;
                break;
            case "i":
                result = 1;
                break;
            case "j":
                result = 1;
                break;
            case "k":
                result = 1;
                break;
            case "l":
                result = 1;
                break;
            case "m":
                result = 1;
                break;
            case "n":
                result = 1;
                break;
            case "o":
                result = 1;
                break;
            case "p":
                result = 1;
                break;
            case "q":
                result = 1;
                break;
            case "r":
                result = 1;
                break;
            case "s":
                result = 1;
                break;
            case "t":
                result = 1;
                break;
            case "u":
                result = 1;
                break;
            case "v":
                result = 1;
                break;
            case "w":
                result = 1;
                break;
            case "x":
                result = 1;
                break;
            case "y":
                result = 1;
                break;
            case "z":
                result = 1;
                break;
            // 大写英文
            case "A":
                result = 1;
                break;
            case "B":
                result = 1;
                break;
            case "C":
                result = 1;
                break;
            case "D":
                result = 1;
                break;
            case "E":
                result = 1;
                break;
            case "F":
                result = 1;
                break;
            case "G":
                result = 1;
                break;
            case "H":
                result = 1;
                break;
            case "I":
                result = 1;
                break;
            case "J":
                result = 1;
                break;
            case "K":
                result = 1;
                break;
            case "L":
                result = 1;
                break;
            case "M":
                result = 1;
                break;
            case "N":
                result = 1;
                break;
            case "O":
                result = 1;
                break;
            case "P":
                result = 1;
                break;
            case "Q":
                result = 1;
                break;
            case "R":
                result = 1;
                break;
            case "S":
                result = 1;
                break;
            case "T":
                result = 1;
                break;
            case "U":
                result = 1;
                break;
            case "V":
                result = 1;
                break;
            case "W":
                result = 1;
                break;
            case "X":
                result = 1;
                break;
            case "Y":
                result = 1;
                break;
            case "Z":
                result = 1;
                break;
            // 英文符号
            case ",":
                result = 1;
                break;
            case ".":
                result = 1;
                break;
            case "~":
                result = 1;
                break;
            case "!":
                result = 1;
                break;
            case "@":
                result = 1;
                break;
            case "#":
                result = 1;
                break;
            case "$":
                result = 1;
                break;
            case "%":
                result = 1;
                break;
            case "^":
                result = 1;
                break;
            case "&":
                result = 1;
                break;
            case "*":
                result = 1;
                break;
            case "(":
                result = 1;
                break;
            case ")":
                result = 1;
                break;
            case "[":
                result = 1;
                break;
            case "]":
                result = 1;
                break;
            case "{":
                result = 1;
                break;
            case "}":
                result = 1;
                break;
            case "<":
                result = 1;
                break;
            case ">":
                result = 1;
                break;
            case "?":
                result = 1;
                break;
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case ":":
                result = 1;
                break;
            // 中文符号
            case "，":
                result = 1;
                break;
            case "。":
                result = 1;
                break;
            case "！":
                result = 1;
                break;
            case "￥":
                result = 1;
                break;
            case "……":
                result = 2;
                break;
            case "（":
                result = 1;
                break;
            case "）":
                result = 1;
                break;
            case "【":
                result = 1;
                break;
            case "】":
                result = 1;
                break;
            case "《":
                result = 1;
                break;
            case "》":
                result = 1;
                break;
            case "？":
                result = 1;
                break;
            case "：":
                result = 1;
                break;
            // 数字
            case "0":
                result = 1;
                break;
            case "1":
                result = 1;
                break;
            case "2":
                result = 1;
                break;
            case "3":
                result = 1;
                break;
            case "4":
                result = 1;
                break;
            case "5":
                result = 1;
                break;
            case "6":
                result = 1;
                break;
            case "7":
                result = 1;
                break;
            case "8":
                result = 1;
                break;
            case "9":
                result = 1;
                break;
            // 其他
            default:
                result = 2;
                break;
        }
        return result;
    }

    /**
     * 位置（如左、右）
     *
     * @author liaoc
     */
    public static enum Position {
        /**
         * 左
         */
        Left,
        /**
         * 右
         */
        Right
    }

}
