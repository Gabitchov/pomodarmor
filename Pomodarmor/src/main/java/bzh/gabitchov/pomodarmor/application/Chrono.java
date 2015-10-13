package bzh.gabitchov.pomodarmor.application;

public class Chrono implements IChrono {

	public static int DEFAULT_TIME = 25000;

	private boolean stopped = false;

	public Chrono() {
		super();
	}

	public boolean isStopped() {
		return stopped;
	}

	public void stop() {
		stopped = true;
	}

	public void restart() {
		stopped = false;

	}

}
