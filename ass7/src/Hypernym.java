import java.util.Map;
import java.util.TreeMap;


public class Hypernym {
    private NounPhrase np;
    private Map<NounPhrase,Integer> hyponyms;
    public Hypernym(String name)
    {
    this.np=NounPhrase.getNounPhrase(name);
    hyponyms=new TreeMap<NounPhrase,Integer>();
    }
    public String getName(){
        return this.np.getName();
    }
    public void relate(NounPhrase hyponym){
        if(this.hyponyms.containsKey(hyponym)){
            this.hyponyms.put(hyponym,this.hyponyms.get(hyponym)+1);
            return;
    }
    this.hyponyms.put(hyponym, 1);
        }
    public int getNumOfHyponyms(){
    return hyponyms.size();
}

        @Override
        public String toString() {
            StringBuilder sb= new StringBuilder();
            sb.append(this.getName()+": ");
            for(Map.Entry<NounPhrase,Integer> hyponym : hyponyms.entrySet()) {
                sb.append(hyponym.getKey().toString()+" ("+hyponym.getValue().toString()+"), ");
            }
            int lastComma=sb.lastIndexOf(",");
            if(lastComma!=-1){
                sb.replace(lastComma, lastComma+1, "");
            }
         return sb.toString();   
        }
       
    public void sortByOccurrences(){
    this.hyponyms=HyponymComparator.sortValues(this.hyponyms);      
    }
    public int getMaxOccurence(){
        int max=1;
        for(Map.Entry<NounPhrase,Integer> hyponym : hyponyms.entrySet()) {
            if(hyponym.getValue()>max)
            {
                max=hyponym.getValue();
            }
        }
        return max;

    }

}
    

