class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            // 不管三七二十一，只要不存在，先把当前名称放入哈希表中
            map.put(names[i], map.getOrDefault(names[i], -1) + 1);
            // 确定所能添加的后缀最大值
            int num = map.get(names[i]);
            res[i] = generateName(names[i], num);
            while (map.containsKey(res[i]) && !res[i].equals(names[i])) {
                map.put(names[i], map.get(names[i]) + 1);
                res[i] = generateName(names[i], map.get(names[i]));
            }
            // 进行新名称文件夹数量的更新
            if (!map.containsKey(res[i])) {
                map.put(res[i], 0);
            }
            // 确定无后缀的名称文件夹的数量
            if (names[i].matches(".*\\([0-9]\\)")) {
                String name = names[i].substring(0, names[i].length() - 3);
                int k = names[i].charAt(names[i].length() - 2) - '0';
                if (map.containsKey(name) && k == map.get(name) + 1) {
                    num = map.get(name);
                    map.put(name, ++num);
                }
            }
        }
        return res;
    }

    public String generateName(String name, int num) {
        if (num == 0) return name;
        return name + "(" + String.valueOf(num) + ")";
    }
}