package si.um.feri.aiv;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;

public class MyPage extends Page {
	
	private static final long serialVersionUID = -935765462070791645L;

	public MyPage() {
		add(new Label("message", "Hello World!"));
	}
	
}
