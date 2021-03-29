package com.usf.fewa.services.impl;
import java.util.ArrayList;
import com.usf.fewa.services.TagTestService;

public class TagTestServiceImpl implements TagTestService {

	public ArrayList<String> JPEGtags = new ArrayList<String>();
	public ArrayList<String> MP4tags = new ArrayList<String>();
	public ArrayList<String> PDFtags = new ArrayList<String>();
	public ArrayList<String> PNGtags = new ArrayList<String>();
	public ArrayList<String> TXTtags = new ArrayList<String>();
	
	public TagTestServiceImpl() {
		
		JPEGtags.add("jpeg");
		MP4tags.add("mp4");
		PDFtags.add("pdf");
		PNGtags.add("png");
		TXTtags.add("txt");
		
	}
	
	@Override
	public String returnService(String tag) {
		
		String output = "";
		
		if(tag.startsWith("jpeg-addTag-")) {
			
			if(!JPEGtags.contains(tag.substring(7))) {
				JPEGtags.add(tag.substring(7));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : JPEGtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("mp4-addTag-")) {
			
			if(!MP4tags.contains(tag.substring(7))) {
				MP4tags.add(tag.substring(7));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : MP4tags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("pdf-addTag-")) {
			
			if(!PDFtags.contains(tag.substring(7))) {
				PDFtags.add(tag.substring(7));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : PDFtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("png-addTag-")) {
			
			if(!PNGtags.contains(tag.substring(7))) {
				PNGtags.add(tag.substring(7));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : PNGtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("txt-addTag-")) {
			
			if(!TXTtags.contains(tag.substring(7))) {
				TXTtags.add(tag.substring(7));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : TXTtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		
		
		
		if(tag.startsWith("jpeg-deleteTag-")) {
			
			if(JPEGtags.contains(tag.substring(10))) {
				JPEGtags.remove(tag.substring(10));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : JPEGtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("mp4-deleteTag-")) {
			
			if(MP4tags.contains(tag.substring(10))) {
				MP4tags.remove(tag.substring(10));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : MP4tags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("pdf-deleteTag-")) {
			
			if(PDFtags.contains(tag.substring(10))) {
				PDFtags.remove(tag.substring(10));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : PDFtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("png-deleteTag-")) {
			
			if(PNGtags.contains(tag.substring(10))) {
				PNGtags.remove(tag.substring(10));
			}
			
			output += "{\"tags\":[";
			
			for(String tagName : PNGtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
		if(tag.startsWith("txt-deleteTag-")) {
			
			if(TXTtags.contains(tag.substring(10))) {
				TXTtags.remove(tag.substring(10));
			}
		
			output += "{\"tags\":[";
			
			for(String tagName : TXTtags) {
				
				output += "{\"tag\":\"" + tagName + "\"},";
				
			}
			output = output.substring(0, output.length() - 1);
			output += "]}";
			
		}
			
		return output;
	}
}
