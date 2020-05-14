package ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrToDateParser {

	private final String SEPARATOR = "[/-:]";

	private final String[] yyyyMMdd = {
			"^[0-9]{8}"
	};
	private final String[] HHmmss = {
			"[0-9]{6}$",
			"[0-9]{2}" + SEPARATOR + "[0-9]{2}" + SEPARATOR + "[0-9]{2}$"
	};
	private final String[] HHmm = {
			"[0-9]{4}$",
			"[0-9]{2}" + SEPARATOR + "[0-9]{2}$"
	};

	private final String[] HH = {
			"[0-9]{2}$"
	};

	private DateFormat format;

	private final Map<String,String> formatMap;

	public StrToDateParser() {
		formatMap = new HashMap<String,String>();
		formatMap.put("^[0-9]{8}","yyyyMMdd");

		formatMap.put("[0-9]{6}$","HHmmss");
		formatMap.put("[0-9]{2}" + SEPARATOR + "[0-9]{2}" + SEPARATOR + "[0-9]{2}$","HH:mm:ss");

		formatMap.put("[0-9]{4}$","HHmm");
		formatMap.put("[0-9]{2}" + SEPARATOR + "[0-9]{2}$","HH:mm");

		formatMap.put("[0-9]{2}$","HH");
	}

	public boolean validDate(String str) {

		String target = str.replaceAll("[/-]","");

		String yyyyMMddRegex = "";
		String HHmmssRegex = "";

		try {
			yyyyMMddRegex = yyyyMMddMatching(target);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		if(yyyyMMddRegex.isEmpty()) {
			return false;
		}

		try {
			HHmmssRegex = HHmmssMatching(target);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		String regex = yyyyMMddRegex + " " + HHmmssRegex;
		this.format = new SimpleDateFormat(regex.trim());

		return true;
	}

	public Date getDate(String str) throws ParseException {
		String target = str.replaceAll("[/-]","");
		try {
			//if failed parse String to Date , return null.
			return format.parse(target);

		} catch (ParseException e) {
			System.err.println("Invalid running. Please run validDate() beforehand.");
			throw e;
		}
	}

	private String yyyyMMddMatching(String target) throws ParseException {

		Node node = matchingRegex(target,yyyyMMdd);

		if(node.matching) {
			return node.regex;
		} else {
			//if don't any matching , return empty String.
			return "";
		}
	}

	private String HHmmssMatching(String target) throws ParseException {

		Node node;

		node = matchingRegex(target,HHmmss);
		if(node.matching) return node.regex;

		node = matchingRegex(target,HHmm);
		if(node.matching) return node.regex;

		node = matchingRegex(target,HH);
		if(node.matching) return node.regex;

		return "";

	}

	private Node matchingRegex(String target,String[] regex) throws ParseException {
		Node node = new Node();
		for(String r : regex) {
			Matcher m = Pattern.compile(r).matcher(target);
			if(m.find()) {
				node.regex = formatMap.get(r);
				node.group = m.group();
				node.parseTest();
				break;
			}
		}
		return node;
	}

	private class Node {
		String regex = "";
		String group = "";
		boolean matching = false;

		void parseTest() throws ParseException {
			DateFormat df = new SimpleDateFormat(regex);
			try {
				//if failed parse String to Date , return null.
				df.parse(group);
				matching = true;
			} catch (ParseException e) {
				System.out.println("invalid format :" + regex);
				throw e;
			}
		}
	}
 }
