/**
 *
 */
package bzh.gabitchov.pomodarmor.utils;

import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bzh.gabitchov.pomodarmor.view.IView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * The Class FXMLUtils.
 *
 * @author g.pascual
 */
public class FXMLUtils {

	/** The Constant FXML_RESOURCES_PATH. */
	private static final String FXML_RESOURCES_PATH = "fxml/";

	/** The Constant log. */
	private static final Logger log = LogManager.getLogger(FXMLUtils.class);

	/**
	 * Load view.
	 *
	 * @param controllerClass
	 *            the controller class
	 * @param fileName
	 *            the file name
	 * @return the FXML loader
	 */
	public static FXMLLoader loadView(final Class<? extends IView> controllerClass, final String fileName) {
		URL location = controllerClass.getClassLoader().getResource(FXML_RESOURCES_PATH + fileName);
		FXMLLoader loader = new FXMLLoader(location);
		try {
			loader.<Node> load();
		} catch (final IOException e) {
			log.error(e.getMessage());
		}
		return loader;
	}

}
