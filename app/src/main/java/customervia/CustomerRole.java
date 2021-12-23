package customervia;

public class CustomerRole {

            String id;
            String roleId;
            String parentId;
            String code;
            String displayName;
            String status;
            String level;
            String tanentId;
            String createdBy;
            String createdAt;
            String modifiedBy;
            String modifiedAt;

    public CustomerRole(String id, String roleId, String parentId, String code, String displayName, String status, String level, String tanentId, String createdBy, String createdAt, String modifiedBy, String modifiedAt) {
        this.id = id;
        this.roleId = roleId;
        this.parentId = parentId;
        this.code = code;
        this.displayName = displayName;
        this.status = status;
        this.level = level;
        this.tanentId = tanentId;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
}
