/**
 *
 */
package bzh.gabitchov.pomodarmor.controller;

import java.util.Optional;

import bzh.gabitchov.pomodarmor.application.IPomodarmor;
import bzh.gabitchov.pomodarmor.application.Pomodarmor;
import bzh.gabitchov.pomodarmor.utils.FXMLUtils;
import bzh.gabitchov.pomodarmor.utils.ImageRegistry;
import bzh.gabitchov.pomodarmor.view.IPomodarmorView;
import bzh.gabitchov.pomodarmor.view.IView;
import bzh.gabitchov.pomodarmor.view.PomodarmorView;
import bzh.gabitchov.pomodarmor.view.dialog.DashboardLocationDialog;
import bzh.gabitchov.pomodarmor.view.dialog.IDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for Pomodarmor application.
 *
 * @author g.pascual
 *
 */
public class PomodarmorController extends Pomodarmor
		implements IPomodarmorController {

	/** The view. */
	private IPomodarmorView view = null;

	/** The application. */
	private final IPomodarmor application = null;

	/**
	 * Instantiates a new pomodarmor controller.
	 */
	public PomodarmorController() {
		createView();
		createChildren();

	}

	/**
	 * Creates the children.
	 */
	private void createChildren() {
		setChrono(new ChronoController(this));
		setDashboard(new DashboardController(this));
	}

	/**
	 * Creates the view.
	 */
	private void createView() {
		FXMLLoader loader = FXMLUtils.loadView(PomodarmorView.class,
				"Pomodarmor.fxml");
		view = loader.<IPomodarmorView> getController();
		view.setController(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.IPomodarmorController#getView()
	 */
	@Override
	public IView getView() {
		return view;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		super.start(primaryStage);
		primaryStage.getIcons().add(ImageRegistry.getInstance()
				.getImage(ImageRegistry.APPLICATION_ICON_KEY).getImage());
		primaryStage.setScene(view.getScene());
		primaryStage.show();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.IPomodarmorController#run()
	 */
	@Override
	public void run() {
		// Only launch if the application is a Java FX application
		if (application instanceof Application) {
			Application.launch(Application.class.cast(this).getClass(),
					new String[0]);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.application.Application#stop()
	 */
	@Override
	public void stop() throws Exception {
		Object controller = getChrono();
		if (controller instanceof IChronoController) {
			((IChronoController) controller).stop();
		}
		super.stop();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.controller.IPomodarmorController#save()
	 */
	@Override
	public void save() {
		IDashboardController dashboard = (IDashboardController) getDashboard();

		boolean cancel = false;

		// Case 0: The dashboard location was never specified
		if (null == dashboard.getLocation()) {

			// Load FX template of the dialog content
			FXMLLoader loader = FXMLUtils.loadView(
					DashboardLocationDialog.class,
					"DashboardLocationDialog.fxml");

			// Set controller to dialog
			IDialog dialogController = loader.<IDialog> getController();
			dialogController.setController(getDashboard());

			// Create and configure the dialog
			Dialog<ButtonType> dialogScene = new Dialog<ButtonType>();
			dialogScene.setTitle("Dasboard Location");
			Pane pane = loader.<Pane> getRoot();
			dialogScene.setDialogPane((DialogPane) pane);

			dialogController.setOwner(dialogScene.getOwner());

			// Open dialog
			Optional<ButtonType> result = dialogScene.showAndWait();
			cancel = result.isPresent() && ButtonType.CANCEL == result.get();

		}

		if (!cancel && dashboard.isDirty()) {
			dashboard.save();
		}
	}

}
