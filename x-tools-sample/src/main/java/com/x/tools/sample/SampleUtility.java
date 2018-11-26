package com.x.tools.sample;

import com.x.tools.core.ToolsLogger;
import org.slf4j.Logger;


public class SampleUtility implements ToolsLogger {

    private String sampleStr;
    private int sampleInt;

    private final Logger logger = logger();


    public SampleUtility(String sampleStr, int sampleInt ){

        this.sampleStr = sampleStr;
        this.sampleInt = sampleInt;
    }

    public void sampleMethod(){


        logger.info("sample_str: " + getSampleStr());
        logger.info("sample_int: " + getSampleInt());

    }

    public String getSampleStr() {
        return sampleStr;
    }

    public int getSampleInt() {
        return sampleInt;
    }
}
