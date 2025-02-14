/*
// a. Assignment vs comparison operator
// Wrong: if (num1 = num2)
// Correct:
if (num1 == num2) {
    System.out.println("Number 1 is equal to number 2.");
}

// b. Multiple comparisons
// Wrong: if (x > y > z)
// Correct:
if (x > y && x > z) {
    System.out.println("x is the largest number");
}

// c. String comparison
// Wrong: if (s1==s2)
// Correct:
String s1, s2;
if (s1.equals(s2)) {
    System.out.println("They are equal strings.");
} else {
    System.out.println("They are not equal strings.");
}

// d. Logical operator and semicolon
// Wrong: if x>0 or y>0;
// Correct:
if (x > 0 || y > 0) {
    System.out.println("Either x or y is positive");
}
*/
