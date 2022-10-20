package ask;

import java.util.Scanner;

import clients.Country;

public class Asker {

    private Asker asker = new Asker();

    private Asker() {
    }

    public Asker getAsker() {
        return asker;
    }

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
        sc.close();
        return answer;
    }

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
        sc.close();
        return answer;
    }

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
        sc.close();
        return answer;
    }

    public String askString(String message, String error) {
        String answer = "";
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        while (!valid) {
            System.out.println(message);
            answer = sc.nextLine();
            if (answer.length() > 0) {
                valid = true;
            } else {
                System.out.println(error);
            }
        }
        sc.close();
        return answer;
    }

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
        sc.close();
        return ans;
    }

}
