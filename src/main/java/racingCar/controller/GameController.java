package racingCar.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingCar.domain.RacingGame;
import racingCar.domain.Round;
import racingCar.domain.car.Car;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.Engine;
import racingCar.domain.car.Engine.RandomEngine;
import racingCar.utils.ValidateUtils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private Round round;
    private Cars cars;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        inputCars();
        inputRacingRound();
        RacingGame racingGame = new RacingGame(cars, round);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(cars.toList());
        }
        OutputView.printWinners(cars.findWinners());
    }

    private void inputCars() {
        try {
            OutputView.printInputCarNameMessage();
            String[] carNames = inputView.inputCarNames();
            cars = makeCars(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            inputCars();
        }
    }

    private Cars makeCars(String[] carNames) {
        Engine engine = new RandomEngine();
        return new Cars(Arrays.stream(carNames)
            .map(carName -> new Car(carName, engine))
            .collect(Collectors.toList()));
    }

    private void inputRacingRound() {
        try {
            OutputView.printInputNumOfRoundMessage();
            round = new Round(ValidateUtils.validateInteger(inputView.inputValue()));
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            inputRacingRound();
        }
    }
}
