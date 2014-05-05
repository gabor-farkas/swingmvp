package swingmvp;

import java.awt.Component;
import java.awt.Container;

import swingmvp.mvp.AbstractPresenter;
import swingmvp.mvp.SwingView;
import swingmvp.person.ExamplePresenter;

public class Application {
	
	private Container mainContainer;
	
	private AbstractPresenter<?> currentPresenter;

	private Component lastView;

	public Application(Container mainContainer) {
		this.mainContainer = mainContainer;
		startPresenter(new ExamplePresenter());
	}
	
	protected void startPresenter(AbstractPresenter presenter) {
		if (lastView != null) {
			mainContainer.remove(lastView);
		}
		currentPresenter = presenter;
		presenter.start();
		SwingView view = presenter.getView();
		view.setPresenter(presenter);
		lastView = view.asComponent();
		mainContainer.add(lastView);
	}

}
