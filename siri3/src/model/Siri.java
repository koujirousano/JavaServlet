package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Siri implements Serializable{
	private String before="";
	private String after;
	private String msg="";
	private boolean ok=true;
	private List<String> wordList=new ArrayList<>();
	private String displayWord;


	public Siri() {}
	public Siri(String after) {
		this.after=after;
		wordList.add(after);
		this.displayWord=after;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public String getAfter() {
		return after;
	}
	public void setAfter(String after) {
		this.after = after;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<String> getWordList() {
		return wordList;
	}
	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}
	public String getDisplayWord() {
		return displayWord;
	}
	public void setDisplayWord(String displayWord) {
		this.displayWord = displayWord;
	}

}
