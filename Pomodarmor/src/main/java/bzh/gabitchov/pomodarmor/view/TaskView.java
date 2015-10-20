/**
 *
 */
package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.controller.ITaskController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

/**
 * View controller for Task.
 *
 * @author g.pascual
 */
public class TaskView implements ITaskView, Initializable {

	/** The pane. */
	@FXML
	private DialogPane pane;

	/** The label field. */
	@FXML
	private TextField labelField;

	/** The finish button. */
	@FXML
	private ButtonType finishButton;

	/** The controller. */
	private ITaskController controller;

	/**
	 * Instantiates a new task view.
	 */
	public TaskView() {
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

		Button button = (Button) pane.lookupButton(finishButton);
		button.addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {

			@Override
			public void handle(final Event event) {
				controller.setLabel(labelField.getText());
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object newController) {
		if (newController instanceof ITaskController) {
			controller = (ITaskController) newController;
			labelField.setText(controller.getLabel());
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane(java.lang.Class)
	 */
	@Override
	public <T extends Pane> T getPane(final Class<T> paneType) {
		return paneType.isInstance(pane) ? paneType.cast(pane) : null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.dialog.IDialog#setOwner(javafx.stage.
	 * Window)
	 */
	@Override
	public void setOwner(final Window window) {
		// No dialog to open
	}

}
