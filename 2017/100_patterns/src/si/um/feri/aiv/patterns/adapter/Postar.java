package si.um.feri.aiv.patterns.adapter;

import si.um.feri.aiv.patterns.adapter.adaptiranci.MailSenderAdapter;
import si.um.feri.aiv.patterns.adapter.adaptiranci.SMSSenderAdapter;

public class Postar {

	//Poštar dela z obvešèevalcem
	//Novost sta SMSSender in MailSender - vkljuèimo ju z adapterjema
	
	//1. možnost: pri definiciji reference doloèimo, kateri adapter se uporablja
	Obvescevalec o;

	//2. možnost: še vedno kreiramo adapter v kodi, vendar na podlagi parametra
	public Postar(String obvescanjePreko) {
		if (obvescanjePreko.equals("sms")) o=new SMSSenderAdapter();
		if (obvescanjePreko.equals("mail")) o=new MailSenderAdapter();
		if (o==null) o=new Obvescevalec();
		
		o.obvestilo("Rojstvo poštarja: "+this);
	}
	
	//3. možnost: smo "odprti" za vse morebitne - morda še neobstojeèe - adapterje
	public Postar(Class<? extends  Obvescevalec> adapter) {
		try {
			o=adapter.newInstance();
		} catch (Exception e) {
			o=new Obvescevalec();
		}
		o.obvestilo("Rojstvo poštarja: "+this);
	}
	
	public Postar() {
		o=new Obvescevalec();
		o.obvestilo("Rojstvo poštarja: "+this);
	}
	
	public String prinesiPosto() {
		return o.obvestilo("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
