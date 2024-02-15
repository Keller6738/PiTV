package Util;

import java.awt.*;

public enum Buttons {
    mechanicsMenu(new MyButton(, "Mechanics", new Dimension(300, 50))),
    ELECTRONICS_MENU(new MyButton(, "Electronics", new Dimension(300, 50))),
    PROGRAMMING_MENU(new MyButton(, "Programming", new Dimension(300, 50))),
    COMMUNITY_MENU(new MyButton(, "Community", new Dimension(300, 50)));

    public Button button;

    Buttons(Buttons button) {
    }

}
