package com.x.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ToolsLogger {


    default Logger logger() {
        return LoggerFactory.getLogger(this.getClass().getName());
    }

}
