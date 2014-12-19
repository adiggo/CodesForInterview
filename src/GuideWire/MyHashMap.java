package GuideWire;

/**
 * Created by i843719 on 12/3/14.
 */
public class MyHashMap {
    private static final int SIZE = 256;
    private Entry table[] = new Entry[SIZE];
    class Entry {
        final String key;
        String value;
        Entry next;
        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }


    public String get(String k){
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];  //get the entry
        while(e!= null){
            if (e.key.equals(k)){
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }


    public void put(String k , String v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        if (e != null) {
            // if the insert key is the same, then we just need to cover its original val
            if (e.key.equals(k)) {
                e.value = v;
            }else {
                boolean entryReplace = false;
                while (e.next != null) {
                    e = e.next;
                    if (e.key.equals(k)){
                        e.value = v;
                        entryReplace = true;
                    }
                }
                if (entryReplace) {
                    Entry newEntryInOld = new Entry(k, v);
                    e.next = newEntryInOld;
                }
            }
        }else{
            // insert a new value at the bucket
            Entry newEntry = new Entry(k, v);
            table[hash] = newEntry;
        }
    }


    public void delete(String k, String v){

    }



}
