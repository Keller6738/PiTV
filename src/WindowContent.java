import java.util.Arrays;

public class WindowContent {
    private final String fileName;
    private final double scaleFactor;
    private final String[] buttonText;

    public WindowContent(String fileName, double scaleFactor, String... texts) {
        this.fileName = fileName;
        this.scaleFactor = scaleFactor;

        this.buttonText = new String[texts.length];
        Arrays.setAll(this.buttonText, i -> texts[i]);
    }

    public WindowContent(String fileName, String... texts) {
        this(fileName, 1, texts);
    }

    public String getFileName() {
        return fileName;
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public String[] getButtonText() {
        return buttonText;
    }
}
