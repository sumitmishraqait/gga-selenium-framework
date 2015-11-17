/*
 * Copyright 2004-2016 EPAM Systems
 *
 * This file is part of JDI project.
 *
 * JDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JDI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty ofMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JDI. If not, see <http://www.gnu.org/licenses/>.
 */
 
/**
 * *************************************************************************
 * Copyright (C) 2014 GGA Software Services LLC
 * <p>
 * This file may be distributed and/or modified under the terms of the
 * GNU General Public License version 3 as published by the Free Software
 * Foundation.
 * <p>
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 * *************************************************************************
 */
package com.ggasoftware.jdiuitest.web.selenium.elements.complex;

import com.ggasoftware.jdiuitest.core.interfaces.complex.IDropDown;
import com.ggasoftware.jdiuitest.core.utils.linqinterfaces.JFuncTT;
import com.ggasoftware.jdiuitest.web.selenium.elements.GetElementType;
import com.ggasoftware.jdiuitest.web.selenium.elements.base.Element;
import com.ggasoftware.jdiuitest.web.selenium.elements.common.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * RadioButtons control implementation
 *
 * @author Alexeenko Yan
 */
public class Dropdown<TEnum extends Enum> extends Selector<TEnum> implements IDropDown<TEnum> {
    private GetElementType element = new GetElementType();

    public Dropdown() {
        super();
    }

    public Dropdown(By selectLocator) {
        super(selectLocator);
    }

    public Dropdown(By selectLocator, By optionsNamesLocator) {
        this(selectLocator, optionsNamesLocator, null);
    }

    public Dropdown(By selectLocator, By optionsNamesLocator, By allOptionsNamesLocator) {
        super(optionsNamesLocator, allOptionsNamesLocator);
        this.element = new GetElementType(selectLocator);
    }

    protected Label element() {
        return element.get(new Label(), getAvatar());
    }

    protected void expandAction(String name) {
        getAvatar().context.clear();
        if (element().isDisplayed()) {
            setWaitTimeout(0);
            if (!isDisplayedAction(name)) element().click();
            restoreWaitTimeout();
        }
    }

    protected void expandAction(int index) {
        getAvatar().context.clear();
        if (!isDisplayedAction(index))
            element().click();
    }

    @Override
    protected void selectAction(String name) {
        if (element() != null) {
            expandAction(name);
            super.selectAction(name);
        } else
            new Select(getWebElement()).selectByVisibleText(name);
    }

    @Override
    protected void selectAction(int index) {
        if (element() != null) {
            expandAction(index);
            super.selectAction(index);
        } else
            new Select(getWebElement()).selectByIndex(index);
    }

    @Override
    protected String getValueAction() {
        return getTextAction();
    }

    @Override
    protected String getSelectedAction() {
        return getTextAction();
    }

    @Override
    public boolean waitDisplayed() {
        return element().waitDisplayed();
    }

    @Override
    public boolean waitVanished() {
        return element().waitVanished();
    }

    public Boolean wait(JFuncTT<WebElement, Boolean> resultFunc) {
        return element().wait(resultFunc);
    }

    public <T> T wait(JFuncTT<WebElement, T> resultFunc, JFuncTT<T, Boolean> condition) {
        return element().wait(resultFunc, condition);
    }

    public Boolean wait(JFuncTT<WebElement, Boolean> resultFunc, int timeoutSec) {
        return element().wait(resultFunc, timeoutSec);
    }

    public <T> T wait(JFuncTT<WebElement, T> resultFunc, JFuncTT<T, Boolean> condition, int timeoutSec) {
        return element().wait(resultFunc, condition, timeoutSec);
    }

    @Override
    protected List<String> getOptionsAction() {
        boolean isExpanded = isDisplayedAction(1);
        if (!isExpanded) element().click();
        List<String> result = super.getOptionsAction();
        if (!isExpanded) element().click();
        return result;
    }

    protected void clickAction() {
        element().click();
    }

    protected String getTextAction() {
        return element().getText();
    }

    public final void expand() {
        if (!isDisplayedAction(1)) element().click();
    }

    public final void close() {
        if (isDisplayedAction(1)) element().click();
    }

    public final void click() {
        actions.click(this::clickAction);
    }

    public final String getText() {
        return actions.getText(this::getTextAction);
    }

    public final String waitText(String text) {
        return actions.waitText(text, this::getTextAction);
    }

    public final String waitMatchText(String regEx) {
        return actions.waitMatchText(regEx, this::getTextAction);
    }

    public void setAttribute(String attributeName, String value) {
        element().setAttribute(attributeName, value);
    }

    public WebElement getWebElement() {
        return new Element(getLocator()).getWebElement();
    }

    public String getAttribute(String name) {
        return element().getAttribute(name);
    }

    public boolean waitAttribute(String name, String value) {
        return element().waitAttribute(name, value);
    }

}
