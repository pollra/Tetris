package tetris.app.main.basis.entity;

public enum Color {
    BLOCK ("block" , -1, "111111"),
    WHITE ("white" , 0 , "FFFFFF"),
    RED   ("red"   , 1 , "FF675C"),
    ORANGE("orange", 2 , "FFB15E"),
    YELLOW("yellow", 3 , "FFF25E"),
    GREEN ("green" , 4 , "91FF5E"),
    SKY   ("sky"   , 5 , "5EFFFA"),
    BLUE  ("blue"  , 6 , "5E73FF"),
    PURPLE("purple", 7 , "B75EFF");

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
