package swingmvp.person;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import swingmvp.mvp.BaseView;
import swingmvp.mvp.SwingBindings;

public class ExampleView extends BaseView<ExamplePresenter> {
	
	public ExampleView() {
		JTextField textField = new JTextField(20);
		content.add(textField);
		SwingBindings.text(textField, bindOnPresenter().get(ExamplePresenter_._text));

		JButton button = new JButton("clickme");
		content.add(button);
		SwingBindings.click(button, presenterMethod(ExamplePresenter_.__clicked));
		
		JLabel label = new JLabel();
		content.add(label);
		SwingBindings.label(label, bindOnPresenter().get(ExamplePresenter_._label));
	}

}
