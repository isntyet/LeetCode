class Solution {
    public String largestNumber(int[] nums) {
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(result, new LargerNumberComparator());

        if (result[0].equals("0")) {
            return "0";
        }

        String largestNumberStr = new String();
        for (String numAsStr : result) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
    
    class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}