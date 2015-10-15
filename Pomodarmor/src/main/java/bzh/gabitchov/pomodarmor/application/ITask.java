package bzh.gabitchov.pomodarmor.application;

/**
 * The Interface ITask.
 */
public interface ITask {

	/**
	 * Closed.
	 */
	void setClosed();

	/**
	 * Checks if is closed.
	 *
	 * @return true, if is closed
	 */
	boolean isClosed();

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	String getLabel();

	/**
	 * Sets the task.
	 *
	 * @param label
	 *            the new task
	 */
	void setLabel(final String label);

}
