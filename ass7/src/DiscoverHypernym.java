import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiscoverHypernym {
    public static void main(String[] args) {
        String lemmaString="diabetes";
        String corpus="C:/Users/uziam/Code/corpus/";
        String corpus1 = "C:/Users/uziam/Code/minicorpus.txt";
        File file2 = new File(corpus1);
        File dir=new File(corpus);
        File[] files=dir.listFiles();
        NounPhrase lemma=NounPhrase.getNounPhrase(lemmaString);
        long startTime = System.nanoTime();
        String output = "./data1.txt";
        File outputFile=new File(output);
        HypernymDatabase db=new LemmaHypernymDatabase(lemma);
        BufferedReader is = null;
        File dir1 = new File(corpus1);
        for(File file:files){
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
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000000000);

    
}
}

