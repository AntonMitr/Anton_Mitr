package task13.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Boolean canDeleteHome;
    private Integer maxCatsAtHome;

    public Config() {
        initConfigConst();
    }

    private void initConfigConst() {
        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream("src/task13/config/config.properties")) {
            property.load(fis);
            canDeleteHome = Boolean.valueOf(property.getProperty("CAN_DELETE_HOME"));
            maxCatsAtHome = Integer.valueOf(property.getProperty("MAX_CATS_AT_HOME"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Boolean getCanDeleteHome() {
        return canDeleteHome;
    }

    public Integer getMaxCatsAtHome() {
        return maxCatsAtHome;
    }
}
