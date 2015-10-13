package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.IChrono;

public interface IChronoController extends IChrono {

	void start();

	boolean isStopped();

	void restart();

	void stop();

}
