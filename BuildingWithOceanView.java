class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            int current = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] <= current) {
                stack.pop();
            }
            stack.push(i);
        }

        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
