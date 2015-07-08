import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.net.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class QuizNework
{
	//String url;
	public QuizNework(){
		//url = u;
	}
	public String convertInputStreamToString(InputStream inputStream) throws IOException
	  {
	      BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
	      String line = "";
	      String result = "";
	      while((line = bufferedReader.readLine()) != null)
	          result += line;

	      inputStream.close();
	      return result;

	  }
	public String doInBackground(String url) {
		InputStream inputStream = null;
        String result = "";
        try {
 
            // create HttpClient
            
			HttpClient httpclient = new DefaultHttpClient();
          
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
          
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
         
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
        	e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Cannot connect to server");
            
        }
       
		return result;
	}

	
	
	
}
class Login
{
	final JFrame frame;
	JTextField usernm;
	JPasswordField pass;
	JButton login;
	QuizNework con;
	private JButton signup;
	private JLabel label;
	private JLabel label1;
	String site;
Login(){
			site="http://localhost/";
			con=new QuizNework();
			Font f=new Font("Microsoft JhengHei Light",Font.PLAIN,20);
			frame = new JFrame();
			
			frame.setTitle("FlatPro");
			frame.setLayout(null);
			label1=new JLabel("FREE For One Month");
			label1.setVisible(false);
			label1.setBounds(1100,300,117,30);
			label1.setForeground(Color.WHITE);
			signup=new JButton("Signup");
			signup.setBounds(1100,245,117,50);
			signup.setBackground(new Color(0, 25, 0));
			signup.setForeground(Color.RED);
			signup.addFocusListener(new FocusListener() {
				
				
				public void focusLost(FocusEvent arg0) {
					
					label1.setVisible(false);
				}
				
				
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					label1.setVisible(true);
				}
			});
			signup.setToolTipText("Free for 1 month");
			signup.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						Desktop.getDesktop().browse(new URI("http://localhost/login/signup"));
					} catch ( URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			ImageIcon icon = new ImageIcon(getClass().getResource("/images/main2.jpg"));
			JLabel label = new JLabel(icon);
			frame.setContentPane(label);
			login =new JButton(new ImageIcon(getClass().getResource("/images/index.jpg")));
			login.setBounds(1100,175, 117, 50);
			login.setOpaque(true);
			login.addActionListener(new ActionListener() {
				
				
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						
						String[] ans=con.doInBackground(site+"login/index.php?username="+usernm.getText().toString()+"+&pass="+pass.getText().toString()).split(" ");
						System.out.println(""+ans.toString());
						String [] arr = ans[1].split(":");
						arr[0]="YES";
						if(("YES").equalsIgnoreCase("YES"))
						{
							//System.out.println("in if");
							JFrame frame1=new JFrame();
							JOptionPane.showMessageDialog(frame1,  "Soccesfully logged in");
							frame.removeNotify();
							new JTappedPaneDemo1(Integer.parseInt(""+2));
						} 
						else
						{
							JFrame frame1=new JFrame();
							JOptionPane.showMessageDialog(frame1,  "Wrong111 Password or Username");
						}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}
					
				}
				
			});
			//contentPane = frame.getContentPane();
			
			
			usernm = new JTextField(20);
			usernm.setBounds(1080, 45, 250, 40);
			usernm.setOpaque(false);
			usernm.setFont(f);
			usernm.setForeground(Color.RED);
			usernm.setToolTipText("Username");
			pass=new JPasswordField(20);
			pass.setBounds(1080, 115, 250, 40);
			pass.setOpaque(false);
			pass.setForeground(Color.WHITE);
			pass.setToolTipText("Password");
			pass.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
						try {
						
						String[] ans=con.doInBackground(site+"login/index.php?username="+usernm.getText().toString()+"+&pass="+pass.getText().toString()).split(" ");
						for(int i=0;i<ans.length;i++)
							System.out.println(""+ans[i]);
						String [] arr = ans[1].split(":");
						if(arr[0].equalsIgnoreCase("YES"))
						{
							//System.out.println("in if");
							JFrame frame1=new JFrame();
							JOptionPane.showMessageDialog(frame1,  "Soccesfully logged in");
							frame.removeNotify();
							new JTappedPaneDemo1(Integer.parseInt(arr[1]));
						} 
						else
						{
							JFrame frame1=new JFrame();
							JOptionPane.showMessageDialog(frame1,  "Wrong111 Password or Username");
						}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}
					
				}
			});
			usernm.setFont(f);
			
			
			frame.add(login);
			frame.add(usernm);
			frame.add(pass);
			frame.add(signup);
			frame.add(label1);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setSize(1366,768);
			frame.setVisible(true);
			frame.setBackground(Color.BLACK);
			frame.setResizable(false);
		}
} 
public class FlatPro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Connection conn=new Connection();		
		new Login();
	}

}
