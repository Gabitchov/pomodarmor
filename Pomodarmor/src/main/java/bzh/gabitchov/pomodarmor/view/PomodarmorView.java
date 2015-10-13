package bzh.gabitchov.pomodarmor.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PomodarmorView implements IPomodarmorView {

	private Scene scene = null;

	private Pane parent = null;

	public PomodarmorView() {
		createView();
	}

	private void createView() {
		parent = new VBox();
		scene = new Scene(parent, 340, 250);
	}

	@Override
	public Scene getScene() {
		return scene;
	}

	@Override
	public Pane getPane() {
		return parent;
	}

	@Override
	public void setController(Object controller) {

	}
}
