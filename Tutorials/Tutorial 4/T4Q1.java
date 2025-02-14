/* 
Question 1

a)
int n = 1;
while ((n+1) * (n+1) * (n+1) < 2000) {
    n++;
}
System.out.println("Largest n is: " + n); 

b) 
for (int i = 1; i <= 12; i++) {
    System.out.println(i * i);
}

c)
Random rand = new Random();
for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 5; j++) {
        System.out.print(rand.nextInt(101) + " ");
    }
    System.out.println();
}

d)
int n = 2
int sum = 0;
for (int i = 1; i <= n; i++) {
    sum += i;
}
System.out.println("Sum is: " + sum);

e)
double sum = 0;
for (int i = 1; i <= 25; i++) {
    sum += (double)(26-i)/i;
}
System.out.printf("%.2f%n", sum);


*/
