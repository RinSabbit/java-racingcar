package racingCar.view;

import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValue() {
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String cars = scanner.nextLine();
        return cars.split(DELIMITER);
    }

}
