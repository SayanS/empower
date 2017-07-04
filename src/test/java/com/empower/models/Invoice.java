package com.empower.models;


import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String number;
    private String date;
    private String poNumber;
    private String geSalesOrder;
    private Boolean checkedForRequest;
    private List<InvoiceLine> lines=new ArrayList<>();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getGeSalesOrder() {
        return geSalesOrder;
    }

    public void setGeSalesOrder(String geSalesOrder) {
        this.geSalesOrder = geSalesOrder;
    }

    public Boolean getCheckedForRequest() {
        return checkedForRequest;
    }

    public void setCheckedForRequest(Boolean checkedForRequest) {
        this.checkedForRequest = checkedForRequest;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public void addInvoiceLine(InvoiceLine line) {
        this.lines.add(line);
    }
}
