package club.mlcs.logging;

import club.mlcs.core.Main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;

/**
 * Created by asus_nb on 2016/9/27.
 */
public class startLogging {

    private static boolean Loaded = false;

    private startLogging() {}

    private static void log4j2Configurater() {
        ConfigurationSource log4j2Conf = null;
        try {
            log4j2Conf = log4j2ConfLoader();
        } catch (IOException e) {
            System.out.println("Fail to Load Configuration");
        }
        Configurator.initialize(null, log4j2Conf);
        Loaded = true;
    }

    private static ConfigurationSource log4j2ConfLoader() throws IOException {
        ConfigurationSource log4j2Conf = new ConfigurationSource(
                Main.class.getResourceAsStream("/res/config/log4j2.xml")
        );
        return log4j2Conf;
    }

    public static void setLog(){
        if (!Loaded) {
            log4j2Configurater();
            Logger logger = LogManager.getLogger("LogStarts");
            logger.info("Load Log4j2 Configuration Succeed");
        }
    }

    public static boolean isLoaded(){
        return Loaded;
    }
}