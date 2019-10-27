package model;

public class SiriLogic {
	public void execute(Siri siri) {
		if(siri.getAfter().endsWith("ん")) {
			siri.setMsg("「ん」が最後なのでNG");
		}else if(!siri.getAfter().startsWith(siri.getBefore().substring(siri.getBefore().length()-1))) {
			siri.setMsg("しりとりになってないのでNG");
		}else {
			siri.setMsg("OK");
		}
	}
}
