package zsy.algs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter("d:\\Docs\\read.txt", StandardCharsets.UTF_8);
            out.print("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Scanner scanner1 = new Scanner(Path.of("d:\\Docs\\read.txt"), StandardCharsets.UTF_8);
            while (scanner1.hasNext()) {
                System.out.println(scanner1.next());
            }
            scanner1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
