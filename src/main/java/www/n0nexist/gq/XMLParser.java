package www.n0nexist.gq;
import www.n0nexist.gq.utils.PingAndCheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLParser {
    private static final String ADDR_REGEX = "address addr=\".*?\"";
    private static final String PORT_REGEX = "portid=\".*?\"";

    public static void parseXML(String fileName, int numThreads) {
        List<String> lines = readLinesFromFile(fileName);
        int linesPerThread = lines.size() / numThreads;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            try {
            int startIndex = i * linesPerThread;
            int endIndex = (i + 1) * linesPerThread - 1;
            if (i == numThreads - 1) {
                endIndex = lines.size() - 1;
            }
            List<String> subList = lines.subList(startIndex, endIndex + 1);
                try {
                    threads.add(new Thread(() -> {
                        for (String line : subList) {
                            String address = extractValue(line, ADDR_REGEX);
                            int port = Integer.parseInt(extractValue(line, PORT_REGEX));
                            hellomf(address, port);
                        }
                    }));
                }catch(Exception ee){}
            }catch(Exception eee){}
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractValue(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String matchedString = matcher.group();
            return matchedString.split("\"")[1];
        }
        return null;
    }

    private static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void hellomf(String address, int port) {
        PingAndCheck.processServer(address,port);
    }

}
