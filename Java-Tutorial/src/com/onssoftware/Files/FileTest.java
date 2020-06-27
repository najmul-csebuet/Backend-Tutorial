package com.onssoftware.Files;

import java.io.*;

public class FileTest {

    public static void main(String[] args) throws IOException {
        new FileTest().copyFileTest_8_BitText();
        new FileTest().copyFileTest_16_BitUnicode();
    }

    private void copyFileTest_16_BitUnicode() {
        try (FileReader fileReader = new FileReader("in.txt");
             FileWriter fileWriter = new FileWriter("out.txt")) {

            int c;
            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFileTest_8_BitText() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream("in.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("out.txt")) {

            int c;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
