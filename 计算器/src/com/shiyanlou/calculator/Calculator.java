package com.shiyanlou.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.math.BigDecimal;

public class Calculator {

    // \u64cd\u4f5c\u65701\uff0c\u4e3a\u4e86\u7a0b\u5e8f\u7684\u5b89\u5168\uff0c\u521d\u503c\u4e00\u5b9a\u8bbe\u7f6e\uff0c\u8fd9\u91cc\u6211\u4eec\u8bbe\u7f6e\u4e3a0\u3002
	String str1 = "0"; 
	
	// \u64cd\u4f5c\u65702
	String str2 = "0"; 
	
	// \u8fd0\u7b97\u7b26
	String signal = "+"; 
	
	// \u8fd0\u7b97\u7ed3\u679c
	String result = "";

	// \u4ee5\u4e0bk1\u81f3k2\u4e3a\u72b6\u6001\u5f00\u5173
	
	// \u5f00\u51731\u7528\u4e8e\u9009\u62e9\u8f93\u5165\u65b9\u5411\uff0c\u5c06\u8981\u5199\u5165str1\u6216str2
	int k1 = 1;
	// \u5f00\u51732\u7528\u4e8e\u8bb0\u5f55\u7b26\u53f7\u952e\u7684\u6b21\u6570\uff0c\u5982\u679c k2>1 \u8bf4\u660e\u8fdb\u884c\u7684\u662f 2+3-9+8 \u8fd9\u6837\u7684\u591a\u7b26\u53f7\u8fd0\u7b97
	int k2 = 1;
	// \u5f00\u51733\u7528\u4e8e\u6807\u8bc6 str1 \u662f\u5426\u53ef\u4ee5\u88ab\u6e050 \uff0c\u7b49\u4e8e1\u65f6\u53ef\u4ee5\uff0c\u4e0d\u7b49\u4e8e1\u65f6\u4e0d\u80fd\u88ab\u6e050
	int k3 = 1;
	// \u5f00\u51734\u7528\u4e8e\u6807\u8bc6 str2 \u662f\u5426\u53ef\u4ee5\u88ab\u6e050
	int k4 = 1;
	// \u5f00\u51735\u7528\u4e8e\u63a7\u5236\u5c0f\u6570\u70b9\u53ef\u5426\u88ab\u5f55\u5165\uff0c\u7b49\u4e8e1\u65f6\u53ef\u4ee5\uff0c\u4e0d\u4e3a1\u65f6\uff0c\u8f93\u5165\u7684\u5c0f\u6570\u70b9\u88ab\u4e22\u6389
	int k5 = 1;
	// store\u7684\u4f5c\u7528\u7c7b\u4f3c\u4e8e\u5bc4\u5b58\u5668\uff0c\u7528\u4e8e\u8bb0\u5f55\u662f\u5426\u8fde\u7eed\u6309\u4e0b\u7b26\u53f7\u952e
	JButton store; 
	
	@SuppressWarnings("rawtypes")
	Vector vt = new Vector(20, 10);

    // \u58f0\u660e\u5404\u4e2aUI\u7ec4\u4ef6\u5bf9\u8c61\u5e76\u521d\u59cb\u5316
	JFrame frame = new JFrame("Calculator");
	JTextField result_TextField = new JTextField(result, 20);
	JButton clear_Button = new JButton("Clear");
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button_Dian = new JButton(".");
	JButton button_jia = new JButton("+");
	JButton button_jian = new JButton("-");
	JButton button_cheng = new JButton("*");
	JButton button_chu = new JButton("/");
	JButton button_dy = new JButton("=");

