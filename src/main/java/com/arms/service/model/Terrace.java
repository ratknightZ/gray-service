package com.arms.service.model;

import java.sql.Timestamp;

/**
 * @author liuchen
 * @since 2017/12/5
 */
public class Terrace {

    private int id;

    private String logo;

    private String name;

    private double rate;

    private int lendType;

    private double quickestTime;

    private String applyForCondition;

    private String needInformation;

    private int repaymentWay;

    private int haveCreditCard;

    private int minRepaymentTimeLimit;

    private int maxRepaymentTimeLimit;

    private String choosableRepaymentTimeLimit;

    private int maxAmount;

    private int minAmount;

    private int status;

    private Timestamp gmtCreate;

    private Timestamp gmtUpdate;

    private String profession;

    private String credit;

    private String lendPurpose;

    private String url;

    private int applyForCount;

    private int successCount;

    private int successRate;

    private int isHot;

    private int unitOfQuickestTime;

    private int quickestTimeSecond;

    private int unitOfRepaymentTime;

    private double rateDay;

    private int unitOfRate;

    private int sortCode;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getLendType() {
        return lendType;
    }

    public void setLendType(int lendType) {
        this.lendType = lendType;
    }

    public double getQuickestTime() {
        return quickestTime;
    }

    public void setQuickestTime(double quickestTime) {
        this.quickestTime = quickestTime;
    }

    public String getApplyForCondition() {
        return applyForCondition;
    }

    public void setApplyForCondition(String applyForCondition) {
        this.applyForCondition = applyForCondition;
    }

    public String getNeedInformation() {
        return needInformation;
    }

    public void setNeedInformation(String needInformation) {
        this.needInformation = needInformation;
    }

    public int getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(int repaymentWay) {
        this.repaymentWay = repaymentWay;
    }

    public int getHaveCreditCard() {
        return haveCreditCard;
    }

    public void setHaveCreditCard(int haveCreditCard) {
        this.haveCreditCard = haveCreditCard;
    }

    public int getMinRepaymentTimeLimit() {
        return minRepaymentTimeLimit;
    }

    public void setMinRepaymentTimeLimit(int minRepaymentTimeLimit) {
        this.minRepaymentTimeLimit = minRepaymentTimeLimit;
    }

    public int getMaxRepaymentTimeLimit() {
        return maxRepaymentTimeLimit;
    }

    public void setMaxRepaymentTimeLimit(int maxRepaymentTimeLimit) {
        this.maxRepaymentTimeLimit = maxRepaymentTimeLimit;
    }

    public String getChoosableRepaymentTimeLimit() {
        return choosableRepaymentTimeLimit;
    }

    public void setChoosableRepaymentTimeLimit(String choosableRepaymentTimeLimit) {
        this.choosableRepaymentTimeLimit = choosableRepaymentTimeLimit;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getLendPurpose() {
        return lendPurpose;
    }

    public void setLendPurpose(String lendPurpose) {
        this.lendPurpose = lendPurpose;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getApplyForCount() {
        return applyForCount;
    }

    public void setApplyForCount(int applyForCount) {
        this.applyForCount = applyForCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getUnitOfQuickestTime() {
        return unitOfQuickestTime;
    }

    public void setUnitOfQuickestTime(int unitOfQuickestTime) {
        this.unitOfQuickestTime = unitOfQuickestTime;
    }

    public int getQuickestTimeSecond() {
        return quickestTimeSecond;
    }

    public void setQuickestTimeSecond(int quickestTimeSecond) {
        this.quickestTimeSecond = quickestTimeSecond;
    }

    public int getUnitOfRepaymentTime() {
        return unitOfRepaymentTime;
    }

    public void setUnitOfRepaymentTime(int unitOfRepaymentTime) {
        this.unitOfRepaymentTime = unitOfRepaymentTime;
    }

    public double getRateDay() {
        return rateDay;
    }

    public void setRateDay(double rateDay) {
        this.rateDay = rateDay;
    }

    public int getUnitOfRate() {
        return unitOfRate;
    }

    public void setUnitOfRate(int unitOfRate) {
        this.unitOfRate = unitOfRate;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }
}
