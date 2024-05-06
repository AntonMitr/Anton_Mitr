package task14.config;

public class Config {

    @ConfigProperty(propertyName = "CAN_DELETE_HOME", type = boolean.class)
    private boolean canDeleteHome;
    @ConfigProperty(propertyName = "MAX_CATS_AT_HOME", type = int.class)
    private int maxCatsAtHome;

    public Config() {
        ConfigAnalizator configAnalizator = new ConfigAnalizator();
        configAnalizator.analize(this);
    }

    public Boolean getCanDeleteHome() {
        return canDeleteHome;
    }

    public Integer getMaxCatsAtHome() {
        return maxCatsAtHome;
    }
}
