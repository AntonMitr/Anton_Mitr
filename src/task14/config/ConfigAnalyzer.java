package task14.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigAnalyzer {

    private final Properties property;

    public ConfigAnalyzer() {
        property = new Properties();
    }

    public void analize(Config config) {
        Field[] fields = config.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ConfigProperty.class)) {
                field.setAccessible(true);
                ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
                try (FileInputStream fis = new FileInputStream(configProperty.configFileName())) {
                    property.load(fis);
                    field.set(config, ConfigConvert.convertValue(property.getProperty(configProperty.propertyName()), configProperty.type()));
                } catch (final IOException | IllegalArgumentException | IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                }
                field.setAccessible(false);
            }
        }
    }

}
