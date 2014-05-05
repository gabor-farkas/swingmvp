package swingmvp.mvp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.doctusoft.bean.ListenerRegistration;
import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.ValueBinding;
import com.doctusoft.bean.binding.observable.ObservableValueBinding;
import com.doctusoft.bean.internal.PropertyListeners;

public class SwingBindings {
	
	public static void click(AbstractButton button, final EmptyEventHandler handler) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.handle();
			}
		});
	}
	
	public static void label(final JLabel label, ValueBinding<String> labelBinding) {
		ValueBinding<String> targetBinding = new ValueBinding<String>() {
			@Override
			public String getValue() {
				return label.getText();
			}
			@Override
			public void setValue(String value) {
				label.setText(value);
			}
		};
		Bindings.bind(labelBinding, targetBinding);
	}
	
	public static void text(final JTextField textField, ValueBinding<String> textBinding) {
		Bindings.bind(textBinding, new JTextFieldTextBinding(textField));
	}

	public static class JTextFieldTextBinding implements ObservableValueBinding<String> {
		private JTextField textField;
		private final PropertyListeners<String> listeners = new PropertyListeners<String>();
		public JTextFieldTextBinding(final JTextField textField) {
			this.textField = textField;
			textField.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					listeners.fireListeners(textField.getText());
				}
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					listeners.fireListeners(textField.getText());
				}
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					listeners.fireListeners(textField.getText());
				}
			});
		}
		@Override
		public void setValue(String value) {
			textField.setText(value);
			listeners.fireListeners(value);
		}
		
		@Override
		public String getValue() {
			return textField.getText();
		}
		
		@Override
		public ListenerRegistration addValueChangeListener(
				ValueChangeListener<String> listener) {
			return listeners.addListener(listener);
		}
		
	}
}
