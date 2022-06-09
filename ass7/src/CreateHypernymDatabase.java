import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CreateHypernymDatabase {
    public static void main(String[] args) {
        String corpus = "C:/Users/uziam/Code/corpus/mbta.com_mtu.pages_0.possf2";
        String output = "./data.txt";
        BufferedReader is = null;
        File file=new File(corpus);
        /* 
        File file=new File(output);
        RelationDatabase db = new RelationDatabase();
        db.insert("animal","cat" );
        db.insert("animal", "dog");
        db.insert("animal", "dog");
        db.insert("animal", "cow");
        
        try{
        db.export(file);
        }
        catch (IOException e){
            System.out.println("file is not valid "+e.getMessage());
        }

        */
        Pattern pattern = Pattern.compile(HearstPattern.SUCH_AS2);
        try {
            is = new BufferedReader( // wrapper that reads ahead
                    new InputStreamReader( // wrapper that reads characters
                            new FileInputStream(file)));
            String line;
            while ((line = is.readLine()) != null) { // ’null ’->no more data in the stream
                Matcher mathcer = pattern.matcher(line);
                while(mathcer.find()){
                    System.out.println(line.substring(mathcer.start(),mathcer.end())+"_");
                }

            }
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
}
