package com.x.tools.sample;

import com.x.tools.core.Tool;
import com.x.tools.core.exceptions.ToolsException;
import org.slf4j.Logger;


public class SampleTool implements Tool {


    private final Logger logger = logger();

    @Override
    public void execute(String... args) throws ToolsException {

        logger.info("Started sample-tool...");

        String sample_str = args[0];
        int sample_int;

        try {
            sample_int = Integer.valueOf(args[1]);
        } catch (NumberFormatException e) {
            logger.error("Failed to configure sample-tool", e);
            throw new ToolsException("Failed to configure sample-tool", e);
        }

        new SampleUtility(sample_str,sample_int).sampleMethod();

        logger.info("Finished sample-tool");

    }



}
