import java.util.Scanner;

public class DaysOfTheYear {

  private static Scanner sc = new Scanner(System.in);
  private static int currentDay = 1;
  private static int currentMonth = 1;
  private static int player = 0;
  static final int MAX_DAY = 31;
  static final int SECOND_LAST_DAY = 30;
  static final int MIN_DAY = 1;
  static final int MAX_MONTH = 12;
  static final int MIN_MONTH = 1;
  private static int monthValidate;
  private static int day;
  private static String userEntryDay;
  private static String userEntryMonth;
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

  static void player() {
    if (player % 2 == 0) {
      player = 2;
    } else {
      player = 1;
    }
  }

  static void checkingDay() {
    userEntryDay = sc.next();

    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    day = Integer.parseInt(userEntryDay);
    if ((currentMonth == SECOND_MONTH) && (day > FEB_MONTH_DAY)) {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    } else if (MIN_DAY <= day && day <= MAX_DAY) {
      if (currentDay <= day) {
        currentDay = day;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingDay();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    }
  }

  static void checkingMonth() {
    userEntryMonth = sc.next();
    while (!checkInputMonth(userEntryMonth)) {
      System.out.println("Input invalid, please try again!");
      userEntryMonth = sc.next();
    }
    monthValidate = Integer.parseInt(userEntryMonth);
    if (((currentDay == FEB_LEAP_MONTH_DAY
        || currentDay == SECOND_LAST_DAY
        || currentDay == MAX_DAY)
        &&
        (monthValidate == SECOND_MONTH))
        || ((currentDay == MAX_DAY) && ((monthValidate == FOURTH_MONTH)
            || (monthValidate == SIXTH_MONTH)
            || (monthValidate == NINETH_MONTH)
            || (monthValidate == ELEVEN_MONTH)))) {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    } else if ((MIN_DAY <= monthValidate) && (monthValidate <= MAX_MONTH)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingMonth();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    }
  }

  static boolean checkInput(String userEntryDay) {
    boolean hasString = false;
    int index = 0;
    while (index < userEntryDay.length()) {
      if ((userEntryDay.charAt(index) >= '0')
          && (userEntryDay.charAt(index) <= '9')) {
        hasString = true;
      }
      index++;
    }
    return hasString;
  }

  static boolean checkInputMonth(String userEntryMonth) {
    boolean hasString = false;
    int index = 0;
    while (index < userEntryMonth.length()) {
      if ((userEntryMonth.charAt(index) >= '0')
          && (userEntryMonth.charAt(index) <= '9')) {
        hasString = true;
      }
      index++;
    }
    return hasString;
  }

  static void caseMonth() {
    System.out.print("Which month do you want to pick: ");
    userEntryMonth = sc.next();
    while (!checkInputMonth(userEntryMonth)) {
      System.out.println("Input invalid, please try again!");
      userEntryMonth = sc.next();
    }
    monthValidate = Integer.parseInt(userEntryMonth);
    if (((currentDay == FEB_LEAP_MONTH_DAY
        ||
        currentDay == SECOND_LAST_DAY
        ||
        currentDay == MAX_DAY)
        &&
        (monthValidate == SECOND_MONTH))
        ||
        ((currentDay == MAX_DAY)
            &&
            ((monthValidate == FOURTH_MONTH)
                ||
                (monthValidate == SIXTH_MONTH)
                ||
                (monthValidate == NINETH_MONTH)
                ||
                (monthValidate == ELEVEN_MONTH)))) {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    } else if ((MIN_MONTH <= monthValidate) && (monthValidate <= MAX_MONTH)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingMonth();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    }
  }

  static void tempDay() {
    userEntryDay = sc.next();
    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    day = Integer.parseInt(userEntryDay);

    if (day == MAX_DAY) {
      System.out.println("Input invalid, please try again!");
      tempDay();
    } else if (((currentMonth == SECOND_MONTH) && (day > FEB_MONTH_DAY))
        ||
        (((currentMonth == FOURTH_MONTH)
            ||
            (currentMonth == SIXTH_MONTH)
            ||
            (currentMonth == NINETH_MONTH)
            ||
            (currentMonth == ELEVEN_MONTH))
            &&
            (day > SECOND_LAST_DAY))) {
      System.out.println("Input invalid, please try again!");

      caseDay();
    } else {
      currentDay = SECOND_LAST_DAY;
    }
  }

  static void caseDay() {
    System.out.print("Which day do you want to pick: ");
    userEntryDay = sc.next();

    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    day = Integer.parseInt(userEntryDay);
    if (((currentMonth == SECOND_MONTH) && (day > FEB_MONTH_DAY))
        ||
        (((currentMonth == FOURTH_MONTH)
            ||
            (currentMonth == SIXTH_MONTH)
            ||
            (currentMonth == NINETH_MONTH)
            ||
            (currentMonth == ELEVEN_MONTH))
            &&
            (day > SECOND_LAST_DAY))) {
      System.out.println("Input invalid, please try again!");

      tempDay();
    } else if (MIN_DAY <= day && day <= MAX_DAY) {
      if (currentDay < day) {
        currentDay = day;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingDay();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    }
  }

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

  public static void main(String[] args) {
    while (true) {
      player = player + 1;
      if (currentDay == MAX_DAY && currentMonth == MAX_MONTH) {
        if (currentMonth == MAX_MONTH) {
          System.out.println(
              "The current date is: "
                  +
                  currentDay
                  +
                  " of "
                  +
                  ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH]);
        }
        System.out.println(
            "Player " + (player - 1) + " is the winner of the game!");
        player();
        break;
      } else {
        player();
        System.out.println(
            "The current date is: "
                +
                currentDay
                +
                " of "
                +
                ALL_MONTH_OF_YEAR[currentMonth - MIN_MONTH]);
        System.out.println("It is Player " + player + "'s Turn!");
        System.out.print(
            "Do you want to increase the day or the month? (day or month): ");
        selectedMonthDay();
      }
    }
    sc.close();
  }
}
