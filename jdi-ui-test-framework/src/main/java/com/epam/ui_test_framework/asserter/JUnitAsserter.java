package com.epam.ui_test_framework.asserter;

import com.epam.ui_test_framework.utils.linqInterfaces.JAction;
import com.epam.ui_test_framework.utils.linqInterfaces.JFuncT;
import org.junit.Assert;

import static com.epam.ui_test_framework.logger.enums.LogInfoTypes.FRAMEWORK;
import static com.epam.ui_test_framework.settings.FrameworkSettings.logger;

/**
 * Created by Roman_Iovlev on 6/9/2015.
 */
public class JUnitAsserter extends Assert implements IAsserter {

    public Exception exception(String message) {
        logger.error(FRAMEWORK, message);
        assertTrue(message, false);
        return new Exception(message);
    }
    public void silentException(JAction action) {
        try { action.invoke();
        } catch (Exception ex) { exception(ex.getMessage()); }
    }
    public <TResult> TResult silentException(JFuncT<TResult> func) {
        try { return func.invoke();
        } catch (Exception ex) { exception(ex.getMessage()); }
        return null;
    }


}
