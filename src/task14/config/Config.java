package task14.config;

public class Config {

    @ConfigProperty(propertyName = "CAN_DELETE_HOME", type = boolean.class)
    private boolean CAN_DELETE_HOME;
    @ConfigProperty(propertyName = "MAX_CATS_AT_HOME", type = int.class)
    private int MAX_CATS_AT_HOME;

    public Config() {
        ConfigAnalizator configAnalizator = new ConfigAnalizator();
        configAnalizator.analize(this);
    }

    public Boolean getCanDeleteHome() {
        return CAN_DELETE_HOME;
    }

    public Integer getMaxCatsAtHome() {
        return MAX_CATS_AT_HOME;
    }
}
