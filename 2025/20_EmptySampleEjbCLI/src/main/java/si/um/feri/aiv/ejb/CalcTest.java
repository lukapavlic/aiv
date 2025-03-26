package si.um.feri.aiv.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import si.um.feri.aiv.Calc;

import java.util.Properties;

public class CalcTest {

	// WF says:
	//
	// java:global/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:app/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:module/CalcBean!si.um.feri.aiv.Calc
	// java:jboss/exported/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// ejb:EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:global/EmptySampleEjb/CalcBean
	// java:app/EmptySampleEjb/CalcBean
	// java:module/CalcBean
	
	public static void main(String[] args) throws Exception {

		Properties props=new Properties();
		props.put("java.naming.factory.initial","org.wildfly.naming.client.WildFlyInitialContextFactory");
		props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
		props.put("jboss.naming.client.ejb.context","true");
		props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
		InitialContext ctx=new InitialContext(props);

		Calc c = (Calc) ctx.lookup("EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc");

		System.out.println(c.add(4, 5));

		System.out.println(c.getHistory());

		System.out.println(c.getLastCalculation());

		for (int i = 0; i < 5; i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}

		Runnable r=new Runnable() {
			@Override
			public void run() {
                Calc c = null;
                try {
                    c = (Calc) ctx.lookup("EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc");
                } catch (NamingException e) {
                    throw new RuntimeException(e);
                }
				c.add(0,0);
                for (int i=0;i<100;i++) {
					c.add(c.getHistory(),1.0);
					System.out.println(c.getHistory());
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
			}
		};

		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();



//		System.out.println("------------------------------");
//
//		Demo demo=(Demo) ctx.lookup("EmptySampleEjb/DemoBean!si.um.feri.aiv.ejb.Demo");
//		System.out.println(demo.racunaj(1, 2, 3));
		
	}

}
