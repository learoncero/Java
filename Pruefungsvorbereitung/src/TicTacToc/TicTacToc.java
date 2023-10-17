package TicTacToc;

import java.awt.*;
import java.awt.event.*;

public class TicTacToc extends Frame {
	private static final long serialVersionUID = 1L;
	private Label _currPlayerLabelOutput;
	
	public TicTacToc() {
		initFrame();
		initPanels();
	}
	
	private void initFrame() {
		setTitle("Tic Tac Toc");
		setSize(400, 400);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void initPanels() {
		// north
		Panel northPanel = new Panel();
		
		Label currPlayerLabel = new Label("Current Player: ");
		northPanel.add(currPlayerLabel);
		
		_currPlayerLabelOutput = new Label();
		northPanel.add(_currPlayerLabelOutput);
		
		Button xButton = new Button("X");
		xButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_currPlayerLabelOutput.setText("X");
			}
		});
		northPanel.add(xButton);
		
		Button oButton = new Button("O");
		oButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_currPlayerLabelOutput.setText("O");
			}
		});
		northPanel.add(oButton);
		
		add(northPanel, BorderLayout.NORTH);
		
		// center
		Panel centerPanel = new Panel(new GridLayout(3, 3));
		
		Button firstButton = new Button();
		firstButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(firstButton);
			}
		});
		centerPanel.add(firstButton);
		
		Button secondButton = new Button();
		secondButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(secondButton);
			}
		});
		centerPanel.add(secondButton);
		
		Button thirdButton = new Button();
		thirdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(thirdButton);
			}
		});
		centerPanel.add(thirdButton);
		
		Button fourthButton = new Button();
		fourthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(fourthButton);
			}
		});
		centerPanel.add(fourthButton);
		
		Button fifthButton = new Button();
		fifthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(fifthButton);
			}
		});
		centerPanel.add(fifthButton);
		
		Button sixthButton = new Button();
		sixthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(sixthButton);
			}
		});
		centerPanel.add(sixthButton);
		
		Button seventhButton = new Button();
		seventhButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(seventhButton);
			}
		});
		centerPanel.add(seventhButton);
		
		Button eigthButton = new Button();
		eigthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(eigthButton);
			}
		});
		centerPanel.add(eigthButton);
		
		Button ninethButton = new Button();
		ninethButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonText(ninethButton);
			}
		});
		centerPanel.add(ninethButton);
		
		add(centerPanel, BorderLayout.CENTER);
	}
	
	private void buttonText(Button b) {
		if (b.getLabel().length() == 0) {
			b.setLabel(_currPlayerLabelOutput.getText());
		}
	}
	
	public static void main(String[] args) {
		TicTacToc test = new TicTacToc();
		test.setVisible(true);
	}
}
