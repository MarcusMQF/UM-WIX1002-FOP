/*

// Generate random number between 0-255
Random rand = new Random();
int number = rand.nextInt(256);  // 256 is exclusive upper bound

// Create binary array
int[] binary = new int[8];

// Convert to binary and store in array
for (int i = 7; i >= 0; i--) {
    binary[i] = number % 2;
    number = number / 2;
}

// Display the binary number
System.out.print("Binary number: ");
for (int bit : binary) {
    System.out.print(bit);
}

// Alternative method for binary conversion using Integer.toBinaryString():

int number = rand.nextInt(256);
String binaryString = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');

// Convert to array if needed
int[] binary = new int[8];
for (int i = 0; i < 8; i++) {
    binary[i] = binaryString.charAt(i) - '0';
}    
*/
