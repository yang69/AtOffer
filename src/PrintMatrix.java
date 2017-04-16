import java.util.ArrayList;

/**
 * Created by Yang on 2017/4/16.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while(rows > 2*start && columns > 2*start) {
            printMatrixInCircle(matrix, start, res);
            start++;
        }
        return res;
    }
    private void printMatrixInCircle(int[][] matrix, int start, ArrayList<Integer> res) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int endRow = rows - 1 - start;
        int endCol = columns - 1 - start;
        //第一步：从左向右。（总是必须的）
        for(int i = start; i <= endCol; i++) {
            res.add(matrix[start][i]);
        }
        //第二步：从上向下。（进行这一步的条件是：需要打印的内容多于一行）
        if(endRow > start) {
            for(int i = start + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
        }
        //第三步：从右向左。（进行这一步的条件是：需要打印的内容至少有两行两列）
        if(endRow > start && endCol > start) {
            for(int i = endCol - 1; i >= start; i--) {
                res.add(matrix[endRow][i]);
            }
        }
        //第四步：从下向上。（进行这一步的条件是：需要打印的内容至少有三行两列）
        if(endRow > start+1 && endCol > start) {
            for(int i = endRow-1; i > start; i--) {
                res.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //输出应该是[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        System.out.println(printMatrix.printMatrix(matrix));

        matrix = new int[][]{{1,2,3,4},{5,6,7,8}};
        //输出应该是[1, 2, 3, 4, 8, 7, 6, 5]
        System.out.println(printMatrix.printMatrix(matrix));

        matrix = new int[][]{{1}};
        //输出应该是[1]
        System.out.println(printMatrix.printMatrix(matrix));

        matrix = new int[][]{{1},{2}};
        //输出应该是[1, 2]
        System.out.println(printMatrix.printMatrix(matrix));

        matrix = new int[][]{};
        //输出应该是[]
        System.out.println(printMatrix.printMatrix(matrix));
    }
}
