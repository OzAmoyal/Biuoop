import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
public class HyponymComparator
{
    //got refrence in https://www.flowerbrackets.com/java-treemap-sort-by-value/
    //changed it for the demeand of descending order->lexicographic order.
    public static <NounPhrase extends Comparable<NounPhrase>,Integer extends Comparable<Integer>> Map<NounPhrase,Integer> sortValues(Map<NounPhrase,Integer> m){
        Comparator<NounPhrase> com = new Comparator<NounPhrase>()
       {
          public int compare(NounPhrase np1, NounPhrase np2) 
          {
             int compare = m.get(np1).compareTo(m.get(np2));
             if(compare == 0)
             {
                return np1.compareTo(np2);
             }
             else
             {
                return -compare;
             }
          }
       };
       Map<NounPhrase, Integer> sortedByValues = new TreeMap<NounPhrase, Integer>(com);
       sortedByValues.putAll(m);
       return sortedByValues;
    }

  /*   public static <K, V extends Comparable<V>> Map<K, V> sortValues(final Map<K, V> m) 
    {
       Comparator<K> com = new Comparator<K>()
       {
          public int compare(K k1, K k2) 
          {
             int compare = m.get(k1).compareTo(m.get(k2));
             if(compare == 0)
             {
                return 1;
             }
             else
             {
                return compare;
             }
          }
       };
       Map<K, V> sortedByValues = new TreeMap<K, V>(com);
       sortedByValues.putAll(m);
       return sortedByValues;
    }*/
}
