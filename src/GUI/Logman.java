/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author yanukadeneth
 */
public class Logman {

    public void SetupLogger(Logger logr) {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("log.log", true);
            fh.setLevel(Level.CONFIG);
            fh.setFormatter(new SimpleFormatter());
            logr.addHandler(fh);

            FileHandler fh2 = new FileHandler("DevLog.log", true);
            fh2.setLevel(Level.FINEST);
            fh2.setFormatter(new SimpleFormatter());
            logr.addHandler(fh2);

        } catch (Exception ex) {
            logr.log(Level.SEVERE, "File Logger not working", ex);
        }
    }
}
