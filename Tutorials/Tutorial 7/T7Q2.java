/*

a. The correct code should be:
PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));

b. The correct code should be:
try {
PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
out.close();
} catch (FileNotFoundException e) {
System.out.println("Problem with file output");
}

c. The correct code should be:
int num;
Scanner a = new Scanner(new FileInputStream("data.dat"));
num = a.nextInt();
a.close();

d. The correct code should be:
ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.dat"));
o.writeObject('A');
o.close();

*/
