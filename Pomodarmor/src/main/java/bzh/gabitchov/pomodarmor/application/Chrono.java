/*
 *
 */
package bzh.gabitchov.pomodarmor.application;

/**
 * The Class Chrono.
 */
public class Chrono implements IChrono {

	/** The default time. */
	public static int DEFAULT_TIME = 25000;

	/** The stopped. */
	private boolean stopped = false;

	/**
	 * Instantiates a new chrono.
	 */
	public Chrono() {
		super();
	}

	/**
	 * Checks if is stopped.
	 *
	 * @return true, if is stopped
	 */
	public boolean isStopped() {
		return stopped;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#stop()
	 */
	@Override
	public void stop() {
		stopped = true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#restart()
	 */
	@Override
	public void restart() {
		stopped = false;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#start()
	 */
	@Override
	public void start() {
		stopped = false;

	}

}
