package de.lars.remotelightclient.ui.panels.output.outputComps;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import de.lars.remotelightclient.devices.artnet.Artnet;
import de.lars.remotelightclient.lang.i18n;
import de.lars.remotelightclient.ui.Style;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ArtnetSettingsPanel extends DeviceSettingsPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1248292009488744767L;
	private Artnet artnet;
	private JTextField fieldId;
	private JSpinner spinnerPixels;
	private Dimension size;
	private JTextField fieldIpAddress;
	private JCheckBox chckbxBroadcast;
	private JLabel lblEndUniverse;
	private JSpinner spinnerSubnet;
	private JSpinner spinnerStartUniverse;

	public ArtnetSettingsPanel(Artnet artnet, boolean setup) {
		super(artnet, setup);
		this.artnet = artnet;
		
		size = new Dimension(800, 40);
		setBackground(Style.panelBackground);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JPanel panelId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelId.setPreferredSize(size);
		panelId.setMaximumSize(size);
		panelId.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelId.setBackground(Style.panelBackground);
		add(panelId);
		
		JLabel lblNameId = new JLabel(i18n.getString("OutputPanel.NameID")); //$NON-NLS-1$
		lblNameId.setForeground(Style.textColor);
		panelId.add(lblNameId);
		
		fieldId = new JTextField();
		panelId.add(fieldId);
		fieldId.setColumns(10);
		
		JPanel panelIpAddress = new JPanel();
		FlowLayout fl_panelIpAddress = (FlowLayout) panelIpAddress.getLayout();
		fl_panelIpAddress.setAlignment(FlowLayout.LEFT);
		panelIpAddress.setPreferredSize(size);
		panelIpAddress.setMaximumSize(size);
		panelIpAddress.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelIpAddress.setBackground(Style.panelBackground);
		add(panelIpAddress);
		
		JLabel lblIpAddress = new JLabel("IP Address:"); //$NON-NLS-1$
		lblIpAddress.setForeground(Style.textColor);
		panelIpAddress.add(lblIpAddress);
		
		fieldIpAddress = new JTextField();
		fieldIpAddress.setText("");
		panelIpAddress.add(fieldIpAddress);
		fieldIpAddress.setColumns(10);
		
		chckbxBroadcast = new JCheckBox(i18n.getString("ArtnetSettingsPanel.chckbxBroadcast.text")); //$NON-NLS-1$
		chckbxBroadcast.addChangeListener(broadcastCheckboxListener);
		chckbxBroadcast.setBackground(Style.panelBackground);
		chckbxBroadcast.setForeground(Style.textColor);
		panelIpAddress.add(chckbxBroadcast);
		
		JPanel panelSubnet = new JPanel();
		FlowLayout fl_panelSubnet = (FlowLayout) panelSubnet.getLayout();
		fl_panelSubnet.setAlignment(FlowLayout.LEFT);
		panelSubnet.setPreferredSize(size);
		panelSubnet.setMaximumSize(size);
		panelSubnet.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelSubnet.setBackground(Style.panelBackground);
		add(panelSubnet);
		
		JLabel lblSubnet = new JLabel(i18n.getString("ArtnetSettingsPanel.lblSubnet.text")); //$NON-NLS-1$
		lblSubnet.setForeground(Style.textColor);
		panelSubnet.add(lblSubnet);
		
		spinnerSubnet = new JSpinner();
		spinnerSubnet.setPreferredSize(new Dimension(40, 20));
		spinnerSubnet.setMinimumSize(new Dimension(40, 20));
		spinnerSubnet.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panelSubnet.add(spinnerSubnet);
		
		JPanel panelUniverse = new JPanel();
		FlowLayout fl_panelUniverse = (FlowLayout) panelUniverse.getLayout();
		fl_panelUniverse.setAlignment(FlowLayout.LEFT);
		panelUniverse.setPreferredSize(size);
		panelUniverse.setMaximumSize(size);
		panelUniverse.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelUniverse.setBackground(Style.panelBackground);
		add(panelUniverse);
		
		JLabel lblStartUniverse = new JLabel(i18n.getString("ArtnetSettingsPanel.lblStartUniverse.text")); //$NON-NLS-1$
		lblStartUniverse.setForeground(Style.textColor);
		panelUniverse.add(lblStartUniverse);
		
		spinnerStartUniverse = new JSpinner();
		spinnerStartUniverse.setPreferredSize(new Dimension(40, 20));
		spinnerStartUniverse.setMinimumSize(new Dimension(40, 20));
		spinnerStartUniverse.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerStartUniverse.addChangeListener(universeUpdateListener);
		panelUniverse.add(spinnerStartUniverse);
		
		JLabel lblEndUniverseText = new JLabel(i18n.getString("ArtnetSettingsPanel.lblEndUniverse.text")); //$NON-NLS-1$
		lblEndUniverseText.setForeground(Style.textColor);
		panelUniverse.add(lblEndUniverseText);
		
		lblEndUniverse = new JLabel("0");
		lblEndUniverse.setForeground(Style.textColor);
		panelUniverse.add(lblEndUniverse);
		
		JPanel panelPixels = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPixels.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelPixels.setPreferredSize(size);
		panelPixels.setMaximumSize(size);
		panelPixels.setBackground(Style.panelBackground);
		panelPixels.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(panelPixels);
		
		JLabel lblPixels = new JLabel(i18n.getString("OutputPanel.Pixels")); //$NON-NLS-1$
		lblPixels.setForeground(Style.textColor);
		panelPixels.add(lblPixels);
		
		spinnerPixels = new JSpinner();
		spinnerPixels.setPreferredSize(new Dimension(50, 20));
		spinnerPixels.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerPixels.addChangeListener(universeUpdateListener);
		panelPixels.add(spinnerPixels);
		
		setValues();
	}
	
	private void setValues() {
		if(artnet.getId() != null) {
			fieldId.setText(artnet.getId());
		}
		
		if(artnet.getPixels() <= 0) {
			artnet.setPixels(1);
		}
		spinnerPixels.setValue(artnet.getPixels());
		
		chckbxBroadcast.setSelected(artnet.isBroadcast());
		if(artnet.getUnicastAddress() != null) {
			fieldIpAddress.setText(artnet.getUnicastAddress());
		}
		
		spinnerSubnet.setValue(artnet.getSubnet());
		spinnerStartUniverse.setValue(artnet.getStartUniverse());
		lblEndUniverse.setText(artnet.getEndUniverse(artnet.getStartUniverse(), artnet.getPixels()) +"");
	}
	
	private ChangeListener broadcastCheckboxListener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			if(chckbxBroadcast.isSelected()) {
				fieldIpAddress.setEnabled(false);
			} else {
				fieldIpAddress.setEnabled(true);
			}
		}
	};
	
	private ChangeListener universeUpdateListener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			lblEndUniverse.setText(artnet.getEndUniverse((int) spinnerStartUniverse.getValue(), (int) spinnerPixels.getValue()) +"");
			updateUI();
		}
	};

	@Override
	public boolean save() {
		if(fieldId.getText().isEmpty()) {
			return false;
		}
		artnet.setId(fieldId.getText());
		artnet.setPixels((int) spinnerPixels.getValue());
		artnet.setUnicastAddress(fieldIpAddress.getText());
		artnet.setBroadcast(chckbxBroadcast.isSelected());
		artnet.setSubnet((int) spinnerSubnet.getValue());
		artnet.setStartUniverse((int) spinnerStartUniverse.getValue());
		return true;
	}

	@Override
	public String getId() {
		return fieldId.getText();
	}

}
