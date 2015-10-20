package bzh.gabitchov.pomodarmor.application;

/**
 * The Interface IPomodarmor.
 */
public interface IPomodarmor {

	/**
	 * Sets the chrono.
	 *
	 * @param chrono
	 *            the new chrono
	 */
	void setChrono(final IChrono chrono);

	/**
	 * Gets the chrono.
	 *
	 * @return the chrono
	 */
	IChrono getChrono();

	/**
	 * Sets the dashboard.
	 *
	 * @param dashboard
	 *            the new dashboard
	 */
	void setDashboard(final IDashboard dashboard);

	/**
	 * Gets the dashboard.
	 *
	 * @return the dashboard
	 */
	IDashboard getDashboard();
}
