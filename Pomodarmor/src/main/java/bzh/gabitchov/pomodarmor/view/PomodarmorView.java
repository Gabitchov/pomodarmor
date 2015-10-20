package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.controller.IPomodarmorController;
import bzh.gabitchov.pomodarmor.utils.ImageRegistry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

/**
 * The Class PomodarmorView.
 */
public class PomodarmorView implements Initializable, IPomodarmorView {

	/** The scene. */
	@FXML
	private Scene scene;

	/** The save menu. */
	@FXML
	private MenuItem saveMenu;

	/** The parent. */
	@FXML
	private Pane pane;

	/** The controller. */
	private IPomodarmorController controller = null;

	/**
	 * Instantiates a new pomodarmor view.
	 */
	public PomodarmorView() {
		super();
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		saveMenu.setGraphic(ImageRegistry.getInstance()
				.getImage(ImageRegistry.SAVE_ICON_KEY));
		saveMenu.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(final ActionEvent event) {
						controller.save();
					}
				});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IPomodarmorView#getScene()
	 */
	@Override
	public Scene getScene() {
		return scene;
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
		if (newController instanceof IPomodarmorController) {
			this.controller = (IPomodarmorController) newController;
		}
	}
}
