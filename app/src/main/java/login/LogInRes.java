package login;

public class LogInRes {

        String code;
        String result;
        String message;
        String userId;
        String tanentId;
        RoleList[] roleList;
        String userName;
        String userPhone;
        AuthResponse authResponse;

        public LogInRes(String code, String result, String message, String userId, String tanentId, RoleList[] roleList, String userName, String userPhone, AuthResponse authResponse) {
                this.code = code;
                this.result = result;
                this.message = message;
                this.userId = userId;
                this.tanentId = tanentId;
                this.roleList = roleList;
                this.userName = userName;
                this.userPhone = userPhone;
                this.authResponse = authResponse;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getResult() {
                return result;
        }

        public void setResult(String result) {
                this.result = result;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getTanentId() {
                return tanentId;
        }

        public void setTanentId(String tanentId) {
                this.tanentId = tanentId;
        }

        public RoleList[] getRoleList() {
                return roleList;
        }

        public void setRoleList(RoleList[] roleList) {
                this.roleList = roleList;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserPhone() {
                return userPhone;
        }

        public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
        }

        public AuthResponse getAuthResponse() {
                return authResponse;
        }

        public void setAuthResponse(AuthResponse authResponse) {
                this.authResponse = authResponse;
        }
}
