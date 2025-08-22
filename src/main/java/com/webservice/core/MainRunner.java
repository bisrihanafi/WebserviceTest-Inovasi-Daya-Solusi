package com.webservice.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import com.webservice.services.Router;


/**
 *
 * @author Hanafi
 */
public class MainRunner {

    //port untuk running aplikasi
    public static int PORT = 4448;

    private static final Map<String, OptionInfo> optionHandlers;

    static {
        optionHandlers = new HashMap<>();
        optionHandlers.put("-port=", new OptionInfo(
                value -> PORT = Integer.parseInt(value),
                "  -> setting port yang akan menjadi receiver aplikasi ini -port=8080"
        ));
        optionHandlers.put("-run", new OptionInfo(
                value -> System.out.println("RUNNING APPLICAION"),
                "  -> Menjalankan applikasi secara default (port=4443)"
        ));

        optionHandlers.put("-help", new OptionInfo(
                value -> printHelp(),
                "  -> show option can will selected"
        ));
    }

    public static void start(String[] args) throws Exception {
        for (String arg : args) {
            String lowerArg = arg.toLowerCase();
            for (Map.Entry<String, OptionInfo> entry : optionHandlers.entrySet()) {
                if (lowerArg.startsWith(entry.getKey())) {
                    entry.getValue().action.accept(arg.substring(entry.getKey().length()));
                    break;
                }
            }
        }
        if (InitializeWeb.initWeb(new Router().getItems().getArrayServletModel(), PORT)) {
            System.out.println("Aplikasi Running");
        }
    }


    private static String printHelp() {
        System.out.println("Available options:");
        for (Map.Entry<String, OptionInfo> entry : optionHandlers.entrySet()) {
            System.out.printf("  %s%s%n", entry.getKey(), entry.getValue().description);
        }
        System.exit(0);
        return null;
    }

    private static class OptionInfo {

        final Consumer<String> action;
        final String description;

        OptionInfo(Consumer<String> action, String description) {
            this.action = action;
            this.description = description;
        }
    }
}
