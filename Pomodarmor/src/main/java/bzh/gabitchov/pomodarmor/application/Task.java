package bzh.gabitchov.pomodarmor.application;

/**
 * The Class Task.
 */
public class Task implements ITask {

	/** The closed. */
	protected boolean closed = false;

	/** The label. */
	protected String label;

	/**
	 * Instantiates a new task.
	 *
	 * @param label
	 *            the label
	 */
	public Task(final String label) {
		super();
		this.label = label;
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
	public void setLabel(final String label) {
		this.label = label;

	}

}
