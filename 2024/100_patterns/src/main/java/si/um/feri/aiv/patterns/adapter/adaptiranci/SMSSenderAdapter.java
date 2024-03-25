package si.um.feri.aiv.patterns.adapter.adaptiranci;

import si.um.feri.aiv.patterns.adapter.Obvescevalec;

public class SMSSenderAdapter extends Obvescevalec {

	SMSSender smss=new SMSSender();
	
	@Override
	public String obvestilo(String text) {
		smss.posljiSMS("00123", text);
		return "00123; sms: "+text;
	}
	
}
