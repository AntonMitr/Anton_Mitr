package task13.UI;

public enum EnumCommands {

    ADD_HOME("1. Добавить новый питомник."),
    ADD_CAT("2. Добавить нового кота."),
    DEL_CAT("3. Удалить кота."),
    REPLACE("4. Переселить котов из одного питомника в другой."),
    INFO_ABOUT_ALL_CATS("5. Посмотреть информацию о всех котах."),
    INFO_ABOUT_CATS("6. Посмотреть информацию о котах в конкретном питомнике."),
    INFO_ABOUT_CAT("7. Посммотреть информацию о конкретном коте."),
    INFO_ABOUT_HOME("8. Посммотреть информацию о всех питомниках."),
    CHANGE_CAT_INFO("9. Редактировать информацию о коте."),
    CHANGE_HOME_INFO("10. Редактировать информацию о питомнике."),
    DEL_HOME_AND_REPLACE_CATS("11. Удалить питомник и перенести всех котов в другой."),
    EXIT("12. Выйти из программы");

    private String menuCommand;

    EnumCommands(String menuCommand) {
        this.menuCommand = menuCommand;
    }

    public String getEnumCommand() {
        return menuCommand;
    }
}
