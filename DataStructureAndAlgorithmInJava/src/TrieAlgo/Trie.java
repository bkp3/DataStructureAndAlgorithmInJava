package TrieAlgo;

import java.util.*;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode(); // root is empty
	}

	private class TrieNode {
		private TrieNode[] children;
		private boolean isWord;

		public TrieNode() {
			this.children = new TrieNode[26]; // storing english words - a -> z
			this.isWord = false;
		}
	}

	public void insert(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.isWord = true;

	}

	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}
		if (curr.isWord) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Trie obj = new Trie();
		obj.insert("cat");
		obj.insert("cab");
		obj.insert("son");
		obj.insert("so");
		System.out.println("values inserted successfully....");

	}

}
