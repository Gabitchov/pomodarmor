/**
 * 
 */
package bzh.gabitchov.pomodarmor.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author g.pascual
 *
 */
public class Pomodarmor extends Application implements IPomodarmor {

	private Scene applicationScene;

	/**
	 * 
	 */
	public Pomodarmor() {
		super();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setScene(applicationScene);
		primaryStage.setTitle("Pomod'Armor");
		primaryStage.show();
	}

	@Override
	public void setContent(final Scene scene) {
		applicationScene = scene;
	}

}
