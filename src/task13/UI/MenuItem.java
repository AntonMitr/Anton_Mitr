package task13.UI;

public class MenuItem {

    private String title;
    private IAction iAction;
    private Menu nextMenu;

    public MenuItem(String title, IAction iAction) {
        this.title = title;
        this.iAction = iAction;
    }

    public IAction getiAction() {
        return iAction;
    }

    public void setIAction(IAction iAction) {
        this.iAction = iAction;
    }

    public String getTitle() {
        return title;
    }

    public void doAction() {
        iAction.execute();

    }
}
