package model;

import java.io.Serializable;

public class Siri implements Serializable{
	private String before;
	private String after;
	private String msg="";
	private boolean ok=true;
	public Siri() {}
	public Siri(String before,String after) {
		this.before=before;
		this.after=after;
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

}
