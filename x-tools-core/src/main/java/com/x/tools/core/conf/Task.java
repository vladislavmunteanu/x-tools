package com.x.tools.core.conf;

import java.util.List;

public class Task {

    private String toolName;
    private String classPath;
    private List<String> args;

    public Task(){}

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

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
