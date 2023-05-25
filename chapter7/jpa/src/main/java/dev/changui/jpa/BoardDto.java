package dev.changui.jpa;

public class BoardDto {
    private String name;

    public BoardDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
