package login;

public class AuthResponse {

        String id_token;
        Integer expires_in;
        String refresh_token;

    public AuthResponse(String id_token, Integer expires_in, String refresh_token) {
        this.id_token = id_token;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
