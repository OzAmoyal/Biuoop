import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

public class LemmaHypernymDatabase extends HypernymDatabase{
    private NounPhrase lemma;
    public LemmaHypernymDatabase(NounPhrase lemma){
        super();
        this.lemma=lemma;
    }
    @Override
    public void getRelationFromLine(String line) {
        if(!line.contains(this.lemma.getName()))
        {
            return;
        }
        for (HearstPattern pattern : super.patterns) {
            List<String> patternStrings = pattern.getPatternStrings(line);
            if (!patternStrings.isEmpty()) {
                for (String ps : patternStrings) {
                    List<String> matches = pattern.getMatchesList(ps);
                    if (!matches.isEmpty()) {
                        matches = pattern.removeTags(matches);
                        
                        List<NounPhrase> hyponyms = pattern.getHyponymList(matches);
                        if(hyponyms.contains(this.lemma)){
                            Hypernym hypernym = pattern.getHypernym(this,matches);
                            this.insert(hypernym, this.lemma);
                        
                    }
                }
            }
        }
    }
    
    }
    @Override
    public void export(File file) throws IOException {
        if(this.relationMap.isEmpty()){
            System.out.println("The lemma doesn't appear in the corpus.");
            return;
        }
        file.createNewFile();
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file)); // wrapper that can write strings
        List<Hypernym> hypernyms=new ArrayList<>(this.relationMap.values());
        hypernyms.sort(new Comparator<Hypernym>() {

            @Override
            public int compare(Hypernym o1, Hypernym o2) {
                int x=o1.getMaxOccurence();
                int y=o2.getMaxOccurence();
                if(x<y){
                    return 1;
                }
                else if(x==y){
                    return 0;
                }else{
                    return -1;
                }
            }
            
            
        });
        
        for (Hypernym hypernym:hypernyms){
            //hypernyms.getValue().sortByOccurrences();
            os.write(hypernym.toString() + "\n");
        }
        os.close();
}
}
