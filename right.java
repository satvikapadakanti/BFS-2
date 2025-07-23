class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer>res=new ArrayList<>();
    if(root==null){
        return res;
    }
    dfs(root,res,0);
    return res;
    }
    private void dfs(TreeNode root,List<Integer>res,int lvl){
        if(root==null)return;
        if(res.size()==lvl){
            res.add(root.val);
        }
        dfs(root.right,res,lvl+1);
        dfs(root.left,res,lvl+1);

    }
}