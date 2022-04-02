import java.util.*;

class ParkingSystem {
    private List<Integer> big_nums;
    private List<Integer> med_nums;
    private List<Integer> sma_nums;
    private int bn;
    private int mn;
    private int sn;

    public ParkingSystem(int big, int medium, int small) {
        big_nums =  new ArrayList<>();
        med_nums =  new ArrayList<>();
        sma_nums =  new ArrayList<>();
        bn = big;
        mn = medium;
        sn = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) // big
            if (big_nums.size() < bn) {big_nums.add(1); return true;}
            else return false;
        else if (carType == 2) // medium
            if (med_nums.size() < mn) {med_nums.add(1); return true;}
            else return false;
        else // small
            if (sma_nums.size() < sn) {sma_nums.add(1); return true;}
            else return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */