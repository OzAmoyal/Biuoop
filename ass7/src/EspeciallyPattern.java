import java.util.List;
import java.util.regex.Pattern;

public class EspeciallyPattern extends HearstPattern {
    private RegexMatcher matcher;
    public static final String ESPECIALLY = NP+"(,| )*especially(,| )*"+NP+"((,| )*"+NP+")*((,| )*(and|or)( )*"+NP+")?";
    public EspeciallyPattern(){
        super();
        Pattern pattern=Pattern.compile(ESPECIALLY);
        this.matcher=new RegexMatcher(pattern);
    }
    @Override
    public List<String> getPatternStrings(String line) {
        return this.matcher.findMatches(line);
    }
    
}