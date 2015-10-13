package bzh.gabitchov.pomodarmor.view;

import javafx.scene.layout.Pane;

public interface IView {

	Pane getPane();

	void setController(final Object controller);
}
