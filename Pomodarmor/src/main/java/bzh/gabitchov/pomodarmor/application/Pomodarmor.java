/**
 *
 */
package bzh.gabitchov.pomodarmor.application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author g.pascual
 *
 */
public class Pomodarmor extends Application implements IPomodarmor {

	/** The chrono. */
	private IChrono chrono = null;

	/** The dashboard. */
	private IDashboard dashboard = null;

	/**
	 * Instantiates a new pomodarmor.
	 */
	public Pomodarmor() {
		super();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Pomod'Armor");
	}

	@Override
	public IChrono getChrono() {
		return chrono;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IPomodarmor#setChrono(bzh.gabitchov.
	 * pomodarmor.application.IChrono)
	 */
	@Override
	public void setChrono(final IChrono newChrono) {
		chrono = newChrono;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IPomodarmor#getDashboard()
	 */
	@Override
	public IDashboard getDashboard() {
		return dashboard;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IPomodarmor#setDashboard(bzh.
	 * gabitchov.pomodarmor.application.IDashboard)
	 */
	@Override
	public void setDashboard(final IDashboard newDashboard) {
		dashboard = newDashboard;

	}

}
