package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;

/**
 * The Class PomodarmorView.
 */
public class PomodarmorView implements Initializable, IPomodarmorView {

	/** The scene. */
	@FXML
	private Scene scene;

	@FXML
	private Menu fileMenu;

	/** The parent. */
	@FXML
	private Pane pane;

	/**
	 * Instantiates a new pomodarmor view.
	 */
	public PomodarmorView() {
		super();
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

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
	public Pane getPane() {
		return pane;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object controller) {

	}
}
