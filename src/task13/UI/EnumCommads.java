package task13.UI;

public enum EnumCommads {

    FIRST("1. Добавить новый питомник."),
    SECOND("2. Добавить нового кота."),
    THIRD("3. Удалить кота."),
    FOURTH("4. Переселить котов из одного питомника в другой."),
    FIFTH("5. Посмотреть информацию о всех котах."),
    SIXTH("6. Посмотреть информацию о котах в конкретном питомнике."),
    SEVENTH("7. Посммотреть информацию о конкретном коте."),
    EIGHTH("8. Посммотреть информацию о всех питомниках."),
    NINTH("9. Редактировать информацию о коте."),
    TENTH("10. Редактировать информацию о питомнике."),
    ELEVENTH("11. Удалить питомник и перенести всех котов в другой."),
    TWELFTH("12. Выйти из программы");

    private String menuCommand;

    EnumCommads(String menuCommand) {
        this.menuCommand = menuCommand;
    }

    public String getMenuCommand() {
        return menuCommand;
    }
}
