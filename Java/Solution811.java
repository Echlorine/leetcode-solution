class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str: cpdomains) {
            int num = Integer.valueOf(str.split(" ")[0]);
            String domain = str.split(" ")[1];
            String[] domains = domain.split("\\.");
            for (int i = 0; i < domains.length; i++) {
                map.put(domain, map.getOrDefault(domain, 0) + num);
                domain = domain.replaceFirst(domains[i] + ".", "");
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        return res;
    }
}