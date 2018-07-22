/**
 * @author yang
 * @version 0.1 20180721
 * Created by yang on 2017/07/21.
 ************************************************************************************************
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,
 * 3,8,6}，则重建二叉树并返回。
 ************************************************************************************************
 */
package AtOffer

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func ReConstructBinaryTree(preorder []int, inorder []int) *TreeNode {
    if 0 == len(preorder) || 0 == len(inorder) {
        return nil
    }
    m := make(map[int]int)
    for i, v := range inorder {
        m[v] = i
    }

    return reConstructBinaryTreeCore(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1, m)
}

func reConstructBinaryTreeCore(preorder []int, from1, to1 int, inorder []int, from2, to2 int, m map[int]int) *TreeNode {
    if from1 > to1 {
        return nil
    }

    index := m[preorder[from1]]
    root := &TreeNode{Val:preorder[from1]}
    //leftLength, rightLength := index - from2, to2 - index
    root.Left = reConstructBinaryTreeCore(preorder, from1+1, from1+index-from2, inorder, from2, index-1, m)
    root.Right = reConstructBinaryTreeCore(preorder, from1+index-from2+1, to1, inorder, index+1, to2, m)

    return root
}
