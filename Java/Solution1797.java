class AuthenticationManager {
    private int timeToLive;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        // if (!map.containsKey(tokenId)) map.put(tokenId, currentTime);
        map.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        int time = map.getOrDefault(tokenId, -1 - timeToLive) + timeToLive;
        if (time > currentTime) map.put(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int num = 0;
        for (String key : map.keySet()) {
            int time = map.get(key) + timeToLive;
            if (time > currentTime) num++;
        }
        return num;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */