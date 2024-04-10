package task13.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Boolean CAN_DELETE_HOME;
    private Integer MAX_CATS_AT_HOME;

    public Config() {
        InitConfigConst();
    }

    private void InitConfigConst() {
        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream("src/task13/config/config.properties")) {
            property.load(fis);
            CAN_DELETE_HOME = Boolean.valueOf(property.getProperty("CAN_DELETE_HOME"));
            MAX_CATS_AT_HOME = Integer.valueOf(property.getProperty("MAX_CATS_AT_HOME"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Boolean getCanDeleteHome() {
        return CAN_DELETE_HOME;
    }

    public Integer getMaxCatsAtHome() {
        return MAX_CATS_AT_HOME;
    }
}
