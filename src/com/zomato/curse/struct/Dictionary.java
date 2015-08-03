package com.zomato.curse.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ahocorasick.trie.Trie;

public class Dictionary {
	
	private Map<String, Trie> dictionary;
	
	public List<String> getAllLanguages(){
		Set<String> set = dictionary.keySet();
		
		List<String> languages = new ArrayList<String>();
		languages.addAll(set);
		return languages;
		
	}
	public Dictionary(){
		dictionary = new HashMap<String,Trie>();
	}
	
	public Trie get(String language){
		
		return dictionary.get(language);
		
	}
	
	public void set(String language, Trie trie){
		dictionary.put(language, trie);
	}
	

}
