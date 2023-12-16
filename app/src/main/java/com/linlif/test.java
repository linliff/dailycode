package com.linlif;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.linlif.leecode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by linlif on 2020/8/13
 */
class test {

    private static boolean target = false;

//    public static void main(String[] aa) {
//        runCBA();
//    }

    public static void runCBA() {

        generate(5);
        String[] aa = new String[]{"ab", "a"};
        longestCommonPrefix(aa);
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));

//        twoSum2(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12});

//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(7);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

//
//        listnodeadd(listNode1, listNode4);


        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;

//        kthSmallest(treeNode5, 3);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndexMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {

            if (numIndexMap.containsKey(target - nums[i])) {
                return new int[]{numIndexMap.get(target - nums[i]), i};
            }
            numIndexMap.put(nums[i], i);
        }

        return new int[0];
    }

    public static int[] twoSum2(int[] arr) {

        int[] clone = arr.clone();
        Arrays.sort(clone);

        HashMap<Integer, Integer> numIndexMap = new HashMap();
        int add = 0;
        for (int i = 0; i < clone.length; i++) {

            if (!numIndexMap.containsKey(clone[i])) {
                numIndexMap.put(clone[i], i + 1 - add);
            } else {
                add++;
            }

        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = numIndexMap.get(arr[i]);
        }

        return result;

    }


    public static ListNode listnodeadd(ListNode l1, ListNode l2) {

        int add1 = getAdd(l1, 0, getsize(l1));
        int add2 = getAdd(l2, 0, getsize(l2));

        int add = add1 + add2;

        return numToListNode(null, add, 0);
    }

    private static int getAdd(ListNode listNode, int before, int index) {

        int current = (int) (before + listNode.val * Math.pow(10, index - 1));

        if (listNode.next == null) {
            return current;
        }
        return getAdd(listNode.next, current, index - 1);

    }

    private static ListNode numToListNode(ListNode listNode, int num, int index) {

        if (listNode == null) {
            listNode = new ListNode(num % 10);
            return numToListNode(listNode, num, index + 1);
        }

        int current = (int) (num / Math.pow(10, index));
        int value = current % 10;
        if (current == 0) {
            return listNode;
        }

        ListNode nextlistNode = new ListNode(value);

        ListNode nexttt = listNode;
        while (nexttt.next != null) {
            nexttt = listNode.next;
        }
        nexttt.next = nextlistNode;

        return numToListNode(listNode, num, index + 1);
    }

    private static int getsize(ListNode listNode) {

        int count = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            count++;
        }

        return count;
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int index = -1;
        int length = 0;
        char[] charList = s.toCharArray();

        for (int i = 0; i < charList.length; i++) {

            if (i != 0) {
                hashSet.remove(charList[i - 1]);
            }

            while (index + 1 < charList.length && !hashSet.contains(charList[index + 1])) {

                hashSet.add(charList[index + 1]);
                index++;
            }
            length = Math.max(length, index - i + 1);
        }

        return length;
    }

    public int lengthOfLongestSubstring3(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();

        int max = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {

            if (hashMap.containsKey(chars[i])) {
                left = Math.max(left, hashMap.get(chars[i]) + 1);
            }
            hashMap.put(chars[i], i);
            max = Math.max(max, i - left + 1);

        }

        return max;
    }


    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                int addValue = leftValue + rightValue;
                if (addValue == target) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(leftValue);
                    arrayList.add(rightValue);
                    result.add(arrayList);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (addValue < target) {
                    left++;
                } else if (addValue > target) {
                    right--;
                }

            }

        }

        return result;
    }

    public void setZeroes(int[][] matrix) {

        if (matrix == null) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxlength = 1;

        int length = s.length();
        boolean[][] isPalind = new boolean[length][length];

        for (int right = 1; right < s.length(); right++) {

            for (int left = 0; left < right; left++) {

                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }

                if (right - left <= 2) {
                    isPalind[left][right] = true;
                } else {
                    isPalind[left][right] = isPalind[left + 1][right - 1];
                }

                if (isPalind[left][right] && right - left + 1 > maxlength) {
                    maxlength = right - left + 1;
                    start = left;
                }
            }

        }
        return s.substring(start, start + maxlength);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;

        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            sum = carry;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(sum % 10);
            carry = sum / 10;
            pre = pre.next;
        }

        return listNode.next;

    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode oddCurrent = oddNode;

        ListNode eventNode = head.next;
        ListNode eventCurrent = eventNode;

        while (eventCurrent != null && eventCurrent.next != null) {
            oddCurrent.next = oddCurrent.next.next;
            eventCurrent.next = eventCurrent.next.next;

            oddCurrent = oddCurrent.next;
            eventCurrent = eventCurrent.next;

        }
        oddCurrent.next = eventNode;

        return oddNode;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        inoder(root, result);
        return result;

    }

    private void inoder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        inoder(treeNode.left, result);
        result.add(treeNode.val);
        inoder(treeNode.right, result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        zigzag(root, result, 0);

        return result;
    }

    private void zigzag(TreeNode treeNode, List<List<Integer>> result, int level) {

        if (treeNode == null) {
            return;
        }

        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }

        if (level % 2 == 0) {
            result.get(level).add(treeNode.val);
        } else {
            result.get(level).add(0, treeNode.val);
        }
        zigzag(treeNode.left, result, level + 1);
        zigzag(treeNode.right, result, level + 1);

    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {

            return -1;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                }

                dfs(grid, i, j);

            }

        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {

        if (grid == null || i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }

    static int target2 = -1;
    static int count;

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        count = k;
        findk(root);
        return target2;
    }

    private static void findk(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        System.out.println("value1 = " + treeNode.val + " count = " + count);
        findk(treeNode.left);
        System.out.println("count --");

        if (--count == 0) {
            System.out.println("return");
            target2 = treeNode.val;
            return;
        }

        System.out.println("value2 = " + treeNode.val + " count = " + count);
        findk(treeNode.right);

    }

    public int uniquePaths(int m, int n) {

        int[][] num = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) {
                    num[i][j] = 1;
                    continue;
                }

                num[i][j] = num[i - 1][j] + num[i][j - 1];

            }
        }

        return num[m - 1][n - 1];

    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    min = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[amount] > amount ? -1 : dp[amount];
