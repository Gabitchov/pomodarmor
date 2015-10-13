/**
 * 
 */
package bzh.gabitchov.pomodarmor.controller;

import java.util.HashMap;
import java.util.Map;

import bzh.gabitchov.pomodarmor.application.IPomodarmor;
import bzh.gabitchov.pomodarmor.application.Pomodarmor;
import bzh.gabitchov.pomodarmor.view.IPomodarmorView;
import bzh.gabitchov.pomodarmor.view.IView;
import bzh.gabitchov.pomodarmor.view.PomodarmorView;
import javafx.application.Application;

/**
 * @author g.pascual
 *
 */
public class PomodarmorController extends Pomodarmor implements IPomodarmorController {

	private IPomodarmorView pomodarmorView = null;

	private IPomodarmor application = null;

	private final Map<String, Object> children = new HashMap<String, Object>();

	public PomodarmorController() {
		createView();
		createChildren();

	}

	private void createChildren() {

		children.put("Timer", new ChronoController(this));
	}

	private void createView() {
		pomodarmorView = new PomodarmorView();
		setContent(pomodarmorView.getScene());
	}

	@Override
	public IView getView() {
		return pomodarmorView;
	}

	@Override
	public void run() {
		// Only launch if the application is a Java FX application
		if (application instanceof Application) {
			Application.launch(Application.class.cast(this).getClass(), new String[0]);
		}
	}
}
