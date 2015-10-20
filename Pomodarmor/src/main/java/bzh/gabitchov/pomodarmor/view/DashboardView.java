/**
 *
 */
package bzh.gabitchov.pomodarmor.view;

import java.net.URL;
import java.util.ResourceBundle;

import bzh.gabitchov.pomodarmor.application.ITask;
import bzh.gabitchov.pomodarmor.controller.IDashboardController;
import bzh.gabitchov.pomodarmor.controller.ITaskController;
import bzh.gabitchov.pomodarmor.controller.TaskController;
import bzh.gabitchov.pomodarmor.utils.ImageRegistry;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableStringValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * @author g.pascual
 *
 */
public class DashboardView implements Initializable, IDashboardView {

	/** The tasks view. */
	@FXML
	private TableView<ITask> tasksView;

	/** The add button. */
	@FXML
	private Button addTask;

	/** The remove button. */
	@FXML
	private Button removeTask;

	/** The edit task. */
	@FXML
	private Button editTask;

	/** The controller. */
	private IDashboardController controller;

	/** The parent. */
	private final Pane parent = null;

	/** The value factory. */
	private PropertyValueFactory<ITask, String> valueFactory = null;

	/** The label column. */
	private TableColumn<ITask, String> labelColumn = null;

	/**
	 *
	 */
	public DashboardView() {
		super();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		ImageRegistry imageRegistry = ImageRegistry.getInstance();
		addTask.setGraphic(
				imageRegistry.getImage(ImageRegistry.ADD_TASK_ICON_KEY));
		addTask.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(final ActionEvent event) {

						controller.addTask(new TaskController());

					}
				});

		removeTask.setGraphic(
				imageRegistry.getImage(ImageRegistry.REMOVE_TASK_ICON_KEY));
		removeTask.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(final ActionEvent event) {
						ITaskController task = (ITaskController) tasksView
								.getSelectionModel().getSelectedItem();

						controller.removeTask(task);

					}
				});

		editTask.setGraphic(
				imageRegistry.getImage(ImageRegistry.EDIT_TASK_ICON_KEY));
		editTask.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(final ActionEvent event) {
						ITask task = tasksView.getSelectionModel()
								.getSelectedItem();
						ObservableValue<String> valueObs = valueFactory.call(
								new CellDataFeatures<ITask, String>(tasksView,
										labelColumn, task));
						controller.editTask(task);

						if (valueObs instanceof WritableStringValue) {
							((WritableStringValue) valueObs)
									.set(task.getLabel());
						}

					}

				});

		labelColumn = new TableColumn<ITask, String>("Label");

		valueFactory = new PropertyValueFactory<ITask, String>("label");

		labelColumn.setCellValueFactory(valueFactory);

		TableColumn<ITask, Boolean> closedColumn = new TableColumn<ITask, Boolean>(
				"Closed");

		closedColumn.setCellValueFactory(
				new PropertyValueFactory<ITask, Boolean>("closed"));
		closedColumn
				.setCellFactory(CheckBoxTableCell.forTableColumn(closedColumn));

		tasksView.getColumns().setAll(labelColumn, closedColumn);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane()
	 */
	@Override
	public <T extends Pane> T getPane(final Class<T> paneType) {
		return paneType.isInstance(parent) ? paneType.cast(parent) : null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object newController) {
		if (newController instanceof IDashboardController) {
			this.controller = (IDashboardController) newController;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IDashboardView#update()
	 */
	@Override
	public void update() {
		tasksView.setItems((ObservableList<ITask>) controller.getTasks());
	}

}
