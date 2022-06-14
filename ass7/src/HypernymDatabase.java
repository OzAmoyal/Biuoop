import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HypernymDatabase {
    private Map<String, Hypernym> relationMap;
    private List<HearstPattern> patterns;

    public HypernymDatabase() {
        this.relationMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.patterns = createPatterns();

    }

    public void readData(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) { // ’null ’->no more data in the stream
            if(line.isEmpty()){
                continue;
            }
            this.getRelationFromLine(line);

        }
    }

    public void insert(Hypernym hypernym, NounPhrase hyponym) {
        if (!this.relationMap.containsKey(hypernym.getName())) {
            this.relationMap.put(hypernym.getName(), hypernym);
        }
        hypernym.relate(hyponym);
    }

    public void getRelationFromLine(String line) {
        for (HearstPattern pattern : this.patterns) {
            List<String> patternStrings = pattern.getPatternStrings(line);
            if (!patternStrings.isEmpty()) {
                for (String ps : patternStrings) {
                    List<String> matches = pattern.getMatchesList(ps);
                    if (!matches.isEmpty()) {
                        matches = pattern.removeTags(matches);
                        Hypernym hypernym = pattern.getHypernym(matches);
                        List<NounPhrase> hyponyms = pattern.getHyponymList(matches);
                        for (NounPhrase hyponym : hyponyms) {
                            this.insert(hypernym, hyponym);
                        }
                    }
                }
            }
        }

    }

    public void export(File file) throws IOException {
        file.createNewFile();
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file)); // wrapper that can write strings
        for (Map.Entry<String, Hypernym> hypernyms : relationMap.entrySet()) {
            os.write(hypernyms.getValue().toString() + "\n");
        }
        os.close();
    }
    public void filterHypernyms(){
        Map<String, Hypernym> hypernyms=new TreeMap<>(this.relationMap);
        for(Map.Entry<String, Hypernym> entry:hypernyms.entrySet()){
            if(entry.getValue().getNumOfHyponyms()<3){
                this.relationMap.remove(entry.getKey());
            }
        }

    }

    private static List<HearstPattern> createPatterns() {
        List<HearstPattern> patterns = new ArrayList<>();
        patterns.add(new SuchAs1Pattern());
        patterns.add(new SuchAs2Pattern());
        patterns.add(new IncludingPattern());
        patterns.add(new EspeciallyPattern());
        patterns.add(new ExampleOfPattern());
        return patterns;
    }
}