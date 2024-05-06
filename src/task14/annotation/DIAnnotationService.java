package task14.annotation;

import java.lang.reflect.Field;

public class DIAnnotationService {

    private DIAnnotationService() {
    }

    public static void processingDI(Object obj) {
        Field[] Fields = obj.getClass().getDeclaredFields();

        for (Field field : Fields) {
            if (field.isAnnotationPresent(DIAnnotation.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, field.getType().newInstance());
                } catch (final IllegalAccessException | InstantiationException ex) {
                    System.out.println(ex.getMessage());
                }
                field.setAccessible(false);
            }
        }
    }
}
