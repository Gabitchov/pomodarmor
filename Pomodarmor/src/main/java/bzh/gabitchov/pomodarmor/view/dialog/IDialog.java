/*
 *
 */
package bzh.gabitchov.pomodarmor.view.dialog;

import bzh.gabitchov.pomodarmor.view.IView;
import javafx.stage.Window;

/**
 * The Interface IDialog.
 */
public interface IDialog extends IView {

	/**
	 * Sets the owner.
	 *
	 * @param window
	 *            the new owner
	 */
	void setOwner(final Window window);
}
