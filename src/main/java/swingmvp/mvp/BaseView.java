package swingmvp.mvp;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import lombok.Getter;

import com.doctusoft.ObservableProperty;
import com.doctusoft.bean.ParametricClassMethodReferences.ClassMethodReference0;
import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.observable.ObservableChainedValueBindingBuilder;

public class BaseView<Presenter> implements SwingView {
	
	@ObservableProperty @Getter
	protected Presenter pres;
	protected JPanel content = new JPanel();
	
	public BaseView() {
		content.setLayout(new FlowLayout());
	}

	@Override
	public Component asComponent() {
		return content;
	}
	
	protected ObservableChainedValueBindingBuilder<Presenter> bindOnPresenter() {
		return Bindings.obs(this).get((com.doctusoft.bean.ObservableProperty)BaseView_._pres);
	}
	
	@Override
	public void setPresenter(Object presenter) {
		// hack until generics is fixed
		setPres((Presenter) presenter);
	}
	
	public EmptyEventHandler presenterMethod(final ClassMethodReference0<Presenter, Void> method) {
		return new EmptyEventHandler() {
			@Override
			public void handle() {
				method.apply(pres);
			}
		};
	}
	
}
