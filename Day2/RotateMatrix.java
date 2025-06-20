class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Finding the transpose of the matrix
        for(int i=0; i<n;i++){
            for(int j=i; j<n; j++){
                if(i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //reversing the transpose array
        for(int i=0; i<n; i++){
            int low=0, high = n-1;
            while(low<=high){
                int temp = matrix[i][high];
                matrix[i][high] = matrix[i][low];
                matrix[i][low] = temp;
                high--;
                low++;
            }
        }
    }
}