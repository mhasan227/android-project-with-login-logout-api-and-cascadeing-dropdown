package apiforcreditsale;

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
    String receipt;
    String handlerId;
    String customerName;
    String handlerName;
    String paymentStatus;
    String remainingAmount;
    CreditCollections[] creditCollections;

    public CreditSales(String id, String code, String amount, String customer, String invoiceNumber, String tenantId, String userId, String followUpDate, String invoiceDate, String saleType, String creationTime, String receipt, String handlerId, String customerName, String handlerName, String paymentStatus, String remainingAmount, CreditCollections[] creditCollections) {
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
        this.receipt = receipt;
        this.handlerId = handlerId;
        this.customerName = customerName;
        this.handlerName = handlerName;
        this.paymentStatus = paymentStatus;
        this.remainingAmount = remainingAmount;
        this.creditCollections = creditCollections;
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

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(String remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public CreditCollections[] getCreditCollections() {
        return creditCollections;
    }

    public void setCreditCollections(CreditCollections[] creditCollections) {
        this.creditCollections = creditCollections;
    }
}
