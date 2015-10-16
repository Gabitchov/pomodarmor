package bzh.gabitchov.pomodarmor.controller;

import java.util.Observer;

import bzh.gabitchov.pomodarmor.application.Chrono;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.utils.ImageRegistry;
import bzh.gabitchov.pomodarmor.view.ChronoView;
import bzh.gabitchov.pomodarmor.view.IChronoView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Controller for Chrono.
 */
public class ChronoController extends Chrono implements IChronoController {

	/** The Constant RESTART_BUTTON_LABEL. */
	private static final String RESTART_BUTTON_LABEL = "Restart";

	/** The Constant PAUSE_BUTTON_LABEL. */
	private static final String PAUSE_BUTTON_LABEL = "Pause";

	/** The Constant STOP_BUTTON_LABEL. */
	private static final String STOP_BUTTON_LABEL = "Stop";

	/** The Constant START_BUTTON_LABEL. */
	private static final String START_BUTTON_LABEL = "Start";

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
		if (view instanceof Observer) {
			getTimer().addObserver(view);
		}
		ImageRegistry imageRegistry = ImageRegistry.getInstance();
		view.updateButton(ChronoView.ChronoButton.START, START_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.START_ICON_KEY), false);
		view.updateButton(ChronoView.ChronoButton.STOP, PAUSE_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.PAUSE_ICON_KEY), true);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#restart()
	 */
	@Override
	public void restart() {
		super.restart();
		ImageRegistry imageRegistry = ImageRegistry.getInstance();
		view.updateButton(ChronoView.ChronoButton.STOP, PAUSE_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.PAUSE_ICON_KEY), true);
		view.updateButton(ChronoView.ChronoButton.START, START_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.START_ICON_KEY), false);

	}

	@Override
	public void pause() {
		super.pause();
		ImageRegistry imageRegistry = ImageRegistry.getInstance();
		view.updateButton(ChronoView.ChronoButton.STOP, STOP_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.STOP_ICON_KEY), true);
		view.updateButton(ChronoView.ChronoButton.START, RESTART_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.RESTART_ICON_KEY), true);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Chrono#stop()
	 */
	@Override
	public void stop() {
		PomodarmorTimer timer = getTimer();
		if (null != timer) {
			if (view instanceof Observer) {
				timer.deleteObserver(view);
			}
			super.stop();
		}

		ImageRegistry imageRegistry = ImageRegistry.getInstance();
		view.updateButton(ChronoView.ChronoButton.START, START_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.START_ICON_KEY), true);
		view.updateButton(ChronoView.ChronoButton.STOP, STOP_BUTTON_LABEL,
				imageRegistry.getImage(ImageRegistry.STOP_ICON_KEY), false);
		view.resetDisplay();

	}

}
