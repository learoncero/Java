package at.fhv.itb.lro3572;

import java.awt.*;
import java.awt.event.*;

public class TemperatureAnalyser extends Frame {
	private static final long serialVersionUID = 1L;
	
	public TemperatureAnalyser() {
		initFrame();
		initPanel();
	}
	
	public void initFrame() {
		setTitle("Temperature GUI");
		setSize(400, 400);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void initPanel() {
		// inputPanel
		Panel inputPanel = new Panel(new FlowLayout());
		Label temperature = new Label("Temperature: ");
		inputPanel.add(temperature);
		TextField inputTemperature = new TextField(5);
		inputPanel.add(inputTemperature);
		add(inputPanel, BorderLayout.NORTH);
		
		// outputPanel
		Panel outputPanel = new Panel(new BorderLayout());
		Button analyzeButton = new Button("Analyze");
		Label evaluate = new Label();	
		outputPanel.add(evaluate, BorderLayout.CENTER);
		
		outputPanel.add(analyzeButton, BorderLayout.NORTH);
		
		add(outputPanel, BorderLayout.CENTER);
		
		analyzeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inTemp = inputTemperature.getText();
				double tempDouble = Double.parseDouble(inTemp);
				
				if (tempDouble <= 35) {
					evaluate.setText("low");
					evaluate.setForeground(Color.BLUE);
				}
				else if ((tempDouble > 35) && (tempDouble < 37.5)) {
					evaluate.setText("normal");
					evaluate.setForeground(Color.GREEN);
				}
				else if (tempDouble >= 37.5) {
					evaluate.setText("high");
					evaluate.setForeground(Color.RED);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		TemperatureAnalyser analyser = new TemperatureAnalyser();
		analyser.setVisible(true);
	}
	
}
