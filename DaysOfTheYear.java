import java.util.*;

public class DaysOfTheYear {

  static Scanner sc = new Scanner(System.in);
  static int currentDay = 1;
  static int currentMonth = 1;
  static int player = 0;
  static int maxDay = 31;
  static int minDay = 1;
  static int maxMonth = 12;
  static int minMonth = 1;
  static int monthValidate;
  static int day;
  static String userEntryDay;
  static String userEntryMonth;
  static String lastMonth = "December";

  static String[] allMonth = {
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
    if ((currentMonth == 2) && (day > 28)) {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    } else if (minDay <= day && day <= maxDay) {
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
    if (
      (
        (currentDay == 29 || currentDay == 30 || currentDay == maxDay) &&
        (monthValidate == 2)
      ) ||
      (
        (currentDay == maxDay) &&
        (
          (monthValidate == 4) ||
          (monthValidate == 6) ||
          (monthValidate == 9) ||
          (monthValidate == 11)
        )
      )
    ) {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    } else if ((0 < monthValidate) && (monthValidate <= 12)) {
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
      if (
        (userEntryDay.charAt(index) >= '0') &&
        (userEntryDay.charAt(index) <= '9')
      ) {
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
      if (
        (userEntryMonth.charAt(index) >= '0') &&
        (userEntryMonth.charAt(index) <= '9')
      ) {
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
    if (
      (
        (currentDay == 29 || currentDay == 30 || currentDay == maxDay) &&
        (monthValidate == 2)
      ) ||
      (
        (currentDay == maxDay) &&
        (
          (monthValidate == 4) ||
          (monthValidate == 6) ||
          (monthValidate == 9) ||
          (monthValidate == 11)
        )
      )
    ) {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    } else if ((0 < monthValidate) && (monthValidate <= 12)) {
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

  static void caseDay() {
    System.out.print("Which day do you want to pick: ");
    userEntryDay = sc.next();

    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    day = Integer.parseInt(userEntryDay);
    if (
      ((currentMonth == 2) && (day > 28)) ||
      (
        (
          (currentMonth == 4) ||
          (currentMonth == 6) ||
          (currentMonth == 9) ||
          (currentMonth == 11)
        ) &&
        (day > 30)
      )
    ) {
      System.out.println("Input invalid, please try again!");
      selectedMonthDay();
    } else if (minDay <= day && day <= maxDay) {
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
      if (currentDay == maxDay && currentMonth == maxMonth) {
        if (currentMonth == maxMonth) {
          System.out.println(
            "The current date is: " +
            currentDay +
            " of " +
            allMonth[currentMonth - minMonth]
          );
        }
        System.out.println(
          "Player " + (player - 1) + " is the winner of the game!"
        );
        player();
        break;
      } else {
        player();
        System.out.println(
          "The current date is: " +
          currentDay +
          " of " +
          allMonth[currentMonth - minMonth]
        );
        System.out.println("It is Player " + player + "'s Turn!");
        System.out.print(
          "Do you want to increase the day or the month? (day or month): "
        );
        selectedMonthDay();
      }
    }
    sc.close();
  }
}
