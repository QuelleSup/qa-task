package com.task.selenium.utils;

public final class OSValidator {

   public static boolean isWindows() {
      return System.getProperty("os.name").toLowerCase().contains("win");
   }

   public static boolean isMac() {
      return System.getProperty("os.name").toLowerCase().contains("mac");
   }

   public static boolean isLinux() {
      return System.getProperty("os.name").toLowerCase().contains("linux");
   }
}
