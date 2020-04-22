package tetris.app.main.command.entity;

public enum Command {
    SPACE(32),
    LEFT (37),
    RIGHT(39),
    UP   (38),
    DOWN (40),
    PAUSE(80);

    private Integer keyCode;

    Command(int keyCode) {
        this.keyCode = keyCode;
    }

    public Integer getKeyCode() {
        return keyCode;
    }
}
