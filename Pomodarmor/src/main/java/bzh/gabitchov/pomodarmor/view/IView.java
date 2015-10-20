package bzh.gabitchov.pomodarmor.view;

import javafx.scene.layout.Pane;

/**
 * The Interface IView.
 */
public interface IView {

	/**
	 * Gets the pane.
	 *
	 * @param <T>
	 *            the generic type
	 * @param paneType
	 *            the pane type
	 * @return the pane
	 */
	<T extends Pane> T getPane(Class<T> paneType);

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *            the new controller
	 */
	void setController(final Object controller);
}
