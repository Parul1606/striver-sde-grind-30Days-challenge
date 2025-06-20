class Solution {
    public void setZeroes(int[][] matrix) {

        //OPTIMIZED - TC:O(n x m) & SC: O(n+m)
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Step 1: Check if first row has any 0
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Step 1: Check if first column has any 0
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Step 2: Use first row and column as flags
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Step 3: Set matrix[i][j] = 0 if its row or column is marked
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Update first row if needed
        if (firstRowHasZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 5: Update first column if needed
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        /*
        // Time Complexity: O(n × m)
        // Space Complexity: O(n + m)

        // Step 1: Store row and column indexes of all zero elements
        // Brute force would overwrite values too early, so we use HashSet to store positions
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        // First pass: Identify all the rows and columns that need to be zeroed
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // Second pass: Set elements to zero if they're in a zero row or column
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(zeroRows.contains(i) || zeroCols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        */
    }



    public void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
