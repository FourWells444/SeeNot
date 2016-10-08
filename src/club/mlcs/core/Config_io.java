package club.mlcs.core;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Config_io {
    String listen_port;
    String hdfs;

    private static Config _instance;

    static {
        Gson gson = new Gson();
        FileInputStream configIn = null;
        try {
            configIn = new FileInputStream("conf.json");
            _instance = gson.fromJson(IOUtils.toString(configIn), Config.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(configIn);
        }
    }

    public static Config getInstance() {
        return _instance;
    }
}