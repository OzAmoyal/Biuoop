import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExampleOfPattern extends HearstPattern {
private RegexMatcher matcher;
public static final String EXAMPLE_OF = NP+"(,)? which is ((an example|a kind|a class) of)? "+NP;
public ExampleOfPattern(){
    super();
    Pattern pattern=Pattern.compile(EXAMPLE_OF);
    this.matcher=new RegexMatcher(pattern);
}

    @Override
    public Hypernym getHypernym(List<String> matches){
        return new Hypernym(matches.get(1).toLowerCase());

    }
    @Override
    public List<NounPhrase> getHyponymList(List<String> matches)
    {
    List<NounPhrase> nounPhrases=new ArrayList<>();
    nounPhrases.add(NounPhrase.getNounPhrase(matches.get(0).toLowerCase()));
    return nounPhrases;
        
    }

    @Override
    public List<String> getPatternStrings(String line) {
        return this.matcher.findMatches(line);
    }
    
}
