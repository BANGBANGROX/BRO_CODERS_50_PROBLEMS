import java.util.*;


class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
}

class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> convert = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();

        q.add(node);
        convert.put(node, new UndirectedGraphNode(node.label));

        while (!q.isEmpty()) {
            UndirectedGraphNode currentNode = q.poll();
            UndirectedGraphNode newNode = convert.get(currentNode);
            convert.put(currentNode, newNode);
            for (UndirectedGraphNode childNode : currentNode.neighbors) {
                UndirectedGraphNode convertedChild;
                if (convert.containsKey(childNode)) {
                    convertedChild = convert.get(childNode);
                }
                else {
                    convertedChild = new UndirectedGraphNode(childNode.label);
                    convert.put(childNode, convertedChild);
                    q.add(childNode);
                }
                newNode.neighbors.add(convertedChild);
            }
        }

        return convert.get(node);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
