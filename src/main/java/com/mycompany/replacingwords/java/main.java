package com.mycompany.replacingwords.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mykyta Tymko
 */
public class main {

    static String everything = "";
    static String pathStringFirst = "e:\\Users\\Nikita\\Desktop\\ \\Programming\\Projects\\ReplacingWords\\src\\main\\java\\resources\\1.txt";
    static String pathStringSecond = "e:\\Users\\Nikita\\Desktop\\ \\Programming\\Projects\\ReplacingWords\\src\\main\\java\\resources\\2.txt";

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter(pathStringFirst, false)) {
            String text = "Hello world! I am here! ";
            writer.write(text);
            writer.flush();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(pathStringFirst))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }

        String[] words = everything.split(" ");

        String[] one = new String[3];
        one[0] = "Hello";
        one[1] = "world!";
        one[2] = "here!";

        String[] two = new String[3];
        two[0] = "Bye";
        two[1] = "everybody!";
        two[2] = "there!";

        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < one.length; k++) {
                if (words[i].equals(one[k])) {
                    words[i] = two[k];
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String s : words) {
            builder.append(s).append(" ");
        }
        String text2 = builder.toString();

        try (FileWriter writer2 = new FileWriter(pathStringSecond, false)) {
            writer2.write(text2);
            writer2.flush();
        }
    }
}
