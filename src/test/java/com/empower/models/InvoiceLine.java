package com.empower.models;

public class InvoiceLine {
    private Boolean checkedForRequest;
    private String catalogName;
    private String qty;
    private String returnable;


    public Boolean getCheckedForRequest() {
        return checkedForRequest;
    }

    public void setCheckedForRequest(Boolean checkedForRequest) {
        this.checkedForRequest = checkedForRequest;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getReturnable() {
        return returnable;
    }

    public void setReturnable(String returnable) {
        this.returnable = returnable;
    }
}
