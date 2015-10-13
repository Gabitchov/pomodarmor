package bzh.gabitchov.pomodarmor.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bzh.gabitchov.pomodarmor.application.Chrono;
import bzh.gabitchov.pomodarmor.view.ChronoView;
import bzh.gabitchov.pomodarmor.view.IChronoView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ChronoController extends Chrono implements IChronoController {
	private final Logger log = LogManager.getLogger(ChronoController.class);

	private final IPomodarmorController parent;

	private IChronoView view;

	public ChronoController(final IPomodarmorController pomodarmorController) {
		parent = pomodarmorController;
		createView();

	}

	private void createView() {

		FXMLLoader loader = new FXMLLoader(ChronoView.class.getResource("Chrono.fxml"));
		Node node = null;
		try {
			node = loader.<Node> load();
		} catch (IOException e) {
			log.error(e);
		}

		Pane parentNode = parent.getView().getPane();
		parentNode.getChildren().add(node);

		Object controller = loader.getController();

		if (controller instanceof IChronoView) {
			view = (IChronoView) controller;
			((IChronoView) controller).setController(this);

		}

	}

	@Override
	public void start() {

	}

	@Override
	public boolean isStopped() {
		return super.isStopped();
	}

	@Override
	public void restart() {
		super.restart();
		view.changeStopButtonLabel("Stop");

	}

	@Override
	public void stop() {
		super.stop();
		view.changeStopButtonLabel("Restart");

	}

}
