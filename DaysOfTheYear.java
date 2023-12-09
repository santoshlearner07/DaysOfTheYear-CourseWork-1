/*
 * DaysOfTheYear is the game
 * the playerPlaying to reach 31/31st December will win the game.
 */

import java.util.Scanner;

public class DaysOfTheYear {

  private static Scanner sc = new Scanner(System.in);
  private static int currentDay = 1;
  private static int currentSuffixDay;
  private static int currentSuffixMonth;
  private static int currentMonth = 1;
  private static int playerPlaying = 0;
  static final int MAX_DAY_IN_A_MONTH = 31;
  static final int SECOND_LAST_DAY_IN_A_MONTH = 30;
  static final int MIN_DAY_IN_A_MONTH = 1;
  static final int MAX_MONTH_IN_A_YEAR = 12;
  static final int MIN_MONTH_IN_A_YEAR = 1;
  static final int ELEVENTH_DAY = 11;
  static final int THIRTEENTH_DAY = 13;
  static final int SUFFIX_DIVISION = 10;
  static final int ZERO = 0;
  static final int FEB_MONTH_DAY = 28;
  static final int FEB_LEAP_MONTH_DAY = 29;
  static final int CASE_1 = 1;
  static final int CASE_2 = 2;
  static final int CASE_3 = 3;
  static final int FIRST_MONTH = 1;
  static final int SECOND_MONTH = 2;
  static final int THIRD_MONTH = 3;
  static final int FOURTH_MONTH = 4;
  static final int FIFTH_MONTH = 5;
  static final int SIXTH_MONTH = 6;
  static final int SEVENTH_MONTH = 7;
  static final int EIGHT_MONTH = 8;
  static final int NINETH_MONTH = 9;
  static final int TENTH_MONTH = 10;
  static final int ELEVEN_MONTH = 11;
  static final int TWELVE_MONTH = 12;
  static final String INPUT_INVALID = "Input invalid, please try again!";
  private static int monthValidate;
  private static int day;
  private static String userEntry;
  static final String[] ALL_MONTH_OF_YEAR = {
      "January", "February", "March", "April", "May", "June", "July", "August", "September",
      "October", "November", "December" };

