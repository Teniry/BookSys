package pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ReaderType {
    private Integer rdType;
    private String rdTypeName;
    private Integer canLendCount;
    private Integer canLendDay;
    private Integer canContinueTimes;
    private BigDecimal punishRate;
    private Date dateValid;

    public ReaderType() {
    }

    public ReaderType(Integer rdType, String rdTypeName, Integer canLendCount, Integer canLendDay, Integer canContinueTimes, BigDecimal punishRate, Date dateValid) {
        this.rdType = rdType;
        this.rdTypeName = rdTypeName;
        this.canLendCount = canLendCount;
        this.canLendDay = canLendDay;
        this.canContinueTimes = canContinueTimes;
        this.punishRate = punishRate;
        this.dateValid = dateValid;
    }

    @Override
    public String toString() {
        return "ReaderType{" +
                "rdType=" + rdType +
                ", rdTypeName='" + rdTypeName + '\'' +
                ", canLendCount=" + canLendCount +
                ", canLendDay=" + canLendDay +
                ", canContinueTimes=" + canContinueTimes +
                ", punishRate=" + punishRate +
                ", dateValid=" + dateValid +
                '}';
    }

    public Integer getRdType() {
        return rdType;
    }

    public void setRdType(Integer rdType) {
        this.rdType = rdType;
    }

    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }

    public Integer getCanLendCount() {
        return canLendCount;
    }

    public void setCanLendCount(Integer canLendCount) {
        this.canLendCount = canLendCount;
    }

    public Integer getCanLendDay() {
        return canLendDay;
    }

    public void setCanLendDay(Integer canLendDay) {
        this.canLendDay = canLendDay;
    }

    public Integer getCanContinueTimes() {
        return canContinueTimes;
    }

    public void setCanContinueTimes(Integer canContinueTimes) {
        this.canContinueTimes = canContinueTimes;
    }

    public BigDecimal getPunishRate() {
        return punishRate;
    }

    public void setPunishRate(BigDecimal punishRate) {
        this.punishRate = punishRate;
    }

    public Date getdateValid() {
        return dateValid;
    }

    public void setdateValid(Date dateValid) {
        this.dateValid = dateValid;
    }
}
