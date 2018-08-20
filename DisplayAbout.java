package com.mycompany.a1;

import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class DisplayAbout extends Form
{
	public DisplayAbout()
	{
		this.setTitle("About");
		this.getAllStyles().setPadding(1, 1, 20, 20);
		Command cOk = new Command ("Ok");
		Label name = new Label("Sameeh Khan");
		Label course = new Label("CSC 133 Fall 2017");
		Container textBody = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		textBody.add(name);
		textBody.add(course);
		Dialog.show("About",textBody , cOk);	
	}
}