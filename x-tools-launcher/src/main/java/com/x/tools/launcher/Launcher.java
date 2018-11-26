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

    private static String TOOLS_CONF = "conf/tools.yaml";
    private static String ALIASES_CONF = "conf/aliases.yaml";
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    public Launcher() {

        try {
            this.configuration = buildConfiguration();
            this.loggerManager = LoggerManager.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    private static Configuration buildConfiguration() throws IOException {

        Yaml yaml = new Yaml();

        InputStream toolsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(TOOLS_CONF);
        InputStream aliasStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALIASES_CONF);
        SequenceInputStream confStream = new SequenceInputStream(toolsStream, aliasStream);

        Configuration config = yaml.loadAs(confStream, Configuration.class);

        Utils.closeStreams(toolsStream, aliasStream, confStream);

        return config;
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
