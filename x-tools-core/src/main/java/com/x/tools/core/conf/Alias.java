package com.x.tools.core.conf;

import java.util.List;

public class Alias {

    private String name;
    private String toolName;
    private List<String> args;

    public Alias(){}

    public String getToolName() {
        return toolName;
    }

    public List<String> getArgs() {
        return args;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return name;
    }
}
