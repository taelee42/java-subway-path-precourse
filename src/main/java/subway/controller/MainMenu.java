package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainMenu {
    public static final String REGEX_VALID_MENU_CHARACTER = "[1-2Qq]";
    private final Scanner scanner;
    private boolean doNext;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.doNext = true;
    }

    public void run() {
        askValidMenuNumber();
    }

    private String askValidMenuNumber() {
        OutputView.mainMenu();
        try {
            return InputView.askMenu(scanner, REGEX_VALID_MENU_CHARACTER);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidMenuNumber();
        }
    }

    public boolean doNext() {
        if (doNext) {
            System.out.println();
        }
        return doNext;
    }
}
