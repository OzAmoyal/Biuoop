import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class RelationDatabase {
    private final Map<String, Map<String, Integer>> relationMap;
    public RelationDatabase(){
        this.relationMap=new TreeMap<>();
    }
public void insert(String hypernym,String hyponym){
    if(!this.relationMap.containsKey(hypernym)){
        this.relationMap.put(hypernym, new TreeMap<String,Integer>());
    }
    Map<String, Integer> hypernymMap= this.relationMap.get(hypernym);
    if(!hypernymMap.containsKey(hyponym)){
        hypernymMap.put(hyponym,1);
        return;
    }
    hypernymMap.put(hyponym,hypernymMap.get(hyponym)+1);    
}
public void export(File file) throws IOException{
    file.createNewFile();
     OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream (file)); // wrapper that can write strings
        

    for (Map.Entry<String, Map<String,Integer>> hypernyms : relationMap.entrySet()) {
        String key = hypernyms.getKey();
        Map<String,Integer> hypernymMap = hypernyms.getValue();
        StringBuilder sb= new StringBuilder();
        sb.append(key+": ");
        for(Map.Entry<String,Integer> hyponyms : hypernymMap.entrySet()) {
            sb.append(hyponyms.getKey()+" ("+hyponyms.getValue()+"), ");
        }
        int lastComma=sb.lastIndexOf(",");
        if(lastComma!=-1){
            sb.replace(lastComma, lastComma+1, "");
        }
        os.write(sb.toString()); 
        
    }
    os.close();
}

     
    
}
