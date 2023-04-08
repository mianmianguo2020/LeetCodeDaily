package HashTable;

/**
 * @author Christy Guo
 * @create 2023-04-08 10:41 AM
 */



import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private ArrayList<ArrayList<String[]>> keyMap;

    public HashTable(int size) {
        keyMap = new ArrayList<ArrayList<String[]>>(size);
        for (int i = 0; i < size; i++) {
            keyMap.add(new ArrayList<String[]>());
        }
    }

    private int hash(String key) {
        int total = 0;
        int WEIRD_PRIME = 31;
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char c = key.charAt(i);
            int value = (int) c - 96;
            total = (total * WEIRD_PRIME + value) % keyMap.size();
        }
        return total;
    }

    public void set(String key, String value) {
        int index = hash(key);
        ArrayList<String[]> bucket = keyMap.get(index);
        boolean keyFound = false;
        for (String[] pair : bucket) {
            if (pair[0].equals(key)) {
                pair[1] = value;
                keyFound = true;
                break;
            }
        }
        if (!keyFound) {
            bucket.add(new String[] {key, value});
        }
    }

    public String get(String key) {
        int index = hash(key);
        ArrayList<String[]> bucket = keyMap.get(index);
        for (String[] pair : bucket) {
            if (pair[0].equals(key)) {
                return pair[1];
            }
        }
        return null;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keysArr = new ArrayList<String>();
        for (ArrayList<String[]> bucket : keyMap) {
            for (String[] pair : bucket) {
                if (!keysArr.contains(pair[0])) {
                    keysArr.add(pair[0]);
                }
            }
        }
        return keysArr;
    }

    public ArrayList<String> values() {
        ArrayList<String> valuesArr = new ArrayList<String>();
        for (ArrayList<String[]> bucket : keyMap) {
            for (String[] pair : bucket) {
                if (!valuesArr.contains(pair[1])) {
                    valuesArr.add(pair[1]);
                }
            }
        }
        return valuesArr;
    }

        public static void main(String[] args) {
            HashTable ht = new HashTable(17);
            ht.set("maroon", "#800000");
            ht.set("yellow", "#FFFF00");
            ht.set("olive", "#808000");
            ht.set("salmon", "#FA8072");
            ht.set("lightcoral", "#F08080");
            ht.set("mediumvioletred", "#C71585");
            ht.set("plum", "#DDA0DD");
            ht.set("purple", "#DDA0DD");
            ht.set("violet", "#DDA0DD");

            for (String key : ht.keys()) {
                System.out.println(ht.get(key));
            }
        }

}
