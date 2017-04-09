/**
 * Created by yang on 2017/4/8.
 * 在一个二维数组中，每一行都按照
 * 从左到右递增的顺序排序，每一列
 * 都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个
 * 二维数组和一个整数，判断数组中
 * 是否含有该整数。
 */
public class SearchInTwoDimensionalArray {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        //从左下角开始查找
        //1.小于target则向右查找；
        //2.大于target则向上查找；
        //3.找到返回true；
        //出界还没找到就返回false；
        int i = array.length - 1;
        int j = 0;
        while(i >= 0 && j <= array[0].length - 1) {
            if(array[i][j] > target) {
                i--;
            } else if(array[i][j] < target){
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 8;
        System.out.println(Find(target, array));
    }
}
