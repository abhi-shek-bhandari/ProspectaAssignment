import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
/*
 * How will you tackle the challenge above?
 * 
 * As the Above question states that the file is csv and will be going to be kind of 3x3.
 * So now i will be creating a hard coded program to handle the above program
 * 
 * 
 * What type of errors you would you check for?
 * 1. FileNotFound
 * 2. Unable to Retrive Data
 * 3. File is of Small Size then 3x3
 * 
 * 
 * How might a user break your code?
 * 1. By giving a big csv file then 3x3
 * 2. By giving a small csv file then 3x3
 * 3. Changing the Name of File
 * 4. Changing ',' to something else.
 * 5. Try to Perform new Operations
 * 
 */
public class HandlingCSVFILES {
    public static void main(String[] args) {
        String file = "C:/Users/abhis/OneDrive/Desktop/Test/file.csv"; //Giving the File Path 

        try(BufferedReader br = new BufferedReader(new FileReader(file))) { // Reading and Checking if file Exists or Not.

            String[] line1 = br.readLine().split(","); // Reading Line One and Spliting on bases of commas
            //Assigning A1, B1, C1 There Respective Values According to The Question
            int a1 = Integer.parseInt(line1[0]);
            int b1 = Integer.parseInt(line1[1]);
            int c1 = Integer.parseInt(line1[2])+a1;

            String[] line2 = br.readLine().split(",");// Reading Line Two and Spliting on bases of commas
            //Assigning A2, B2, C2 There Respective Values According to The Question
            int a2 = Integer.parseInt(line2[0]);
            int b2 = Integer.parseInt(line2[1]);
            int c2 = b2+a2;

            String[] line3 = br.readLine().split(",");// Reading Line Three and Spliting on bases of commas
            //Assigning A3, B3, C3 There Respective Values According to The Question
            int a3 = Integer.parseInt(line3[0]);
            int b3 = a2+b2;
            int c3 = c2+b3;

            FileWriter fileWriter = new FileWriter("newFile.csv"); // Creating new File
            //Writng Values 
            fileWriter.write(a1+","+b1+","+c1+"\n");
            fileWriter.write(a2+","+b2+","+c2+"\n");
            fileWriter.write(a3+","+b3+","+c3+"\n");

            fileWriter.close();

        } catch (Exception e) {//If File not Found Error Will be thrown
            System.out.println(e.getMessage());
        }
    }
}
