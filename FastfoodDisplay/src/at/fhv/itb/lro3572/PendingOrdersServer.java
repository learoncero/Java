package at.fhv.itb.lro3572;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class PendingOrdersServer extends Frame {
	private static final long serialVersionUID = 1L;
	private TextArea _pending;

	public PendingOrdersServer() {
		initFrame();
		initPanel();
	}

	private void initFrame() {
		setTitle("Pending orders");
		setSize(400, 400);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
	}
	
	private void initPanel() {
		// north
		Panel northPanel = new Panel();
		northPanel.setBackground(Color.BLACK);
		Label numberLabel = new Label("Achten Sie auf Ihre Nummer");
		numberLabel.setForeground(Color.WHITE);
		numberLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
		northPanel.add(numberLabel);
		add(northPanel, BorderLayout.NORTH);
		
		// south
		Panel southPanel = new Panel();
		southPanel.setBackground(Color.BLACK);
		Label statusLabel = new Label("Hier sehen Sie den Status Ihrer Bestellung");
		statusLabel.setForeground(Color.WHITE);
		statusLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
		southPanel.add(statusLabel);
		add(southPanel, BorderLayout.SOUTH);
	
		// center
		Panel centerPanel = new Panel(new BorderLayout());
		
		// center panel north west
		Panel westPanelNorth = new Panel();
		westPanelNorth.setBackground(Color.LIGHT_GRAY);
		Label inPreparationLabel = new Label("In Zubereitung");
		inPreparationLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
		inPreparationLabel.setForeground(Color.WHITE);
		westPanelNorth.add(inPreparationLabel);
		
		// center panel north east
		Panel eastPanelNorth = new Panel();
		eastPanelNorth.setBackground(Color.ORANGE);
		Label pickUpLabel = new Label("Abholbereit");
		pickUpLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
		pickUpLabel.setForeground(Color.WHITE);
		eastPanelNorth.add(pickUpLabel);
		
		//center north
		Panel centerPanelNorth = new Panel(new GridLayout (1, 2));
		centerPanelNorth.add(westPanelNorth);
		centerPanelNorth.add(eastPanelNorth);
		centerPanel.add(centerPanelNorth, BorderLayout.NORTH);

		// center panel center
		Panel centerPanelCenter = new Panel(new GridLayout (1, 2));

		// center panel center west
		Panel westCenterPanel = new Panel(new GridLayout(1, 1));
		_pending = new TextArea();
		westCenterPanel.add(_pending);
		
		centerPanelCenter.add(westCenterPanel);
		
		// center panel center east
		Panel eastCenterPanel = new Panel();
		
		centerPanelCenter.add(eastCenterPanel);
		
		centerPanel.add(centerPanelCenter);
		
		// add centerPanel to Frame
		add(centerPanel, BorderLayout.CENTER);
	}
	
	public void updateFrame(Order order) {
		int orderNumber = order.getOrderNumber();
		List<String> orderDetails = order.getOrderDetails();
		StringBuilder orderDetailsString = new StringBuilder();
		
		for (String detail : orderDetails) {
			orderDetailsString.append("  ").append(detail).append("\n");
		}
		
		_pending.append("Bestellnummer: " + orderNumber + "\n" + orderDetailsString.toString() + "\n\n");
	}
	
	public static void start(int port) {
		PendingOrdersServer f = new PendingOrdersServer();
		f.setVisible(true);
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket connection = serverSocket.accept();
                ObjectInputStream objectIn = new ObjectInputStream(connection.getInputStream());
                Order newOrder = (Order) objectIn.readObject();
                f.updateFrame(newOrder);
            }
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		PendingOrdersServer.start(1234);
	}
}
