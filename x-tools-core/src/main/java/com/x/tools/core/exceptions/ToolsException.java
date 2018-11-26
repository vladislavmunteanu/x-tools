package com.x.tools.core.exceptions;

public class ToolsException extends Exception {

    public ToolsException(String message){
        super(message);
    }

    public ToolsException(String message, Throwable cause){
        super(message,cause);
    }


}
