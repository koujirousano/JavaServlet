package model;

public class JKLogic {
	public void execute(Jyanken jk,String handNo) {
		String[] handName= {"グー","チョキ","パー"};
		int userHandNo=Integer.parseInt(handNo);
		int pcHandNo=(int)(Math.random()*handName.length);
		jk.setUserHand(handName[userHandNo]);
		jk.setPcHand(handName[pcHandNo]);
		int mod=(userHandNo-pcHandNo+3)%3;
		if(mod==0) {
			jk.setResult("あいこ");
		}else if(mod==2) {
			jk.setResult("あなたの勝ち");
			jk.setWin(jk.getWin()+1);
		}else {
			jk.setResult("あなたの負け");
			jk.setLose(jk.getLose()+1);
		}
	}

}
