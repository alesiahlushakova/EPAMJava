package by.training.task03.view;

import by.training.task03.controller.Controller;

import java.util.Scanner;

/**
 * @author Alesyahlushakova
 * view class.
 */
public final class Runner {
    /**
     * private constructor.
     */
    private Runner() { }
    /**
     * main function.
     * @param args console args
     */
    public static void main(final String[] args) {
        /**
         * controller.
         */
        Controller controller = new Controller();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write option:(use space after commands) \n "
                    + "0.EXIT \n "
                    + "1.FILL_FROM_FILE  \n 2.WRITE_TO_FILE"
                    + "(fill from file first)"
                    + "  \n 3.FILL_DIAGONAL (fill"
                    + " from file first)");

            String option = scanner.nextLine();
            if ("EXIT ".equals(option)) {
                return;
            }
                    controller.executeTask(option);

            }
        }
    }

