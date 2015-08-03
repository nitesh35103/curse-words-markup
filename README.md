# curse-words-markup
Curse Words Markup in Java


## Sample code
Main class is CurseWordMark. 

```
		CurseWordMarkup curse = new CurseWordMarkup();
		curse.load();
		
		List<CurseWord> words = curse.parse("Concha de tu madre auto erotic Hacer una paja Heroína fuck ass ");
		//List<CurseWord> words = curse.parse("Concha de tu madre auto erotic Hacer una paja Heroína fuck ass ", "es");
		List<CurseWord> cleanList = curse.cleanList(words);
		
		for(CurseWord word:cleanList){
			System.out.println( word.getWord() + "\t" + word.getStart() + "\t" + word.getEnd() + 
					"\t" + word.getLanguage());
		}
```
 

## Supporting library
[Shutter stock curse words library](https://github.com/shutterstock/List-of-Dirty-Naughty-Obscene-and-Otherwise-Bad-Words)
