package utility;

import java.util.Scanner;
import clients.Country;

/**
 * Class to ask for user input
 * It is a singleton class
 */
public class Asker {

    /* Singleton instance */
    private static Asker asker = new Asker();

    /**
     * Private constructor
     */
    private Asker() {
    }

    /**
     * Method to get the singleton instance
     * 
     * @return the singleton instance
     */
    public static Asker getAsker() {
        return asker;
    }

    /**
     * Method to ask for an option in the form of an integer
     * The method will keep asking until the user enters a valid option
     * The result is in the range [min, max]
     * 
     * @param message the message to show to the user
     * @param min     the minimum value of the option
     * @param max     the maximum value of the option
     * @param error   the error message to show to the user
     * @return the option entered by the user
     */
    public int askOption(String message, int min, int max, String error) {
        int answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Integer.parseInt(text);
                if (answer >= min && answer <= max) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(error);
            }
        }
        return answer;
    }

    /**
     * Method to ask for a long
     * The method will keep asking until the user enters a valid long
     * The result is in the range [min, max]
     * 
     * @param message the message to show to the user
     * @param min     the minimum value of the option
     * @param max     the maximum value of the option
     * @param error   the error message to show to the user
     * @return the long entered by the user
     */
    public long askLong(String message, long min, long max, String error) {
        long answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Long.parseLong(text);
                if (answer >= min && answer <= max) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(error);
            }
        }
        return answer;
    }

    /**
     * Method to ask for a double
     * The method will keep asking until the user enters a valid double
     * The result is in the range [min, max]
     * 
     * @param message the message to show to the user
     * @param min     the minimum value of the option
     * @param max     the maximum value of the option
     * @param error   the error message to show to the user
     * @return the double entered by the user
     */
    public double askDouble(String message, double min, double max, String error) {
        double answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Double.parseDouble(text);
                if (answer >= min && answer <= max) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(error);
            }
        }
        return answer;
    }

    /**
     * Method to ask for a string
     * The method will keep asking until the user enters a valid string
     * The result must not be empty
     * 
     * @param message the message to show to the user
     * @param error   the error message to show to the user
     * @return the string entered by the user
     */
    public String askString(String message, String error) {
        String answer = "";
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                answer = sc.nextLine();
                if (!answer.isEmpty()) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(error);
            }
        }
        return answer;
    }

    /**
     * Method to ask for a country
     * The method will keep asking until the user enters a valid country
     * The user gives a string and the method returns the corresponding country if
     * its a valid country
     * 
     * @param message the message to show to the user
     * @param error   the error message to show to the user
     * @return the country entered by the user
     */
    public Country askCountry(String message, String error) {
        Country ans = null;
        int answer = -1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            try {
                String text = sc.nextLine();
                answer = Integer.parseInt(text);
                ans = Country.getCountry(answer);
                if (ans != null) {
                    valid = true;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(error);
            }
        }
        return ans;
    }

}
