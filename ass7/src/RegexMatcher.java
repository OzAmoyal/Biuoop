import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
    private Pattern pattern;
    public RegexMatcher(Pattern pattern){
        this.pattern=pattern;
    }
    public ArrayList<String> findMatches(String line){
        ArrayList<String> matches= new ArrayList<>();
        Matcher mathcer = pattern.matcher(line);
        while(mathcer.find()){
            matches.add(mathcer.group());
        }
        return matches;
    }
    
    
}
