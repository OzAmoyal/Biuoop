import java.util.Map;
import java.util.TreeMap;

public class NounPhrase implements Comparable<NounPhrase>{
    private String name;
    private static Map<String,NounPhrase> NounPhraseDB = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private NounPhrase(String name)
    {
        this.name=name;
    }
    public static NounPhrase getNounPhrase(String name){
        if(NounPhraseDB.containsKey(name)){
            return NounPhraseDB.get(name);
        }
        NounPhrase np = new NounPhrase(name);
        NounPhraseDB.put(name, np);
        return np;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public int compareTo(NounPhrase np) {
        return this.name.compareTo(np.getName());
    }
   
    
}
