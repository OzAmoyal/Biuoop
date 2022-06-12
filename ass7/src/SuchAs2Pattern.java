import java.util.List;
import java.util.regex.Pattern;

public class SuchAs2Pattern extends HearstPattern {
    private RegexMatcher matcher;
    public static final String SUCH_AS2 ="such "+NP+" as "+NP+"((, )?"+NP+")*((, )?(and|or) "+NP+")?";
    public SuchAs2Pattern(){
        super();
        Pattern pattern=Pattern.compile(SUCH_AS2);
        this.matcher=new RegexMatcher(pattern);
    }
    @Override
    public List<String> getPatternStrings(String line) {
        return this.matcher.findMatches(line);
    }
    
}