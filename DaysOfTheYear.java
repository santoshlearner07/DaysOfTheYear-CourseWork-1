import java.util.Scanner;

public class DaysOfTheYear {

  private static Scanner sc = new Scanner(System.in);
  private static int currentDay = 1;
  private static int currentSuffixDay;
  private static int currentSuffixMonth;
  private static int currentMonth = 1;
  private static int player = 0;
  static final int MAX_DAY = 31;
  static final int SECOND_LAST_DAY = 30;
  static final int MIN_DAY = 1;
  static final int MAX_MONTH = 12;
  static final int MIN_MONTH = 1;
  static final int ELEVENTH_DAY = 11;
  static final int THIRTEENTH_DAY = 13;
  static final int SUFFIX_DIVISION = 10;
  private static int monthValidate;
  private static int day;
  private static String userEntry;
  static final int ZERO = 0;
  static final int FEB_MONTH_DAY = 28;
  static final int FEB_LEAP_MONTH_DAY = 29;
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
  static final String[] ALL_MONTH_OF_YEAR = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December",
  };

  // player increment where even = player 2 and odd = player 1
  static void player() {
    if (player % 2 == 0) {
      player = 2;
    } else {
      player = 1;
    }
  }

  static void handlingThirdLevel() {
    // // this loop will run if user puts words
    // System.out.println(day + "day64");
    while (!checkInput(userEntry)) {
      System.out.println("Input invalid, please try again!");
      userEntry = sc.next();
    }
    // // converts string number to integer
    day = Integer.parseInt(userEntry);
    if ((((currentMonth == SECOND_MONTH) || (currentSuffixMonth == SECOND_MONTH))
        && (day > FEB_MONTH_DAY))
        ||
        (((currentMonth == FOURTH_MONTH) || (currentMonth == SIXTH_MONTH)
            || (currentMonth == NINETH_MONTH) || (currentMonth == ELEVEN_MONTH))
            && (day > SECOND_LAST_DAY))) {
      System.out.println("Input invalid, please try again!");

      // // till the user puts correct day it will call this method everytime
      tempDay();
    } else if (MIN_DAY <= day && day <= MAX_DAY) {
      if (currentDay < day) {
        currentDay = day;
      } else {
        System.out.println("Input invalid, please try again!");
        // // till the user puts correct day it will call this method everytime
        checkingDay();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    }
  }

  // method to check if day is not selected correctly
  static void checkingDay() {
    userEntry = sc.next();
    handlingThirdLevel();
  }

  // method to check if month is not selected correctly
  static void checkingMonth() {
    userEntry = sc.next();
    // this loop will run if user puts words
    while (!checkInput(userEntry)) {
      System.out.println("Input invalid, please try again!");
      userEntry = sc.next();
    }
    // converts string number to integer
    monthValidate = Integer.parseInt(userEntry);

    if (((currentDay == FEB_LEAP_MONTH_DAY || currentDay == SECOND_LAST_DAY
        || currentDay == MAX_DAY)
        &&
        (monthValidate == SECOND_MONTH))
        || ((currentDay == MAX_DAY) && ((monthValidate == FOURTH_MONTH)
            || (monthValidate == SIXTH_MONTH) || (monthValidate == NINETH_MONTH)
            || (monthValidate == ELEVEN_MONTH)))) {
      System.out.println("Input invalid, please try again!");
      // till the user puts correct day it will call this method everytime
      checkingMonth();
    } else if ((MIN_DAY <= monthValidate) && (monthValidate <= MAX_MONTH)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        System.out.println("Input invalid, please try again!");
        // till the user puts correct day it will call this method everytime
        checkingMonth();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      // till the user puts correct day it will call this method everytime
      checkingMonth();
    }
  }

  // this method gets called if user puts alphabets for the day/month
  static boolean checkInput(String userEntry) {
    boolean hasString = false;
    int index = 0;
    while (index < userEntry.length()) {
      if ((userEntry.charAt(index) >= '0')
          && (userEntry.charAt(index) <= '9')) {
        hasString = true;
      }
      index++;
    }
    return hasString;
  }

  // switch month case will get called
  static void caseMonth() {
    System.out.print("Which month do you want to pick: ");
    checkingMonth();
  }

  // it checks if user entered 29 for feb and 31 for 30 days of month
  static void tempDay() {
    userEntry = sc.next();
    while (!checkInput(userEntry)) {
      System.out.println("Input invalid, please try again!");
      userEntry = sc.next();
    }
    day = Integer.parseInt(userEntry);

    if (((day == MAX_DAY) || (day == SECOND_LAST_DAY) && (monthValidate == SECOND_MONTH))) {
      System.out.println("Input invalid, please try again!");
      tempDay();
    } else if (((currentMonth == SECOND_MONTH) && (day > FEB_MONTH_DAY))
        || (((currentMonth == FOURTH_MONTH) || (currentMonth == SIXTH_MONTH)
            || (currentMonth == NINETH_MONTH) || (currentMonth == ELEVEN_MONTH))
            &&
            (day > SECOND_LAST_DAY))) {
      System.out.println("Input invalid, please try again!");

      caseDay();
    } else {
      currentDay = day;
    }
  }

  // switch day case will get called
  static void caseDay() {
    System.out.print("Which day do you want to pick: ");
    checkingDay();
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
        System.out.println("Input invalid, please try again!");
        selectedMonthDay();
    }
  }

  static String suffixDay(String[] args) {
    String only = "th";
    if (args.length == 2) {
      if (currentDay >= ELEVENTH_DAY && currentDay <= THIRTEENTH_DAY) {
        return "th";
      }
      switch (day % SUFFIX_DIVISION) {
        case FIRST_MONTH:
          return "st";
        case SECOND_MONTH:
          return "nd";
        case THIRD_MONTH:
          return "rd";
        default:
          return "th";
      }
    }
    return only;
  }

  // the main code starts here
  public static void main(String[] args) {
    while (true) {
      player = player + 1;
      if (currentDay == MAX_DAY && currentMonth == MAX_MONTH) {
        if (currentMonth == MAX_MONTH) {
          if (args.length == 2) {
            System.out.println(
                "The current date is: " + currentDay + suffixDay(args) + " of "
                    + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH]);
          } else {
            System.out.println(
                "The current date is: " + currentDay + " of "
                    + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH]);
          }
        }

        System.out.println(
            "Player " + (player - 1) + " is the winner of the game!");
        player();
        break;
      } else {
        player();
        if (args.length == 2) {
          currentSuffixDay = Integer.parseInt(args[0]);
          currentSuffixMonth = Integer.parseInt(args[1]);
          if (currentDay <= currentSuffixDay && currentMonth <= currentSuffixMonth) {
            System.out.println(
                "The current date is: " + currentSuffixDay + suffixDay(args) + " of "
                    + ALL_MONTH_OF_YEAR[currentSuffixMonth - MIN_MONTH]);
          } else {
            // currentSuffixDay = 0;
            // currentSuffixMonth = 0;
            if (currentMonth == MIN_MONTH) {
              System.out.println(
                  "The current date is: " + currentDay + suffixDay(args) + " of "
                      + ALL_MONTH_OF_YEAR[currentSuffixMonth - MIN_MONTH]);
            } else {
              currentSuffixMonth = 0;
              currentSuffixMonth = monthValidate;
              System.out.println(
                  "The current date is: " + currentDay + suffixDay(args) + " of "
                      + ALL_MONTH_OF_YEAR[currentSuffixMonth - MIN_MONTH]);
            }
          }
        } else {
          System.out.println(
              "The current date is: " + currentDay + " of "
                  + ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH]);
        }
        System.out.println("It is Player " + player + "'s Turn!");
        System.out.print(
            "Do you want to increase the day or the month? (day or month): ");

        // if (args.length == 2) {
        //   if ((currentDay > FEB_LEAP_MONTH_DAY) && ((currentSuffixMonth == SECOND_MONTH))) {
        //     System.out.print("Can't change the day, please try again!");
        //     selectedMonthDay();
        //   } else {
        //     selectedMonthDay();
        //   }
        // } 
        selectedMonthDay();
      }
    }
    // closing the scanner
    sc.close();
  }
}
