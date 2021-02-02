package lk.ijse.dep.listener;

import lk.ijse.dep.util.JPAUtil;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

@WebListener
public class ContextListener implements ServletContextListener {
    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties prop = new Properties();
        try {
            logger.info("Session factory is being initialized");
            sce.getServletContext().setAttribute("emf", JPAUtil.getEntityManagerFactory());

//            Properties properties = System.getProperties();
//            for (Object o : properties.keySet()) {
//                System.out.println(o);
//            }

//            System.out.println(System.getProperty("catalina.home"));

            String logFilePath;
            if (prop.getProperty("app.log_dir") != null) {
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            } else {
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.getEntityManagerFactory().close();
        logger.info("Session factory is being shut down");
    }
}
