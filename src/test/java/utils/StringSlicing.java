package utils;

public class StringSlicing {
	
	public String slice_range(String s, int startIndex, int endIndex) {
	    if (startIndex < 0) startIndex = s.length() + startIndex;
	    if (endIndex < 0) endIndex = s.length() + endIndex;
	    return s.substring(startIndex, endIndex);
	}
}
