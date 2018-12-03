package com.x.tools.launcher.conf;

import com.x.tools.core.conf.Alias;
import com.x.tools.core.conf.Task;
import com.x.tools.core.exceptions.ToolsException;
import com.x.tools.core.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.List;

public class Configuration {

    private List<Task> tools;
    private List<Alias> aliases;

    private static Configuration instance;


    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
    private static final String TOOLS_CONF = "conf/tools.yaml";
    private static final String ALIASES_CONF = "conf/aliases.yaml";
    private static final String FAILED_TO_BUILD_CONFIGURATION = "Failed to build configuration:";

    public static Configuration getInstance() throws ToolsException {

        if (instance == null) {
            try {
                instance = buildConfiguration();
            } catch (IOException e) {
               logger.error(String.format(FAILED_TO_BUILD_CONFIGURATION + " %s",e.getMessage()));
               throw new ToolsException(FAILED_TO_BUILD_CONFIGURATION,e);
            }
        }
        return instance;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }

    public List<Task> getTools() {
        return tools;
    }

    public void setTools(List<Task> tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return tools + "\n" + aliases;
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
}
