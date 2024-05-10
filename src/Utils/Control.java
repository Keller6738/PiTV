package Utils;

import java.util.Arrays;

public class Control {
    private boolean[] menus;
    private boolean[] windows;

    private int menusNum = 0;
    private int windowsNum = 0;

    Control control = new Control();

    public Control getInstance() {
        return control;
    }

    private Control() {
        this.menus = new boolean[this.menusNum];
        Arrays.fill(this.menus, false);

        this.windows = new boolean[this.windowsNum];
        Arrays.fill(this.windows, false);
    }

    public void setMenusNum(int menusNum) {
        this.menusNum = menusNum;
    }

    public void setWindowsNum(int windowsNum) {
        this.windowsNum = windowsNum;
    }

    public int getVisibleMenu() {
        for (int i = 0; i < this.menus.length; i++) if (this.menus[i]) return i;
        return -1;
    }

    public void setVisibleMenu(int index) {
        for (int i = 0; i < this.menus.length; i++) if (this.menus[i]) this.menus[i] = false;
        this.menus[index] = true;
    }

    public int getVisibleWindow() {
        for (int i = 0; i < this.windows.length; i++) if (this.windows[i]) return i;
        return -1;
    }

    public void setVisibleWindow(int index) {
        for (int i = 0; i < this.windows.length; i++) if (this.windows[i]) this.windows[i] = false;
        this.windows[index] = true;
    }
}
