import java.util.Random;

public class T1Q10{
    public static void main(String[] args) {
        Random random = new Random();
        int Femalecount = 0;
        String gender;
        
        for(int i = 0; i < 100; i++){
            boolean Gender = random.nextBoolean();

            if(Gender == true){
                gender = "Female";
            }else{
                gender = "Male";
            }

            System.out.println((i+1) + "." + gender);
            
            if(gender == "Female"){
                Femalecount++;
            }
        }

        System.out.println();

        System.out.println("The total number of the Female Students from the 100 Students is " + Femalecount);
    }
}

//Display the number of female student from a random list of 100 students
