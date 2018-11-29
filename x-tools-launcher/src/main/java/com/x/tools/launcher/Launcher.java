package com.x.tools.launcher;

import com.x.tools.core.Tool;
import com.x.tools.core.exceptions.ToolsException;
import com.x.tools.core.utils.Utils;
import com.x.tools.launcher.conf.Configuration;
import com.x.tools.launcher.conf.LoggerManager;
import com.x.tools.sample.SampleTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;


public class Launcher {

    private Configuration configuration;
    private LoggerManager loggerManager;

    private static final String FAILED_TO_LUNCH = "Failed to lunch tools";
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    public Launcher() {
        try {
            this.configuration = Configuration.getInstance();
            this.loggerManager = LoggerManager.getInstance();
        } catch (ToolsException e) {
            logger.error(FAILED_TO_LUNCH);
            throw new RuntimeException(FAILED_TO_LUNCH,e);
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public LoggerManager getLoggerManager() {
        return loggerManager;
    }

    public static void main(String[] args) {


        logger.info("Launch...");
        Launcher launcher = new Launcher();
        try {
            launcher.getLoggerManager().addLogger("sample-tool", "com.x.tools.sample");
        } catch (ToolsException e) {
            logger.error("Failed to create logger");
            throw new RuntimeException("Failed to create logger",e);
        }

        Tool tool = new SampleTool();

        try {
            tool.execute("sample", "9");
        } catch (ToolsException e) {
            logger.error(String.format("Failed to run tool sample-tool: %s",e.getMessage()));
        }

        logger.info("Done");
    }


}
