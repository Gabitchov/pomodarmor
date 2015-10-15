package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.ITask;
import javafx.beans.property.Property;

public interface ITaskController extends ITask {

	public Property<String> labelProperty();

	public Property<Boolean> closedProperty();
}
