package bzh.gabitchov.pomodarmor.application;

/**
 * The Interface IChrono.
 */
public interface IChrono {

	/**
	 * Start.
	 */
	void start();

	/**
	 * Restart.
	 */
	void restart();

	/**
	 * Pause.
	 */
	void pause();

	/**
	 * Stop.
	 */
	void stop();

	/**
	 * Checks if is running.
	 *
	 * @return true, if is running
	 */
	boolean isRunning();

	/**
	 * Checks if is stopped.
	 *
	 * @return true, if is stopped
	 */
	boolean isStopped();

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	int getMinute();

	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	int getSecond();
}
