package fis.java.bigexample.model.enums;

public enum Rank {
    TRAINEE(1),

    JUNIOR(2),

    SENIOR(3),

    INSPECTOR(4),

    CHEF_INSPECTOR(5);

    private int code;

    Rank() {

    }

    Rank(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
