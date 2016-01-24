/**
 * Created by adamli on 1/19/16.
 */
public class Tweaked_Identical_Binary_Tree {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b != null)
            return false;

        if (a != null && b == null)
            return false;

        if (a == b)
            return true;

        boolean aLbL = isTweakedIdentical(a.left, b.left);
        boolean aRbR = isTweakedIdentical(a.right, b.right);
        boolean aLbR = isTweakedIdentical(a.left, b.right);
        boolean aRbL = isTweakedIdentical(a.right, b.left);

        if (aLbL && aRbR )
            return true;

        if (aLbR && aRbL && a.val == b.val)
            return true;

        return false;
    }
}
