package com.x.tools.core.utils;


import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;


public class Utils {

    public static String streamToString(InputStream stream) throws IOException {

        StringWriter writer = new StringWriter();
        IOUtils.copy(stream, writer, "UTF-8");

        return writer.toString();
    }

    public static void closeStreams(@NotNull InputStream... streams) throws IOException {

        for (InputStream stream : streams) {
            stream.close();
        }

    }

    public static Logger addLogger(String className){

        return LoggerFactory.getLogger(className);
    }

}
