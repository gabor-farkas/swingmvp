package swingmvp.mvp;

public abstract class AbstractPresenter<Presenter extends AbstractPresenter<Presenter>> {
	
	public SwingView getView() {
		// note: view classes normally should not be annotated on the presenters. Presenters should
		// not know about their actual views
		// note: views should be lazy singletons
		try {
			Class<? extends SwingView> viewClass = getClass().getAnnotation(PresenterOf.class).value();
			return (SwingView) viewClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public abstract void start();
	
}
