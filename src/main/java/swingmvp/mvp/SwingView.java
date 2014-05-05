package swingmvp.mvp;import java.awt.Component;
public interface SwingView/*<Presenter extends AbstractPresenter<Presenter>>*/ {
	
	public void setPresenter(Object presenter);
	
	public Component asComponent();

}
