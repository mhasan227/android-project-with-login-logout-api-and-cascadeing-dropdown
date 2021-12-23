package apiforcreditcollection;

public class CreditCollectionHandler {

    CreditCollectionArray[] creditCollection;
     String id;
     String status;
     String message;

    public CreditCollectionHandler(CreditCollectionArray[] creditCollection, String id, String status, String message) {
        this.creditCollection = creditCollection;
        this.id = id;
        this.status = status;
        this.message = message;

    }

    public CreditCollectionArray[] getCreditCollection() {
        return creditCollection;
    }

    public void setCreditCollection(CreditCollectionArray[] creditCollection) {
        this.creditCollection = creditCollection;
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
