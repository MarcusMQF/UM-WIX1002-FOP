import java.util.Scanner;

public class viva1Q5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Remixed Song:");
        String SongName = scanner.nextLine();
        
        char[] Temp = {'R','E','M','I','X'}; 
        char[] RawRemixSong = SongName.toCharArray();
        char[] RemixSong = new char[RawRemixSong.length + 5];
          
        System.arraycopy(RawRemixSong, 0, RemixSong, 0, RawRemixSong.length);
        System.arraycopy(Temp, 0, RemixSong, RawRemixSong.length, 5);
        
          for(int i = 0; i <= RemixSong.length - 5; i++){
            for(int j = 0; j <= 4; j++){
                Temp[j] = RemixSong[i + j];
            }
            if(Temp[0] == 'R' && Temp[1] == 'E' && Temp[2] == 'M' && Temp[3] == 'I' && Temp[4] == 'X'){
                System.out.print(" ");
                i = i + 4;
            }
            else{
                System.out.print(RemixSong[i]);
            }
        }

        scanner.close();
    }
}
