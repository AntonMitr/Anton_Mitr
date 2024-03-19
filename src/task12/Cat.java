package task12;

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

    public String getHome() {
        return home;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome(String home) {
        this.home = home;
    }

}
