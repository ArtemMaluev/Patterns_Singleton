package maluevArtem;

import java.util.Date;

public class Logger {

    private static Logger log = null;
    private int numberMsg = 0;

    private Logger() {
    }

    public static Logger getLog() {
        if (log == null) {
            log = new Logger();
        }
        return log;
    }

    public void log(String msg) {
        Date date = new Date();
        numberMsg++;
        System.out.println("[" + date + "] log № " + numberMsg + " " + msg);
    }
}
