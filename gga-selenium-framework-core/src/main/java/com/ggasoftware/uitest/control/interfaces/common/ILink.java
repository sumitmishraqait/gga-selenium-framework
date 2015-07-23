package com.ggasoftware.uitest.control.interfaces.common;

import com.ggasoftware.uitest.control.interfaces.base.IClickableText;

/**
 * Created by Roman_Iovlev on 6/10/2015.
 */
public interface ILink<P> extends IClickableText<P> {
    String getReference();
}
