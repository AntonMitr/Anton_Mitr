package task12;

import java.io.*;

public class Cats implements Serializable {

    private String name;
    private String home;

    public Cats(String name, String home){
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
