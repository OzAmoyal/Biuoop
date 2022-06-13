import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class CreateHypernymDatabase {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        String corpus = "C:/Users/uziam/Code/corpus/";
        String output = "./data.txt";
        HypernymDatabase db = new HypernymDatabase();
        BufferedReader is = null;
        File dir = new File(corpus);
        File[] files = dir.listFiles();
        File outputFile = new File(output);
        for (File file : files) {
            try {
                is = new BufferedReader( // wrapper that reads ahead
                        new InputStreamReader( // wrapper that reads characters
                                new FileInputStream(file)));
                db.readData(is);

            } catch (IOException e) {
                System.out.println(" Something went wrong while reading !");
            } finally {
                if (is != null) { // Exception might have happened at constructor
                    try {
                        is.close(); // closes FileInputStream too
                    } catch (IOException e) {
                        System.out.println(" Failed closing the file !");

                    }

                }
            }
        }
        db.filterHypernyms();
        try {
            db.export(outputFile);
        } catch (IOException e) {
            System.out.println(" Something went wrong while writing !");
        } finally {
            if (is != null) { // Exception might have happened at constructor
                try {
                    is.close(); // closes FileInputStream too
                } catch (IOException e) {
                    System.out.println(" Failed closing the file !");

                }

            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime / 1000000000);
        }
    }
}