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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

	/** The controller. */
	private IDashboardController controller;

	/** The parent. */
	private final Pane parent = null;

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
		addTask.setGraphic(imageRegistry.getImage(ImageRegistry.ADD_TASK_ICON_KEY));
		addTask.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				controller.addTask(new TaskController("Pipo"));

			}
		});

		removeTask.setGraphic(imageRegistry.getImage(ImageRegistry.REMOVE_TASK_ICON_KEY));
		removeTask.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				ITaskController task = (ITaskController) tasksView.getSelectionModel().getSelectedItem();
				controller.removeTask(task);
			}
		});

		TableColumn<ITask, String> labelColumn = new TableColumn<ITask, String>("Label");
		labelColumn.setId("dark-blue");
		labelColumn.setCellValueFactory(new PropertyValueFactory<ITask, String>("label"));
		labelColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<ITask, Boolean> closedColumn = new TableColumn<ITask, Boolean>("Closed");
		PropertyValueFactory<ITask, Boolean> value = new PropertyValueFactory<ITask, Boolean>("closed");
		closedColumn.setId("dark-blue");
		closedColumn.setCellValueFactory(value);
		closedColumn.setCellFactory(CheckBoxTableCell.forTableColumn(closedColumn));

		tasksView.getColumns().setAll(labelColumn, closedColumn);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#getPane()
	 */
	@Override
	public Pane getPane() {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.view.IView#setController(java.lang.Object)
	 */
	@Override
	public void setController(final Object controller) {
		if (controller instanceof IDashboardController) {
			this.controller = (IDashboardController) controller;
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
