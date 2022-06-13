import java.util.List;
import java.util.regex.Pattern;

public class IncludingPattern extends HearstPattern {
    private RegexMatcher matcher;
    public static final String INCLUDING =NP+"(,)? including "+NP+"((,| )*"+NP+")*((,| )*(and|or) "+NP+")*";
    public IncludingPattern(){
        super();
        Pattern pattern=Pattern.compile(INCLUDING);
        this.matcher=new RegexMatcher(pattern);
    }
    @Override
    public List<String> getPatternStrings(String line) {
        return this.matcher.findMatches(line);
    }
    
}