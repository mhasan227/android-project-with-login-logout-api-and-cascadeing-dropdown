package apiforcreditsale;

public class CreditHandler {

    CreditSales[] creditSales;
    String id;
    String status;
    String message;

    public CreditHandler(CreditSales[] creditSales, String id, String status, String message) {
        this.creditSales = creditSales;
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public CreditSales[] getCreditSales() {
        return creditSales;
    }

    public void setCreditSales(CreditSales[] creditSales) {
        this.creditSales = creditSales;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
