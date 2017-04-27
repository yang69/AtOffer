/**
 * Created by Yang on 2017/4/25.
 * 矩阵中的路径：
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下
 * 移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如[a b c e s f c s a d e e]是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵
 * 中不包含“abcb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子
 * 之后，路径不能再次进入该格子。
 *
 * 【解】：
 *  这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。
 *  假设矩阵中某个格子的字符为 ch，那么这个格子不可能处在路径上的第 i 个位置。
 *      如果路径上的第 i 个字符不是 ch，那么这个格子不可能处在路径上的第 i 个位置。
 *      如果路径上的第 i 个字符正好是 ch，那么往相邻的格子寻找路径上的第 i+1 个字符。
 *      除在矩阵边界上的格子之外，其他格子都有 4 个相邻的格子。
 *  重复这个过程知道路径上的所有字符都在矩阵中找到相应的位置。
 *
 *  由于回朔法的递归特性，路径可以被看成一个栈。
 *  当在矩阵中定位了路径中前 n 个字符的位置之后，在与第 n 个字符对应的格子的周围都没有找到第 n+1 个字符，
 *  这个时候只要在路径上回到第 n-1 个字符，重新定位第 n 个字符。
 *
 *  由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。
 *
 *  当矩阵中坐标为（row,col）的格子和路径字符串中下标为 pathLength 的字符一样时，
 *  从 4 个相邻的格子 (row,col-1),(row-1,col),(row,col+1) 以及 (row+1,col) 中去定位路径字符串中下标为 pathLength+1 的字符。
 *
 *  如果 4 个相邻的格子都没有匹配字符串中下标为 pathLength+1 的字符，表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不正确，
 *  我们需要回到前一个字符 (pathLength-1)，然后重新定位。
 *
 *  一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 */
public class StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int pathLength, boolean[][] visited) {
        if(pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength] && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);

            if(!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        StringPathInMatrix stringPathInMatrix = new StringPathInMatrix();

        System.out.println(stringPathInMatrix.hasPath("abcesfcsadee".toCharArray(),
                3, 4, "bcced".toCharArray()) + " <--> true");
        System.out.println(stringPathInMatrix.hasPath("abcesfcsadee".toCharArray(),
                3, 4, "abcb".toCharArray()) + " <--> false");
        System.out.println(stringPathInMatrix.hasPath("abcesfcsadee".toCharArray(),
                3, 4, "".toCharArray()) + " <--> true");
    }
}
