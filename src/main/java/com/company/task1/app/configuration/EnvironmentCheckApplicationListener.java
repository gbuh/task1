package com.company.task1.app.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import lombok.extern.log4j.Log4j2;

/**
 * An {@code ApplicationListener} that checks if required environment variables was set.
 * <p>
 * Copyright (C) 2018 epam.com
 * <p>
 * Date: Sep 07, 2018
 *
 * @author Raman_Marozau
 */
@Log4j2
public class EnvironmentCheckApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final String DERBY_PATH = "DERBY_PATH";
    private static final String LOG_PATH = "LOG_PATH";

    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
        Environment env = event.getEnvironment();
        if (!env.containsProperty(DERBY_PATH)) {
            log.error(DERBY_PATH + " variable not set");
            throw new IllegalStateException(DERBY_PATH + " variable isn't set");
        }
        if (!env.containsProperty(LOG_PATH)) {
            String loggingPath = env.getProperty("logging.path");
            String loggingFile = env.getProperty("logging.file");
            Path currentPath = Paths.get(loggingPath, loggingFile);
            log.warn(LOG_PATH + " variable isn't set, using default file location: " + currentPath.toAbsolutePath());
        }
    }
}
