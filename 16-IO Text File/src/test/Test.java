package test;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        try {
            int count = 0;
            File inFile = new File("hello.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inFile, true));
            bufferedWriter.write(",A");
            bufferedWriter.close();

            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            StringBuilder srtB = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                srtB.append(line);
//                System.out.println(line);
                count++;
            }
            reader.close();
            String toSplit = srtB.toString();
            String[] results = toSplit.split(",");
            for (String item : results) {
                System.out.println(item);
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println("File not found");

        }


    }
}
