
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dbell17
 */
public class Lab1 {

    public static void main(String[] args) throws IOException {

        File data = new File(File.separatorChar + "Users" + File.separatorChar
                + "dbell17" + File.separatorChar + "Desktop" + File.separatorChar
                + "lab1.txt");

        boolean append = true;   // you can change this

	  // This references the file in the working directory
      // This is where we setup our streams (append = false means overwrite)
        // new FileWriter() creates the file if doesn't exit
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(data, append)));

	  // print statements do actual work of writing data
        // note that print statements work similar to Sytem.out.println,
        // where data is converted to strings
        out.println();
        out.println("Megan Fox");

        out.println("Hotness Lane");
        out.println("Tap That, Fl 55535");

        out.close();  // be sure you close your streams when done!!

        System.out.println("Wrote file to: " + data.getAbsolutePath());

        int counter = 0;

        BufferedReader in = null;
        List<String> fileContents = new ArrayList<String>();

        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            while (line != null) {

                if (counter > 2 && counter < 6) {

                    fileContents.add(line);
                    System.out.println(line);
                }
                line = in.readLine(); // strips out any carriage return chars

                counter++;

            }
        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        }
    }
}
