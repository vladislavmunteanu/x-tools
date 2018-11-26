package com.x.tools.launcher.conf;

import com.x.tools.core.conf.Alias;
import com.x.tools.core.conf.ToolConf;

import java.util.List;

public class Configuration {

    private List<ToolConf> tools;
    private List<Alias> aliases;

    public Configuration(){}

    public List<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }

    public List<ToolConf> getTools() {
        return tools;
    }

    public void setTools(List<ToolConf> tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return tools+"\n"+aliases;
    }
}
