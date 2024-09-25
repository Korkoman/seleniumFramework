package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Hello World");
        logger.error("Hello World");
        logger.warn("Hello World");
        logger.fatal("Hello World");
    }


}