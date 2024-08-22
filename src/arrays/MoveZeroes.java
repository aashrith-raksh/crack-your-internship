package arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int el = 0;
        int z = nums.length - 1;

        int ans[] = new int[nums.length];

        for (int i : nums) {

            if (i != 0) {
                ans[el] = i;
                el++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

        return;

    }

}
