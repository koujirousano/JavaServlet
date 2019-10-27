package model;

public class SiriLogic {
	public void execute(Siri siri) {
		//System.out.println("before"+siri.getBefore()+":"+"after"+siri.getAfter());
		if(!siri.getAfter().startsWith(siri.getBefore().substring(siri.getBefore().length()-1))) {
			siri.setMsg("しりとりになってないのでNG");
			siri.setOk(false);
		}else if(siri.getAfter().endsWith("ん")) {
			siri.setMsg("「ん」が最後なのでNG");
			siri.setOk(false);
		}else {
			siri.setMsg("OK");
		}
	}
}
