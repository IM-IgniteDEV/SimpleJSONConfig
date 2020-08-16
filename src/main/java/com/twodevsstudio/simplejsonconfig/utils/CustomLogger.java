package com.twodevsstudio.simplejsonconfig.utils;


import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomLogger {

  public static final Logger LOGGER = LoggerFactory.getLogger(CustomLogger.class.getSimpleName());

  public static String LOG_PREFIX = "&7[&aSimpleJSONConfig&7] &a»» &7";

  public static String WARNING_PREFIX = "&7[&eWARNING&7] &a»» &e";

  public static String ERROR_PREFIX = "&7[&4ERROR&7] &c»» &4";

  public static void log(@NotNull String message) {

    LOGGER.info(LOG_PREFIX + message);
  }

  public static void warning(@NotNull String message) {

    LOGGER.warn(WARNING_PREFIX + message);
  }

  public static void warning(@NotNull Throwable throwable) {

    LOGGER.warn(WARNING_PREFIX + throwable.getMessage());
    throwable.getCause().printStackTrace();
  }

  public static void error(@NotNull String message) {

    LOGGER.error(ERROR_PREFIX + message);
  }


  public static void error(@NotNull Throwable throwable) {

    LOGGER.error(ERROR_PREFIX + throwable.getMessage());
    throwable.getCause().printStackTrace();
  }

}
