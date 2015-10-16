package bzh.gabitchov.pomodarmor.view;

import java.util.Observer;

import bzh.gabitchov.pomodarmor.view.ChronoView.ChronoButton;
import javafx.scene.image.ImageView;

/**
 * The Interface IChronoView.
 */
public interface IChronoView extends IView, Observer {

	/**
	 * Update button.
	 *
	 * @param button
	 *            the button
	 * @param label
	 *            the label
	 * @param icon
	 *            the icon
	 * @param enable
	 *            the enable
	 */
	void updateButton(final ChronoButton button, final String label, final ImageView icon, final boolean enable);

	/**
	 * Reset display.
	 */
	void resetDisplay();

}
