package leetcode.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/

input
[3,5,1,6,2,0,8,null,null,7,4]
[5]
[1]
 
output
3

 */
public class Prb_236_Lowest_Common_Ancestor_BinaryTree {

	public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            TreeNode p = stringToTreeNode(line);
            line = in.readLine();
            TreeNode q = stringToTreeNode(line);
            
            TreeNode ret = new Solution().lowestCommonAncestor(root, p, q);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
    
    private static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	TreeNode(int x){
    		val = x; 
    	}
    }
    
    private static class Solution {
    	
    	List<TreeNode> preOrderList = new ArrayList<>();
    	List<Integer> childList = new ArrayList<>();
    	
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        	TreeNode ans = root;
        	
        	preOrderTraversalList(root);
        	
        	for (TreeNode node : preOrderList) {
				
        		getAllChilds(node);
        		if(childList.contains(p.val) && childList.contains(q.val)) {
        			ans = new TreeNode(node.val);
        		}
        		childList.clear();
			}
        	
        	return ans;
        }

		private void getAllChilds(TreeNode node) {
			
			if(node == null) {
				return;
			}
			
			childList.add(node.val);
			getAllChilds(node.left);
			getAllChilds(node.right);
			
		}

		private void preOrderTraversalList(TreeNode root) {

			if(root == null) {
				return;
			}
			
			preOrderList.add(root);
			preOrderTraversalList(root.left);
			preOrderTraversalList(root.right);
			
		}
        
    }

}
