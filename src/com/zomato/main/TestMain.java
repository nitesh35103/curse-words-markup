package com.zomato.main;

import java.util.Collection;
import java.util.List;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;

import com.zomato.curse.CurseWordMarkup;
import com.zomato.curse.CONST;
import com.zomato.curse.ReadFolder;
import com.zomato.curse.struct.CurseWord;

/**
 * 
 * @author nitesh 
 * 
 * CurseWordMarkup 
 *
 */
public class TestMain {

	public static void main(String[] args) {
		//Load the data
		CurseWordMarkup curse = new CurseWordMarkup();
		curse.load();
		
		List<CurseWord> words = curse.parse("Concha de tu madre auto erotic Hacer una paja Heroína fuck ass ");
		//List<CurseWord> words = curse.parse("Concha de tu madre auto erotic Hacer una paja Heroína fuck ass ", "es");
		List<CurseWord> cleanList = curse.cleanList(words);
		
		for(CurseWord word:cleanList){
			System.out.println( word.getWord() + "\t" + word.getStart() + "\t" + word.getEnd() + 
					"\t" + word.getLanguage());
		}
		

	}
	
		
	

}
