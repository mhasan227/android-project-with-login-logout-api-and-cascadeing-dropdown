package apiforcreditcollection;

public class CreditCollectionArray {


        String id;
        String code;
        String customer;
        String amount;
        String tenantId;
        String userId;
        String creationTime;
        String receipt;
        String collectionDate;
        String moneyReceiptNumber;
        String handlerId;
        String customerName;
        String handlerName;
        Integer remainingAmount;
        CreditSales[] creditSales;
        String availability;

        public CreditCollectionArray(String id, String code, String customer, String amount, String tenantId, String userId, String creationTime, String receipt, String collectionDate, String moneyReceiptNumber, String handlerId, String customerName, String handlerName, Integer remainingAmount, CreditSales[] creditSales, String availability) {
                this.id = id;
                this.code = code;
                this.customer = customer;
                this.amount = amount;
                this.tenantId = tenantId;
                this.userId = userId;
                this.creationTime = creationTime;
                this.receipt = receipt;
                this.collectionDate = collectionDate;
                this.moneyReceiptNumber = moneyReceiptNumber;
                this.handlerId = handlerId;
                this.customerName = customerName;
                this.handlerName = handlerName;
                this.remainingAmount = remainingAmount;
                this.creditSales = creditSales;
                this.availability = availability;
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

        public String getReceipt() {
                return receipt;
        }

        public void setReceipt(String receipt) {
                this.receipt = receipt;
        }

        public String getCollectionDate() {
                return collectionDate;
        }

        public void setCollectionDate(String collectionDate) {
                this.collectionDate = collectionDate;
        }

        public String getMoneyReceiptNumber() {
                return moneyReceiptNumber;
        }

        public void setMoneyReceiptNumber(String moneyReceiptNumber) {
                this.moneyReceiptNumber = moneyReceiptNumber;
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

        public Integer getRemainingAmount() {
                return remainingAmount;
        }

        public void setRemainingAmount(Integer remainingAmount) {
                this.remainingAmount = remainingAmount;
        }

        public CreditSales[] getCreditSales() {
                return creditSales;
        }

        public void setCreditSales(CreditSales[] creditSales) {
                this.creditSales = creditSales;
        }

        public String getAvailability() {
                return availability;
        }

        public void setAvailability(String availability) {
                this.availability = availability;
        }
}
