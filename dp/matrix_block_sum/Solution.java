package dp.matrix_block_sum;

interface Solution {
    int[][] matrixBlockSum(int[][] mat, int k);    
}

class MySolution implements Solution {

    @Override
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] out = new int[mat.length][mat[0].length];

        // insert out[0][0]
        for (int i=0; i<=k && i<mat.length; i++) {
            for (int j=0; j<=k && j<mat[0].length; j++)
                out[0][0] += mat[i][j];
        }

        // insert out[0][c]
        for (int c=1; c<mat[0].length; c++) {
            int oldCol = 0;
            if (c-k-1 >= 0) {
                for (int r=0; r<=k && r<mat.length; r++) oldCol += mat[r][c-k-1];
            }

            int newCol = 0;
            if (c+k < mat[0].length) {
                for (int r=0; r<=k && r<mat.length; r++) newCol += mat[r][c+k];
            }

            out[0][c] = out[0][c-1] - oldCol + newCol;
        }

        // insert rest
        for (int r=1; r<mat.length; r++) {
            for (int c=0; c<mat[0].length; c++) {
                int oldRow = 0;
                if (r-k-1 >= 0) {
                    for (int j=c-k; j<=c+k; j++) {
                        if (j>=0 && j<mat[0].length) oldRow += mat[r-k-1][j];
                    }
                }

                int newRow = 0;
                if (r+k < mat.length) {
                    for (int j=c-k; j<=c+k; j++) {
                        if (j>=0 && j<mat[0].length) newRow += mat[r+k][j];
                    }
                }

                out[r][c] = out[r-1][c] - oldRow + newRow;
            }
            
        }

        return out;
    }

}
