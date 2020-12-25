package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyTextFile {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("filename.txt");
        FileWriter fileWriter = new FileWriter("filenameCopy.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String temp;

        while ((temp = bufferedReader.readLine()) != null) {
            bufferedWriter.write(temp);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
