/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // 得到域名
        String domain = getDomain(startUrl);
        System.out.println(domain);
        List<String> res = new ArrayList<>();
        // BFS
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Boolean> visited = new HashMap<>(); // 标记是否访问
        queue.offer(startUrl);
        visited.put(startUrl, true);
        res.add(startUrl);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (String url : htmlParser.getUrls(str)) { // 访问邻接结点
                if (visited.getOrDefault(url, false) || !getDomain(url).equals(domain)) continue;
                visited.put(url, true);
                queue.offer(url);
                res.add(url);
            }
        }
        return res;
    }

    public String getDomain(String url) {
        String s = url.split("/")[2];
        return s;
    }
}