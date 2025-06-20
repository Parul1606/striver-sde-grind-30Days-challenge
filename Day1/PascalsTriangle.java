class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // first element is always 1

            if (i > 0) {
                List<Integer> prevRow = triangle.get(i - 1);
                for (int j = 1; j < i; j++) {
                    int val = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(val);
                }
                row.add(1);  // last element is always 1
            }
            triangle.add(row); // add built row to triangle
        }
        return triangle;
    }
}