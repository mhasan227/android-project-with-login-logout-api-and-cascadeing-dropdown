package com.example.maxisloginlogout;

public class EntityDropdown {
    public String id;
    public String name;
    public String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    Object dropRef;
   // private ObjectCom objectResponse;

   /* public ObjectCom getObjectResponse() {
        return objectResponse;
    }*/

   /* public void setObjectResponse(ObjectCom objectResponse) {
        this.objectResponse = objectResponse;
    }*/

    public EntityDropdown(String id, String name,String ref /*,ObjectCom objectResponse*/) {
        super();
        this.id = id;
        this.name = name;
        this.ref=ref;
        //this.objectResponse=objectResponse;
        this.dropRef = dropRef;
    }

    public EntityDropdown() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDropRef() {
        return dropRef;
    }

    public void setDropRef(Object dropRef) {
        this.dropRef = dropRef;
    }





}
