package WordHuntSolver;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }


    protected static class Node {
        protected Map<Character, Node> children;
        protected boolean isWord;

        protected Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }
}


