package pct.com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    
    Map<Integer, Integer> mapNodeHeight = new HashMap<>();
	private int height = 0;

	public int maxLevelSum(TreeNode root) {
		
		preOrderTraversal(root);
		
		int sum=0;
		Collection<Integer> levels = mapNodeHeight.values();
		ArrayList<Integer> sumList = new ArrayList<>();
		
		for (Integer level : levels) {
			
			for (Map.Entry<Integer, Integer> entry : mapNodeHeight.entrySet()) {
				
				if(entry.getValue().equals(level)) {
					
					sum = sum + entry.getValue();
					
				}
			}
			
			sumList.add(sum);
		}
		
		Integer max = Collections.max(sumList);
		
		return max;
    
    }
    
    
    private void preOrderTraversal(TreeNode node){
        
		
		
		if(node == null) {
			return;
		}
		
		Integer h = getHeight(node);
		
        mapNodeHeight.put(node.val,h);
        //System.out.println("");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        
    }
    
    private Integer getHeight(TreeNode node) {
		
    	height  = height + 1;
		return height;
	}
}

public class Find_Sum_Of_Max_Level {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            int ret = new Solution().maxLevelSum(root);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}