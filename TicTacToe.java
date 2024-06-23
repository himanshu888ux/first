import java.awt.*;
import java.awt.event.*;
class TicTacToeStart extends Frame implements ActionListener
{
	Button start=new Button("start");
	Button close=new Button("close");
	Button ok=new Button("ok");
	TextField tf1=new TextField(30);
	TextField tf2=new TextField(30);
	Label l1=new Label("Player 1");
	Label l2=new Label("Player 2");
	String lname="";
	Label lp;
	static String pname1="",pname2="";
	String str="";
	Frame ft;
	Graphics g;
		TicTacToeStart()
		{
			setLayout(null);
			setSize(800,400);
			setLocation(400,300);
			setTitle("Welcome to Tic Tac Toe");
			add(start);
			add(close);
			add(tf1);
			add(tf2);
			add(l1);
			add(l2);
			setFont(new Font("calibri",Font.PLAIN,40));
			l1.setBounds(40,100,400,50);
			l2.setBounds(40,170,400,50);
			tf1.setBounds(200,100,400,50);
			tf2.setBounds(200,170,400,50);
			start.setBounds(100,300,200,50);
			close.setBounds(500,300,200,50);
			start.addActionListener(this);
			close.addActionListener(this);
			ft=new Frame();
			ft.setLayout(null);
			ft.setSize(1000,500);
			ft.setLocation(400,300);
			ft.setTitle("Enter Player Names Error");
			ft.setFont(new Font("arial",Font.PLAIN,40));
			ft.add(ok);
			ok.setBounds(200,300,100,40);
			ok.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent a)
						{
							ft.dispose();
							TicTacToeStart tsf=new TicTacToeStart();
							tsf.setVisible(true);
						}
				});
				addWindowListener(new WindowAdapter(){
						  					public void windowClosing(WindowEvent e)
						  					{
												dispose();
											}
		  		});
		}
		public void actionPerformed(ActionEvent a)
		{
			str=a.getActionCommand();
			pname1=tf1.getText();
			pname2=tf2.getText();
			if(str.equals("start"))
			{
				if(pname1.equals("")&&pname2.equals(""))
				{
					dispose();
					lname="Please Enter the player 1 and player 2 names";
					ft.setVisible(true);
					lp=new Label(lname);
					lp.setBounds(100,100,800,40);
					ft.add(lp);
				}
				else if(pname1.equals(""))
					{
					  dispose();
					  lname="Please Enter the player 1 name";
					  ft.setVisible(true);
					  lp=new Label(lname);
					  lp.setBounds(100,100,800,40);
					  ft.add(lp);
					}
					else if(pname2.equals(""))
					{
										  dispose();
										  lname="Please Enter the player 2 name";
										  ft.setVisible(true);
										  lp=new Label(lname);
										  lp.setBounds(100,100,800,40);
										  ft.add(lp);
					}
					else
					{
					   dispose();
					   TicTacToe t=new TicTacToe();
					   t.setVisible(true);
					}
			}
			if(str.equals("close"))
						{
						   dispose();
			}
		}

}
public class TicTacToe extends Frame implements ActionListener,FocusListener
{
  String str,sign="X",lab;
  Button b[]=new Button[9];
  boolean p1=true,p2;
  TicTacToeStart tn;
  Label is;
  int count=0;
  int k,i;
  long freeze,inc;
  Frame showSymbol=new Frame();
  Label symbol1=new Label(TicTacToeStart.pname1+" : X");
  Label symbol2=new Label(TicTacToeStart.pname2+" : O");
  Color color;
  public TicTacToe()
  {
	  setSize(900,600);
	  setLocation(100,200);
	  setTitle("Tic Tac Toe");
	  setLayout(new GridLayout(3,3));
	  addWindowListener(new WindowAdapter(){
		  					public void windowClosing(WindowEvent e)
		  					{
								dispose();
							}
		  		});
	  for(k=0;k<9;k++)
  	   {
		  b[k]=new Button();
		  b[k].setBackground(Color.GREEN);
		  add(b[k]);
		  b[k].addActionListener(this);
		  b[k].addFocusListener(this);
	   }
	   showSymbol.setLocation(1050,300);
	   showSymbol.setSize(800,300);
	   showSymbol.setLayout(new GridLayout(2,1));
	   showSymbol.setFont(new Font("calibri",Font.BOLD,40));
	   showSymbol.setVisible(true);
	   showSymbol.add(symbol1);
	   showSymbol.add(symbol2);

 }
	   public void focusGained(FocusEvent f)
	   {
		  Object o=f.getComponent();
		  	      for(i=0;i<9;i++)
		  	      {
		  			  if(b[i]==o)
		  			  {
		  				 b[i].setBackground(Color.gray);
		  			  }
		  }
	   }
	   public void focusLost(FocusEvent f)
	   {
			Object o=f.getComponent();
				      for(i=0;i<9;i++)
				      {
						  if(b[i]==o)
						  {
							 b[i].setBackground(Color.green);
						  }
					  }
	   }
  public void actionPerformed(ActionEvent a)
  {
			Object o=a.getSource();

			if(p1==true)
			{
				sign="X";
			}
			else
			{
			     sign="O";
			}
		  	 for(int j=0;j<9;j++)
			{
			   if(b[j]==o)
			   {
				   lab=b[j].getLabel();
				   if(lab.equals(""))
				   {
				    setFont(new Font("calibri",Font.BOLD,40));
				    b[j].setLabel(sign);
				    count++;
				    if(p1==true)
				    {
					   p1=false;
					}
					else
					p1=true;
			   	   }
			   }
			}
		if((b[0].getLabel()=="X" && b[1].getLabel()=="X" && b[2].getLabel()=="X")||
		(b[3].getLabel()=="X" && b[4].getLabel()=="X" && b[5].getLabel()=="X")||
		(b[6].getLabel()=="X" && b[7].getLabel()=="X" && b[8].getLabel()=="X")||
		(b[0].getLabel()=="X" && b[3].getLabel()=="X" && b[6].getLabel()=="X")||
		(b[1].getLabel()=="X" && b[4].getLabel()=="X" && b[7].getLabel()=="X")||
		(b[2].getLabel()=="X" && b[5].getLabel()=="X" && b[8].getLabel()=="X")||
		(b[0].getLabel()=="X" && b[4].getLabel()=="X" && b[8].getLabel()=="X")||
		(b[2].getLabel()=="X" && b[4].getLabel()=="X" && b[6].getLabel()=="X"))
		{
			showSymbol.dispose();
			if((b[0].getLabel()=="X" && b[1].getLabel()=="X" && b[2].getLabel()=="X"))
			{
				b[0].setBackground(Color.MAGENTA);
				b[1].setBackground(Color.MAGENTA);
				b[2].setBackground(Color.MAGENTA);
			}
			else if ((b[3].getLabel()=="X" && b[4].getLabel()=="X" && b[5].getLabel()=="X")) {
				
				b[3].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[5].setBackground(Color.MAGENTA);
			}
			else if ((b[6].getLabel()=="X" && b[7].getLabel()=="X" && b[8].getLabel()=="X")) {
				b[6].setBackground(Color.MAGENTA);
				b[7].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[0].getLabel()=="X" && b[3].getLabel()=="X" && b[6].getLabel()=="X")) {
				
				b[0].setBackground(Color.MAGENTA);
				b[3].setBackground(Color.MAGENTA);
				b[6].setBackground(Color.MAGENTA);
			}
			else if((b[1].getLabel()=="X" && b[4].getLabel()=="X" && b[7].getLabel()=="X"))
			{
				b[1].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[7].setBackground(Color.MAGENTA);
			}
			else if((b[2].getLabel()=="X" && b[5].getLabel()=="X" && b[8].getLabel()=="X"))
			{
				b[2].setBackground(Color.MAGENTA);
				b[5].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[0].getLabel()=="X" && b[4].getLabel()=="X" && b[8].getLabel()=="X")) {
				b[0].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[2].getLabel()=="X" && b[4].getLabel()=="X" && b[6].getLabel()=="X")) {
				b[2].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[6].setBackground(Color.MAGENTA);
			}
			
			
			for(i=0;i<9;i++)
		  		      {
							 b[i].setEnabled(false);
					  }
						Label l=new Label("Congratulations "+TicTacToeStart.pname1+" is winner");
						Frame f=new Frame("Winner");
						f.setResizable(false);
						f.setLayout(new GridLayout(4,1));
						f.add(l);
						f.setFont(new Font("calibri",Font.BOLD,40));
						f.setLocation(1050,300);
						f.setSize(800,300);
						f.setVisible(true);
						is=new Label("Do you want to play again:");
						f.add(is);
						Button b=new Button("yes");
					    f.add(b);
					    b.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent a)
							{
							    dispose();
							    tn=new TicTacToeStart();
							    tn.setVisible(true);
							    f.dispose();
							}
						});
						Button no=new Button("no");
						f.add(no);
						no.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent a)
						{
							dispose();
							f.dispose();
						}
						});
		}
		else if((b[0].getLabel()=="O" && b[1].getLabel()=="O" && b[2].getLabel()=="O")||
		(b[3].getLabel()=="O" && b[4].getLabel()=="O" && b[5].getLabel()=="O")||
		(b[6].getLabel()=="O" && b[7].getLabel()=="O" && b[8].getLabel()=="O")||
		(b[0].getLabel()=="O" && b[3].getLabel()=="O" && b[6].getLabel()=="O")||
		(b[1].getLabel()=="O" && b[4].getLabel()=="O" && b[7].getLabel()=="O")||
		(b[2].getLabel()=="O" && b[5].getLabel()=="O" && b[8].getLabel()=="O")||
		(b[0].getLabel()=="O" && b[4].getLabel()=="O" && b[8].getLabel()=="O")||
		(b[2].getLabel()=="O" && b[4].getLabel()=="O" && b[6].getLabel()=="O"))
		{
			showSymbol.dispose();
			if((b[0].getLabel()=="O" && b[1].getLabel()=="O" && b[2].getLabel()=="O"))
			{
				b[0].setBackground(Color.MAGENTA);
				b[1].setBackground(Color.MAGENTA);
				b[2].setBackground(Color.MAGENTA);
				b[2].setBackground(Color.MAGENTA);
			}
			else if ((b[3].getLabel()=="O" && b[4].getLabel()=="O" && b[5].getLabel()=="O")) {
				
				b[3].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[5].setBackground(Color.MAGENTA);
			}
			else if ((b[6].getLabel()=="O" && b[7].getLabel()=="O" && b[8].getLabel()=="O")) {
				b[6].setBackground(Color.MAGENTA);
				b[7].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[0].getLabel()=="O" && b[3].getLabel()=="O" && b[6].getLabel()=="O")) {
				
				b[0].setBackground(Color.MAGENTA);
				b[3].setBackground(Color.MAGENTA);
				b[6].setBackground(Color.MAGENTA);
			}
			else if((b[1].getLabel()=="O" && b[4].getLabel()=="O" && b[7].getLabel()=="O"))
			{
				b[1].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[7].setBackground(Color.MAGENTA);
			}
			else if((b[2].getLabel()=="O" && b[5].getLabel()=="O" && b[8].getLabel()=="O"))
			{
				b[2].setBackground(Color.MAGENTA);
				b[5].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[0].getLabel()=="O" && b[4].getLabel()=="O" && b[8].getLabel()=="O")) {
				b[0].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[8].setBackground(Color.MAGENTA);
			}
			else if ((b[2].getLabel()=="O" && b[4].getLabel()=="O" && b[6].getLabel()=="O")) {
				b[2].setBackground(Color.MAGENTA);
				b[4].setBackground(Color.MAGENTA);
				b[6].setBackground(Color.MAGENTA);
			}
			
			

			for(i=0;i<9;i++)
					  		      {
										 b[i].setEnabled(false);
					  }
			Label l=new Label("Congratulations "+TicTacToeStart.pname2+" is winner");
			Frame f=new Frame();
			f.add(l);
			f.setLayout(new GridLayout(4,1));
			f.setFont(new Font("calibri",Font.BOLD,40));
			f.setResizable(false);
			f.setLocation(1050,300);
			f.setSize(800,300);
			f.setVisible(true);
			is=new Label("Do you want to play again:");
			f.add(is);
			Button b=new Button("yes");
								    f.add(b);
								    b.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent a)
										{
										    dispose();
										    tn=new TicTacToeStart();
										    tn.setVisible(true);
										    f.dispose();
										}
						});
						Button no=new Button("no");
														    f.add(no);
														    no.addActionListener(new ActionListener(){
																public void actionPerformed(ActionEvent a)
																{
																    dispose();
																    f.dispose();
																	showSymbol.dispose();
																}
						});
	}
		else if(count==9){
			 showSymbol.dispose();
			 for(i=0;i<9;i++)
			 	      {
			 						 b[i].setEnabled(false);
					  }
				Label l=new Label("Draw");
							Frame f=new Frame("Winner");
							f.add(l);
							f.setLayout(new GridLayout(4,1));
							f.setFont(new Font("calibri",Font.BOLD,40));
							f.setLocation(1050,300);
							f.setSize(800,300);
							f.setResizable(false);
							f.setVisible(true);
							is=new Label("Do you want to play again:");
							f.add(is);
							Button b=new Button("yes");
												    f.add(b);
												    b.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent a)
														{
														    dispose();
														    tn=new TicTacToeStart();
														    tn.setVisible(true);
														    f.dispose();
														}
						});
						Button no=new Button("no");
					    f.add(no);
					    no.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent a)
															{
																	    dispose();
																	    f.dispose();
															}
						});


  }
}

public static void main(String args[])
{
	 TicTacToeStart t=new TicTacToeStart();
	 t.setVisible(true);
}
}