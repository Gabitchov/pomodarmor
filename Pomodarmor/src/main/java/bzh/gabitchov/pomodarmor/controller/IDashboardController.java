package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.IDashboard;
import bzh.gabitchov.pomodarmor.application.ITask;

/**
 * The Interface IDashboardController.
 */
public interface IDashboardController extends IDashboard {

	/**
	 * Edits the task.
	 *
	 * @param task
	 *            the task
	 */
	void editTask(final ITask task);

}
