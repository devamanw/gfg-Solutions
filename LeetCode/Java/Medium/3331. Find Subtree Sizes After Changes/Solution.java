class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        int[] newParent = parent.clone();

        for (int i = 1; i < n; i++) {
            int p = parent[i];

            while (p != -1 && s.charAt(p) != s.charAt(i)) {
                p = parent[p];
            }

            if (p != -1) {
                newParent[i] = p;
            }
        }


        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        dfs(0, tree, ans);

        return ans;
    }

    private int dfs(int node, List<Integer>[] tree, int[] ans) {
        int size = 1;

        for (int child : tree[node]) {
            size += dfs(child, tree, ans);
        }

        ans[node] = size;

        return size;
    }
}
