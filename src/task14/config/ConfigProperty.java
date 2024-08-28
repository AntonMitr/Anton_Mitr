package task14.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigProperty {

    String configFileName() default "src/task14/config/config.properties";

    String propertyName() default "";

    Class<?> type() default String.class;
}
