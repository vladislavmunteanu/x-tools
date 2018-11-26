package com.x.tools.core.conf;

import java.util.List;

public class ToolConf {

    private String toolName;
    private String classPath;

    public ToolConf(){}


    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String toString() {
        return toolName;
    }
}
