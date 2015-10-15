package bzh.gabitchov.pomodarmor.application;

import java.util.List;

/**
 * The Interface IDashboard.
 */
public interface IDashboard {

	/**
	 * Adds the task.
	 *
	 * @param task
	 *            the task
	 */
	void addTask(final ITask task);

	/**
	 * Removes the task.
	 *
	 * @param task
	 *            the task
	 */
	void removeTask(final ITask task);

	/**
	 * Closed task.
	 *
	 * @param task
	 *            the task
	 */
	void closeTask(final ITask task);

	/**
	 * Gets the tasks.
	 *
	 * @return the tasks
	 */
	List<ITask> getTasks();
}
