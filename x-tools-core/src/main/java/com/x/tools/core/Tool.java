package com.x.tools.core;

import com.x.tools.core.exceptions.ToolsException;
import com.x.tools.core.utils.Utils;

import java.io.IOException;
import java.io.InputStream;

public interface Tool extends ToolsLogger{

    String USAGE_FILE = "Usage.txt";

    default String getUsage() throws ToolsException {

        InputStream usageStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(USAGE_FILE);
        String usage = "";

        if (usageStream == null){
            String error_message = String.format("Unable to find usage for %s", this.getClass().getName());
            throw new ToolsException(error_message);
        }else {

            try {
                usage = Utils.streamToString(usageStream);
            } catch (IOException e) {
                String error_message = String.format("Unable to convert usage for %s", this.getClass().getName());
                throw new ToolsException(error_message, e);
            }
        }

        return usage;
    }

    void execute(String... args) throws ToolsException;
}
