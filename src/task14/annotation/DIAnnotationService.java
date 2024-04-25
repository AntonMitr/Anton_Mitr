package task14.annotation;

import task14.UI.Builder;
import task14.UI.Menu;
import task14.UI.Navigator;
import task14.controller.CatService;
import task14.controller.HomeService;

import java.lang.reflect.Field;

public class DIAnnotationService {

    public DIAnnotationService() {
    }

    public static void processingDI(Object obj) {
        Field[] Fields = obj.getClass().getDeclaredFields();

        for (Field field : Fields) {
            if (field.isAnnotationPresent(MenuDI.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, new Menu());
                } catch (final IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                }
                field.setAccessible(false);
            } else if (field.isAnnotationPresent(HomeServiceDI.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, new HomeService());
                } catch (final IllegalAccessException illegalAccessException) {
                    System.out.println(illegalAccessException.getMessage());
                }
                field.setAccessible(false);
            } else if (field.isAnnotationPresent(CatServiceDI.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, new CatService());
                } catch (final IllegalAccessException illegalAccessException) {
                    System.out.println(illegalAccessException.getMessage());
                }
                field.setAccessible(false);
            } else if (field.isAnnotationPresent(NavigatorDI.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, new Navigator());
                } catch (final IllegalAccessException illegalAccessException) {
                    System.out.println(illegalAccessException.getMessage());
                }
                field.setAccessible(false);
            } else if (field.isAnnotationPresent(BuilderDI.class)) {
                field.setAccessible(true);
                try {
                    field.set(obj, new Builder());
                } catch (final IllegalAccessException illegalAccessException) {
                    System.out.println(illegalAccessException.getMessage());
                }
                field.setAccessible(false);
            }
        }
    }
}