  // the main code starts here
  public static void main(String[] args) {
    // this loop will always be true and will break only if playerPlaying reaches 31/31st December
    while (true) {
      playerPlaying = playerPlaying + 1;
      // if currentDay = 31 and MAX_DAY_IN_A_MONTH = 12 it will print 31 dec/ 31st dec
      if (currentDay == MAX_DAY_IN_A_MONTH && currentMonth == MAX_MONTH_IN_A_YEAR) {
        if (args.length == 2) {
          System.out.println(
              "The current date is: " + currentDay + suffixDay(args) + " of "
                  + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH_IN_A_YEAR]);
        } else {
          System.out.println(
              "The current date is: " + currentDay + " of "
                  + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH_IN_A_YEAR]);
        }
        System.out.println(
            "Player " + (playerPlaying - 1) + " is the winner of the game!");
        currentPlayerPlaying();
        break;
      } else {
        currentPlayerPlaying();
        // args.length will only run when user puts day and month in terminal
        if (args.length == 2) {
          currentSuffixDay = Integer.parseInt(args[0]); // user day from terminal
          currentSuffixMonth = Integer.parseInt(args[1]); // user month from terminal
          if (currentDay <= currentSuffixDay && currentMonth <= currentSuffixMonth) {
            currentMonth = currentSuffixMonth;
        // suffixDay(args) will help use to print suffix values for number like st,nd,rd and th
            System.out.println(
                "The current date is: " + currentSuffixDay + suffixDay(args) + " of "
                    + ALL_MONTH_OF_YEAR[currentSuffixMonth - MIN_MONTH_IN_A_YEAR]);
          } else {
            if (currentMonth == MIN_MONTH_IN_A_YEAR) {
              System.out.println(
                  "The current date is: " + currentDay + suffixDay(args) + " of "
                      + ALL_MONTH_OF_YEAR[currentSuffixMonth - MIN_MONTH_IN_A_YEAR]);
            } else {
              currentSuffixMonth = 0;
              currentSuffixMonth = monthValidate;
              System.out.println(
                  "The current date is: " + currentDay + suffixDay(args) + " of "
                      + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH_IN_A_YEAR]);
            }
          }
        } else {
          System.out.println(
              "The current date is: " + currentDay + " of "
                  + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH_IN_A_YEAR]);
        }
        System.out.println("It is Player " + playerPlaying + "'s Turn!");
        System.out.print(
            "Do you want to increase the day or the month? (day or month): ");
        if (args.length == 2) {
          if ((currentDay >= FEB_MONTH_DAY) && ((currentMonth == SECOND_MONTH)
              || (currentSuffixMonth == SECOND_MONTH))) {
            selectedMonthDay();
          } else {
            selectedMonthDay();
          }
        } else {
          selectedMonthDay();
        }
      }
    }
    // closing the scanner
    sc.close();
  }

  // switch case for month and day
  static void selectedMonthDay() {
    String selectDayOrMonth = sc.next();
    switch (selectDayOrMonth.toLowerCase()) {
      case "day":
        caseDay();
        break;
      case "month":
        caseMonth();
        break;
      default:
        System.out.println(INPUT_INVALID);
        selectedMonthDay();
    }
  }

  // switch day case will get called
  static void caseDay() {
    if (((currentDay == FEB_MONTH_DAY) && (currentMonth == SECOND_MONTH))
        || ((currentDay == MAX_DAY_IN_A_MONTH) && ((currentMonth == FIRST_MONTH)
            || (currentMonth == THIRD_MONTH) || (currentMonth == FIFTH_MONTH)
            || (currentMonth == SEVENTH_MONTH) || (currentMonth == EIGHT_MONTH)
            || (currentMonth == TENTH_MONTH) || (currentMonth == TWELVE_MONTH)))
        || ((currentDay == SECOND_LAST_DAY_IN_A_MONTH) && ((currentMonth == FOURTH_MONTH)
            || (currentMonth == SIXTH_MONTH) || (currentMonth == NINETH_MONTH)
            || (currentMonth == ELEVEN_MONTH)))) {
      System.out.println("Can't change the day, please try again!");
      selectedMonthDay();
    } else {
      System.out.print("Which day do you want to pick: ");
      checkingDay();
    }
  }

  // switch month case will get called
  static void caseMonth() {
    if (currentMonth == TWELVE_MONTH) {
      System.out.println("Can't change the month, please try again!");
      selectedMonthDay();
    } else {
      System.out.print("Which month do you want to pick: ");
      checkingMonth();
    }
  }

  // at the beginning playerPlaying will be 1 and it will increment on every loop
  // the % (modulous) will help us to find the correct playerPlaying
  // for even playerPlaying = Player 2 and for odd = playerPlaying Player 1
  static void currentPlayerPlaying() {
    if (playerPlaying % 2 == 0) {
      playerPlaying = 2;
    } else {
      playerPlaying = 1;
    }
  }

  // prints Invalid and calls checkDay method
  static void printInvalidAndCheckDay() {
    System.out.println(INPUT_INVALID);
    checkingDay();
  }
  // prints Invalid and calls checkMonth method
  static void printInvalidAndCheckMonth() {
    System.out.println(INPUT_INVALID);
    checkingMonth();
  }
  // prints Invalid and calls CheckForEvenMonth method
  static void printInvalidAndCheckForEvenMonth() {
    System.out.println(INPUT_INVALID);
    checkForEvenMonth();
  }

  // method to check if day is not selected correctly
  static void checkingDay() {
    userEntry = sc.next();
    // this while loop will run if user puts alphabet instead of Number for day
    while (!checkInput(userEntry)) {
      System.out.println(INPUT_INVALID);
      userEntry = sc.next();
    }
    // // converts string userEntry to integer(day)
    day = Integer.parseInt(userEntry);
    if ((((currentMonth == SECOND_MONTH) || (currentSuffixMonth == SECOND_MONTH))
        && (day > FEB_MONTH_DAY))
        ||
        (((currentMonth == FOURTH_MONTH) || (currentMonth == SIXTH_MONTH)
            || (currentMonth == NINETH_MONTH) || (currentMonth == ELEVEN_MONTH))
            && (day > SECOND_LAST_DAY_IN_A_MONTH))) {
      // till the user puts correct day it will call this method
      printInvalidAndCheckForEvenMonth();
    } else if (MIN_DAY_IN_A_MONTH <= day && day <= MAX_DAY_IN_A_MONTH) {
      if (currentDay < day) {
        currentDay = day;
      } else {
        printInvalidAndCheckDay();
      }
    } else {
      printInvalidAndCheckDay();
    }
  }

  // method to check if month is not selected correctly
  static void checkingMonth() {
    userEntry = sc.next();
    // this while loop will run if user puts alphabet instead of Number
    while (!checkInput(userEntry)) {
      System.out.println(INPUT_INVALID);
      userEntry = sc.next();
    }
    // converts string userEntry to integer(monthValidate)
    monthValidate = Integer.parseInt(userEntry);
    // if the user puts any invalid date for specific month there will be INPUT Invalid
    if (((currentDay == FEB_LEAP_MONTH_DAY || currentDay == SECOND_LAST_DAY_IN_A_MONTH
        || currentDay == MAX_DAY_IN_A_MONTH)
        &&
        (monthValidate == SECOND_MONTH))
        || ((currentDay == MAX_DAY_IN_A_MONTH) && ((monthValidate == FOURTH_MONTH)
            || (monthValidate == SIXTH_MONTH) || (monthValidate == NINETH_MONTH)
            || (monthValidate == ELEVEN_MONTH)))) {
      // till the user puts correct month it will call this method
      printInvalidAndCheckMonth();
    } else if ((MIN_DAY_IN_A_MONTH <= monthValidate) && (monthValidate <= MAX_MONTH_IN_A_YEAR)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        printInvalidAndCheckMonth();
      }
    } else {
      printInvalidAndCheckMonth();
    }
  }

  // this method gets called if user puts alphabets for the day/month
  static boolean checkInput(String userEntry) {
    boolean inputContainString = false;
    int index = 0;
    while (index < userEntry.length()) {
      if ((userEntry.charAt(index) >= '0')
          && (userEntry.charAt(index) <= '9')) {
        inputContainString = true;
      }
      index++;
    }
    return inputContainString;
  }

  // it checks if user entered 29 for feb and 31 or 30 days for month
  static void checkForEvenMonth() {
    userEntry = sc.next();
    while (!checkInput(userEntry)) {
      System.out.println(INPUT_INVALID);
      userEntry = sc.next();
    }
    day = Integer.parseInt(userEntry);
    // if the user puts any invalid date for specific day there will be INPUT Invalid
    if (((day == MAX_DAY_IN_A_MONTH) || (day == SECOND_LAST_DAY_IN_A_MONTH)
        && (monthValidate == SECOND_MONTH))) {
      printInvalidAndCheckForEvenMonth();
    } else if (((currentMonth == SECOND_MONTH) && (day > FEB_MONTH_DAY))
        || (((currentMonth == FOURTH_MONTH) || (currentMonth == SIXTH_MONTH)
            || (currentMonth == NINETH_MONTH) || (currentMonth == ELEVEN_MONTH))
            && (day > SECOND_LAST_DAY_IN_A_MONTH))) {
      printInvalidAndCheckForEvenMonth();
    } else {
      currentDay = day;
    }
  }

  // this method is used to print suffix for every date where SUFFIX_DIVISION will be 10
  static String suffixDay(String[] args) {
    String only = "th";
    if (args.length == 2) {
      if (currentDay <= currentSuffixDay) {
        currentDay = currentSuffixDay;
      }
      if (currentDay >= ELEVENTH_DAY && currentDay <= THIRTEENTH_DAY) {
        return "th";
      }
      switch (currentDay % SUFFIX_DIVISION) {
        case CASE_1:
          return "st";
        case CASE_2:
          return "nd";
        case CASE_3:
          return "rd";
        default:
          return "th";
      }
    }
    return only;
  }
}