//
//        int[] dp = new int[amount+1];
//        for(int i = 1;i<=amount;i++){
//            int min = Integer.MAX_VALUE;
//            for(int coin: coins){
//                if(i>=coin && dp[i-coin] < min){
//                    min = dp[i-coin] + 1;
//                }
//            }
//            dp[i] = min;
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 0) {
            return 0;
        }

        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }

        }

        return profit;
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[left] != nums[i]) {
                nums[++left] = nums[i];
            }
        }

        return ++left;

    }

    public void rotate(int[] nums, int k) {

        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }


        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % copy.length] = copy[i];
        }

    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                return true;
            }

        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (!hashSet.add(nums[i])) {
                return true;
            }

        }
        return false;
    }

    public void reverseString(char[] s) {

        if (s == null || s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }

    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void reverseString2(char[] s) {

        if (s == null || s.length <= 1) {
            return;
        }
        int index = s.length / 2;
        char temp;
        for (int i = 0; i < index; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

    }


    public boolean isPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }

            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        while (head != null) {
            length++;
        }

        if (length - n == 0) {
            return head.next;
        }

        ListNode node = head;
        for (int i = 0; i < length; i++) {
            if (length - n - 1 == 0) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;


        return head;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = null;
        while (head != null) {
            ListNode temp2 = head.next;
            head.next = temp;

            temp = head;
            head = temp2;

        }

        return temp;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode reverse = reverseList2(next);
        next.next = head;
        head.next = null;

        return reverse;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode newListNode = new ListNode();
        ListNode current = newListNode;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;

        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return newListNode.next;


    }

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    public int majorityElement(int[] nums) {

        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            if (count == 0) {
                count++;
                result = nums[i];
            } else if (result != current) {
                count--;
            } else {
                count++;
            }

        }

        return result;

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int col = matrix[0].length;
        int row = matrix.length;

        int startCol = col - 1;
        int startRow = 0;

        while (startRow <= row - 1 && startCol >= 0) {

            int current = matrix[startRow][startCol];
            if (current == target) {
                return true;
            }

            if (target > current) {
                startRow++;
            } else {
                startCol--;
            }

        }

        return false;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;

        while (j >= 0) {

            nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Object, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char charAt = s.charAt(i);
            int orDefault = hashMap.getOrDefault(charAt, 0);
            hashMap.put(charAt, orDefault + 1);

        }

        for (int i = 0; i < t.length(); i++) {

            char charAt = t.charAt(i);
            int orDefault = hashMap.getOrDefault(charAt, 0);
            hashMap.put(charAt, orDefault - 1);

            if (hashMap.get(charAt) == 0) {
                hashMap.remove(charAt);
            }

        }

        return hashMap.isEmpty();

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] booleans = new boolean[s.length() + 1];
        booleans[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (String word : wordDict) {
                if (i >= word.length() && s.substring(i - word.length(), i).equals(word)
                        && booleans[i - word.length()]) {
                    booleans[i] = true;
                    break;
                }

            }

        }

        return booleans[s.length()];

    }

    public void moveZeroes(int[] nums) {

        int index = 0;

        for (int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }

        for (int i = index; i < nums.length; i++) {

            nums[i] = 0;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int firstUniqChar(String s) {

        char[] chars = s.toCharArray();

        HashMap<Object, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char charAt = s.charAt(i);
            int orDefault = hashMap.getOrDefault(charAt, 0);
            hashMap.put(charAt, orDefault + 1);

        }


        for (int i = 0; i < chars.length; i++) {
            char charAt = s.charAt(i);
            Integer integer = hashMap.get(charAt);
            if (integer == 1) {
                return i;
            }

        }

        return -1;
    }

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int n : nums) {
            if (n < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * n, n);
            min = Math.min(min * n, n);

            result = Math.max(result, max);

        }

        return result;

    }

    public boolean isValidSudoku(char board[][]) {
        int length = board.length;
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i)
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                shift = 1 << (board[i][j] - '0');
                int k = (i / 3) * 3 + j / 3;
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0)
                    return false;
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val <= root.left.val || root.right != null && root.val >= root.right.val) {
            return false;

        }
        return isValidBST(root.left) && isValidBST(root.right);

    }

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//        if (root == null)
//            return true;
//        if (root.val >= maxVal || root.val <= minVal){
//            return false;
//        }
//        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//    }

    public boolean isValidBSTw(TreeNode root) {

        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode rigth = root.right;

        boolean leftResult = left == null || left.val < root.val;
        boolean rightResult = rigth == null || rigth.val > root.val;

        if (leftResult && rightResult) {
            return isValidBSTw(root.left) && isValidBSTw(root.right);
        }
        return false;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth2(root.left, 1);
        int right = maxDepth2(root.right, 1);

        return Math.max(left, right);

    }

    public int maxDepth2(TreeNode root, int index) {

        if (root == null) {
            return index;
        }

        index++;
        int left = maxDepth2(root.left, index);
        int right = maxDepth2(root.right, index);

        return Math.max(left, right);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxPrice = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {

            min = Math.min(prices[i], min);
            maxPrice = Math.max(maxPrice, prices[i] - min);

        }

        return maxPrice;
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode index = head;
        ListNode index2 = head;
        while (index != null && index.next != null && index2 != null && index2.next != null) {

            index = index.next;
            index2 = index2.next.next;
            if (index == index2) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum(int[] nums, int k) {

        int length = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int res = 0, sum1 = 0;
        for (int i = 0; i < length; i++) {

            sum1 = sum1 + nums[i];
            int sum2 = sum1 - k;
            if (hashMap.containsKey(sum2)) {
                res += hashMap.get(sum2);
            }

            hashMap.put(sum1, hashMap.getOrDefault(sum1, 0) + 1);

        }

        return res;

    }

    public int strStr(String haystack, String needle) {
        int length = needle.length();
        int total = haystack.length() - length + 1;

        for (int i = 0; i < total; i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs == null) {
            return "";
        }

        String result = "";
        String start1 = strs[0];

        for (int i = 0; i < start1.length(); i++) {

            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].length() <= i || strs[j + 1].length() <= i) {
                    return result;
                }
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {

                    return result;
                }
            }
            result = result + start1.charAt(i);
        }

        return result;
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = revert(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;

    }

    private ListNode revert(ListNode head) {

        ListNode pre = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> arrayList = new ArrayList<>();

        addValue(arrayList, root, 0);
        return arrayList;

    }

    private void addValue(ArrayList<List<Integer>> list, TreeNode treeNode, int level) {

        if (treeNode == null) {
            return;
        }

        if (level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(treeNode.val);
        addValue(list, treeNode.left, level + 1);
        addValue(list, treeNode.right, level + 1);

    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            current = Math.max(current, 0) + nums[i];
            max = Math.max(max, current);
        }

        return max;

    }

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        int pre = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            int cur = getValue(s.charAt(i));
            if (pre < cur) {
                sum -= pre;
            } else {
                sum += pre;
            }

            pre = cur;

        }

        sum += pre;
        return sum;
    }

    public int getValue(char key) {

        switch (key) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int length = height.length;
        int left = 0;
        int right = length - 1;
        int max = 0;

        while (left < right) {

            max = height[left] < height[right] ? Math.max(max, (right - left) * height[left++]) : Math.max(max, (right - left) * height[right--]);
        }

        return max;
    }

