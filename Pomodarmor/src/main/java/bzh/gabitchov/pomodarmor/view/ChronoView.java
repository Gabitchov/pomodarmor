/**
 *
 */
package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.application.Chrono.TimerChange;
import bzh.gabitchov.pomodarmor.controller.IChronoController;
import bzh.gabitchov.pomodarmor.utils.ImageRegistry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// TODO: Auto-generated Javadoc
/**
 * The Class ChronoView.
 *
 * @author g.pascual
 */
public class ChronoView implements Initializable, IChronoView {

	/** The chrono. */
	@FXML
	private TextField chrono;

	/** The start button. */
	@FXML
	private Button startButton;

	/** The stop button. */
	@FXML
	private Button stopButton;

	/** The controller. */
	private IChronoController controller;

	/** The pane. */
	private Pane pane;

	/**
	 * Instantiates a new chrono view.
	 */
	public ChronoView() {
		super();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */

	/**
	 * Initialise.
	 *
	 * @param location
	 *            the location
	 * @param resources
	 *            the resources
	 */
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

		// Initialise start button
		ImageRegistry instance = ImageRegistry.getInstance();
		startButton.setGraphic(instance.getImage(ImageRegistry.START_ICON_KEY));
		startButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {

				if (controller.isRunning() && controller.isStopped()) {
					controller.restart();
				} else {
					controller.start();

				}
			}
		});

		// Initialise stop button
		stopButton.setGraphic(instance.getImage(ImageRegistry.STOP_ICON_KEY));
		stopButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {
				if (controller.isStopped()) {
					controller.stop();
				} else {
					controller.pause();
				}
			}

		});

	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *            the new controller
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object controller) {
		if (controller instanceof IChronoController) {
			this.controller = (IChronoController) controller;
		}

	}

	/**
	 * Gets the pane.
	 *
	 * @return the pane
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane()
	 */
	@Override
	public Pane getPane() {
		return pane;
	}

	/**
	 * Update button.
	 *
	 * @param button
	 *            the button
	 * @param label
	 *            the label
	 * @param enable
	 *            the enable
	 */
	@Override
	public void updateButton(final ChronoButton button, final String label, final ImageView icon,
			final boolean enable) {
		switch (button) {
		case START:
			startButton.setText(label);
			startButton.setDisable(!enable);
			startButton.setGraphic(icon);
			break;
		case STOP:
			stopButton.setText(label);
			stopButton.setDisable(!enable);
			stopButton.setGraphic(icon);
			break;
		default:
			break;
		}
	}

	/**
	 * Reset display.
	 */
	@Override
	public void resetDisplay() {
		chrono.setText("00:00");
	}

	/**
	 * Update.
	 *
	 * @param o
	 *            the o
	 * @param arg
	 *            the arg
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(final Observable o, final Object arg) {
		String[] time = chrono.getText().split(":");
		String minute = time[0];
		String seconds = time[1];
		StringBuffer buffer = new StringBuffer();
		if (arg instanceof TimerChange) {
			if (((TimerChange) arg).isChangeMinute()) {
				int min = controller.getMinute();
				if (10 > min) {
					buffer.append(0);
				}
				buffer.append(controller.getMinute());
			} else {
				buffer.append(minute);
			}
			buffer.append(":");
			if (((TimerChange) arg).isChangeSecond()) {
				int second = controller.getSecond();
				if (10 > second) {
					buffer.append(0);
				}
				buffer.append(second);
			} else {

				buffer.append(seconds);
			}

		}

		chrono.setText(buffer.toString());
	}

	/**
	 * The Enum ChronoButton.
	 */
	public enum ChronoButton {

		/** The start. */
		START,
		/** The stop. */
		STOP;
	}

}
