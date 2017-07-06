package com.empower.pages;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public List<String> getTextFromList(List<WebElementFacade> list){
        List<String> textList=new ArrayList<>();
        for(WebElementFacade we:list){
            textList.add(we.getText());
        }
        return textList;
    }
}
