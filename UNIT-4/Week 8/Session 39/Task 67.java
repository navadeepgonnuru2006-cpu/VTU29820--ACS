import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        
        Map<String, List<String>> graph = new HashMap<>();

        
        Map<String, String> emailToName = new HashMap<>();

        
        for (List<String> account : accounts) {

            String name = account.get(0);
            String firstEmail = account.get(1);

            emailToName.put(firstEmail, name);
            graph.putIfAbsent(firstEmail, new ArrayList<>());

            for (int i = 2; i < account.size(); i++) {

                String email = account.get(i);

                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());

                
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        
        for (String email : graph.keySet()) {

            if (!visited.contains(email)) {

                List<String> mergedEmails = new ArrayList<>();

                dfs(email, graph, visited, mergedEmails);

                
                Collections.sort(mergedEmails);

                
                List<String> account = new ArrayList<>();
                account.add(emailToName.get(email));
                account.addAll(mergedEmails);

                result.add(account);
            }
        }

        return result;
    }

    
    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> mergedEmails) {

        visited.add(email);
        mergedEmails.add(email);

        for (String neighbor : graph.get(email)) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, mergedEmails);
            }
        }
    }
}