//'('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('?', '?');

        if (!hashMap.containsKey(s.charAt(0))) {
            return false;
        }

        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('?');

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (hashMap.get(cur) != null) {
                linkedList.add(cur);
            } else if (hashMap.get(linkedList.removeLast()) != cur) {
                return false;
            }

        }

        return linkedList.size() == 1;

    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        if (digits.equals("")) {
            return result;
        }
        addnum(result, 0, digits, "");
        return result;
    }

    private void addnum(List<String> result, int index, String digits, String item) {

        if (index == digits.length()) {
            result.add(item);
            return;
        }

        char charAt = digits.charAt(index);
        String aaa = letterMap[charAt - '0'];

        for (int i = 0; i < aaa.length(); i++) {

            addnum(result, index + 1, digits, item + aaa.charAt(i));
        }

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {

            return result;
        }

        for (int i = 0; i < numRows; i++) {

            List<Integer> item = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    item.add(1);
                } else {
                    item.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(item);
        }

        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<Integer> hashSet = new HashSet<>();

        while (headA != null) {
            boolean add = hashSet.add(headA.val);
            if (!add) {
                return headA.next;
            }
            headA = headA.next;

            if (headB != null) {
                boolean add2 = hashSet.add(headB.val);
                if (!add2) {
                    return headB.next;
                }
            }

            headB = headB.next;
        }

        return null;

    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int search(int[] nums, int target) {

        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }


    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;

        for (int i = 0; i < lists.length; i++) {

            result = mergeTwoLists2(result, lists[i]);
        }

        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode temp = new ListNode(-1);
        ListNode p = temp;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {

            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return temp.next;

    }

    public static ListNode mergeKLists2(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );

        for (ListNode item : lists) {
            if (item != null) {
                priorityQueue.add(item);
            }
        }

        while (!priorityQueue.isEmpty()) {

            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;

    }

    public ListNode middleNode2(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null && slow.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;


    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2) {
            if (head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }

            if (head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }

        return head1;

    }

    public int removeDuplicates2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;

        }

        return slow++;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {

            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }


        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;

        }

        return slow;
    }

    public int[] twoSum3(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }

    public void reverseString3(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public String longestPalindrome2(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {

            String s1 = currentS(s, i, i);
            String s2 = currentS(s, i, i + 1);

            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;

        }

        return result;

    }

    public String currentS(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode treeNode = new TreeNode(root1.val + root2.val);

        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);

        return treeNode;
    }


    public boolean isValid2(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                chars.push(current);
            } else {

                if (!chars.empty() && chars.peek() == leftOf(current)) {
                    chars.pop();
                } else {
                    return false;
                }

            }

        }

        return chars.empty();

    }

    public Character leftOf(char current) {

        if (current == ')') {
            return '(';
        } else if (current == '}') {
            return '{';

        } else if (current == ']') {
            return '[';
        }
        return ' ';

    }

    public int minAddToMakeValid(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int need = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (current == '(') {
                need++;
            } else if (current == ')') {
                need--;

                if (need == -1) {
                    need = 0;
                    right++;
                }

            }
        }

        return need + right;

    }

    public int minInsertions(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int need = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            if (current == '(') {
                need += 2;
                if (need % 2 == 1) {
                    right++;
                    need--;
                }

            } else if (current == ')') {
                need--;
                if (need == -1) {
                    need = 1;
                    right++;
                }

            }
        }

        return need + right;

    }

    private int max = 0;

    public int maxDepth3(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth3(root.left);
        int right = maxDepth3(root.right);

        max = Math.max(left, right) + 1;

        return max;

    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        maxDiameter(root);
        return maxDiameter;

    }


    public int maxDiameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);

        int temp = left + right;
        maxDiameter = Math.max(maxDiameter, temp);

        return Math.max(left, right) + 1;

    }

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;

        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;

        }
        return reverseNum == x || x == reverseNum / 10;

    }

    public int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int aa = x % 10;
            int newres = result * 10 + aa;
            result = newres;
            x = x / 10;

        }

        return result;
    }


    public static void main(String[] aa) {
//        lists = [[1,4,5],[1,3,4],[2,6]]

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node7.next = node8;


        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = node1;
        listNodes[1] = node4;
        listNodes[2] = node7;

        mergeKLists2(listNodes);


    }

    public int maxProfit333(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                result = Math.max(result, prices[i] - min);
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return result;
    }

}




