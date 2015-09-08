package com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.complex;

import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.composite.Page;
import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.page_objects.annotations.JDIAction;
import org.openqa.selenium.Cookie;

/**
 * Created by Roman_Iovlev on 9/3/2015.
 */
public interface IPage {
    Page.StringCheckType url();
    Page.StringCheckType title();
    /** Check that page opened */
    @JDIAction
    void checkOpened();
    /** Opens url specified for page */
    @JDIAction
    void open();
    /** Refresh current page */
    @JDIAction
    void refresh();
    /** Go back to previous page */
    @JDIAction
    void back();
    /** Go forward to next page */
    @JDIAction
    void forward();
    /** Add cookie in browser */
    @JDIAction
    void addCookie(Cookie cookie);
    /** Clear browsers cache */
    @JDIAction
    void clearCache();
}