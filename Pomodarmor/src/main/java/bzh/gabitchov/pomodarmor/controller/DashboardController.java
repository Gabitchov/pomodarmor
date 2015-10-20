package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.Dashboard;
import bzh.gabitchov.pomodarmor.application.ITask;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.view.DashboardView;
import bzh.gabitchov.pomodarmor.view.IDashboardView;
import bzh.gabitchov.pomodarmor.view.TaskView;
import bzh.gabitchov.pomodarmor.view.dialog.IDialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;

/**
 * The Class DashboardController.
 */
public class DashboardController extends Dashboard
		implements IDashboardController {

	/** The view. */
	private final IDashboardView view = null;

	/** The parent. */
	private final IPomodarmorController parent;

	/**
	 * Instantiates a new dashboard controller.
	 *
	 * @param controller
	 *            the controller
	 */
	public DashboardController(final IPomodarmorController controller) {
		super();
		this.parent = controller;
		createView();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.Dashboard#initialise()
	 */
	@Override
	protected void initialise() {
		super.initialise();
		setTasks(FXCollections.observableArrayList(getTasks()));
	}

	/**
	 * Creates the view.
	 */
	private void createView() {
		FXMLLoader loader = FXMLUtils.loadView(DashboardView.class,
				"Dashboard.fxml");
		Node node = loader.<Node> getRoot();

		Pane parentNode = parent.getView().getPane(Pane.class);
		parentNode.getChildren().add(node);

		IDashboardView view = loader.<IDashboardView> getController();
		view.setController(this);

		view.update();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.controller.IDashboardController#addTask(bzh.
	 * gabitchov.pomodarmor.controller.ITaskController)
	 */
	@Override
	public void addTask(final ITask task) {
		if (!"".equals(task.getLabel())) {
			super.addTask(task);
			setDirty(true);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.IDashboardController#remove(bzh.
	 * gabitchov.pomodarmor.controller.ITaskController)
	 */
	@Override
	public void removeTask(final ITask task) {
		if (null != task) {
			super.removeTask(task);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.Dashboard#closeTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void closeTask(final ITask task) {
		if (null != task) {
			super.closeTask(task);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.controller.IDashboardController#editTask(bzh.
	 * gabitchov.pomodarmor.application.ITask)
	 */
	@Override
	public void editTask(final ITask task) {
		if (null != task) {
			FXMLLoader loader = FXMLUtils.loadView(TaskView.class, "Task.fxml");

			IDialog controller = loader.<IDialog> getController();
			controller.setController(task);

			Dialog<?> dialogStage = new Dialog<ButtonType>();
			dialogStage.setDialogPane(controller.getPane(DialogPane.class));
			dialogStage.setTitle("Edit Task");

			dialogStage.showAndWait();

		}
	}

}
