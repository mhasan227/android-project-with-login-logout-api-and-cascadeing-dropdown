package api1listpartnerrole;

public class BodyResult {

    String status;
    ResponseArray[] response;

    public BodyResult(String status, ResponseArray[] response) {
        this.status = status;
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponseArray[] getResponse() {
        return response;
    }

    public void setResponse(ResponseArray[] response) {
        this.response = response;
    }
}
