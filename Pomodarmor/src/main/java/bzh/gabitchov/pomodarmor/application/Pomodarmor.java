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

	/**
	 *
	 */
	public Pomodarmor() {
		super();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Pomod'Armor");
	}

}
