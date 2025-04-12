package umg.principal.api.main;

import umg.principal.api.service.ExecutorJobHandler;

import java.util.logging.Logger;

public class ApiApplication {

    private static final Logger logger = Logger.getLogger(ApiApplication.class.getName());
    private static final int WAIT_SECONDS = 15;

    public static void main(String[] args) {
        logger.info("Starting COVID Stats Tracker application");

        ExecutorJobHandler executor = new ExecutorJobHandler();
        executor.startProcessing(WAIT_SECONDS);

        logger.info("Application started successfully. The API consumption process will run in " + WAIT_SECONDS + " seconds");
    }

}
