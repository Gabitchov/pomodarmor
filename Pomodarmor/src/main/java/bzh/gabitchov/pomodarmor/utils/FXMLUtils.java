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
public final class FXMLUtils {

	/** The Constant FXML_RESOURCES_PATH. */
	private static final String FXML_RESOURCES_PATH = "fxml/";

	/** The Constant log. */
	private static final Logger LOG = LogManager.getLogger(FXMLUtils.class);

	/**
	 * Instantiates a new FXML utils.
	 */
	private FXMLUtils() {
	}

	/**
	 * Load view.
	 *
	 * @param controllerClass
	 *            the controller class
	 * @param fileName
	 *            the file name
	 * @return the FXML loader
	 */
	public static FXMLLoader loadView(
			final Class<? extends IView> controllerClass,
			final String fileName) {
		URL location = controllerClass.getClassLoader()
				.getResource(FXML_RESOURCES_PATH + fileName);
		FXMLLoader loader = new FXMLLoader(location);
		try {
			loader.<Node> load();
		} catch (final IOException e) {
			LOG.error("JavaFX view is loaded with problem", e);
		}
		return loader;
	}

}
