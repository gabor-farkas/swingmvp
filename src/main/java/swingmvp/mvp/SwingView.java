package swingmvp.mvp;
public interface SwingView/*<Presenter extends AbstractPresenter<Presenter>>*/ {
	
	public void setPresenter(Object presenter);
	
	public Component asComponent();

}