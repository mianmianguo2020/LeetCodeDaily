package Graph;


/**
 * @author Christy Guo
 * @create 2023-04-09 1:18 PM
 * https://leetcode.com/problems/satisfiability-of-equality-equations/description/
 */
public class _990SatisfiabilityofEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        boolean result = true;
        int[] parent = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(parent, x, y);
            }
        }
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if(find(parent, x) == find(parent, y)){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private int find(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }
        return find(parent, parent[i]);
    }
    private void union(int[] parent, int i, int j){
        int x = find(parent, i);
        int y = find(parent, j);
        parent[x] = y;
    }

}
