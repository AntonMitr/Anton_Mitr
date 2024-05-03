package task13.model;

import java.io.Serial;
import java.io.Serializable;

public class Cat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String home;

    public Cat(String name, String home) {
        this.name = name;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Cat cat = (Cat) obj;
        return ((name.equals(cat.getName())) && (home.equals(cat.getHome())));
    }
}