    // \u8ba1\u7b97\u673a\u7c7b\u7684\u6784\u9020\u5668
	public Calculator() {
	
	    // \u4e3a\u6309\u94ae\u8bbe\u7f6e\u7b49\u6548\u952e\uff0c\u5373\u53ef\u4ee5\u901a\u8fc7\u5bf9\u5e94\u7684\u952e\u76d8\u6309\u952e\u6765\u4ee3\u66ff\u70b9\u51fb\u5b83
		button0.setMnemonic(KeyEvent.VK_0);
		// \u5176\u5b83\u7b49\u6548\u952e\u7701\u7565\uff0c\u4f60\u53ef\u4ee5\u81ea\u884c\u8865\u5145\u5b8c\u6574

        // \u8bbe\u7f6e\u6587\u672c\u6846\u4e3a\u53f3\u5bf9\u9f50\uff0c\u4f7f\u8f93\u5165\u548c\u7ed3\u679c\u90fd\u9760\u53f3\u663e\u793a
		result_TextField.setHorizontalAlignment(JTextField.RIGHT);

        // \u5c06UI\u7ec4\u4ef6\u6dfb\u52a0\u8fdb\u5bb9\u5668\u5185
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4, 4, 5, 5));
		pan.add(button7);
		pan.add(button8);
		pan.add(button9);
		pan.add(button_chu);
		pan.add(button4);
		pan.add(button5);
		pan.add(button6);
		pan.add(button_cheng);
		pan.add(button1);
		pan.add(button2);
		pan.add(button3);
		pan.add(button_jian);
		pan.add(button0);
		pan.add(button_Dian);
		pan.add(button_dy);
		pan.add(button_jia);
		pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		pan2.add(result_TextField, BorderLayout.WEST);
		pan2.add(clear_Button, BorderLayout.EAST);

        // \u8bbe\u7f6e\u4e3b\u7a97\u53e3\u51fa\u73b0\u5728\u5c4f\u5e55\u4e0a\u7684\u4f4d\u7f6e
		frame.setLocation(300, 200);
		// \u8bbe\u7f6e\u7a97\u4f53\u4e0d\u80fd\u8c03\u5927\u5c0f
		frame.setResizable(false); 
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(pan2, BorderLayout.NORTH);
		frame.getContentPane().add(pan, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

		// \u4e8b\u4ef6\u5904\u7406\u7a0b\u5e8f

		// \u6570\u5b57\u952e
		class Listener implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String ss = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						
						// \u8fd8\u539f\u5f00\u5173k5\u72b6\u6001
						k5 = 1;
					}
					str1 = str1 + ss;

					k3 = k3 + 1;
                    
                    // \u663e\u793a\u7ed3\u679c
					result_TextField.setText(str1);

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						
						// \u8fd8\u539f\u5f00\u5173k5\u72b6\u6001
						k5 = 1; 
					}
					str2 = str2 + ss;
					k4 = k4 + 1;
					result_TextField.setText(str2);
				}

			}
		}

		// \u8f93\u5165\u7684\u8fd0\u7b97\u7b26\u53f7\u7684\u5904\u7406
		class Listener_signal implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String ss2 = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);

				if (k2 == 1) {
				    // \u5f00\u5173 k1 \u4e3a 1 \u65f6\u5411\u6570 1 \u5199\u8f93\u5165\u503c\uff0c\u4e3a2\u65f6\u5411\u65702\u5199\u8f93\u5165\u503c\u3002
					k1 = 2;
					k5 = 1;
					signal = ss2;
					k2 = k2 + 1;// \u6309\u7b26\u53f7\u952e\u7684\u6b21\u6570
				} else {
					int a = vt.size();
					JButton c = (JButton) vt.get(a - 2);

					if (!(c.getText().equals("+"))
							&& !(c.getText().equals("-"))
							&& !(c.getText().equals("*"))
							&& !(c.getText().equals("/")))

					{
						cal();
						str1 = result;
						// \u5f00\u5173 k1 \u4e3a 1 \u65f6\uff0c\u5411\u6570 1 \u5199\u503c\uff0c\u4e3a2\u65f6\u5411\u65702\u5199
						k1 = 2;
						k5 = 1;
						k4 = 1;
						signal = ss2;
					}
					k2 = k2 + 1;

				}

			}
		}

		// \u6e05\u9664\u952e\u7684\u903b\u8f91\uff08Clear\uff09
		class Listener_clear implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				store = (JButton) e.getSource();
				vt.add(store);
				k5 = 1;
				k2 = 1;
				k1 = 1;
				k3 = 1;
				k4 = 1;
				str1 = "0";
				str2 = "0";
				signal = "";
				result = "";
				result_TextField.setText(result);
				vt.clear();
			}
		}

		// \u7b49\u4e8e\u952e\u7684\u903b\u8f91
		class Listener_dy implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {

				store = (JButton) e.getSource();
				vt.add(store);
				cal();
				
				// \u8fd8\u539f\u5404\u4e2a\u5f00\u5173\u7684\u72b6\u6001
				k1 = 1; 
				k2 = 1;
				k3 = 1;
				k4 = 1;

				str1 = result; 
			}
		}
		
		// \u5c0f\u6570\u70b9\u7684\u5904\u7406
		class Listener_xiaos implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				store = (JButton) e.getSource();
				vt.add(store);
				if (k5 == 1) {
					String ss2 = ((JButton) e.getSource()).getText();
					if (k1 == 1) {
						if (k3 == 1) {
							str1 = "";
							// \u8fd8\u539f\u5f00\u5173k5\u72b6\u6001
							k5 = 1; 
						}
						str1 = str1 + ss2;

						k3 = k3 + 1;

                        // \u663e\u793a\u7ed3\u679c
						result_TextField.setText(str1);

					} else if (k1 == 2) {
						if (k4 == 1) {
							str2 = "";
							// \u8fd8\u539f\u5f00\u5173k5\u7684\u72b6\u6001
							k5 = 1;
						}
						str2 = str2 + ss2;

						k4 = k4 + 1;

						result_TextField.setText(str2);
					}
				}

				k5 = k5 + 1;
			}
		}

		// \u6ce8\u518c\u5404\u4e2a\u76d1\u542c\u5668\uff0c\u5373\u7ed1\u5b9a\u4e8b\u4ef6\u54cd\u5e94\u903b\u8f91\u5230\u5404\u4e2aUI\u7ec4\u4ef6\u4e0a
		Listener_dy jt_dy = new Listener_dy();
		
		// \u76d1\u542c\u6570\u5b57\u952e
		Listener jt = new Listener();
		// \u76d1\u542c\u7b26\u53f7\u952e
		Listener_signal jt_signal = new Listener_signal();
		// \u76d1\u542c\u6e05\u9664\u952e
		Listener_clear jt_c = new Listener_clear(); 
		// \u76d1\u542c\u5c0f\u6570\u70b9\u952e
		Listener_xiaos jt_xs = new Listener_xiaos();

		button7.addActionListener(jt);
		button8.addActionListener(jt);
		button9.addActionListener(jt);
		button_chu.addActionListener(jt_signal);
		button4.addActionListener(jt);
		button5.addActionListener(jt);
		button6.addActionListener(jt);
		button_cheng.addActionListener(jt_signal);
		button1.addActionListener(jt);
		button2.addActionListener(jt);
		button3.addActionListener(jt);
		button_jian.addActionListener(jt_signal);
		button0.addActionListener(jt);
		button_Dian.addActionListener(jt_xs);
		button_dy.addActionListener(jt_dy);
		button_jia.addActionListener(jt_signal);
		clear_Button.addActionListener(jt_c);

		// \u7a97\u4f53\u5173\u95ed\u4e8b\u4ef6\u7684\u54cd\u5e94\u7a0b\u5e8f
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	// \u8ba1\u7b97\u903b\u8f91
	public void cal() {
    	// \u64cd\u4f5c\u65701
		double a2;
		// \u64cd\u4f5c\u65702
		double b2;
		// \u8fd0\u7b97\u7b26
		String c = signal;
		// \u8fd0\u7b97\u7ed3\u679c
		double result2 = 0;

		if (c.equals("")) {
			result_TextField.setText("Please input operator");

		} else {
            // \u624b\u52a8\u5904\u7406\u5c0f\u6570\u70b9\u7684\u95ee\u9898
			if (str1.equals("."))
				str1 = "0.0";
			if (str2.equals("."))
				str2 = "0.0";
			a2 = Double.valueOf(str1).doubleValue();
			b2 = Double.valueOf(str2).doubleValue();

			if (c.equals("+")) {
				result2 = a2 + b2;
			}
			if (c.equals("-")) {
				result2 = a2 - b2;
			}
			if (c.equals("*")) {
				BigDecimal m1 = new BigDecimal(Double.toString(a2));
			        BigDecimal m2 = new BigDecimal(Double.toString(b2));
			        result2 = m1.multiply(m2).doubleValue();
			}
			if (c.equals("/")) {
				if (b2 == 0) {
					result2 = 0;
				} else {
					result2 = a2 / b2;
				}

			}

			result = ((new Double(result2)).toString());

			result_TextField.setText(result);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// \u8bbe\u7f6e\u7a0b\u5e8f\u663e\u793a\u7684\u754c\u9762\u98ce\u683c\uff0c\u53ef\u4ee5\u53bb\u9664
	try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calculator cal = new Calculator();
	}

}