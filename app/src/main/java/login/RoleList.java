package login;

public class RoleList {

                     Integer id;
                     Integer roleId;
                     Integer parentId;
                     String code;
                     String displayName;
                     String status;
                     String level;
                     String tanentId;

    public RoleList(Integer id, Integer roleId, Integer parentId, String code, String displayName, String status, String level, String tanentId) {
        this.id = id;
        this.roleId = roleId;
        this.parentId = parentId;
        this.code = code;
        this.displayName = displayName;
        this.status = status;
        this.level = level;
        this.tanentId = tanentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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
}
