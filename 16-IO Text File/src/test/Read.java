package test;

import java.io.*;

public class Read {
    public static void main(String[] args) throws Exception {
//        FileReader fileReader = new FileReader("filename.txt");
//        FileWriter fileWriter = new FileWriter("filenameCopy.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//        String temp;
//
//        while ((temp = bufferedReader.readLine()) != null) {
//            bufferedWriter.write(temp);
//        }
//        bufferedReader.close();
//        bufferedWriter.close();

        File fileIn = new File("img1.png");
        File fileOut = new File("img2.png");
        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
        FileInputStream fileInputStream = new FileInputStream(fileIn);

        byte[] b = new byte[1];
        while ((fileInputStream.read(b)) > 0 ){
            fileOutputStream.write(b);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
