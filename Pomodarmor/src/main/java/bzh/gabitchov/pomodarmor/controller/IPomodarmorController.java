package bzh.gabitchov.pomodarmor.controller;

import bzh.gabitchov.pomodarmor.application.IPomodarmor;
import bzh.gabitchov.pomodarmor.view.IView;

public interface IPomodarmorController extends IPomodarmor {
	IView getView();

	void run();
}
