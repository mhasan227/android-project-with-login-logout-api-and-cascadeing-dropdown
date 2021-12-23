package apiforcreditsale;

public class CreditCollections {

    String id;
    String code;
    String customer;
    String amount;
    String tenantId;
    String userId;
    String creationTime;
    String takenAmount;
    String remainingAmount;
    String previousRemainingAmount;

    public CreditCollections(String id, String code, String customer, String amount, String tenantId, String userId, String creationTime, String takenAmount, String remainingAmount, String previousRemainingAmount) {
        this.id = id;
        this.code = code;
        this.customer = customer;
        this.amount = amount;
        this.tenantId = tenantId;
        this.userId = userId;
        this.creationTime = creationTime;
        this.takenAmount = takenAmount;
        this.remainingAmount = remainingAmount;
        this.previousRemainingAmount = previousRemainingAmount;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getTakenAmount() {
        return takenAmount;
    }

    public void setTakenAmount(String takenAmount) {
        this.takenAmount = takenAmount;
    }

    public String getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(String remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getPreviousRemainingAmount() {
        return previousRemainingAmount;
    }

    public void setPreviousRemainingAmount(String previousRemainingAmount) {
        this.previousRemainingAmount = previousRemainingAmount;
    }
}
