/*
 *
 */
package bzh.gabitchov.pomodarmor.application;

import java.util.Observable;

/**
 * The Class Chrono.
 */
public class Chrono implements IChrono {

	/** The default time. */
	public static int DEFAULT_TIME = 25;

	/** The stopped. */
	private boolean stopped = false;

	private PomodarmorTimer timer;

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

	@Override
	public boolean isRunning() {
		return null != timer;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#stop()
	 */
	@Override
	public void stop() {
		timer.setBlincker(null);
		timer = null;
		stopped = true;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#restart()
	 */
	@Override
	public void restart() {

		Thread thread = new Thread(timer, "[Chrono] Restart");
		timer.setBlincker(thread);

		thread.start();
		stopped = false;

	}

	@Override
	public void pause() {
		timer.setBlincker(null);
		stopped = true;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#start()
	 */
	@Override
	public void start() {
		timer = new PomodarmorTimer();
		Thread thread = new Thread(timer, "[Chrono] Start");
		timer.setBlincker(thread);

		thread.start();
		stopped = false;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#getMinute()
	 */
	@Override
	public int getMinute() {
		return timer.getMinute();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IChrono#getSecond()
	 */
	@Override
	public int getSecond() {
		return timer.getSecond();
	}

	/**
	 * Gets the timer.
	 *
	 * @return the timer
	 */
	protected PomodarmorTimer getTimer() {
		return timer;
	}

	/**
	 * The Class PomodarmorTimer.
	 */
	public class PomodarmorTimer extends Observable implements Runnable {

		/** The blincker. */
		private volatile Thread blincker;

		/** The minute. */
		private int minute;

		/** The second. */
		private int second;

		/** The index. */
		private int index = 0;

		/**
		 * Instantiates a new pomodarmor timer.
		 */
		public PomodarmorTimer() {
			super();
		}

		/**
		 * Sets the blincker.
		 *
		 * @param caller
		 *            the new blincker
		 */
		public void setBlincker(final Thread caller) {
			blincker = caller;
		}

		@Override
		public void run() {
			int total = Chrono.DEFAULT_TIME * 60;

			Thread currentThread = Thread.currentThread();

			for (; blincker == currentThread && index < total; index++) {
				TimerChange change = new TimerChange();
				int modulo = index % 60;
				if (0 == modulo) {
					minute = index / 60;
					change.setChangeMinute();

				}

				try {
					Thread.sleep(1000);
					second = index - 60 * minute;
					change.setChangeSecond();
				} catch (InterruptedException e) {

				}
				setChanged();
				notifyObservers(change);
			}

			if (null != blincker) {
				index = 0;
			} else {
				index--;
			}

		}

		public int getMinute() {
			return minute;
		}

		public int getSecond() {
			return second;
		}

	}

	public class TimerChange {

		private boolean changeMinute = false;

		private boolean changeSecond = false;

		public TimerChange() {
			super();
		}

		public void setChangeMinute() {
			changeMinute = true;
		}

		public void setChangeSecond() {
			changeSecond = true;
		}

		public boolean isChangeMinute() {
			return changeMinute;
		}

		public boolean isChangeSecond() {
			return changeSecond;
		}
	}
}
