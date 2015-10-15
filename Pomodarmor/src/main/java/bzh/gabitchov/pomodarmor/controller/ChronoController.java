package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.Chrono;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.view.ChronoView;
import bzh.gabitchov.pomodarmor.view.IChronoView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * The Class ChronoController.
 */
public class ChronoController extends Chrono implements IChronoController {

	/** The parent. */
	private final IPomodarmorController parent;

	/** The view. */
	private IChronoView view;

	/**
	 * Instantiates a new chrono controller.
	 *
	 * @param pomodarmorController
	 *            the pomodarmor controller
	 */
	public ChronoController(final IPomodarmorController pomodarmorController) {
		parent = pomodarmorController;
		createView();

	}

	/**
	 * Creates the view.
	 */
	private void createView() {

		FXMLLoader loader = FXMLUtils.loadView(ChronoView.class, "Chrono.fxml");
		Node node = loader.<Node> getRoot();

		Pane parentNode = parent.getView().getPane();
		parentNode.getChildren().add(node);

		view = loader.<IChronoView> getController();
		view.setController(this);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#start()
	 */
	@Override
	public void start() {
		super.start();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#isStopped()
	 */
	@Override
	public boolean isStopped() {
		return super.isStopped();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#restart()
	 */
	@Override
	public void restart() {
		super.restart();
		view.changeStopButtonLabel("Stop");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#stop()
	 */
	@Override
	public void stop() {
		super.stop();
		view.changeStopButtonLabel("Restart");

	}

}
