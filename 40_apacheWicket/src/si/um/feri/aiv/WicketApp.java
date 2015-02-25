package si.um.feri.aiv;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApp extends WebApplication {

	@Override
	public RuntimeConfigurationType getConfigurationType() {
		return RuntimeConfigurationType.DEPLOYMENT;
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return MyPage.class;
	}
}
