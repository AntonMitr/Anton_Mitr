package task14.UI;

public enum EnumCommands {

    ADD_HOME("Добавить новый питомник."),
    ADD_CAT("Добавить нового кота."),
    DEL_CAT("Удалить кота."),
    REPLACE("Переселить котов из одного питомника в другой."),
    INFO_ABOUT_ALL_CATS("Посмотреть информацию о всех котах."),
    INFO_ABOUT_CATS("Посмотреть информацию о котах в конкретном питомнике."),
    INFO_ABOUT_CAT("Посммотреть информацию о конкретном коте."),
    INFO_ABOUT_HOME("Посммотреть информацию о всех питомниках."),
    CHANGE_CAT_INFO("Редактировать информацию о коте."),
    CHANGE_HOME_INFO("Редактировать информацию о питомнике."),
    DEL_HOME_AND_REPLACE_CATS("Удалить питомник и перенести всех котов в другой."),
    EXIT("exit. Выйти из программы");

    private String menuCommand;

    EnumCommands(String menuCommand) {
        this.menuCommand = menuCommand;
    }

    public String getEnumCommand() {
        return menuCommand;
    }
}
