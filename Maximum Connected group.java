class Solution {

    public int MaxConnection(int grid[][]) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        int[][] componentNumber = new int[grid.length][grid[0].length]; 
        int numberOfTheComponent = 0;
        HashMap<Integer,Integer> componentNumberToCount = new HashMap<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){ 
                if(grid[i][j] != 0 && !visited[i][j]){ 
                    int componentLength = DFS(i, j, grid, numberOfTheComponent, componentNumber, visited);
                    componentNumberToCount.put(numberOfTheComponent, componentLength);
                    numberOfTheComponent++;
                }
            }
        }
        int max = 0;

        for(int i = 0; i < numberOfTheComponent; i++){
            max = Math.max(max, componentNumberToCount.get(i));
        }

        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    max = Math.max(max, componentConnector(i, j, grid, componentNumberToCount, componentNumber));
                }
            }
        }

        return max;
    }

    private int componentConnector(int i, int j, int[][] grid, HashMap<Integer, Integer> componentNumberToCount,
            int[][] componentNumber) {
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1 , 0, -1};
        
        HashSet<Integer> set = new HashSet<>();

        for(int k = 0; k < 4; k++){
            int r = i + row[k];
            int c = j + col[k];

            if(isSafe(r, c, grid.length) && grid[r][c] == 1){
                set.add(componentNumber[r][c]);
            }
        }

        int len = 1;

        for(int val : set){
            len += componentNumberToCount.get(val);
        }
        return len;
    }

    private int DFS(int i, int j, int[][] grid, int numberOfTheComponent, int[][] componentNumber,
            boolean[][] visited) {
        visited[i][j] = true;
        componentNumber[i][j] = numberOfTheComponent;

        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1 , 0, -1};

        int len = 1;

        for(int k = 0; k < 4; k++){
            int r = i + row[k];
            int c = j + col[k];

            if(isSafe(r, c, grid.length) && !visited[r][c] && grid[r][c] == 1){ // simplified condition check
                len += DFS(r, c, grid, numberOfTheComponent, componentNumber, visited);
            }
        }
        return len;
    }

    private boolean isSafe(int r, int c, int length) {
        return r >= 0 && r < length && c >= 0 && c < length;
    }
}
