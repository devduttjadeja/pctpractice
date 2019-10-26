package leetcode.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class Prb_103_binary_tree_zigzag_level_order_traversal {

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
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            List<List<Integer>> ret = new Solution().zigzagLevelOrder(root);
            
            String out = int2dListToString(ret);
            
            System.out.print(out);
            break;
        }
    }

    
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.data = x;
		}
	}
     
	private static class Solution {
		
		private Map<Integer,ArrayList<Integer>> map = new LinkedHashMap<>();
		
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    	
	    	List<List<Integer>> list = new ArrayList<>();
	    	
	    	int height = getHeight(root);
	    	
	    	preOrderTraversalToCreateMap(root,height);
	    	
	    	int i = 0;
	    	
	    	for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
				
	    		ArrayList<Integer> value = entry.getValue();
	    		
	    		if(i%2 == 0) {
	    			list.add(value);
	    		}
	    		
	    		if(i%2 == 1) {
	    			Collections.reverse(value);
	    			list.add(value);
	    		}
	    		
	    		i++;
			}
	    	
	    	
	    	return list;
	    }

		private int getHeight(TreeNode root) {

			if(root == null) {
				return 0;
			}
			
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}

		private void preOrderTraversalToCreateMap(TreeNode root, int height) {

			if(root == null) {
				return;
			}
			
			if(map.containsKey(height)) {
				map.get(height).add(root.data);
			}else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(root.data);
				map.put(height, al);
			}
			
			preOrderTraversalToCreateMap(root.left, height-1);
			preOrderTraversalToCreateMap(root.right, height-1);
			
		}
	}
    
}
