//Ke Zhang; 500832394

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * this program draws out a display JFrame
 */
public class GroceryStoreFrame extends JFrame
{
	/**
	 * 
	 */
	private static JButton button;
	private static JLabel label;
	private static JPanel panel;
	private static JScrollPane scrollPane;
	private static JTextArea cart;
	private static JTextArea cash;
	private static JTextArea nutrition;
	
	private static final int FRAME_WIDTH = 700; 
	private static final int FRAME_HEIGHT = 700;
	private static final int TEXTAREA_WIDTH = 220;
	private static final int TEXTAREA_HEIGHT = 340;
	
	private static GroceryItem groceryItem;
	private static GroceryCart groceryCart;
	private static CashRegister cashRegister = new CashRegister();
	private static NutritionScanner nutritionScanner = new NutritionScanner();
	private static int code;
	
	public GroceryStoreFrame()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(new BorderLayout());
		add(createGroceryCartPanel(), BorderLayout.WEST);
		add(createScanItemsPanel(), BorderLayout.CENTER);
		add(createCashRegisterPanel(), BorderLayout.EAST);
		add(createNutritionScannerPanel(), BorderLayout.SOUTH);
	}
	//creates a GroceryCart panel
	public static JPanel createGroceryCartPanel()
	{
		//add label, button
		label = new JLabel("Grocery Cart");
		button = new JButton("REFILL");
		class RefillListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				groceryCart = new GroceryCart();
				groceryCart.fill();
				groceryCart.display(cart);
			}           
		}
		ActionListener listener = new RefillListener();
		button.addActionListener(listener);
	      
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.add(label);
		topPanel.add(button);
		panel.add(topPanel, BorderLayout.NORTH);
		
		cart = new JTextArea();
		cart.setEditable(false);
		scrollPane = new JScrollPane(cart); 
		scrollPane.setPreferredSize(new Dimension(TEXTAREA_WIDTH, TEXTAREA_HEIGHT));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.SOUTH);
		
		return panel;
	}
	//creates a CashRegister panel
	public static JPanel createCashRegisterPanel()
	{
		//add label, button
		label = new JLabel("Cash Register");
		button = new JButton("CHECKOUT");
		class CheckOutListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				cashRegister.clear();
				cashRegister.displayAll(cash);
			}           
		}
		ActionListener listener = new CheckOutListener();
		button.addActionListener(listener);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.add(label);
		topPanel.add(button);
		panel.add(topPanel, BorderLayout.NORTH);
		
		cash = new JTextArea();
		cash.setEditable(false);
		scrollPane = new JScrollPane(cash); 
		scrollPane.setPreferredSize(new Dimension(TEXTAREA_WIDTH, TEXTAREA_HEIGHT));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.SOUTH);
		
		return panel;
	}
	//creates a createScanItems panel
	public static JPanel createScanItemsPanel() 
	{
		//add button
		button = new JButton("SCAN GROCERY ITEM");
		class ScanListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				if(groceryCart.listSize()>0) 
				{
					cashRegister.scanItem();
					cashRegister.displayAll(cash);
					groceryCart.display(cart);
				}
			}           
		}
		ActionListener listener = new ScanListener();
		button.addActionListener(listener);
		
		panel= new JPanel();
		panel.add(button);	
		
		return panel;	
	}
	//creates a NutritionScanner panel
	public static JPanel createNutritionScannerPanel()
	{
		//add label, button
		label = new JLabel("CART NUTRITION INFORMATION");
		button = new JButton("SCAN FOOD ITEM");
		JButton clear = new JButton("CLEAR");
		JButton Cals = new JButton("Cals");
		JButton Carbs = new JButton("Carbs");
		JButton Fat = new JButton("Fat");
		JButton Sugar = new JButton("Sugar");
		class ScanFoodItemListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				groceryItem = groceryCart.nextGroceryItem();
				code = groceryItem.getFoodCode();
				nutritionScanner.scanFoodCode(code);
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listener = new ScanFoodItemListener();
		button.addActionListener(listener);
		
		class ClearListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				nutritionScanner.clear();
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listenerClear = new ClearListener();
		clear.addActionListener(listenerClear);
		
		class CalsListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				Collections.sort(nutritionScanner.List());
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listenerCals = new CalsListener();
		Cals.addActionListener(listenerCals);
		
		class CarbsListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				Collections.sort(nutritionScanner.List(), new FoodTypeCarbsComparator());
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listenerCarbs = new CarbsListener();
		Carbs.addActionListener(listenerCarbs);
		
		class FatListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				Collections.sort(nutritionScanner.List(), new FoodTypeFatComparator());
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listenerFat = new FatListener();
		Fat.addActionListener(listenerFat);
		
		class SugarListener implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				Collections.sort(nutritionScanner.List(), new FoodTypeSugarComparator());
				nutritionScanner.displayAll(nutrition);
			}           
		}
		ActionListener listenerSugar = new SugarListener();
		Sugar.addActionListener(listenerSugar);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.add(label);
		topPanel.add(button);
		topPanel.add(clear);
		panel.add(topPanel, BorderLayout.NORTH);
		
		nutrition = new JTextArea();
		nutrition.setEditable(false);
		scrollPane = new JScrollPane(nutrition); 
		scrollPane.setPreferredSize(new Dimension(640, 220));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(Cals);
		bottomPanel.add(Carbs);
		bottomPanel.add(Fat);
		bottomPanel.add(Sugar);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		
		return panel;
		
	}
}