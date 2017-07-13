package b;
import java.awt.*;
import javax.swing.*;

public class TestPanels extends JFrame{
	public TestPanels() {
		//创建一个panel放按钮，设置成矩阵方式排列
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,3));
		
		for(int i=1; i<=9; i++){
			p1.add(new JButton("" + i));
		}
		
		p1.add(new JButton("" + 0));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		//再创建一个panel做右边的操作面板
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(new JTextField("Time to be displayed here"),BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		
		//把操作面板和微波炉的门放在一起
		add(p2, BorderLayout.EAST);
		add(new JButton("Food to be placed here"),BorderLayout.CENTER);
	}
	
	public static void main(String[] args)
	{
		TestPanels frame = new TestPanels();
		frame.setTitle("The Front View of a Microwave Oven");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,250);
		frame.setVisible(true);
	}
}
