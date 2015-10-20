/**
 *
 */
package bzh.gabitchov.pomodarmor.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerationException;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class Dashboard.
 *
 * @author g.pascual
 */
public class Dashboard implements IDashboard {

	/** The Constant log. */
	private static final Logger LOG = LogManager.getLogger(Dashboard.class);

	/** The tasks list. */
	private List<ITask> tasksList;

	/** The dirty. */
	private boolean dirty = false;

	/** The dashboard location. */
	private URI dashboardLocation;

	/**
	 * Instantiates a new dashboard.
	 */
	public Dashboard() {
		super();
		initialise();

	}

	/**
	 * Initialise.
	 */
	protected void initialise() {
		tasksList = new ArrayList<ITask>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#getTasks()
	 */
	@Override
	public List<ITask> getTasks() {
		return tasksList;
	}

	/**
	 * Sets the tasks list.
	 *
	 * @param newTasksList
	 *            the new tasks list
	 */
	protected void setTasks(final List<ITask> newTasksList) {
		this.tasksList = newTasksList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#addTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void addTask(final ITask task) {
		getTasks().add(task);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#removeTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void removeTask(final ITask task) {
		getTasks().remove(task);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#closedTask(bzh.gabitchov.
	 * pomodarmor.application.ITask)
	 */
	@Override
	public void closeTask(final ITask task) {
		task.setClosed();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return dirty;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#setDirty(boolean)
	 */
	@Override
	public void setDirty(final boolean modified) {
		dirty = modified;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#getLocation()
	 */
	@Override
	public URI getLocation() {
		return dashboardLocation;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * bzh.gabitchov.pomodarmor.application.IDashboard#setLocation(java.net.URI)
	 */
	@Override
	public void setLocation(final URI newLocation) {
		dashboardLocation = newLocation;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see bzh.gabitchov.pomodarmor.application.IDashboard#save()
	 */
	@Override
	public void save() {
		File file = new File(getLocation());
		JsonGenerator jsonGenerator = null;
		Writer writer;
		try {
			writer = new FileWriter(file);
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put(JsonGenerator.PRETTY_PRINTING, true);
			JsonGeneratorFactory generatorFactory = Json
					.createGeneratorFactory(propertiesMap);
			jsonGenerator = generatorFactory.createGenerator(writer);

			// Create context
			jsonGenerator.writeStartArray();
			handleTasks(jsonGenerator);
			jsonGenerator.writeEnd();
			jsonGenerator.flush();

		} catch (final JsonGenerationException e) {
			LOG.error(
					"JSon generator has meet a probleme during creation of the save",
					e);

		} catch (final JsonException e) {
			LOG.error(
					"JSon genrator has meet a problem during creation of the save",
					e);
		} catch (final IOException e) {
			LOG.error("Impossible to create file at this location :", e);
		} finally {
			if (null != jsonGenerator) {
				jsonGenerator.close();
			}
			file = null;
		}

	}

	/**
	 * Handle tasks.
	 *
	 * @param generator
	 *            the json generator
	 */
	private void handleTasks(final JsonGenerator generator) {
		JsonObjectBuilder builder = null;

		for (ITask task : tasksList) {
			builder = Json.createObjectBuilder();
			builder.add("label", task.getLabel());
			builder.add("closed", task.isClosed());

			JsonObject jsontask = builder.build();
			generator.write(jsontask);

		}
	}
}
