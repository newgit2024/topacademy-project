package nestedclasses;

public class Table {
    private static final int MAX_SIZE = 5;
    private TableEntry[] entries;
    private int count;

    public Table() {
        this.entries = new TableEntry[MAX_SIZE];
        this.count = 0;
    }

    private static class TableEntry {
        private String key;
        private int value;

        public TableEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class TableIterator {
        private int current = -1;

        public void next(){
            if (current < count){
                current++;
            } else {
                System.err.println("To last element");
            }
        }
        public String key(){
            return entries[current].key;
        }
        public int value(){
            return entries[current].value;
        }
    }

    public void put(String key, int value){
        TableEntry entry = new TableEntry(key, value);
        entries[count] = entry;
        count++;
    }
    public int get(String key){
        for (int i = 0; i < count; i++){
            if (entries[i].key.equals(key)){
                return entries[i].value;
            }
        }
        return -1;
    }

    public int getCount() {
        return count;
    }
}
