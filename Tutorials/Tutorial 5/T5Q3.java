/*

a.
int[] marks = new int[5];  // Creates array of size 5 with all elements = 0
int i = 0, j = 1;

marks[i] = 12;             // marks[0] = 12
marks[j] = marks[i] + 19;  // marks[1] = 12 + 19 = 31
marks[j-1] = marks[j] * marks[j];  // marks[0] = 31 * 31 = 961
marks[j*3] = marks[i+1];   // marks[3] = marks[1] = 31
marks[++j] = marks[i]%5;   // j becomes 2, then marks[2] = 961%5 = 1
marks[2*j] = marks[j-1];   // marks[4] = marks[1] = 31

*/
