/**
 *
 */
package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.Task;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Controller for Task.
 *
 * @author g.pascual
 *
 */
public class TaskController extends Task implements ITaskController {

	/** The closed property. */
	private SimpleBooleanProperty closedProperty;

	/** The label property. */
	private SimpleStringProperty labelProperty;

	/**
	 * @param label
	 */
	public TaskController() {
		super("New Task");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.ITaskController#labelProperty()
	 */
	@Override
	public Property<String> labelProperty() {
		if (null == labelProperty) {
			labelProperty = new SimpleStringProperty(this, "label",
					getLabel()) {
				@Override
				public void set(final String newValue) {
					super.set(newValue);
					Object bean = getBean();
					if (bean instanceof ITaskController) {
						((ITaskController) bean).setLabel(newValue);
					}
				}
			};
		}
		return labelProperty;
	}

	@Override
	public Property<Boolean> closedProperty() {
		if (null == closedProperty) {
			closedProperty = new SimpleBooleanProperty(this, "closed",
					isClosed()) {
				@Override
				public void set(final boolean newValue) {
					super.set(newValue);
					Object bean = getBean();
					if (bean instanceof ITaskController) {
						((ITaskController) bean).setClosed();
					}
				}
			};
		}
		return closedProperty;
	}
}
