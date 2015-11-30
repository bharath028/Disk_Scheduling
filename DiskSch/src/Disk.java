import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Disk {

	private JFrame frame;
	public JTextField head;
	public JTextField num;
	public JTextField start;
	public JTextField end;
	public JTextField res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disk window = new Disk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Disk() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 485, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("FCFS");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random R= new Random();
				int hd,st,ed,n,i,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				System.out.println("Input");
				 	    int[] a = new int[n];
				 	    for (i = 0; i < n; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st) + st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
				 	    if ((hd-a[0])<0)
				 	    {
				 	    	count = a[0]-hd;
				 	    }
				 	    else
				 	    {
				 	    	count = hd-a[0];
				 	    }
				 	    System.out.println(hd+" "+a[0]);
				 	    for (i = 1; i < n; i++)
				 	    {
				 	    	if ((a[i]-a[i-1])<0)
				 	 	    {
				 	 	    	count=count + (a[i-1]-a[i]);
				 	 	    	 System.out.println(a[i-1]+" "+a[i]);
				 	 	    }
				 	 	    else
				 	 	    {
				 	 	    	count=count - (a[i-1]-a[i]);
				 	 	    	System.out.println(a[i-1]+" "+a[i]);
				 	 	    }

				 	     }
				 	    System.out.println("Total Seek Time");
				 	    System.out.println(count);
				 	   res.setText(String.valueOf(count));
				 	   
				 	}
		});
		btnNewButton.setBounds(37, 28, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SSTF");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int hd,st,ed,n,i,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int d[]=new int[n];
				int in[]=new int[n];
				System.out.println("Input");
				for(i=0;i<n;i++)
				{
					in[i]=R.nextInt(ed-st)+st;
					System.out.println(in[i]);
				}
				int m=0,k=0;
				System.out.println("Output :");
				for(i=0;i<n;i++)
				{
					for(k=0;k<n;k++)
					{
							d[k]=in[k]-hd;
							if(d[k]<0)
								d[k]=-d[k];
					}
					m=fun(d,n);
					System.out.println(hd+" "+in[m]);
					if(in[m]>hd)
						count=count+(in[m]-hd);
					else
						count=count+(hd-in[m]);
					hd=in[m];
					in[m]=100000000;
				}
				res.setText(String.valueOf(count));
			}
			public int fun(int a[],int n)
			{
				int min=a[0],j,p=0;
				for(j=0;j<n;j++)
				{
					if(a[j]<min)
					{
						min=a[j];
						p=j;
					}
				}
				return p;
			}
				
		});
		btnNewButton_1.setBounds(37, 62, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LOOK");
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int hd,st,ed,i,n,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				System.out.println("Input");
				 	    int[] a = new int[n+1];
				 	    a[0]=hd;
				 	    for (i = 1; i < n+1; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st)+st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
				 	    System.out.println(hd);
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for ( i = 0; i < (n+1); i++)
					    {
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for ( i = p; i > 0; i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }

					     }
					    if((a[p+1]-a[0])>0)
					    {
					    	count = count + (a[p+1]-a[0]);
					    	System.out.println(a[0]+" "+a[p+1]);
					    }
					    else
					    {
					    	count= count-(a[p+1]-a[0]); 
					    }
					    for (i = (p+1); i < (n); i++)
					    {
					    	if ((a[i]-a[i+1])<0)
					 	    {
					 	    	count=count + (a[i+1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i+1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i+1]-a[i]);
					 	    	System.out.println(a[i+1]+" "+a[i]);
					 	    }
					     }
					    System.out.println(count);
					    res.setText(String.valueOf(count));
			}
		});
		btnNewButton_2.setBounds(37, 96, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("SCAN");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random R= new Random();
				int hd,st,ed,n,i,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				System.out.println("Input");
				 	    int[] a = new int[n+1];
				 	    a[0]=hd;
				 	    for (i = 1; i < n+1; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st)+st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for ( i = 0; i < (n+1); i++)
					    {
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for (i = p; i > 0; i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	        System.out.println(a[i-1]+" "+a[i]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }

					     }
				    	 System.out.println(a[i]+" "+ 0);
				    	 if(p+1<n+1)
				    	 {
				    	 System.out.println(0+" "+a[p+1]);
					    if((a[p+1]-a[0])>0)
					    {
					    	count = count + (a[p+1]-a[0]);
					    }
					    else
					    {
					    	count= count-(a[p+1]-a[0]); 
					    }
					    for (i = (p+1); i < (n); i++)
					    {
					    	 if ((a[i]-a[i+1])<0)
					 	    {
					 	    	count=count + (a[i+1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i+1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i+1]-a[i]);
					 	    	System.out.println(a[i+1]+" "+a[i]);
					 	    }

					     }
				    	 }
					    count=count+(2*(a[0]-st));
					    System.out.println(count);
					    res.setText(String.valueOf(count));
				
			}
		});
		btnNewButton_3.setBounds(37, 170, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CSCAN");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int n,i, hd,st,ed;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int a[]=new int[n+1];
				System.out.println("Input");
			    int head=hd;
			    int lb=st,ub=ed;
				for(i=1;i<n+1;i++)
				{
					a[i]=R.nextInt(ub-lb)+lb;
					System.out.println(a[i]);
				}	
				System.out.println("Output: ");
					    a[0]=head;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for (i = 0; i < (n+1); i++)
					    {
					        if(a[i]==head)
					        {
					        	p=i;
					        }
					    }
					    int count=0;
					    for (i = p; i > 0; i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    }
					     }
				    	 System.out.println(a[0]+" "+st);
				    	 System.out.println(ed+" "+a[n]);
					    for (i = n; i > (p+1); i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    }
					     }
					    count=count+(a[0]-lb)+(ub-a[n]);
					    System.out.println(count);
					    res.setText(String.valueOf(count));
					}
		});
		btnNewButton_4.setBounds(37, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CLOOK");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random R= new Random();
				int hd,st,ed,n,i,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int a[]=new int[n+1];
				System.out.println("Input");
				for(i=1;i<n+1;i++)
				{
					a[i]=R.nextInt(ed-st)+st;
					System.out.println(a[i]);
				}		
					    a[0]=hd;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    System.out.println("Output :");
					    for (i = 0; i < (n+1); i++)
					    {
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for (i = p; i > 0; i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }
					     }
					    for ( i = n; i > (p+1); i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    }
					     }
					    System.out.println(count);
					    res.setText(String.valueOf(count));
					}
		});
		btnNewButton_5.setBounds(37, 136, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		head = new JTextField();
		head.setForeground(Color.BLACK);
		head.setBounds(173, 41, 86, 20);
		frame.getContentPane().add(head);
		head.setColumns(10);
		
		num = new JTextField();
		num.setText("");
		num.setBounds(173, 173, 86, 20);
		frame.getContentPane().add(num);
		num.setColumns(10);
		
		start = new JTextField();
		start.setBounds(173, 99, 86, 20);
		frame.getContentPane().add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setText("");
		end.setBounds(335, 99, 86, 20);
		frame.getContentPane().add(end);
		end.setColumns(10);
		
		res = new JTextField();
		res.setBounds(335, 173, 86, 20);
		frame.getContentPane().add(res);
		res.setColumns(10);
		
		JLabel lblOutput = new JLabel("Seek Time");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(335, 136, 89, 23);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblHead = new JLabel("Head");
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHead.setForeground(Color.BLACK);
		lblHead.setBounds(173, 16, 46, 14);
		frame.getContentPane().add(lblHead);
		
		JLabel lblNum = new JLabel("Num");
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNum.setBounds(173, 140, 46, 14);
		frame.getContentPane().add(lblNum);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStart.setBounds(173, 72, 46, 14);
		frame.getContentPane().add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnd.setBounds(335, 72, 46, 14);
		frame.getContentPane().add(lblEnd);
	}
}


