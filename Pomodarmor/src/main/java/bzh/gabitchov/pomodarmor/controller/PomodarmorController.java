/**
 *
 */
package bzh.gabitchov.pomodarmor.controller;

import java.util.HashMap;
import java.util.Map;

import bzh.gabitchov.pomodarmor.application.IPomodarmor;
import bzh.gabitchov.pomodarmor.application.Pomodarmor;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.view.IPomodarmorView;
import bzh.gabitchov.pomodarmor.view.IView;
import bzh.gabitchov.pomodarmor.view.PomodarmorView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * @author g.pascual
 *
 */
public class PomodarmorController extends Pomodarmor implements IPomodarmorController {

	private IPomodarmorView view = null;

	private final IPomodarmor application = null;

	private final Map<String, Object> children = new HashMap<String, Object>();

	public PomodarmorController() {
		createView();
		createChildren();

	}

	private void createChildren() {

		children.put("Timer", new ChronoController(this));
		children.put("Dashboard", new DashboardController(this));
	}

	private void createView() {
		FXMLLoader loader = FXMLUtils.loadView(PomodarmorView.class, "Pomodarmor.fxml");
		view = loader.<IPomodarmorView> getController();
		view.setController(this);
	}

	@Override
	public IView getView() {
		return view;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		super.start(primaryStage);
		primaryStage.setScene(view.getScene());
		primaryStage.show();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.IPomodarmorController#run()
	 */
	@Override
	public void run() {
		// Only launch if the application is a Java FX application
		if (application instanceof Application) {
			Application.launch(Application.class.cast(this).getClass(), new String[0]);
		}
	}

	@Override
	public void stop() throws Exception {
		Object controller = children.get("Timer");
		if (controller instanceof IChronoController) {
			((IChronoController) controller).stop();
		}
		super.stop();
	}

}
