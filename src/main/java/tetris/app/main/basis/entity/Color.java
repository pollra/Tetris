package tetris.app.main.basis.entity;

public enum Color {
    BLOCK ("block" , -1, "111111"),
    WHITE ("white" , 0 , "FFFFFF"),
    RED   ("red"   , 1 , "e86981"),
    ORANGE("orange", 2 , "ef944a"),
    YELLOW("yellow", 3 , "fdc73a"),
    GREEN ("green" , 4 , "91FF5E"),
    SKY   ("sky"   , 5 , "44b9e0"),
    BLUE  ("blue"  , 6 , "6c86e4"),
    PURPLE("purple", 7 , "cd66ce");

    private String name;
    private Integer number;
    private String code;

    Color(String name, Integer number, String code) {
        this.name = name;
        this.number = number;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }
}
