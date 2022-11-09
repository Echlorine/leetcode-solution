class Solution2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int total_energy = 1, total_expe = initialExperience;
        for (int i = 0; i < energy.length; i++) {
            total_energy += energy[i];
        }
        // 训练精力所需要的时间
        int res = total_energy > initialEnergy ? total_energy - initialEnergy : 0;
        // 训练经验所需要的时间
        for (int i = 0; i < experience.length; i++) {
            if (total_expe > experience[i]) {
                total_expe += experience[i];
            } else {
                int temp = experience[i] - total_expe + 1;
                res += temp;
                total_expe += experience[i] + temp;
            }
        }
        return res;
    }
}