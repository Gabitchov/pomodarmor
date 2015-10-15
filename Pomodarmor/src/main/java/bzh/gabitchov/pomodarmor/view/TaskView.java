/**
 *
 */
package bzh.gabitchov.pomodarmor.view;

import bzh.gabitchov.pomodarmor.controller.ITaskController;
import javafx.scene.layout.Pane;

/**
 * @author g.pascual
 *
 */
public class TaskView implements ITaskView {

	/** The controller. */
	private final ITaskController controller;

	/**
	 *
	 */
	public TaskView(final ITaskController controller) {
		super();
		this.controller = controller;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane()
	 */
	@Override
	public Pane getPane() {
		return null;
	}

	@Override
	public void setController(final Object controller) {

	}

}
