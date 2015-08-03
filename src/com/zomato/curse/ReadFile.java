package com.zomato.curse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.ahocorasick.trie.Trie;

public class ReadFile {
	
	public static Trie read(String fullPath, Trie trie){
		BufferedReader br = null;
		try {

			String cLine;

			br = new BufferedReader(new FileReader(fullPath));

			while ((cLine = br.readLine()) != null) {
				//System.out.println(cLine);
				if(cLine.length() > 0)
					trie.addKeyword(cLine.trim().toLowerCase());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		return trie;
	}
	
	

}
