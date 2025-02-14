/* 
// a. Determine whether 3x8=27
if (3 * 8 == 27) {
    System.out.println("3 x 8 equals 27");
} else {
    System.out.println("3 x 8 does not equal 27");
}

// b. Check odd/even number
int number = scanner.nextInt();
if (number % 2 == 0) {
    System.out.println("Even number");
} else {
    System.out.println("Odd number");
}

// c. Check for capital letter
char ch = scanner.next().charAt(0);
if (ch >= 'A' && ch <= 'Z') {
    System.out.println("It's a capital letter");
}

// d. Display strings in alphabetical order ignoring case
String str1 = scanner.next();
String str2 = scanner.next();
if (str1.compareToIgnoreCase(str2) <= 0) {
    System.out.println(str1 + "\n" + str2);
} else {
    System.out.println(str2 + "\n" + str1);
}

// e. Switch statement for days
int day = scanner.nextInt();
switch (day) {
    case 0: System.out.println("Sunday"); break;
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    case 3: System.out.println("Wednesday"); break;
    case 4: System.out.println("Thursday"); break;
    case 5: System.out.println("Friday"); break;
    case 6: System.out.println("Saturday"); break;
    default: System.out.println("Invalid day");
}
*/