package bzh.gabitchov.pomodarmor.application;

import java.net.URI;
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

	/**
	 * Checks if is dirty.
	 *
	 * @return true, if is dirty
	 */
	boolean isDirty();

	/**
	 * Sets the dirty.
	 *
	 * @param modified
	 *            the new dirty
	 */
	void setDirty(final boolean modified);

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	URI getLocation();

	/**
	 * Sets the location.
	 *
	 * @param newLocation
	 *            the new location
	 */
	void setLocation(final URI newLocation);;

	/**
	 * Save.
	 */
	void save();
}
