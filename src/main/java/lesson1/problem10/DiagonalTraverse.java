package lesson1.problem10;

// O(n x m) time | O(n x m) space
public class DiagonalTraverse {
    private int[] orderedList;
    private int[][] matrix;

    public int[] getDiagonalOrder(int[][] input) {
        if (input == null || (input.length == 0 && input[0].length == 0)) return new int[0];

        matrix = input;

        int rows = matrix.length;
        int columns = matrix[0].length;
        orderedList = new int[rows*columns];

        int currentRow = 0;
        int currentColumn = 0;
        boolean isGoingUp = true;

        for(int i = 0; i < orderedList.length; i++)
        {
            if(isGoingUp)
            {
                orderedList[i] = matrix[currentRow--][currentColumn++];

                // exceed the boundary, change directions
                if(!(currentRow >= 0 && currentColumn <= columns - 1))
                {
                    currentRow++;
                    currentColumn--;

                    if(currentColumn < columns - 1) currentColumn++;
                    else currentRow++;

                    isGoingUp = false;
                }
            }
            else
            {
                orderedList[i] = matrix[currentRow++][currentColumn--];

                // exceed the boundary, change directions
                if(!(currentRow <= rows - 1 && currentColumn >= 0))
                {
                    currentRow--;
                    currentColumn++;

                    if(currentRow < rows - 1) currentRow++;
                    else currentColumn++;

                    isGoingUp = true;
                }
            }
        }
        return orderedList;
    }
}

//|1|2|3|4|5|
//|6|7|8|9|1|
//|3|5|6|6|2|

//|1|2|3|4|5|1|2|3|4|5|
//|6|7|8|9|1|1|2|3|4|5|
//|3|5|6|6|2|3|5|6|6|2|

// start at 0, get 1 number
// start at n+1, get m+1 numbers