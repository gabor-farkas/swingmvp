package swingmvp.person;

import lombok.Getter;
import swingmvp.mvp.AbstractPresenter;
import swingmvp.mvp.PresenterOf;

import com.doctusoft.MethodRef;
import com.doctusoft.ObservableProperty;

@PresenterOf(ExampleView.class)
public class ExamplePresenter extends AbstractPresenter<ExamplePresenter> {
	
	@ObservableProperty @Getter
	private String text = "";
	
	@ObservableProperty @Getter
	private String label = "";
	
	@Override
	public void start() {
		/*
		ExamplePresenter_._text.addChangeListener(this, new ValueChangeListener<String>() {
			@Override
			public void valueChanged(String newValue) {
				setLabel("you entered: " + text);
			}
		});
		*/
	}
	
	@MethodRef
	public void clicked() {
		setLabel("you entered: " + text);
	}
	
}
