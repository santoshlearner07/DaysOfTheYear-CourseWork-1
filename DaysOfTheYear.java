
import java.util.Scanner;

public class DaysOfTheYear {

  static int currentDay = 1;
  static int currentMonth = 1;
  static int player = 0;
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

  // static String firstMonth = "January";
  static String lastMonth = "December";

  static void player() {
    if (player % 2 == 0) {
      player = 2;
    } else {
      player = 1;
    }
  }

  static void checkingDay() {
    Scanner sc = new Scanner(System.in);
    System.out.println("You Selected Day");
    System.out.println("Enter the Day Number");
    int day = sc.nextInt();
    while (true) {
      if ((0 < day && day < 32) && (currentDay < day)) {
        currentDay = day;
        System.out.println("Day- " + day + " Current Day - " + currentDay);
        break;
      } else {
        System.out.println("INVALID INPUT - Day is Same or Small");
        checkingDay();
        break;
      }
    }
  }

  static void checkingMonth() {
    Scanner sc = new Scanner(System.in);
    System.out.println("You Selected Month");
    System.out.println("Enter the Month Number");
    int monthValidate = sc.nextInt();
    while (true) {
      if (
        (0 < monthValidate && monthValidate <= 12) &&
        (currentMonth < monthValidate)
      ) {
        currentMonth = monthValidate;
        System.out.println(
          "Month- " + monthValidate + "Current Month - " + currentMonth
        );
        break;
      } else {
        System.out.println("INVALID INPUT - Month is Same or Small");
        checkingMonth();
        break;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      player = player + 1;
      if (currentDay == 31 && currentMonth == 12) {
        if (currentMonth == 12) {
          // System.out.println(
          //   "The current date is: " + currentDay + " of " + lastMonth
          // );
        }
        System.out.println(
          "Player " + (player - 1) + " is the winner of the game!"
        );
        player();
        break;
      } else {
        player();
        
        System.out.println("It is Player " + player + "'s Turn!");
        System.out.print(
          "Do you want to increase the day or the month? (day or month): "
        );
        String selectDayOrMonth = sc.next();
        switch (selectDayOrMonth.toLowerCase()) {
          case "day":
            System.out.print("Which day do you want to pick: ");
            System.out.println(
                  "The current date is: " +
                  currentDay +
                  " of " +
                  allMonth[currentMonth - 1]
                );
            int day = sc.nextInt();
            if (0 < day && day < 32) {
              if (currentDay <= day) {
                currentDay = day;
              } else {
                System.out.println("You cannot decrement the day");
                checkingDay();
              }
            } else {
              System.out.println("Not correct Day Selected inside if " + day);
            }
            break;
          case "month":
            System.out.print("Which month do you want to pick: ");
            int monthValidate = sc.nextInt();
            if ((0 < monthValidate) && (monthValidate <= 12)) {
              if (currentMonth <= monthValidate) {
                currentMonth = monthValidate;
                // System.out.println(
                //   "The current date is: " +
                //   currentDay +
                //   " of " +
                //   allMonth[currentMonth - 1]
                // );
              } else {
                System.out.println("You cannot decrement the Month");
                checkingMonth();
              }
            } else {
              System.out.println("Not correct Month Selected inside if ");
            }
            break;
          default:
            System.out.println("Invalid Input");
        }
      }
    }
    sc.close();
  }
}
