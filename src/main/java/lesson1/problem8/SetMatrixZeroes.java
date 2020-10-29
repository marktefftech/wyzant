package lesson1.problem8;

import java.util.ArrayList;

// O(n^2) time | O(1) space
// 52 minutes to solve with LOTS of help from YouTube
public class SetMatrixZeroes {
    private ArrayList<ArrayList<Integer>> matrix;

    public SetMatrixZeroes (ArrayList<ArrayList<Integer>> in) {
        this.matrix = in;
    }

    public ArrayList<ArrayList<Integer>> setZeroes() {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        boolean rowVisited[] = new boolean[rows];
        boolean colVisited[] = new boolean[cols];

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix.get(i).get(j) == 0) {
                    rowVisited[i]= true;
                    colVisited[j]= true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowVisited[i] || colVisited[j])
                    matrix.get(i).set(j,0);
            }
        }
        return matrix;
    }
}
