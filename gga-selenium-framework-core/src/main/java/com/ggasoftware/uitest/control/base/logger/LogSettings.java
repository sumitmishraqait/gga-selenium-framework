package com.ggasoftware.uitest.control.base.logger;


import com.ggasoftware.uitest.control.base.logger.enums.LogInfoTypes;
import com.ggasoftware.uitest.control.base.logger.enums.LogLevels;

import java.util.ArrayList;
import java.util.List;

import static com.ggasoftware.uitest.control.base.logger.enums.LogInfoTypes.*;
import static com.ggasoftware.uitest.control.base.logger.enums.LogLevels.INFO;

/**
 * Created by Roman_Iovlev on 7/13/2015.
 */
public class LogSettings {
    public LogLevels logLevel;
    public int logInfoTypes;
    public LogInfoTypes logInfoType;

    public LogSettings() {
        this.logLevel = INFO;
        logInfoTypes = BUSINESS.type + FRAMEWORK.type + TECHNICAL.type;
    }

    public LogSettings(LogLevels logLevel, LogInfoTypes... logInfoTypes) {
        this.logLevel = logLevel;
        List<LogInfoTypes> usedTypes = new ArrayList<>();
        this.logInfoTypes = 0;
        for (LogInfoTypes logInfoType : logInfoTypes)
            if (!usedTypes.contains(logInfoType)) {
                usedTypes.add(logInfoType);
                this.logInfoTypes += logInfoType.type;
            }
    }

    public LogSettings(LogLevels logLevel, LogInfoTypes logInfoType) {
        this.logLevel = logLevel;
        this.logInfoType = logInfoType;
    }
}
