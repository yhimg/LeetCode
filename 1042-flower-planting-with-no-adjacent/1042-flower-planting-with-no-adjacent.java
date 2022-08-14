class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int i = 0; i<n; i++) graph.put(i, new ArrayList());
        for(int[] path: paths){
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }
        
        
        int[] flowerChoices = new int[n];
        solve(0, graph, n, flowerChoices);
        return flowerChoices;
    }
    
    private boolean solve(int garden, Map<Integer, List<Integer>> graph, int n, int[] flowerChoices){
        if(garden == n){
            return true;
        }
        for(int flower = 1; flower<=4; flower++){
            if(isPossible(garden, graph, flowerChoices, flower)){
                flowerChoices[garden] = flower;
                if(solve(garden+1, graph, n, flowerChoices)) return true;
                flowerChoices[garden] = 0;
            }
        }
        return false;
    }
    
    private boolean isPossible(int garden, Map<Integer, List<Integer>> graph, int[] flowerChoices, int flower){
        for(int lawn : graph.get(garden)){
            if(flowerChoices[lawn] == flower) return false;
        }
        return true;
    }
}