/**
 *
 */
package bzh.gabitchov.pomodarmor.view.dialog;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.controller.IDashboardController;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * @author g.pascual
 *
 */
public class DashboardLocationDialog implements IDialog, Initializable {

	/** The browse button. */
	@FXML
	private Button browseButton;

	/** The ok buuton. */
	@FXML
	private DialogPane pane;

	/** The ok type. */
	@FXML
	private ButtonType okType;

	@FXML
	private TextField uriLocation;

	/** The owner dialog. */
	private Window ownerDialog;

	/** Location. */
	private URI enterLocation;

	/** The controller. */
	private IDashboardController controller = null;

	/**
	 *
	 */
	public DashboardLocationDialog() {
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
		browseButton.addEventFilter(ActionEvent.ACTION,
				new EventHandler<Event>() {

					@Override
					public void handle(final Event event) {
						FileChooser chooser = new FileChooser();
						chooser.setSelectedExtensionFilter(
								new ExtensionFilter("Dashboard", "*.dash"));
						File file = chooser.showSaveDialog(ownerDialog);
						if (null != file) {
							enterLocation = file.toURI();
							uriLocation.setText(file.getAbsolutePath());
						}

					}
				});
		Button okButton = (Button) pane.lookupButton(okType);
		okButton.addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {

			@Override
			public void handle(final Event event) {
				controller.setLocation(enterLocation);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane()
	 */
	@Override
	public <T extends Pane> T getPane(final Class<T> paneType) {
		return paneType.isInstance(pane) ? paneType.cast(pane) : null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object newController) {
		if (newController instanceof IDashboardController) {
			controller = (IDashboardController) newController;
		}
	}

	@Override
	public void setOwner(final Window window) {
		ownerDialog = window;

	}

}
