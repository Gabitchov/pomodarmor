/**
 *
 */
package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.controller.IChronoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * @author g.pascual
 *
 */
public class ChronoView implements Initializable, IChronoView {

	@FXML
	private TextField chrono;

	@FXML
	private Button startButton;

	@FXML
	private Button stopButton;

	private IChronoController controller;

	private Pane pane;

	public ChronoView() {
		super();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		startButton.addEventHandler(ActionEvent.ACTION, event -> controller.start());
		stopButton.addEventHandler(ActionEvent.ACTION, event -> {
			if (controller.isStopped()) {
				controller.restart();
			} else {
				controller.stop();
			}
		});

	}

	@Override
	public void setController(final Object controller) {
		if (controller instanceof IChronoController) {
			this.controller = (IChronoController) controller;
		}

	}

	@Override
	public Pane getPane() {
		return pane;
	}

	@Override
	public void changeStopButtonLabel(final String string) {
		stopButton.setText(string);

	}

}
