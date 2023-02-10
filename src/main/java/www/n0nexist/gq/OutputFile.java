package www.n0nexist.gq;

import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {
    private static FileWriter fileWriter;
    private static String filename;

    public static void init(String filename) {
        OutputFile.filename = filename;
        try {
            fileWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String text) {
        try {
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
