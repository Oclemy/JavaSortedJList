import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;


public class Main extends JFrame {
	  
	   public Main() {
	      getContentPane().setLayout(new BorderLayout());
	  
	      final DefaultListModel listModel = new DefaultListModel();   
	  
	      // POPULATE LIST MODEL WITH RANDOM DATA
	      Random r = new Random();
	      for (int i=0; i<50; i++) {
	         listModel.addElement("Spacecraft " + (Math.abs(r.nextInt()) % 100));
	      }
	  
	      //INSTANTIATE JLSIT
	      final JList list = new JList(listModel); 
	  
	      //GUI
	      getContentPane().add(BorderLayout.CENTER, new JScrollPane(list));    
	      JButton sortButton = new JButton("Sort");
	      sortButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent ae) {
	            sortList(list);
	         }
	      });
	      getContentPane().add(BorderLayout.SOUTH, sortButton);
	  
	      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent event) {
	            System.exit(0);   
	         }      
	      });
	  
	      pack();
	   }
	  
	   /*
	    * SORT ARRAY THEN POPULATE JLIST
	    */
	   public void sortList(JList list) {
	      ListModel model = list.getModel();
	  
	      int n = model.getSize();
	      String[] data = new String[n]; 
	  
	      for (int i=0; i<n; i++) { 
	         data[i] = (String) model.getElementAt(i); 
	      }
	  
	      
	      Arrays.sort(data); 
	  
	      list.setListData(data); 
	   }
	    
	   public static void main(String[] args) {
	      (new Main()).setVisible(true);;
	   }
	}
