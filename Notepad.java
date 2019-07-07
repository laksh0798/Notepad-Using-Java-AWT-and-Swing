
import java.io.*;	
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class Notepad extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu file, format, color, font, style;
	JMenuItem new1, open, save, exit;
	JRadioButtonMenuItem yellow, orange, blue, arial, serif, times;
	JCheckBoxMenuItem bold, italic;
	JTextArea ta;
	JScrollPane sc;
	JToolBar tb;
	Container con;
	JFileChooser fc;
	JButton btnnew, btnopen, btnsave;
	 //JComboBox fonts,font_size;
     Font textfont,defaultfont;
	
	public Notepad()
	{
		fc=new JFileChooser(".");
		mb= new JMenuBar();
		setJMenuBar(mb);
		con=this.getContentPane();
		con.setLayout(new BorderLayout());
		file=new JMenu("File");
		file.setMnemonic('F');
		format=new JMenu("Format");
		
		mb.add(file);
		mb.add(format);
		
		new1=new JMenuItem("New");
		open=new JMenuItem("Open");
		save=new JMenuItem("Save");
		exit=new JMenuItem("Exit");
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(exit);
		
		color=new JMenu("Color");
		font= new JMenu("Font");
		style=new JMenu("Style");
		format.add(color);
		format.add(font);
		format.add(style);
		yellow=new JRadioButtonMenuItem("yellow");
		orange=new JRadioButtonMenuItem("orange");
		blue=new JRadioButtonMenuItem("blue");
		color.add(blue);
		color.add(yellow);
		color.add(orange);
		ButtonGroup bg=new ButtonGroup();
		bg.add(blue);
		bg.add(orange);
		bg.add(yellow);
		times=new JRadioButtonMenuItem("Times New Roman");
		arial=new JRadioButtonMenuItem("Arial");
		serif=new JRadioButtonMenuItem("Segoe Script");
		font.add(arial);
		font.add(serif);
		font.add(times);
		ButtonGroup bg1= new ButtonGroup();
		bg1.add(arial);
		bg1.add(serif);
		bg1.add(times);
		bold= new JCheckBoxMenuItem("Bold");
		italic=new JCheckBoxMenuItem("Italic");
		style.add(bold);
		style.add(italic);
		
		
		ta=new JTextArea();
		sc= new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(BorderLayout.CENTER, sc);
		tb= new JToolBar(JToolBar.HORIZONTAL);
		tb.setFloatable(false);
		con.add(BorderLayout.NORTH, tb);
		
		btnopen=new JButton(new ImageIcon("C://xampp//apache//icons//folder.gif"));
		btnsave=new JButton(new ImageIcon("/E:/AJP/savee.gif"));
		btnnew=new JButton(new ImageIcon("/E:/AJP/neww.gif"));
		//String f[]={"Arial","Segoe Script", "Times New Roman"};
	    //fonts=new JComboBox(f);
	    //String s[]={"18","20","22","24","26","28"};
	    //font_size=new JComboBox(s);
	    tb.add(btnsave);
		tb.add(btnopen);
		tb.add(btnnew);
		//tb.add(fonts);
        //tb.add(font_size);
        
        btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
        btnopen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					open();
				}
				catch(Exception e) { }
			}
		});
        btnnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
			}
		});
        yellow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ta.setForeground(Color.yellow);
			}
		});
        blue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ta.setForeground(Color.blue);
			}
		});
        orange.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ta.setForeground(Color.orange);
			}
		});
        serif.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				Font f= new Font("Segoe Script", Font.PLAIN, 20);
				ta.setFont(f);
			}
		});
        arial.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				Font f= new Font("Arial", Font.PLAIN, 20);
				ta.setFont(f);
			}
		});
        times.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				Font f= new Font("Times New Roman", Font.PLAIN, 20);
				ta.setFont(f);
			}
		});
        bold.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Font fa=ta.getFont();
				if(!italic.isSelected()) {
				
				Font f= new Font(fa.getFamily(),
		         Font.BOLD, 20);
				ta.setFont(f);
				}
				else if(italic.isSelected())
				{
					Font f= new Font(fa.getFamily(),
					         Font.ITALIC, 20);
					ta.setFont(f);
				}
			}
		});
        italic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			Font fa=ta.getFont();
				if(!bold.isSelected()) {
					Font f= new Font(fa.getFamily(),
					         Font.ITALIC, 20);
					ta.setFont(f);

					}
					else
					{
						Font f= new Font(fa.getFamily(),
						         Font.ITALIC, 20);
						ta.setFont(f);

					}
			}
		});
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
        new1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
        open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {open(); }
				catch(Exception e1) { }
			}
		});
        save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {save(); }
				catch(Exception e1) { }	}
		});
	}
	
	public void save()
	{
		int i=fc.showSaveDialog(this);
		String filename="";
		if(i==JFileChooser.APPROVE_OPTION)
		{
			filename = fc.getSelectedFile().getAbsolutePath();
			String s= ta.getText();
			RTFEditorKit kit = new RTFEditorKit();
			BufferedOutputStream out;
			try {
			out = new BufferedOutputStream(new FileOutputStream(filename));
			FileWriter fw= new FileWriter(filename);
			//Reader r=ta.getText();
			//fw.write(s);
			out.write(s.getBytes());
			//kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
			out.flush();
			out.close();
			} catch (Exception E) {
			System.out.println("Err:" + E.toString());
			}
		}
	}
	
	
	public void open() throws IOException
	{
		int i=fc.showOpenDialog(this);
		if(i==JFileChooser.APPROVE_OPTION)
		{
			File f= fc.getSelectedFile();
			BufferedReader br= new BufferedReader(new FileReader(f));
			String str, str1="";
			while((str=br.readLine())!=null)
			{
				str1+= str + "\n";
			}
			ta.setText(str1);
		}
	}


	public void actionPerformed(ActionEvent e) {
		String btnpressed=e.getActionCommand();
		System.out.println(btnpressed);
		if(btnpressed.equalsIgnoreCase("exit"))
			System.exit(0);
		else if(btnpressed.equalsIgnoreCase("open"))
		{
			try {open(); }
			catch(Exception e1) { }
		}
		else if(btnpressed.equalsIgnoreCase("save"))
		{
			try {save(); }
			catch(Exception e2) { }
		}
		else
		{
			ta.setText("");
		}
	}
	
	public static void main(String []args) throws Exception {
		Notepad t= new Notepad();
		t.setSize(400, 400);
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}