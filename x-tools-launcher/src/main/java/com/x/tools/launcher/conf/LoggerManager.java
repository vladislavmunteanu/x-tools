package com.x.tools.launcher.conf;

import com.x.tools.core.exceptions.ToolsException;
import org.apache.log4j.*;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

public class LoggerManager {


    private String level;
    private String layout;
    private String folder;

    private static LoggerManager instance;
    private static FileAppender appender;
    private static String LOGGER_CONF = "conf/logger.yaml";
    private static String APPENDER_NAME = "tools_logger";
    private static String ERROR_MESSAGE = "Unable to configure 'LoggerManager'";

    public static LoggerManager getInstance() {

        if (instance == null) {
            instance = buildLoggerManager();
        }

        return instance;
    }

    public void addLogger(String fileName, String classPath) throws ToolsException {
        appender = buildNewAppender(fileName);
        LogManager.getLogger(classPath).addAppender(appender);
    }

    private static LoggerManager buildLoggerManager() {

        Yaml yaml = new Yaml();

        InputStream loggerStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(LOGGER_CONF);

        return yaml.loadAs(loggerStream, LoggerManager.class);
    }

    private static FileAppender buildNewAppender(String fileName) throws ToolsException {

        FileAppender appender;

        try {
            appender = new FileAppender(new PatternLayout(instance.getLayout()), instance.getFolder() + "/" + fileName + ".log");
            appender.setThreshold(addLevel());
            appender.setName(APPENDER_NAME);
        } catch (IOException e) {
            throw new ToolsException(ERROR_MESSAGE, e);
        }

        return appender;
    }

    private static Level addLevel() {

        switch (instance.getLevel().toLowerCase()) {
            case "info":
                return Level.INFO;
            case "debug":
                return Level.DEBUG;
            case "warn":
                return Level.WARN;
            case "error":
                return Level.ERROR;
            default:
                return Level.ALL;
        }
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

}
