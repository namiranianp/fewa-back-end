package com.usf.fewa.services.impl;
import java.util.ArrayList;
import com.usf.fewa.services.TagTestService;

public class TagTestServiceImpl implements TagTestService {

	public ArrayList<String> tags = new ArrayList<String>();
	
	public TagTestServiceImpl() {
		
		tags.add("test1");
		tags.add("test2");
		tags.add("test3");
		
	}
	
	@Override
	public String returnService(String tag) {
		
		String output = "";
		
		if(tag.startsWith("addTag-")) {
			
			if(!tags.contains(tag.substring(7))) {
				tags.add(tag.substring(7));
			}
			
		}
		if(tag.startsWith("deleteTag-")) {
			
			if(tags.contains(tag.substring(10))) {
				tags.remove(tag.substring(10));
			}
			
		}
			
		output += "{\"tags\":[";
		
		for(String tagName : tags) {
			
			output += "{\"tag\":\"" + tagName + "\"},";
			
		}
		output = output.substring(0, output.length() - 1);
		output += "]}";
			
		return output;
	}
}
