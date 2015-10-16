/**
 *
 */
package bzh.gabitchov.pomodarmor.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The Class ImageRegistry.
 *
 * @author g.pascual
 */
public class ImageRegistry {

	/** The Constant STOP_ICON_KEY. */
	public static final String STOP_ICON_KEY = "stop_icon";

	/** The Constant PAUSE_ICON_KEY. */
	public static final String PAUSE_ICON_KEY = "pause_icon";

	/** The Constant RESTART_ICON_KEY. */
	public static final String RESTART_ICON_KEY = "restart_icon";

	/** The Constant START_ICON_KEY. */
	public static final String START_ICON_KEY = "start_icon";

	/** The Constant START_ICON_KEY. */
	public static final String ADD_TASK_ICON_KEY = "add_task_icon";

	/** The Constant START_ICON_KEY. */
	public static final String REMOVE_TASK_ICON_KEY = "remove_task_icon";

	/** The Constant START_ICON_KEY. */
	public static final String EDIT_TASK_ICON_KEY = "edit_task_icon";

	/** The Constant log. */
	private static final Logger log = LogManager.getLogger(ImageRegistry.class);

	/** The registry. */
	private final Map<String, ImageView> registry = new HashMap<String, ImageView>();

	/**
	 * Instantiates a new image registry.
	 */
	private ImageRegistry() {
		loadRegistry();
	}

	/**
	 * Load registry.
	 */
	private void loadRegistry() {

		registry.put(START_ICON_KEY, loadImage("icons/control_play_blue.png"));
		registry.put(STOP_ICON_KEY, loadImage("icons/control_stop_blue.png"));
		registry.put(PAUSE_ICON_KEY, loadImage("icons/control_pause_blue.png"));
		registry.put(RESTART_ICON_KEY, loadImage("icons/control_end_blue.png"));
		registry.put(EDIT_TASK_ICON_KEY, loadImage("icons/tag_blue_edit.png"));
		registry.put(ADD_TASK_ICON_KEY, loadImage("icons/tag_blue_delete.png"));
		registry.put(REMOVE_TASK_ICON_KEY, loadImage("icons/tag_blue_add.png"));
	}

	/**
	 * Gets the single instance of ImageRegistry.
	 *
	 * @return single instance of ImageRegistry
	 */
	public static ImageRegistry getInstance() {
		return new ImageRegistry();
	}

	/**
	 * Load image.
	 *
	 * @param imageURL
	 *            the image url
	 * @return the image view
	 */
	private ImageView loadImage(final String imageURL) {
		ImageView imageView = null;
		try {
			Image image = new Image(getClass().getClassLoader().getResource(imageURL).toString());
			imageView = new ImageView(image);
			log.debug("fini");
		} catch (final IllegalArgumentException exception) {
			log.error(exception);
		}

		return imageView;
	}

	public ImageView getImage(final String key) {
		return registry.get(key);
	}
}
