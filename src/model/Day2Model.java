package model;

public class Day2Model {
    private String direction;
    private Integer value;

    public Day2Model(String direction, Integer value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
