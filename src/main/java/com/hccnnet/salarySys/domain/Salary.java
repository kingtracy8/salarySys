package com.hccnnet.salarySys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Salary {
    private Integer saId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    private String month;

    private Integer epId;

    private String epName;

    private BigDecimal position;

    private BigDecimal annual;

    private BigDecimal global;

    private BigDecimal profession;

    private BigDecimal overtime;

    private BigDecimal welfare;

    private BigDecimal special;

    private BigDecimal special1;

    private BigDecimal special2;

    private BigDecimal otherWelfare;

    private BigDecimal monthlyPerformance;

    private BigDecimal shouldPay;

    private BigDecimal pensionD;

    private BigDecimal pensionC;

    private BigDecimal idlenessD;

    private BigDecimal idlenessC;

    private BigDecimal medicalD;

    private BigDecimal medicalC;

    private BigDecimal
            enterpriseAnnuity;

    private BigDecimal
            housing;

    private BigDecimal
            withholdOther;

    private BigDecimal
            withholdWE;

    private BigDecimal
            withholdRent;

    private BigDecimal
            withholdUnion;

    private BigDecimal
            withholdTrash;

    private BigDecimal tax;

    private BigDecimal withholdTotal;

    private BigDecimal realTotal;

    private BigDecimal last;

    private BigDecimal thisD;

    private BigDecimal taxRefund;

    private BigDecimal taxBase;

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName == null ? null : epName.trim();
    }

    public BigDecimal getPosition() {
        return position;
    }

    public void setPosition(BigDecimal position) {
        this.position = position;
    }

    public BigDecimal getAnnual() {
        return annual;
    }

    public void setAnnual(BigDecimal annual) {
        this.annual = annual;
    }

    public BigDecimal getGlobal() {
        return global;
    }

    public void setGlobal(BigDecimal global) {
        this.global = global;
    }

    public BigDecimal getProfession() {
        return profession;
    }

    public void setProfession(BigDecimal profession) {
        this.profession = profession;
    }

    public BigDecimal getOvertime() {
        return overtime;
    }

    public void setOvertime(BigDecimal overtime) {
        this.overtime = overtime;
    }

    public BigDecimal getWelfare() {
        return welfare;
    }

    public void setWelfare(BigDecimal welfare) {
        this.welfare = welfare;
    }

    public BigDecimal getSpecial() {
        return special;
    }

    public void setSpecial(BigDecimal special) {
        this.special = special;
    }

    public BigDecimal getSpecial1() {
        return special1;
    }

    public void setSpecial1(BigDecimal special1) {
        this.special1 = special1;
    }

    public BigDecimal getSpecial2() {
        return special2;
    }

    public void setSpecial2(BigDecimal special2) {
        this.special2 = special2;
    }

    public BigDecimal getOtherWelfare() {
        return otherWelfare;
    }

    public void setOtherWelfare(BigDecimal otherWelfare) {
        this.otherWelfare = otherWelfare;
    }

    public BigDecimal getMonthlyPerformance() {
        return monthlyPerformance;
    }

    public void setMonthlyPerformance(BigDecimal monthlyPerformance) {
        this.monthlyPerformance = monthlyPerformance;
    }

    public BigDecimal getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(BigDecimal shouldPay) {
        this.shouldPay = shouldPay;
    }

    public BigDecimal getPensionD() {
        return pensionD;
    }

    public void setPensionD(BigDecimal pensionD) {
        this.pensionD = pensionD;
    }

    public BigDecimal getPensionC() {
        return pensionC;
    }

    public void setPensionC(BigDecimal pensionC) {
        this.pensionC = pensionC;
    }

    public BigDecimal getIdlenessD() {
        return idlenessD;
    }

    public void setIdlenessD(BigDecimal idlenessD) {
        this.idlenessD = idlenessD;
    }

    public BigDecimal getIdlenessC() {
        return idlenessC;
    }

    public void setIdlenessC(BigDecimal idlenessC) {
        this.idlenessC = idlenessC;
    }

    public BigDecimal getMedicalD() {
        return medicalD;
    }

    public void setMedicalD(BigDecimal medicalD) {
        this.medicalD = medicalD;
    }

    public BigDecimal getMedicalC() {
        return medicalC;
    }

    public void setMedicalC(BigDecimal medicalC) {
        this.medicalC = medicalC;
    }

    public BigDecimal getenterpriseAnnuity() {
        return
                enterpriseAnnuity;
    }

    public void setenterpriseAnnuity(BigDecimal
                              enterpriseAnnuity) {
        this.
                enterpriseAnnuity =
                enterpriseAnnuity;
    }

    public BigDecimal gethousing() {
        return
                housing;
    }

    public void sethousing(BigDecimal
                    housing) {
        this.
                housing =
                housing;
    }

    public BigDecimal getwithholdOther() {
        return
                withholdOther;
    }

    public void setwithholdOther(BigDecimal
                          withholdOther) {
        this.
                withholdOther =
                withholdOther;
    }

    public BigDecimal getwithholdWE() {
        return
                withholdWE;
    }

    public void setwithholdWE(BigDecimal
                       withholdWE) {
        this.
                withholdWE =
                withholdWE;
    }

    public BigDecimal getwithholdRent() {
        return
                withholdRent;
    }

    public void setwithholdRent(BigDecimal
                         withholdRent) {
        this.
                withholdRent =
                withholdRent;
    }

    public BigDecimal getwithholdUnion() {
        return
                withholdUnion;
    }

    public void setwithholdUnion(BigDecimal
                          withholdUnion) {
        this.
                withholdUnion =
                withholdUnion;
    }

    public BigDecimal getwithholdTrash() {
        return
                withholdTrash;
    }

    public void setwithholdTrash(BigDecimal
                                         withholdTrash) {
        this.
                withholdTrash =
                withholdTrash;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getWithholdTotal() {
        return withholdTotal;
    }

    public void setWithholdTotal(BigDecimal withholdTotal) {
        this.withholdTotal = withholdTotal;
    }

    public BigDecimal getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(BigDecimal realTotal) {
        this.realTotal = realTotal;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getThisD() {
        return thisD;
    }

    public void setThisD(BigDecimal thisD) {
        this.thisD = thisD;
    }

    public BigDecimal getTaxRefund() {
        return taxRefund;
    }

    public void setTaxRefund(BigDecimal taxRefund) {
        this.taxRefund = taxRefund;
    }

    public BigDecimal getTaxBase() {
        return taxBase;
    }

    public void setTaxBase(BigDecimal taxBase) {
        this.taxBase = taxBase;
    }
}