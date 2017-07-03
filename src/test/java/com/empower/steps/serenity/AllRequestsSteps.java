package com.empower.steps.serenity;

import com.empower.pages.AllRequestsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class AllRequestsSteps {
AllRequestsPage allRequestsPage;

    @Step
    public void clickOnCreateRequestButton() {
        allRequestsPage.clickOnCreateRequestButton();
    }
    @Step
    public void searchForValueBy(String value, String searchBy) {
        allRequestsPage.searchForValueBy(value, searchBy);
    }
    @Step
    public void isAllNextButtonInactive() {
        Assert.assertFalse("TOP Next button isn't inactive",allRequestsPage.getTopNextButton().isEnabled());
        Assert.assertFalse("Bottom Next button isn't inactive",allRequestsPage.getBottomNextButton().isEnabled());
    }
    @Step
    public void addToProductListForInvoiceNoLines(String lineNumbers) {
        allRequestsPage.addToProductListForInvoiceNoLines(lineNumbers);
    }
    @Step
    public void selectLinesFromProductListForInvoiceNo(List<String> linesNumbers) {
        allRequestsPage.selectLinesFromProductListForInvoiceNo(linesNumbers);
    }
}
