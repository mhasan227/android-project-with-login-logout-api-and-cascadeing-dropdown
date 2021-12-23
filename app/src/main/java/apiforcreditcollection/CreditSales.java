package apiforcreditcollection;

public class CreditSales {

    String id;
    String code;
    String amount;
    String customer;
    String invoiceNumber;
    String tenantId;
    String userId;
    String followUpDate;
    String invoiceDate;
    String saleType;
    String creationTime;
    Integer remainingBefore;
    Integer remainingAmount;
    Integer takenAmount;

    public CreditSales(String id, String code, String amount, String customer, String invoiceNumber, String tenantId, String userId, String followUpDate, String invoiceDate, String saleType, String creationTime, Integer remainingBefore, Integer remainingAmount, Integer takenAmount) {
        this.id = id;
        this.code = code;
        this.amount = amount;
        this.customer = customer;
        this.invoiceNumber = invoiceNumber;
        this.tenantId = tenantId;
        this.userId = userId;
        this.followUpDate = followUpDate;
        this.invoiceDate = invoiceDate;
        this.saleType = saleType;
        this.creationTime = creationTime;
        this.remainingBefore = remainingBefore;
        this.remainingAmount = remainingAmount;
        this.takenAmount = takenAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getRemainingBefore() {
        return remainingBefore;
    }

    public void setRemainingBefore(Integer remainingBefore) {
        this.remainingBefore = remainingBefore;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Integer getTakenAmount() {
        return takenAmount;
    }

    public void setTakenAmount(Integer takenAmount) {
        this.takenAmount = takenAmount;
    }
}
