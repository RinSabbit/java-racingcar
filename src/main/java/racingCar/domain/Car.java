package racingCar.domain;

import racingCar.domain.Engine.Engine;

public class Car {

    private static final String GO_FORWARD_MARKING = "-";
    private static final int GO_FORWARD_DISTANCE = 1;

    private final String name;
    private final Engine engine;
    private int position = 0;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void run() {
        if (engine.isMove()) {
            position += GO_FORWARD_DISTANCE;
        }
    }

    private String displayCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append(GO_FORWARD_MARKING);
        }
        return currentPosition.toString();
    }

    public boolean isOn(int max) {
        return position == max;
    }

    @Override
    public String toString() {
        return name + " : " + displayCurrentPosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
