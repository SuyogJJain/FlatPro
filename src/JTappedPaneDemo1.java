


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.ReplicateScaleFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class JTappedPaneDemo1 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	JFrame frame;
	JTabbedPane tp;
	JPanel tab1,tab2,tab3,tab4;
	private int main_id;
	QuizNework con;
	JLabel flat_n,flat_h,mob_n;
	JTextField flat_no,flat_holder,mob_no;
	JButton insert,edit,goadd,cancel,pay,goedit;
	String [][]jtable_result2;
	Object [][]jtable_result;
	JScrollPane jscrollpane,jscrollpane2;
	JTable jtable,jtable2;
	DefaultTableModel dtm,dtm1;
	JLabel balance;
	String[] soc_name;
	String site;
	private JTextField amt;
	private JButton collect;
	private JButton delete;
	private JButton tab3_add;
	private JLabel messagel;
	private JLabel datel;
	private JTextField messagef;
	private JTextField datef;
	private JButton tab3_go;
	private JButton tab3_cancel;
	private JButton tab3_delete;
	private JLabel socname;
	private JPanel tab5;
	private JButton changecost;
	private JButton amtcost;
	private DefaultTableModel dtm2;
	private JTable jtable3;
	private JScrollPane jscrollpane3;
	private JButton debit;
	private JTextArea debitdetails;
	private JButton debitsave;
	private JButton tab3_instant;
	private JButton tab3_instsend;
	JTappedPaneDemo1(int id)
	{
		site="http://localhost/";
		this.main_id=id;
		con=new QuizNework();
		String[] result=con.doInBackground(site+"login/get_data.php?id="+main_id).replaceAll(" ", "").split(":");
	//	String []main_result=
	//	String []result=re.split(":");
		/*for(int i=0;i<result.length;i++)
		{
			System.out.println("a"+result[i]+"z");
		}*/
		
		jtable_result=new Object[result.length/4][5];
		for(int i=0;i<result.length/4;i++)
		{
			jtable_result[i][0]=result[i*4+0];
			jtable_result[i][1]=result[i*4+1];
			jtable_result[i][2]=result[i*4+2];
			jtable_result[i][3]=result[i*4+3];
			jtable_result[i][4]=Boolean.FALSE;
		}
		 soc_name=con.doInBackground(site+"login/soc_name.php?id="+main_id).split(":");
		System.out.println("soc_name"+soc_name[0]+id);
		
		frame=new JFrame("FlatPro Society Soln.");
		tp=new JTabbedPane();
		tab1=new JPanel(){
			//
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				//Graphics2D g2d=(Graphics2D)g;
				//g2d.setPaint(new GradientPaint(0,0,Color.BLACK,0,630,Color.WHITE));
				//g2d.fillRect(0,0,1366,630);
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
			}
		};
		tab2=new JPanel(){
			//
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				//Graphics2D g2d=(Graphics2D)g;
				//g2d.setPaint(new GradientPaint(0,0,Color.BLACK,0,630,Color.WHITE));
				//g2d.fillRect(0,0,1366,630);
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
			}
		};
		tab3=new JPanel(){
			//
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				//Graphics2D g2d=(Graphics2D)g;
				//g2d.setPaint(new GradientPaint(0,0,Color.BLACK,0,630,Color.WHITE));
				//g2d.fillRect(0,0,1366,630);
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
			}
		};
		tab4=new JPanel(){
			//
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				//Graphics2D g2d=(Graphics2D)g;
				//g2d.setPaint(new GradientPaint(0,0,Color.BLACK,0,630,Color.WHITE));
				//g2d.fillRect(0,0,1366,630);
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
			}
		};
		tab5=new JPanel();
		createtab1();
		createtab2();
		createtab3();
		createtab4();
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/tab1.jpg"));
		tp.addTab("",icon,tab1);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/tab2.jpg"));
		tp.addTab("",icon1,tab2);
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/meeting.jpg"));
		tp.addTab("",icon2,tab3);
		tp.addTab("",new ImageIcon(getClass().getResource("/images/reports.jpg")),tab4);
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/about_us.jpg"));
		tp.addTab("",icon3,tab5);
		tp.setBounds(0, 100, 1366, 668);
		tp.setOpaque(false);
		tp.setBackground(new Color(0, 255, 0,0));
		tp.addChangeListener(new ChangeListener() {
			
			
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(tab1.isEnabled())
					JTabbedPane jp=(JTabbedPane)arg0.getSource();
					if(jp.getSelectedIndex()==0)
					{
						//tab2.remove(jscrollpane);
						//jtable_result[i].
						tab1.add(jscrollpane,BorderLayout.CENTER);
						
					}
					else if(jp.getSelectedIndex()==1)
					{
						tab2.add(jscrollpane,BorderLayout.CENTER);
					}
					else if(jp.getSelectedIndex()==2)
					{
						if(tab3_instsend.isVisible())
						{
							tab3.add(jscrollpane,BorderLayout.CENTER);
						}
						else
						{
							tab3.add(jscrollpane2,BorderLayout.CENTER);
							jscrollpane2.setVisible(true);
						}
					}
				
			}
		});
		tp.setSelectedIndex(0);
		frame.getContentPane().add(this,BorderLayout.CENTER);
		frame.setSize(1366, 768);
		frame.setLocation(0,0);
		frame.setVisible(true);
		frame.add(tp);
		socname=new JLabel(""+soc_name[0]);
		socname.setBounds(15,15,300,40);
		socname.setFont(new Font("Serif", Font.BOLD, 30));
		
		add(socname);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent)
			{
				System.out.println("on closing");
				if (JOptionPane.showConfirmDialog(frame,  "Are you sure to close this window?", "Really Closing?",  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						con.doInBackground(site+"login/close.php?id="+main_id);
						System.out.println("ON EXIT");
			            System.exit(0);
			        }
			}
		});
		setLayout(null);
		//setLayout(new GridLayout(1,1));
		add(tp);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getResource("/images/main2.jpg")).getImage(), 0, 0, 1366, 768, this);
	}
	public void createtab1()
	{
			flat_no=new JTextField();
			flat_holder=new JTextField();
			flat_n=new JLabel("Flat No.");
			flat_h=new JLabel("Owner Name");
			mob_n=new JLabel("Mob_no");
			flat_no=new JTextField();
			flat_holder=new JTextField();
			mob_no=new JTextField();
			goadd=new JButton(new ImageIcon(getClass().getResource("/images/save.jpg")));
			goedit=new JButton(new ImageIcon(getClass().getResource("/images/save.jpg")));
			cancel=new JButton(new ImageIcon(getClass().getResource("/images/cancel.jpg")));
			balance=new JLabel("");
			
		flat_n.setBounds(250, 50,100 , 40);
		flat_n.setForeground(Color.WHITE);
		flat_n.setFont(new Font("Serif", Font.BOLD, 20));
		flat_h.setBounds(250, 110, 100, 40);
		flat_h.setForeground(Color.WHITE);
		flat_h.setFont(new Font("Serif", Font.BOLD, 20));
		mob_n.setBounds(250, 170, 100, 40);
		mob_n.setForeground(Color.WHITE);
		mob_n.setFont(new Font("Serif", Font.BOLD, 20));
		Font f=new Font("Microsoft JhengHei Light",Font.PLAIN,20);
		flat_no.setBounds(370, 50, 250, 40);
		flat_holder.setBounds(370, 110, 250, 40);
		mob_no.setBounds(370, 170, 250, 40);
		flat_no.setFont(f);
		flat_holder.setFont(f);
		mob_no.setFont(f);
		goedit.setBounds(230,270,160,45);
		goadd.setBounds(230,270,160,45);
		cancel.setBounds(440,270,160,45);
		goedit.setVisible(false);
		goadd.setVisible(false);
		cancel.setVisible(false);
		flat_n.setVisible(false);
		flat_h.setVisible(false);
		mob_n.setVisible(false);
		flat_no.setVisible(false);
		flat_holder.setVisible(false);
		mob_no.setVisible(false);
		edit=new JButton(new ImageIcon(getClass().getResource("/images/edit.jpeg")));
		edit.setBounds(15,150, 176, 49);
		edit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtable.getSelectedRowCount()==1){
						flat_n.setVisible(true);
						flat_h.setVisible(true);
						mob_n.setVisible(true);
						flat_no.setVisible(true);
						flat_no.setText(""+dtm.getValueAt(jtable.getSelectedRow(),0));
						flat_no.setEditable(false);
						flat_holder.setVisible(true);
						flat_holder.setText(""+dtm.getValueAt(jtable.getSelectedRow(),1));
						mob_no.setVisible(true);
						mob_no.setText(	""+dtm.getValueAt(jtable.getSelectedRow(),2));
						balance.setText(""+dtm.getValueAt(jtable.getSelectedRow(),3));
						goadd.setVisible(false);
						goedit.setVisible(true);
						cancel.setVisible(true);
						
				}
				else
				{
						JOptionPane.showMessageDialog(frame, new String("Please Select Row"));
				}
			}
		});
		delete=new JButton(new ImageIcon(getClass().getResource("/images/delete.jpg")));
		delete.setBounds(15,270,176,49);
		delete.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtable.getSelectedRow()!=-1)
				{
					String temp=(String) dtm.getValueAt(jtable.getSelectedRow(), 3);
					if(temp.equalsIgnoreCase("0"))
					{
						String res=con.doInBackground(site+"login/delete_flat.php?id="+main_id+"+&fno="+(String)dtm.getValueAt(jtable.getSelectedRow(), 0));
						dtm.removeRow(jtable.getSelectedRow());
						System.out.println(""+res);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Sorry Cant Delete\nPayment Remaining");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Select Record");
				}
			}
		});
		insert=new JButton(new ImageIcon(getClass().getResource("/images/addnew.jpg")));
		insert.setBounds(15, 30, 176, 49);
		insert.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				flat_n.setVisible(true);
				flat_h.setVisible(true);
				mob_n.setVisible(true);
				flat_no.setVisible(true);
				flat_no.setEditable(true);
				flat_no.setText("");
				flat_holder.setVisible(true);
				flat_holder.setText("");
				mob_no.setVisible(true);
				mob_no.setText("");
				goedit.setVisible(false);
				goadd.setVisible(true);
				cancel.setVisible(true);
				
			}
		});
		goadd.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(flat_no.getText()!=""&&flat_holder.getText()!=""&&mob_no.getText()!="")
				{
					String[] result=con.doInBackground(site+"login/add_data.php?id="+main_id+"+&no="+flat_no.getText() +"+&name="+flat_holder.getText() +"+&mob="+mob_no.getText()).split(" ");
					String ans=result[1];
					if(ans.equalsIgnoreCase("yes"))
					{
						String []arr=new String[4];
						arr[0]=flat_no.getText();
						arr[1]=flat_holder.getText();
						arr[2]=mob_no.getText();
						arr[3]="0";
						dtm.addRow(arr);
						//jtableresult2=jtable_result.clone();
						System.out.println("Executed");
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Flat no Already exists1");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(frame, "ENTER ALL DETAILS"); 
				}
			}
		});
		goedit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
					if(flat_no.getText()!=""&&flat_holder.getText()!=""&&mob_no.getText()!="")
					{
						if(mob_no.getText().length()==10)
						{
							String[] result=con.doInBackground(site+"login/update_flat.php?id="+main_id+"+&fno="+flat_no.getText()+"+&fhn="+flat_holder.getText() +"+&mn="+mob_no.getText()+"&bal="+balance.getText()).split(" ");
							String ans=result[1];
							System.out.println(""+result[1]);
							if(ans.equalsIgnoreCase("yes"))
							{
								String []arr=new String[4];
								arr[0]=flat_no.getText();
								arr[1]=flat_holder.getText();
								arr[2]=mob_no.getText();
								arr[3]=balance.getText();
								dtm.setValueAt(arr[1], jtable.getSelectedRow(),1);
								dtm.setValueAt(arr[2], jtable.getSelectedRow(),2);
								dtm.setValueAt(arr[3], jtable.getSelectedRow(),3);
								flat_no.setEditable(false);
							}
							else
							{
								System.out.println("Flat no Already exists2");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Wrong Number Format");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(frame, "ENTER ALL DETAILS"); 
					}
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				goadd.setVisible(false);
				cancel.setVisible(false);
				flat_n.setVisible(false);
				flat_h.setVisible(false);
				mob_n.setVisible(false);
				flat_no.setVisible(false);
				flat_holder.setVisible(false);
				mob_no.setVisible(false);
				goedit.setVisible(false);
				flat_no.setEditable(true);
			}
		});
		
		tab1.add(flat_no);
		tab1.add(flat_holder);
		tab1.add(insert);
		tab1.setLayout(null);
		tab1.add(flat_n);
		tab1.add(flat_no);
		tab1.add(flat_h);
		tab1.add(flat_holder);
		tab1.add(mob_n);
		tab1.add(mob_no);
		tab1.add(goadd);
		tab1.add(cancel);
		tab1.add(edit);
		tab1.add(goedit);
		tab1.add(delete);
		String []column={"Flat NO","OWNER  ","MOBILE No. ","Balance","Check"};
		dtm=new DefaultTableModel(jtable_result,column){
			
			public boolean isCellEditable(int row,int column)
			{
				return column==4;
			}
			public Class getColumnClass(int columnIndex) {
			      Class clazz = String.class;
			      switch (columnIndex) {
			       
			        case 4:
			          clazz = Boolean.class;
			          break;
			      }
			      return clazz;
			    }
		};
		jtable=new JTable(dtm);
		jtable.setFont(new Font("Serif", Font.BOLD, 20));
		//jtable.setShowHorizontalLines( false );
		jtable.setRowSelectionAllowed( true );
		jtable.setRowHeight(35);
		jtable.setForeground(Color.WHITE);
		jtable.setSelectionBackground(Color.WHITE);
		jtable.setGridColor(new Color(0, 0, 0));
		jtable.setSelectionForeground(Color.RED);
		jtable.setOpaque(false);
		jscrollpane=new JScrollPane(jtable)
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
				super.paintComponents(g);
			}
		};
		jscrollpane.getViewport().setOpaque(false);

		jtable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
		//jscrollpane=JTable.createScrollPaneForTable(jtable);
		jscrollpane.setBounds(680,10,700 ,300);
		tab1.add(jscrollpane,BorderLayout.CENTER);
		
	}
	
	public Image getScaledImage(Image img,int i,int j)
	{
		ImageProducer ip= img.getSource();
		ReplicateScaleFilter rsf=new ReplicateScaleFilter(i, j);
		ImageProducer flp=new FilteredImageSource(ip, rsf);
		Image m=Toolkit.getDefaultToolkit().createImage(flp);
		return m;
	}
	public void createtab2()
	{
		debit=new JButton(new ImageIcon(getClass().getResource("/images/debit.jpg")));
		debit.setBounds(20, 260, 160, 50);
		debit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				amtcost.setVisible(false);
				pay.setVisible(false);
				amt.setVisible(true);
				debitsave.setVisible(true);
				debitdetails.setVisible(true);
				amt.setText("Enter Amount");
				
			}
		});
		debitdetails=new JTextArea("debit details");
		debitdetails.setBounds(200, 150, 200, 100);
		debitdetails.setVisible(false);
		debitsave=new JButton(new ImageIcon(getClass().getResource("/images/save.jpg")));
		debitsave.setBounds(200, 300, 160, 45);
		debitsave.setVisible(false);
		debitsave.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println(""+debitdetails.getText());
					String[] res=con.doInBackground(site+"login/update_socmain.php?id="+main_id+"+&amt="+Integer.parseInt(amt.getText())+"+&details="+debitdetails.getText().replace(" ", "%20")).split(" ");
					jtable3.setValueAt(""+(Integer.parseInt(jtable3.getValueAt(jtable3.getRowCount()-1, 4).toString())+Integer.parseInt(amt.getText())),jtable3.getRowCount()-1 , 4);
					jtable3.setValueAt(debitdetails.getText(), jtable3.getRowCount()-1, 2);
					System.out.println("In socmain");
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, "Enter Valid Amount");
				}
			}
		});
		collect=new JButton(new ImageIcon(getClass().getResource("/images/maintain.jpeg")));
		collect.setBounds(20,50,160,50);
		collect.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtable.getSelectedRow()!=-1)
				{
					amt.setText("Enter Amount");
					amt.setVisible(true);
					pay.setVisible(true);
					amtcost.setVisible(false);
					debitdetails.setVisible(false);
					debitsave.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Select Person");
				}
			}
		});
		changecost=new JButton(new ImageIcon(getClass().getResource("/images/change.jpg")));
		changecost.setBounds(20, 150, 165, 50);
		changecost.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				amt.setVisible(true);
				amtcost.setVisible(true);
				pay.setVisible(false);
				debitsave.setVisible(false);
				debitdetails.setVisible(false);
				amt.setText("df");//+soc_name[1]
				
			}
		});
		amtcost=new JButton(new ImageIcon(getClass().getResource("/images/save.jpg")));
		amtcost.setBounds(200, 180, 160, 45);
		amtcost.setVisible(false);
		amtcost.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!amt.getText().equalsIgnoreCase(soc_name[1]))
				{
					try{
					String []result=con.doInBackground(site+"login/update_maincost.php?id="+main_id+"+&maincost="+Integer.parseInt(amt.getText())).split(" ");
					System.out.println("Maintainance cost updated00");
					}catch(NumberFormatException a)
					{
						JOptionPane.showMessageDialog(frame, "Enter Valid no");
					}
				}
			}
		});
		amt=new JTextField();
		amt.addFocusListener(new FocusListener() {
			
			
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				amt.setText("");
			}
		});
		amt.setBounds(200, 100, 200, 40);
		amt.setFont(new Font("Microsoft JhengHei Light",Font.PLAIN,10));
		amt.setVisible(false);
		pay=new JButton(new ImageIcon(getClass().getResource("/images/paid.jpeg")));
		pay.setBounds(200, 180, 168, 61);
		pay.setVisible(false);
		pay.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<jtable.getRowCount();i++)
				{
					if(jtable.getValueAt(i, 4)==Boolean.TRUE)
					{
							jtable.setValueAt(Boolean.FALSE, i, 4);
							if(((String) dtm.getValueAt(jtable.getSelectedRow(), 3)).equalsIgnoreCase("0"))
							{
								JOptionPane.showMessageDialog(frame, "ALREADY PAID");
							}
							else
							{
								
								if(amt.getText()!="")
								{
									int t=Integer.parseInt((String) dtm.getValueAt(i, 3));
									try{
										int l=Integer.parseInt(amt.getText());
									
									
									String[] result=con.doInBackground(site+"login/update_bal.php?id="+main_id+"+&fno="+dtm.getValueAt(i, 0)+"&bal="+l).split(" ");
									jtable3.setValueAt(""+(Integer.parseInt(jtable3.getValueAt(jtable3.getRowCount()-1, 3).toString())+l), jtable3.getRowCount()-1, 3);
									System.out.println("update table3");
									if(result[1].equalsIgnoreCase("yes"))
									{
										dtm.setValueAt(""+(t-l), i, 3);
									}
									else
									{
										JOptionPane.showMessageDialog(frame, "Sorry cant do this operation");
									}
								}catch(NumberFormatException e)
								{
									
									JOptionPane.showMessageDialog(frame, "Enter Valid Amount");	
									amt.setText("");
								}
								}
							}
					}
				}
			}
		});
		tab2.add(changecost);
		tab2.add(collect);
		tab2.add(amt);
		tab2.add(pay);
		tab2.add(amtcost);
		tab2.setLayout(null);
		tab2.add(debit);
		tab2.add(debitdetails);
		tab2.add(debitsave);
		
	}
	public void createtab3()
	{
		Font f=new Font("Microsoft JhengHei Light",Font.PLAIN,20);
		tab3_add=new JButton("Schedule Meeting");
		tab3_add.setBackground(new Color(220,10,0));
		tab3_add.setFont(new Font("Microsoft JhengHei Light",Font.BOLD,15));
		messagel=new JLabel("Message");
		datel=new JLabel("Date");
		messagef=new JTextField("message to deliver");
		datef=new JTextField("dd-mm-yyyy");
		tab3_go=new JButton(new ImageIcon(getClass().getResource("/images/save.jpg")));
		tab3_cancel=new JButton(new ImageIcon(getClass().getResource("/images/cancel.jpg")));
		tab3_delete=new JButton(new ImageIcon(getClass().getResource("/images/delete.jpg")));
		tab3_delete.setBounds(15,170,176,49);
		tab3_cancel.setBounds(445, 250, 160,45);
		tab3_instant=new JButton("INstant sms");
		tab3_instant.setBounds(15, 300, 176, 49);
		tab3_instant.setBackground(new Color(222,22,22));
		tab3_instant.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jscrollpane2.setVisible(false);
				tab3.add(jscrollpane,BorderLayout.CENTER);
					messagef.setText("INSTANT SMS");
					messagef.setVisible(true);
					messagel.setVisible(true);
					tab3_instsend.setVisible(true);
					datef.setVisible(false);
					datel.setVisible(false);
					tab3_go.setVisible(false);
					tab3_cancel.setVisible(true);
			}
		});
		tab3_instsend=new JButton("Send Instantly");
		tab3_instsend.setBounds(220, 250, 160, 45);
		tab3_instsend.setVisible(false);
		tab3_instsend.setBackground(new Color(22,100,10));
		tab3_instsend.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(messagef.getText().equalsIgnoreCase(""))
				{
					for(int i=0;i<jtable.getRowCount();i++)
					{
						if(jtable.getValueAt(i, 4)==Boolean.TRUE)
						{
							con.doInBackground("http://api.mvaayoo.com/mvaayooapi/MessageCompose?user=sjjain.home28@gmail.com:123456789&senderID=TEST%20SMS&receipientno=9403509212&dcs=0&msgtxt="+messagef.getText().replaceAll(" ", "%20")+"&state=4");
							jtable.setValueAt(Boolean.FALSE, i, 4);
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Enter Message");
				}
			}
		});
		messagel.setBounds(220,15,100,40);
		messagel.setFont(f);
		datel.setBounds(220,150, 60, 40);
		datel.setFont(f);
		messagef.setBounds(350, 15, 160, 40);
		datef.setBounds(350, 150, 100,40);
		tab3_go.setBounds(220, 250, 160, 45);
		tab3_go.setVisible(false);
		messagel.setVisible(false);
		datel.setVisible(false);
		messagef.setVisible(false);
		datef.setVisible(false);
		messagel.setForeground(Color.WHITE);
		datel.setForeground(Color.WHITE);
		tab3_cancel.setVisible(false);
		tab3_add.setBounds(15,35,176,49);
		tab3_add.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("i am in tab3_add");
				jscrollpane2.setVisible(true);
				tab3.remove(jscrollpane);
				tab3.add(jscrollpane2,BorderLayout.CENTER);
				messagel.setVisible(true);
				datel.setVisible(true);
				messagef.setVisible(true);
				datef.setVisible(true);
				tab3_go.setVisible(true);
				tab3_cancel.setVisible(true);
				tab3_instsend.setVisible(false);
			}
		});
		tab3_delete.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtable2.getSelectedRow()!=-1)
				{
					tab3_go.setVisible(false);
					messagel.setVisible(false);
					datel.setVisible(false);
					messagef.setVisible(false);
					datef.setVisible(false);
					tab3_cancel.setVisible(false);
					con.doInBackground(site+"login/delete_sched.php?id="+main_id+"+&date="+dtm1.getValueAt(jtable2.getSelectedRow(), 1));
					dtm1.removeRow(jtable2.getSelectedRow());
				}
				else 
				{
					JOptionPane.showMessageDialog(frame, "Select row");
				}
			}
		});
		tab3_go.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
				try {
					Date t=ft.parse(datef.getText());
					String []main=datef.getText().split("-");
					System.out.println(con.doInBackground(site+"login/new_schedule.php?id="+main_id+"+&message="+messagef.getText().replace(" ", "mm")+"+&date="+main[2]+"-"+main[1]+"-"+main[0]));
					String []res=new String[2];
					res[0]=""+messagef.getText();
					res[1]=""+main[2]+"-"+main[1]+"-"+main[0];
					dtm1.addRow(res);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "Wrong date");
				}		
					
					
				//
			}
		});
		tab3_cancel.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tab3_go.setVisible(false);
				messagel.setVisible(false);
				datel.setVisible(false);
				messagef.setVisible(false);
				datef.setVisible(false);
				tab3_cancel.setVisible(false);
				tab3_instsend.setVisible(false);
			}
		});
		String[] result=con.doInBackground(site+"login/get_sched.php?id="+main_id).replaceAll(" ", "").replaceAll("mm", " ").split(":");
		jtable_result2=new String[result.length/2][2];
		for(int i=0;i<result.length/2;i++)
		{
			jtable_result2[i][0]=result[i*2+0];
			jtable_result2[i][1]=result[i*2+1];
		}
		String []column={"Message","Date"};
		dtm1=new DefaultTableModel(jtable_result2,column){
			
			public boolean isCellEditable(int row,int column)
			{
				return false;
			}
		};
	
		jtable2=new JTable(dtm1);
		jtable2.setFont(new Font("Serif", Font.BOLD, 20));
		jtable2.setShowHorizontalLines( false );
		jtable2.setRowSelectionAllowed( true );
		jtable2.setRowHeight(35);
		jtable2.setForeground(Color.WHITE);
		jtable2.setSelectionBackground(Color.WHITE);
		jtable2.setGridColor(new Color(10, 20, 10));
		jtable2.setSelectionForeground(Color.RED);
		jtable2.setOpaque(false);
		jtable2.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		jscrollpane2=new JScrollPane(jtable2)
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
				super.paintComponents(g);
			}
		};
		jscrollpane2.getViewport().setOpaque(false);

		jtable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
		//jscrollpane=JTable.createScrollPaneForTable(jtable);
		jscrollpane2.setBounds(680,10,700 ,300);
		tab3.add(jscrollpane2,BorderLayout.CENTER);
		tab3.setLayout(null);
		tab3.add(tab3_add);
		tab3.add(messagef);
		tab3.add(messagel);
		tab3.add(datel);
		tab3.add(datef);
		tab3.add(tab3_delete);
		tab3.add(tab3_go);
		tab3.add(tab3_cancel);
		tab3.add(tab3_instant);
		tab3.add(tab3_instsend);
		
	}
	public void createtab4()
	{
		String[] result=con.doInBackground(site+"login/get_maintain.php?id="+main_id).replaceAll(" ", "").split(":");
		String[][] jtable_result3=new String[result.length/5][5];
		for(int i=0;i<result.length/5;i++)
		{
			jtable_result3[i][0]=result[i*5+0];
			jtable_result3[i][1]=result[i*5+1];
			jtable_result3[i][2]=result[i*5+2];
			jtable_result3[i][3]=result[i*5+3];
			jtable_result3[i][4]=result[i*5+4];
		}

		String []column1={"Month","YEAR","Details ","Collection ","DEBIT"};
		System.out.println("hrllo");
		dtm2=new DefaultTableModel(jtable_result3,column1){
			
			public boolean isCellEditable(int row,int column)
			{
				return false;
			}
		};
		jtable3=new JTable(dtm2);
		jtable3.setFont(new Font("Serif", Font.BOLD, 20));
		jtable3.setShowHorizontalLines( false );
		jtable3.setRowSelectionAllowed( true );
		jtable3.setRowHeight(35);
		jtable3.setForeground(Color.WHITE);
		jtable3.setSelectionBackground(Color.WHITE);
		jtable3.setGridColor(new Color(10, 20, 10));
		jtable3.setSelectionForeground(Color.RED);
		jtable3.setOpaque(false);
		jscrollpane3=new JScrollPane(jtable3)
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon(getClass().getResource("/images/tab1b1.jpg")).getImage(), 0, 0,1366, 660, null);
				super.paintComponents(g);
			}
		};
		jscrollpane3.getViewport().setOpaque(false);

		jtable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
		//jscrollpane=JTable.createScrollPaneForTable(jtable);
		jscrollpane3.setBounds(600,10,700 ,300);
		tab4.add(jscrollpane3,BorderLayout.CENTER);
		tab4.setLayout(null);

	}
	protected JPanel createInnerPanel(String text) 
	{
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}
}


