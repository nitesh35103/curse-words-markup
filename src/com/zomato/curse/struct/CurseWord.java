package com.zomato.curse.struct;

public class CurseWord {
	
	private String word;
	private int start; 
	private int end;
	private String language;
	
	
	public void set(String word, int start, int end){
		this.word = word;
		this.start = start;
		this.end = end;
		
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

}
