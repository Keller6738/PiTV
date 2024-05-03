package Utils;

public class DeputyMenuContent {
    private final String buttonText;
    private final boolean isLonger;
    private final WindowContent[] windowContents;

    public DeputyMenuContent(String buttonText, boolean isLonger, WindowContent... windowContents) {
        this.buttonText = buttonText;
        this.isLonger = isLonger;

        this.windowContents = new WindowContent[windowContents.length];
        System.arraycopy(windowContents, 0, this.windowContents, 0, this.windowContents.length);
    }

    public String getButtonText() {
        return buttonText;
    }

    public boolean isLonger() {
        return isLonger;
    }

    public int getWindowContentsLength() {
        return this.windowContents.length;
    }

    public WindowContent getWindowContent(int index) {
        return this.windowContents[index];
    }
}
