package schoolSys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentCrud extends JFrame implements ActionListener {
	
	public static Connection c=null;
	public static PreparedStatement pst;
	private final static String url="jdbc:postgresql://localhost:5432/School_management";
	private final static String user="postgres";
	private final static String password="Ketamine";
	
	public static JFrame f;
	public static JTextField tf1;
	public static JTextField tf2;
	public static JTextField tf3;
	
	public static JButton add;
	public static JButton update;
	public static JButton delete;
	
	
	public StudentCrud() {
		initComponents();
		connect();
	}
	
	public void connect(){
		
		 try {
			 // load the driver class
			 Class.forName("org.postgresql.Driver");
			 
			 // create the connection object
			 c = DriverManager.getConnection(url, user, password);
			 c.setAutoCommit(false);
			 
			 } catch (Exception e) {
			 e.printStackTrace();
			 System.err.println(e.getClass().getName()+": "+e.getMessage());
			 System.exit(0);
			 }
			 JOptionPane.showMessageDialog(this, "Opened Database Successfully");
	
	}
		
	
	
	public void initComponents() {
		f=new JFrame("School Management System");
		JLabel l1=new JLabel("Linda School");
		l1.setBounds(150,0,100,100);
		
		JLabel l2=new JLabel("Name");
		l2.setBounds(80,100,80,30);
		JLabel l3=new JLabel("Address");
		l3.setBounds(80,150,80,30);
		JLabel l4=new JLabel("Phone");
		l4.setBounds(80,200,80,30);

		tf1=new JTextField();
		tf1.setBounds(150,100,150,30);
		tf2=new JTextField();
		tf2.setBounds(150,150,150,30);
		tf3=new JTextField();
		tf3.setBounds(150,200,150,30);
		
		add=new JButton("Add");
		add.setBounds(50,250,80,30);
		
	    update=new JButton("Update");
		update.setBounds(150,250,80,30);
		
		delete=new JButton("Delete");
		delete.setBounds(250,250,80,30);
		
		add.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		
		
		f.add(l1); f.add(l2); f.add(l3);f.add(l4);f.add(tf1); f.add(tf2); f.add(tf3);
		f.add(add); f.add(update); f.add(delete);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new StudentCrud();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name=tf1.getText();
		String address=tf2.getText();
		String phone=tf3.getText();
		
		if(e.getSource()==add) {
			insertIntoDB(name,address,phone);
		}
		else if(e.getSource()==update) {
			updateDB(name,address,phone);
		}
		else if(e.getSource()==delete) {
			DeleteFromDB(name);
		}
		
		
	}
	
	public void insertIntoDB(String n, String a, String p) {
		try {
			String sql="INSERT INTO linda_school(std_name, std_address, std_phone)"+
					"values(?,?,?)";
			pst=c.prepareStatement(sql);
			pst.setString(1, n); // Set the name
	        pst.setString(2, a); // Set the address
	        pst.setString(3, p); // Set the phone number
	        
	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(this, "A new student has been inserted successfully!");
	        }

	        // Commit the transaction
	        c.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error inserting data: " + ex.getMessage());
		}
		finally {
			 try {
		            // Close the PreparedStatement
		            if (pst != null) pst.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
	}
	
	public void updateDB(String n2, String a2, String p2) {
		try {
			String sql="UPDATE linda_school set std_address = ?, std_phone = ? WHERE std_name= ? ";
			pst=c.prepareStatement(sql);
			pst.setString(1, a2); // Set the name
	        pst.setString(2, p2); // Set the address
	        pst.setString(3, n2); // Set the phone number
	        
	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(this, "Student record updated successfully!");
	        }
	        else {
	            JOptionPane.showMessageDialog(this, "No student found with the provided name.");
	        }

	        // Commit the transaction
	        c.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error updating data: " + ex.getMessage());
		}
		finally {
			 try {
		            // Close the PreparedStatement
		            if (pst != null) pst.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		
		
	}
	public void DeleteFromDB(String n3) {
		try {
			String sql="DELETE FROM linda_school WHERE std_name= ? ";
			pst=c.prepareStatement(sql);
	        pst.setString(1, n3); // Set the phone number
	        
	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
	        }
	        else {
	            JOptionPane.showMessageDialog(this, "No student found with the provided name.");
	        }

	        // Commit the transaction
	        c.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error deleting data: " + ex.getMessage());
		}
		finally {
			 try {
		            // Close the PreparedStatement
		            if (pst != null) pst.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		
	}

}
