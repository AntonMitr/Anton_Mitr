package task13.UI;

public class Navigator {

    private Menu currentMenu;

    public Navigator() {
        this.currentMenu = Menu.getMenu();
    }

    public void printMenu() {
        System.out.println("\nВ нашей программе доступны следующие команды:");
        for (int i = 1; i <= currentMenu.getMenuItems().size(); i++) {
            System.out.println(currentMenu.getMenuItems().get(Integer.toString(i)).getTitle());
        }
    }

    public void navigate(String command) {
        currentMenu.getMenuItems().get(command).doAction();
    }
}
