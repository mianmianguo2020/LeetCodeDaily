package UnionFind;

/**
 * @author Christy Guo
 * @create 2023-04-27 9:37 PM
 */
class _839SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int strLen = strs.length;
        DSU dsu = new DSU(strLen);

        for (int left = 0; left < strLen; left++) {
            for (int right = left + 1; right < strLen; right++) {
                if (isSimilar(strs[left], strs[right])) {
                    dsu.union(left, right);
                }
            }
        }

        return dsu.regions();
    }

    private boolean isSimilar(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 2 || count == 0;
    }
}

class DSU {
    private int[] par;
    private int catagories;

    public DSU(int N) {
        par = new int[N];
        for (int i = 0; i < N; i++) {
            par[i] = i;
        }
        catagories = N;
    }

    public int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public void union(int left, int right) {
        int px = find(left);
        int py = find(right);
        if (px == py) {
            return;
        }
        par[py] = px;
        catagories--;
    }

    public int regions() {
        return catagories;
    }
}