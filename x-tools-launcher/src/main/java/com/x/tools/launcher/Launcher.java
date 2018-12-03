package com.x.tools.launcher;

import com.x.tools.core.exceptions.ToolsException;
import com.x.tools.launcher.conf.Configuration;
import com.x.tools.launcher.conf.LoggerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Launcher {

    private Configuration configuration;
    private LoggerManager loggerManager;

    private static final String FAILED_TO_LUNCH = "Failed to lunch tools";
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    public Launcher() {
        try {
            this.configuration = Configuration.getInstance();
            this.loggerManager = LoggerManager.getInstance();
        } catch (ToolsException e) {
            logger.error(FAILED_TO_LUNCH);
            throw new RuntimeException(FAILED_TO_LUNCH, e);
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public LoggerManager getLoggerManager() {
        return loggerManager;
    }

    public void launch() {

        while (true) {

            System.out.print("^");
            Scanner scan = new Scanner(System.in);

            String input_line = scan.nextLine();

            if (input_line.equals("exit"))
                break;

            runTool(input_line);

        }

    }

    public void runTool(String command) {
        System.out.println("Running tool: "+command);
    }


    public static void main(String[] args) {

        Launcher launcher = new Launcher();

        System.out.println(" ------------------------------------");
        System.out.println("| *** I n t e r n a l  T o o l s *** |");
        System.out.println(" ------------------------------------");

        if (args.length == 0) {
            launcher.launch();
        } else {
            launcher.runTool(args[0]);
        }


    }


}
