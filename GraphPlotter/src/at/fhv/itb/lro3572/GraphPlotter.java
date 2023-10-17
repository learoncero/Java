package at.fhv.itb.lro3572;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GraphPlotter extends Frame {
	private static final long serialVersionUID = 1L;
	private TextField _aTextField;
	private TextField _bTextField;
	private TextField _cTextField;
	private Axis _axis;
	private List<ViewPolynom> _viewPolynoms;
	private Panel _graphPanel;
	private TextArea _polynomListArea;
	
	public GraphPlotter() {
		initFrame();
		initMenu();
		initPanel();
		_viewPolynoms = new ArrayList<>();
		_axis = new Axis();
	}
	
	private void initFrame() {
		setTitle("Quadratic Function Plotter");
		setSize(new Dimension(780, 780));
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent ev) {
                    System.exit(0);
            }
		});
	}
	
	private void initMenu() {
		MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            
        	@Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        
        Menu helpMenu = new Menu("Help");
        MenuItem helpMenuItem = new MenuItem("About");
        helpMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showAboutBox();
			}
		});
        
        helpMenu.add(helpMenuItem);
        menuBar.add(helpMenu);
        
        setMenuBar(menuBar);
	}

	private void showAboutBox() {
		TextArea message = new TextArea(
				"Graph Plotter\n\n" +
                "Enter the values for a, b, and c to plot a quadratic polynomial of the form: f(x) = ax^2 + bx + c.\n" +
				"If no values are entered, the value 0 is automatically assumed.\n\n" + 
                "Buttons: \n" +
                "   - Click the 'Add' button to add the polynomial to the list.\n" +
				"   - Click the 'Remove' button to remove the last polynomial from the list.\n" +
                "   - Click the 'Plot' button to plot all polynomials from the list.\n\n" + 
                "File Menu:\n" +
                " - Exit: Close the application.\n\n" +
                "Help Menu:\n" +
                " - About: Show information about the application.");

		Dialog dialog = new Dialog(this, "About", true);
		dialog.setSize(600, 300);
		dialog.setLayout(new BorderLayout());
		dialog.add(message, BorderLayout.CENTER);
		dialog.setResizable(false);
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent ev) {
				dialog.dispose();
            }
		});
		
		dialog.setVisible(true);
	}
	
	private void initPanel() {
		// input panel
		Panel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);
        
        //graph panel
        _graphPanel = new Panel() {
    		private static final long serialVersionUID = 1L;

    		@Override
    		public void paint(Graphics g) {
    			super.paint(g);
    			int width = getWidth();
    			int height = getHeight();
    	        
    	        _axis.draw(g, width, height);
    	        
    	        ViewPolynom.set_indexColors(0);
	        	for (ViewPolynom vP: _viewPolynoms) {
	        		vP.draw(g, width, height);
    	        }
    		}
    	};
    	add(_graphPanel, BorderLayout.CENTER);
    }
	
	public Panel createInputPanel() {
		Panel inputPanel = new Panel(new FlowLayout());
		
		_aTextField = new TextField(3); 
		_bTextField = new TextField(3); 
		_cTextField = new TextField(3); 
		
	    inputPanel.add(new Label("f(x) = "));
	    inputPanel.add(_aTextField);
	    inputPanel.add(new Label("x² + "));
	    inputPanel.add(_bTextField);
	    inputPanel.add(new Label(" x "));
	    inputPanel.add(_cTextField);
	    
	    _polynomListArea = new TextArea(5, 20);
	    _polynomListArea.setEditable(false);
	    inputPanel.add(_polynomListArea);
	    
	    Button addButton = new Button("Add");
	    inputPanel.add(addButton);
	    addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addPolynom();
				_polynomListArea.setText(getPolynomString());
			}
		});
	    
	    Button removeButton = new Button("Remove");
	    inputPanel.add(removeButton);
	    removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_viewPolynoms.remove(_viewPolynoms.size() - 1);
				_polynomListArea.setText(getPolynomString());
			}
		});
	    
	    Button plotButton = new Button("Plot");
	    inputPanel.add(plotButton);
	    plotButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (_viewPolynoms.isEmpty()) {
                    JOptionPane.showMessageDialog(GraphPlotter.this,
                            "Please add polynomials before plotting.", "No Polynomials",
                            JOptionPane.INFORMATION_MESSAGE);
                }
	        	else {
	        		_graphPanel.repaint();
	        	}
	        }
	    });
	    
	    return inputPanel;
	}
	
	public void addPolynom() { 
		String valueA;
		String valueB;
		String valueC;
		
		if (_aTextField.getText().length() <= 0) {
			valueA = "0";
		}
		else {
			valueA = _aTextField.getText();
		}
		
		if (_bTextField.getText().length() <= 0) {
			valueB = "0";
		}
		else {
			valueB = _bTextField.getText();
		}
		
		if (_cTextField.getText().length() <= 0) {
			valueC = "0";
		}
		else {
			valueC = _cTextField.getText();
		}
		
		double a = Double.parseDouble(valueA);
		double b = Double.parseDouble(valueB);
		double c = Double.parseDouble(valueC);
		
		ViewPolynom viewPolynom = new ViewPolynom(new MathPolynom(a, b, c), _axis);
		_viewPolynoms.add(viewPolynom);
	}
	
	private String getPolynomString() {
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < _viewPolynoms.size(); i += 1) {
			output.append(i+1 + ". Polynom: " + _viewPolynoms.get(i).getMathPolynom().getA() + "x² + " + _viewPolynoms.get(i).getMathPolynom().getB() 
					+ "x + " + _viewPolynoms.get(i).getMathPolynom().getC() + "\n ");
		}
		
		return output.toString();
	}

    public static void main(String[] args) {
        GraphPlotter plotter = new GraphPlotter();
        plotter.setVisible(true);
    }
}