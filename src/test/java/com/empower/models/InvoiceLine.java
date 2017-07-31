package com.empower.models;

import java.util.Comparator;

public class InvoiceLine implements Comparator<InvoiceLine> {
    private Boolean checkedForRequest;
    private String catalogName;
    private String qty;
    private String returnable;
    private String labelQty;
    private String reasonForRequest;
    private String requestedType;
    private String requestedSubType;
    private String requestedAction;
    private String requestedQty;

    public InvoiceLine() {
    }

    public InvoiceLine(InvoiceLine invoiceLine) {
        this.checkedForRequest = invoiceLine.checkedForRequest;
        this.catalogName = invoiceLine.catalogName;
        this.qty = invoiceLine.qty;
        this.returnable = invoiceLine.returnable;
        this.reasonForRequest = invoiceLine.reasonForRequest;
        this.requestedType = invoiceLine.requestedType;
        this.requestedSubType = invoiceLine.requestedSubType;
        this.requestedAction = invoiceLine.requestedQty;
    }

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    public String getRequestedType() {
        return requestedType;
    }

    public void setRequestedType(String requestedType) {
        this.requestedType = requestedType;
    }

    public String getRequestedSubType() {
        return requestedSubType;
    }

    public void setRequestedSubType(String requestedSubType) {
        this.requestedSubType = requestedSubType;
    }

    public String getRequestedAction() {
        return requestedAction;
    }

    public void setRequestedAction(String requestedAction) {
        this.requestedAction = requestedAction;
    }

    public String getRequestedQty() {
        return requestedQty;
    }

    public void setRequestedQty(String requestedQty) {
        this.requestedQty = requestedQty;
    }

    public String getLabelQty() {
        return this.labelQty;
    }

    public void setLabelQty(String labelQty) {
        this.labelQty = labelQty;
    }

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

    public int compareTo(Object obj) {
        InvoiceLine tmp = (InvoiceLine) obj;
        if (this.catalogName.compareTo(tmp.catalogName) > 0) {
      /* текущее меньше полученного */
            return -1;
        } else if (this.catalogName.compareTo(tmp.catalogName) < 0) {
      /* текущее больше полученного */
            return 1;
        }
    /* текущее равно полученному */
        return 0;
    }

    @Override
    public int compare(InvoiceLine o1, InvoiceLine o2) {
        return o1.getCatalogName().compareTo(o2.getCatalogName());
    }
}
