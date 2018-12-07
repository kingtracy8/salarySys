package com.hccnnet.salarySys.util;

import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.domain.Salary;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by trcay on 2018/12/6.
 */
public class ReadExcel {
    // 总行数
    private int totalRows = 0;
    // 总条数
    private int totalCells = 0;
    // 错误信息接收器
    private String errorMsg;

    // 构造方法
    public ReadExcel() {
    }

    // 获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    // 获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    // 获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 读EXCEL文件，获取信息集合
     *
     * @param
     * @return
     */
    public List<Salary> getExcelInfo(MultipartFile mFile) {
        String fileName = mFile.getOriginalFilename();// 获取文件名
        List<Salary> salaryList = null;
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            salaryList = createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salaryList;
    }

    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<Salary> createExcel(InputStream is, boolean isExcel2003) {
        List<Salary> salaryList = null;
        try {
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            salaryList = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salaryList;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private List<Salary> readExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Salary> salaryList = new ArrayList<Salary>();
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            Salary salary = new Salary();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        /*if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String name = String.valueOf(cell.getNumericCellValue());
                            user.setEpName(name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));// 名称
                        } else {
                            user.setEpName(cell.getStringCellValue());// 名称
                        }*/

                        //获得发放日期
                        String date = String.valueOf(cell.getStringCellValue());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                        try {
                            salary.setDate(sdf.parse(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    } else if (c == 1) {

                        //期间
                        salary.setMonth(cell.getStringCellValue());

                    } else if (c == 2) {

                        //人员编码
                        salary.setEpId(Integer.valueOf(cell.getStringCellValue()));

                    } else if (c == 3) {

                        //姓名
                        salary.setEpName(cell.getStringCellValue());
                    } else if (c == 4) {

                        //岗位工资
                        //如果为空
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setPosition(null);
                        } else {
                            salary.setPosition(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    } else if (c == 5) {
                        //年功津贴
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setAnnual(null);
                        } else {
                            salary.setAnnual(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    } else if (c == 6) {
                        //综合补贴
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setGlobal(null);
                        } else {
                            salary.setGlobal(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 7) {
                        //专业人才补贴
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setProfession(null);
                        } else {
                            salary.setProfession(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 8) {
                        //加班工资
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setOvertime(null);
                        } else {
                            salary.setOvertime(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 9) {
                        //福利费
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setWelfare(null);
                        } else {
                            salary.setWelfare(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 10) {
                        //专项奖
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setSpecial(null);
                        } else {
                            salary.setSpecial(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 11) {
                        //专项奖预留1
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setSpecial1(null);
                        } else {
                            salary.setSpecial1(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 12) {
                        //专项奖预留2
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setSpecial2(null);
                        } else {
                            salary.setSpecial2(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 13) {
                        //其他福利
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setOtherWelfare(null);
                        } else {
                            salary.setOtherWelfare(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 14) {
                        //月度绩效
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setMonthlyPerformance(null);
                        } else {
                            salary.setMonthlyPerformance(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 15) {
                        //应发合计
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setShouldPay(null);
                        } else {
                            salary.setShouldPay(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 16) {
                        //基本养老保险（个人扣款）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setPensionD(null);
                        } else {
                            salary.setPensionD(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 17) {
                        //基本养老保险（个人补缴）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setPensionC(null);
                        } else {
                            salary.setPensionC(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 18) {
                        //失业保险（个人扣款）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setIdlenessD(null);
                        } else {
                            salary.setIdlenessD(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 19) {
                        //失业保险（个人补缴）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setIdlenessC(null);
                        } else {
                            salary.setIdlenessC(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 20) {
                        //基本医疗保险（个人扣款）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setMedicalD(null);
                        } else {
                            salary.setMedicalD(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 21) {
                        //企业年金（个人扣款）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setenterpriseAnnuity(null);
                        } else {
                            salary.setenterpriseAnnuity(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 22) {
                        //住房公积金（个人扣款）
                        if ("".equals(cell.getStringCellValue())) {
                            salary.sethousing(null);
                        } else {
                            salary.sethousing(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 23) {
                        //代扣其他扣款项
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setwithholdOther(null);
                        } else {
                            salary.setwithholdOther(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 24) {
                        //代扣水电费
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setwithholdWE(null);
                        } else {
                            salary.setwithholdWE(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 25) {
                        //代扣房租费
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setwithholdRent(null);
                        } else {
                            salary.setwithholdRent(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 26) {
                        //代扣工会费
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setwithholdUnion(null);
                        } else {
                            salary.setwithholdUnion(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 27) {
                        //代扣工会费
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setwithholdTrash(null);
                        } else {
                            salary.setwithholdTrash(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 28) {
                        //本次扣税
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setTax(null);
                        } else {
                            salary.setTax(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 29) {
                        //扣款合计
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setWithholdTotal(null);
                        } else {
                            salary.setWithholdTotal(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 30) {
                        //实发合计
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setRealTotal(null);
                        } else {
                            salary.setRealTotal(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 31) {
                        //上次未扣
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setLast(null);
                        } else {
                            salary.setLast(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 32) {
                        //本次未扣
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setThisD(null);
                        } else {
                            salary.setThisD(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 33) {
                        //个税补退补缴
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setTaxRefund(null);
                        } else {
                            salary.setTaxRefund(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }else if (c == 34) {
                        //本次扣税基数
                        if ("".equals(cell.getStringCellValue())) {
                            salary.setTaxBase(null);
                        } else {
                            salary.setTaxBase(StrTrans2Decimal(cell.getStringCellValue()));
                        }
                    }



                }
            }
            // 添加到list
            salaryList.add(salary);
        }
        return salaryList;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    //将String转换成BigDecimal
    public BigDecimal StrTrans2Decimal(String str) {
        BigDecimal bd = new BigDecimal(str);
        return bd;
    }

}
