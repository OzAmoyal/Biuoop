import java.util.List;
import java.util.regex.Pattern;

public class SuchAs1Pattern extends HearstPattern {
    private RegexMatcher matcher;
    public static final String SUCH_AS1 = NP+"(,)? such as "+NP+"( ( ,)?"+NP+")*( ( ,)?(and|or) "+NP+")?";
    public SuchAs1Pattern(){
        Pattern pattern=Pattern.compile(SUCH_AS1);
        this.matcher=new RegexMatcher(pattern);
    }
    @Override
    public List<String> getPatternStrings(String line) {
        return this.matcher.findMatches(line);
    }
    
}

    

