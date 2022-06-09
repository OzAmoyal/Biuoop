import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HearstPattern {
    public static final String NP="<np>([\\w ])*</np>";
    public static final String SUCH_AS1 = NP+" such as "+NP+"( ( ,)?"+NP+")*( ( ,)?(and|or) "+NP+")?";
    public static final String SUCH_AS2 ="such "+NP+" as "+NP+"((, )?"+NP+")*((, )?(and|or) "+NP+")?";
    public HearstPattern(String regex){}

    

    
}
