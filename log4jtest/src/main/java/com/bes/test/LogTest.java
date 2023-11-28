package com.bes.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

public class LogTest {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        LogTest.run();
                    }
                }
            });
            thread.start();
        }
        Thread.sleep(5000);
        System.exit(0);
    }

    private static void run() {
        try {
            callDiv(1, 0);
        } catch (Exception e) {
            logger.error("div error", e);
        }
    }

    private static int callDiv(int a, int b) throws Exception {
        Method method = MathUtil.class.getMethod("div", new Class[]{int.class, int.class});
        return (int) method.invoke(null, a, b);
    }
}