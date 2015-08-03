package com.zomato.curse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import com.zomato.curse.struct.CurseWord;
import com.zomato.curse.struct.Dictionary;

public class CurseWordMarkup {

	private static Dictionary dictionary;
	public CurseWordMarkup() {
		dictionary = new Dictionary();
	}

	
	/*
	 * Load the curseword files in Dictionary
	 */
	public void load() {

		DataLoading load = new DataLoading();
		load.load(CONST.FOLDER_PATH, dictionary);

	}
	

	/*
	 *  Parse the content from all the languages
	 */
	public List<CurseWord> parse(String input) {

		List<String> langauges = dictionary.getAllLanguages();

		List<CurseWord> wordlist = new ArrayList<CurseWord>();

		for (String lang : langauges) {
			wordlist.addAll(parseInternal(input, lang));
		}
		return wordlist;
	}

	
	/*
	 *  Parse content from given language only
	 */
	public List<CurseWord> parse(String input, String language) {
		// System.out.println(language);
		List<CurseWord> wordlist = null;
		if (language == null) {
			return parse(input);
		} else {
			wordlist = parseInternal(input, language);
		}

		return wordlist;

	}

	/*
	 * Clean the list of words by removing similar words from different language.
	 */
	public List<CurseWord> cleanList(List<CurseWord> words) {

		List<CurseWord> cleanList = new ArrayList<CurseWord>();

		for (CurseWord word : words) {
			CurseWord newWord = new CurseWord();
			newWord.set(word.getWord(), word.getStart(), word.getEnd());

			if (check(newWord, cleanList)) {
				cleanList.add(newWord);
			}
		}
		return cleanList;
	}
	

	private boolean check(CurseWord word, List<CurseWord> words) {
		for (CurseWord w : words) {
			if (w.getWord().equals(word.getWord())) {
				if (w.getStart() == word.getStart()
						&& w.getEnd() == word.getEnd()) {
					return false;
				}
			}
		}
		return true;
	}

	
	private List<CurseWord> parseInternal(String input, String language) {
		
		List<CurseWord> wordset = new ArrayList<CurseWord>();
		
		Trie trie = dictionary.get(language);
		if(trie != null){
			Collection<Emit> emits = trie.parseText(input);
			
			for (Emit emit : emits) {
		
				CurseWord word = new CurseWord();
				word.setWord(emit.getKeyword());
				word.setStart(emit.getStart());
				word.setEnd(emit.getEnd());
				word.setLanguage(language);

				wordset.add(word);
			}		
		}
		return wordset;
		
		
	}

}
