package task13.UI;

public class Navigator {

    private Menu currentMenu;
    private Builder builder = Builder.getBuilder(); // builder single ton????

    public Navigator() {
        this.currentMenu = builder.getRootMenu();
    }

    public void printMenu() {
        System.out.println("\nВ нашей программе доступны следующие команды:");
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            System.out.println(currentMenu.getMenuItems().get(i).getTitle());
        }
    }

    public void navigate(int command) {
        currentMenu.getMenuItems().get(command).doAction();
    }
}
