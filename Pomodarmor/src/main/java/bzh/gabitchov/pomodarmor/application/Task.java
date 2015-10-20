package bzh.gabitchov.pomodarmor.application;

/**
 * The Class Task.
 */
public class Task implements ITask {

	/** The closed. */
	private boolean closed = false;

	/** The label. */
	private String label;

	/**
	 * Instantiates a new task.
	 *
	 * @param newLabel
	 *            the label
	 */
	public Task(final String newLabel) {
		super();
		this.label = newLabel;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.ITask#closed()
	 */
	@Override
	public void setClosed() {
		closed = true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.ITask#isClosed()
	 */
	@Override
	public boolean isClosed() {
		return closed;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.ITask#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.ITask#setTask(java.lang.String)
	 */
	@Override
	public void setLabel(final String newLabel) {
		this.label = newLabel;

	}

}
