package pct.com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


/*

refer -- https://youtu.be/c3SAvcjWb1E

input : 1 2 5 3 6 4
output : 1 2 5 6 
  
input 1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
output 2 1 14 15 12 

input : 13 105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198 122 130 183 361 274 291 25 146 121 321 268 273 36 316 216 70 171 75 380 296 66 264 398 359 87 338 355 220 288 225 21 94 157 207 86 97 235 83 381 221 61 42 111 150 320 188 123 300 215 329 267 170 18 167 224 265 293 23 124 212 39 376 326 378 169 415 65 365 394 245 182 211 242 350 336 385 342 233 84 283 228 154 166 418 206 389 214 133 347 232 275 52 402 287 2 318 93 280 248 313 1 131 209 412 406 249 325 276 6 286 9 333 403 314 262 387 30 56 362 141 11 109 417 136 139 322 223 246 101 80 294 404 319 32 69 20 115 174 366 252 90 384 159 411 203
output : 17 1 2 3 4 13 105 278 372 377 393 409 416 418


*/
public class Find_Top_View_Of_Tree {

	private static Map<Integer,ArrayList<Integer>> mapDistanceNode = new TreeMap<>();
	private static List<Integer> levelOrderList = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] strings = sc.nextLine().split("\\s+");
		
		//convert string to Integer Array
		
		Node root = null;
		int distance = 0;
		for (String string : strings) {
			
			int data = Integer.parseInt(string);
			root = addNodeToTree(root,data,distance);
			
		}
		
		preOrderTraverseToCreateMapOfDistanceAndNode(root);
		/*
		-1=[2], 
		0=[1, 3, 4, 8], 
		1=[14, 7, 5, 10, 9], 
		2=[6, 13, 11, 15], 
		3=[12]
		 */
		
		
		findLevelOrder(root);
		
		printTopView();
		
		sc.close();
		
	}

	
	private static void findLevelOrder(Node root) {

		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			levelOrderList.add(temp.data);
			
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
			
		}
		
		
		
	}


	private static void printTopView() {

		String str = "";
		// iterate map print the element which comes first in level traversal
		/*
		-1=[2], 
		0=[1, 3, 4, 8], 
		1=[14, 7, 5, 10, 9], 
		2=[6, 13, 11, 15], 
		3=[12]
		 */
		for (Entry<Integer, ArrayList<Integer>> entry : mapDistanceNode.entrySet()) {
			
			if(entry.getValue().size() == 1) {
				str = str + " " + entry.getValue().get(0);
			}else {
				
				int leastIndex = levelOrderList.size()-1;
				
				for (Integer value : entry.getValue()) {
					
					int index = levelOrderList.indexOf(value);
					
					if(index < leastIndex) {
						leastIndex = index;
					}
					
				}
				
				
				str = str + " " + levelOrderList.get(leastIndex);
				
			}
			
		}
		
		System.out.println(str.trim());
		
	}


	private static void preOrderTraverseToCreateMapOfDistanceAndNode(Node root) {
		
		if(root == null) {
			return;
		}
		
		if(mapDistanceNode.containsKey(root.distance)) {
			mapDistanceNode.get(root.distance).add(root.data);
		}else {
			
			ArrayList<Integer> al = new ArrayList<>();
			al.add(root.data);
			mapDistanceNode.put(root.distance, al);
			
		}
		
		
		preOrderTraverseToCreateMapOfDistanceAndNode(root.left);
		preOrderTraverseToCreateMapOfDistanceAndNode(root.right);
	}


	private static Node addNodeToTree(Node root, int data, int distance) {
		
		if(root == null) {
			return new Node(data,distance);
		}
		
		if(data < root.data) {
			root.left = addNodeToTree(root.left, data, distance-1);
		}
		
		if(data > root.data) {
			root.right = addNodeToTree(root.right, data, distance+1);
		}
		
		
		return root;
	}


	static class Node{
		
		int data;
		int distance;
		Node left;
		Node right;
		
		Node(int data,int distance){
			this.data = data;
			this.distance = distance;
			this.left = null;
			this.right = null;
		}
		
	}
	
}
