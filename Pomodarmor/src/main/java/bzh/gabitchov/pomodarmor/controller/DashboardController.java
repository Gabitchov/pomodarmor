package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.Dashboard;
import bzh.gabitchov.pomodarmor.application.ITask;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.view.DashboardView;
import bzh.gabitchov.pomodarmor.view.IDashboardView;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * The Class DashboardController.
 */
public class DashboardController extends Dashboard implements IDashboardController {

	/** The view. */
	private final IDashboardView view = null;

	/** The parent. */
	private final IPomodarmorController parent;

	/**
	 * Instantiates a new dashboard controller.
	 */
	public DashboardController(final IPomodarmorController parent) {
		super();
		this.parent = parent;
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
		tasksList = FXCollections.observableArrayList(tasksList);
	}

	/**
	 * Creates the view.
	 */
	private void createView() {
		FXMLLoader loader = FXMLUtils.loadView(DashboardView.class, "Dashboard.fxml");
		Node node = loader.<Node> getRoot();

		Pane parentNode = parent.getView().getPane();
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

	@Override
	public void closeTask(final ITask task) {
		if (null != task) {
			super.closeTask(task);
		}
	}

}
