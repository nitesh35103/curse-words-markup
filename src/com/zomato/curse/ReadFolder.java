package com.zomato.curse;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zomato.curse.struct.DataFile;

public class ReadFolder {
	
	
	
	public static List<DataFile> readFiles(String folderPath){
		List<String> ignoreList = Arrays.asList(new String[]{"LICENSE","README.md"});
		
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		
		List<DataFile> fileNames = new ArrayList<DataFile>();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if(ignoreList.contains(file.getName())){
		    		
		    	}
		    	else if (file.getName().startsWith(".")){
		    		
		    	}
		    	else{
		    		DataFile data = new DataFile();
		    		data.setLanguage(file.getName());
		    		data.setPath(folderPath + file.getName());
		    		fileNames.add(data);
		    	}
		    }
		}
		
		return fileNames;
	}

}
