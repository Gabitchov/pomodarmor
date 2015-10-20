package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.IPomodarmor;
import bzh.gabitchov.pomodarmor.view.IView;

/**
 * The Interface IPomodarmorController.
 */
public interface IPomodarmorController extends IPomodarmor {

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	IView getView();

	/**
	 * Run.
	 */
	void run();

	/**
	 * Save.
	 */
	void save();
}
