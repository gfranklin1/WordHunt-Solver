package WordHuntSolver;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			curr.children.putIfAbsent(ch, new Node());
			curr = curr.children.get(ch);
		}
		curr.isWord = true;
	}

	public boolean search(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			if (!curr.children.containsKey(ch)) {
				return false;
			}
			curr = curr.children.get(ch);
		}
		return curr.isWord;
	}

	public boolean startsWith(String prefix) {
		Node curr = root;
		for (char ch : prefix.toCharArray()) {
			if (!curr.children.containsKey(ch)) {
				return false;
			}
			curr = curr.children.get(ch);
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
