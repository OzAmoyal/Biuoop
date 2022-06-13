import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class HearstPattern {
    private RegexMatcher npMatcher;
    public static final String NP="<np>([^<])*</np>";
    public HearstPattern() {
        Pattern pattern = Pattern.compile(NP);
        this.npMatcher = new RegexMatcher(pattern);


    }
    public ArrayList<String> removeTags(List<String> matches) {
        ArrayList<String> clean=new ArrayList<>();
        for(String match:matches){
        
        match=match.replace("<np>","");
        match=match.replace("</np>", "");
        clean.add(match);
        }
        return clean;

    }
    public abstract List<String> getPatternStrings(String line);
    public List<String> getMatchesList(String line){
        return this.npMatcher.findMatches(line);
    }
    public Hypernym getHypernym(List<String> matches){
        return new Hypernym(matches.get(0).toLowerCase());
    }
    public List<NounPhrase> getHyponymList(List<String> matches)
    {
    List<NounPhrase> nounPhrases=new ArrayList<>();
    for(int i=1;i<matches.size();i++){
        nounPhrases.add(NounPhrase.getNounPhrase(matches.get(i).toLowerCase()));
    }
    return nounPhrases;
    }

    

    
}
