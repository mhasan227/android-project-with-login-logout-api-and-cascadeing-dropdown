package customervia;

public class CustomerHandler {

        String id;
        String userCode;
        String userName;
        String password;
        String correlationId;
        CustomerRole[] roles;

        String description;
        String phoneNumber;
        String address;
        String status;
        String tanentId;
        String createdBy;
        String createdAt;
        String modifiedBy;
        String modifiedAt;
        String handlerId;

        public CustomerHandler(String id, String userCode, String userName, String password, String correlationId, CustomerRole[] roles, String description, String phoneNumber, String address, String status, String tanentId, String createdBy, String createdAt, String modifiedBy, String modifiedAt, String handlerId) {
                this.id = id;
                this.userCode = userCode;
                this.userName = userName;
                this.password = password;
                this.correlationId = correlationId;
                this.roles = roles;
                this.description = description;
                this.phoneNumber = phoneNumber;
                this.address = address;
                this.status = status;
                this.tanentId = tanentId;
                this.createdBy = createdBy;
                this.createdAt = createdAt;
                this.modifiedBy = modifiedBy;
                this.modifiedAt = modifiedAt;
                this.handlerId = handlerId;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUserCode() {
                return userCode;
        }

        public void setUserCode(String userCode) {
                this.userCode = userCode;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getCorrelationId() {
                return correlationId;
        }

        public void setCorrelationId(String correlationId) {
                this.correlationId = correlationId;
        }

        public CustomerRole[] getRoles() {
                return roles;
        }

        public void setRoles(CustomerRole[] roles) {
                this.roles = roles;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getTanentId() {
                return tanentId;
        }

        public void setTanentId(String tanentId) {
                this.tanentId = tanentId;
        }

        public String getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
        }

        public String getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
        }

        public String getModifiedBy() {
                return modifiedBy;
        }

        public void setModifiedBy(String modifiedBy) {
                this.modifiedBy = modifiedBy;
        }

        public String getModifiedAt() {
                return modifiedAt;
        }

        public void setModifiedAt(String modifiedAt) {
                this.modifiedAt = modifiedAt;
        }

        public String getHandlerId() {
                return handlerId;
        }

        public void setHandlerId(String handlerId) {
                this.handlerId = handlerId;
        }
}
