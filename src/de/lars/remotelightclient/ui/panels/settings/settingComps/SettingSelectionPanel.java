/*******************************************************************************
 * ______                     _       _     _       _     _   
 * | ___ \                   | |     | |   (_)     | |   | |  
 * | |_/ /___ _ __ ___   ___ | |_ ___| |    _  __ _| |__ | |_ 
 * |    // _ \ '_ ` _ \ / _ \| __/ _ \ |   | |/ _` | '_ \| __|
 * | |\ \  __/ | | | | | (_) | ||  __/ |___| | (_| | | | | |_ 
 * \_| \_\___|_| |_| |_|\___/ \__\___\_____/_|\__, |_| |_|\__|
 *                                             __/ |          
 *                                            |___/           
 * 
 * Copyright (C) 2019 Lars O.
 * 
 * This file is part of RemoteLight.
 ******************************************************************************/
package de.lars.remotelightclient.ui.panels.settings.settingComps;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import de.lars.remotelightclient.settings.types.SettingSelection;
import de.lars.remotelightclient.settings.types.SettingSelection.Model;
import de.lars.remotelightclient.ui.Style;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class SettingSelectionPanel extends SettingPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7949888285481977614L;
	private SettingSelection setting;
	private JComboBox<String> boxValues;
	private ButtonGroup group;

	/**
	 * Create the panel.
	 */
	public SettingSelectionPanel(SettingSelection setting) {
		super(setting);
		this.setting = setting;
		setBackground(Style.panelBackground);
		
		JLabel lblName = new JLabel("name");
		lblName.setText(setting.getName());
		lblName.setForeground(Style.textColor);
		add(lblName);
		
		if(setting.getModel() == Model.ComboBox) {
			boxValues = new JComboBox<String>();
			boxValues.setModel(new DefaultComboBoxModel<String>(setting.getValues()));
			if(setting.getSelected() != null && Arrays.asList(setting.getValues()).contains(setting.getSelected())) {
				boxValues.setSelectedItem(setting.getSelected());
			}
			add(boxValues);
			
			boxValues.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SettingSelectionPanel.this.onChanged(SettingSelectionPanel.this);
				}
			});
			
		} else if(setting.getModel() == Model.RadioButton) {
			group = new ButtonGroup();
			for(String s : setting.getValues()) {
				
				JRadioButton btn = new JRadioButton(s);
				btn.setForeground(Style.textColor);
				btn.setActionCommand(s);
				if(setting.getSelected() != null && s.equals(setting.getSelected())) {
					btn.setSelected(true);
				}
				group.add(btn);
				add(btn);
				
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SettingSelectionPanel.this.onChanged(SettingSelectionPanel.this);
					}
				});
			}
		}
		
		if(setting.getDescription() != null && !setting.getDescription().isEmpty()) {
			JLabel lblHelp = new JLabel("");
			lblHelp.setIcon(Style.getSettingsIcon("help.png"));
			lblHelp.setToolTipText(setting.getDescription());
			add(lblHelp);
		}
	}

	@Override
	public void setValue() {
		if(setting.getModel() == Model.ComboBox) {
			setting.setSelected((String) boxValues.getSelectedItem());
		} else if(setting.getModel() == Model.RadioButton) {
			setting.setSelected(group.getSelection().getActionCommand());
		}
	}

	@Override
	public void updateComponents() {
	}

}
