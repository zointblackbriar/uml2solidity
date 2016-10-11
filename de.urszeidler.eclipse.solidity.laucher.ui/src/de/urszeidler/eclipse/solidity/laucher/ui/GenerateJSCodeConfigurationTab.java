package de.urszeidler.eclipse.solidity.laucher.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import de.urszeidler.eclipse.solidity.ui.preferences.PreferenceConstants;

/**
 * @author uzeidler
 *
 */
public class GenerateJSCodeConfigurationTab extends AbstractLaunchConfigurationTab {
	private Text jsDirectoryText;
	private Text testDirectoryText;
	private Text jsHeaderText;
	private Button btnGenerateJsCode;
	private Button btnGenerateJsTestcode;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new GridLayout(1, true));		
		setControl(mainComposite);
		
		Group grpGenerateJsCode = new Group(mainComposite, SWT.NONE);
		grpGenerateJsCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpGenerateJsCode.setText("generate js code");
		grpGenerateJsCode.setLayout(new GridLayout(3, false));
		
		btnGenerateJsCode = new Button(grpGenerateJsCode, SWT.CHECK);
		btnGenerateJsCode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnGenerateJsCode.setText("generate js code");
		new Label(grpGenerateJsCode, SWT.NONE);
		
		Label lblDirectoryForJs = new Label(grpGenerateJsCode, SWT.NONE);
		lblDirectoryForJs.setText("directory for js code");
		
		jsDirectoryText = new Text(grpGenerateJsCode, SWT.BORDER);
		jsDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelect = new Button(grpGenerateJsCode, SWT.NONE);
		btnSelect.setText("select");
		
		btnGenerateJsTestcode = new Button(grpGenerateJsCode, SWT.CHECK);
		btnGenerateJsTestcode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnGenerateJsTestcode.setText("generate js testcode");
		new Label(grpGenerateJsCode, SWT.NONE);
		
		Label lblNewLabel = new Label(grpGenerateJsCode, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("directory for test code");
		
		testDirectoryText = new Text(grpGenerateJsCode, SWT.BORDER);
		testDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnNewButton = new Button(grpGenerateJsCode, SWT.NONE);
		btnNewButton.setText("select");
		
		Label lblJsFileHeader = new Label(grpGenerateJsCode, SWT.NONE);
		lblJsFileHeader.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblJsFileHeader.setText("js file header");
		
		jsHeaderText = new Text(grpGenerateJsCode, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_text_2.heightHint = 97;
		jsHeaderText.setLayoutData(gd_text_2);

		

	}

	
	
	/* (nicht-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(PreferenceConstants.GENERATE_JS_CONTROLLER, true);
		configuration.setAttribute(PreferenceConstants.GENERATE_JS_CONTROLLER_TARGET, "");
		configuration.setAttribute(PreferenceConstants.GENERATE_JS_TEST, true);
		configuration.setAttribute(PreferenceConstants.GENERATE_JS_TEST_TARGET, "");
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			jsHeaderText.setText(configuration.getAttribute("jsHeader", ""));
			jsDirectoryText.setText(configuration.getAttribute(PreferenceConstants.GENERATE_JS_CONTROLLER_TARGET, ""));
			testDirectoryText.setText(configuration.getAttribute(PreferenceConstants.GENERATE_JS_TEST_TARGET, ""));
			btnGenerateJsCode.setSelection(configuration.getAttribute(PreferenceConstants.GENERATE_JS_CONTROLLER, true));
			btnGenerateJsTestcode.setSelection(configuration.getAttribute(PreferenceConstants.GENERATE_JS_TEST, true));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Automatisch generierter Methodenstub

	}

	@Override
	public String getName() {
		return "generate js code";
	}
}
