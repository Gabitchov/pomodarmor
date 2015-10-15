/**
 *
 */
package bzh.gabitchov.pomodarmor.application;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Dashboard.
 *
 * @author g.pascual
 */
public class Dashboard implements IDashboard {

	/** The tasks list. */
	protected List<ITask> tasksList;

	/**
	 * Instantiates a new dashboard.
	 */
	public Dashboard() {
		super();
		initialise();

	}

	/**
	 * Initialise.
	 */
	protected void initialise() {
		tasksList = new ArrayList<ITask>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#getTasks()
	 */
	@Override
	public List<ITask> getTasks() {
		return tasksList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#addTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void addTask(final ITask task) {
		getTasks().add(task);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#removeTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void removeTask(final ITask task) {
		getTasks().remove(task);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#closedTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void closeTask(final ITask task) {
		task.setClosed();
	}

}
