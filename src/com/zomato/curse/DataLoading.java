package com.zomato.curse;


import java.util.List;
import org.ahocorasick.trie.Trie;

import com.zomato.curse.struct.DataFile;
import com.zomato.curse.struct.Dictionary;

public class DataLoading {

	public void load(String path, Dictionary dictionary) {
		List<DataFile> files = ReadFolder.readFiles(path);

		for (DataFile file : files) {
			Trie trie = readData(file);
			dictionary.set(file.getLanguage(), trie);
		}
	}

	private Trie readData(DataFile file) {

		System.out.println("Loading : " + file.getLanguage());

		Trie trie = new Trie();
		trie.caseInsensitive();
		trie.onlyWholeWords();

		ReadFile.read(file.getPath(), trie);

		return trie;

	}

}
