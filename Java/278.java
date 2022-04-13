class Solution278{
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid = 0;
        while (left < right) {
            mid = left / 2 + right / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public boolean isBadVersion(int version) {
    // The isBadVersion API is defined in the parent class VersionControl.
    // 只是为了在本地IDE不出问题才这么写的
        if (version == 5) return true;
        return false;
    }
}