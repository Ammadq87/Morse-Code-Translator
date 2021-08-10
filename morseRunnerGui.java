import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;


public class morseRunnerGui implements ActionListener{
    
    public static void main(String[] args) {
		new morseRunnerGui();
	}

    JFrame frame = new JFrame("Morse");
    JPanel navBar;
    JButton file;
    JButton help;
    JLabel title;
    JPanel horizRule;
    JLabel prompt;
    JTextField textInput;
    JButton translate;
    JLabel prompt1;
    JTextArea output;

    public morseRunnerGui() {
        init();
    }

    public void init(){
     
        navBar = new JPanel();
        navBar.setBounds(0, 0, 500, 30);
        navBar.setBackground(new Color(23,34,58));

        // Buttons for navigation bar
        file = new JButton("File");
        file.setBounds(0, 0, 75, 30);
        file.setBackground(new Color(23,34,58));
        file.setFont(new Font("Dialog", Font.BOLD, 11));
        file.setForeground(Color.white);
        file.setEnabled(true);
        file.addActionListener(this);
        file.setActionCommand("file");

        help = new JButton("Help");
        help.setBounds(75, 0, 75, 30);
        help.setBackground(new Color(23,34,58));
        help.setFont(new Font("Dialog", Font.BOLD, 11));
        help.setForeground(Color.white);
        help.setEnabled(true);
        help.addActionListener(this);
        help.setActionCommand("help");

        title = new JLabel("Morse Translator");
        title.setBounds(140, 55, 500, 20);
        title.setFont(new Font("Dialog", Font.BOLD, 25));
        title.setForeground(Color.white);

        horizRule = new JPanel();
        horizRule.setBackground(Color.white);
        horizRule.setBounds(90, 85, 300, 5); 

        prompt = new JLabel("Enter a Phrase: ");
        prompt.setBounds(90, 105, 320, 20);
        prompt.setFont(new Font("Dialog", Font.BOLD, 15));
        prompt.setForeground(Color.white);

        // User enters text they want to be translated
        textInput = new JTextField();
        textInput.setBounds(90, 130, 300, 30); 
        textInput.setForeground(Color.black);
        textInput.setFont(new Font("Dialog", Font.BOLD, 15));

        // User presses button to translate text
        translate = new JButton("Translate !");
        translate.setBounds(90, 175, 300, 30);
        translate.setBackground(new Color(23,34,58));
        translate.setFont(new Font("Dialog", Font.BOLD, 15));
        translate.setForeground(Color.white);
        translate.addActionListener(this);
        translate.setActionCommand("translate");

        prompt1 = new JLabel("Translation: ");
        prompt1.setBounds(90, 225, 320, 20);
        prompt1.setFont(new Font("Dialog", Font.BOLD, 15));
        prompt1.setForeground(Color.white);

        // Displays the translation based on user's input
        output = new JTextArea();
        output.setBounds(90, 265, 300, 100);
        output.setForeground(Color.black);
        output.setFont(new Font("Dialog", Font.BOLD, 15));

        frame.add(navBar);
        frame.add(file);
        frame.add(help);

        frame.add(title);
        frame.add(horizRule);
        frame.add(prompt);
        frame.add(textInput);
        frame.add(translate);
        frame.add(prompt1);
        frame.add(output);

        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(29,45,68));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().compareTo("translate") == 0){
            String phrase = textInput.getText();
            morse m = new morse(phrase);
            String translated_phrase = m.insantTranslate();
            output.setText(translated_phrase);
        }

        else if (e.getActionCommand().compareTo("file") == 0){
            String[] options = {"New File", "Open File"};
            int x = JOptionPane.showOptionDialog(null, "File Options",
                    "Morse - File",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
            if (x == 0){
                String name = JOptionPane.showInputDialog("File Name:");
                String fileName = name+".txt";
		        File file = new File(fileName);

                try{
                    PrintWriter to = new PrintWriter(file);

                    String phrase = textInput.getText();
                    morse m = new morse(phrase);
                    String translated_phrase = m.insantTranslate();

                    to.println("\n"+translated_phrase.toString());
                    to.close();
                }

                catch (IOException r){
                    JOptionPane.showMessageDialog(null,"Error","Error: Something Went Wrong",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if (x == 1){
                String name = JOptionPane.showInputDialog("File Name:");
                try {
                    File file = new File (name);
                    Scanner s = new Scanner (file);
                    String fileText = "";
                    while (s.hasNextLine()) {
                        fileText += s.nextLine();
                    }
                    textInput.setText(fileText);
                    s.close();
                }
        
                catch (FileNotFoundException r) {
                    JOptionPane.showMessageDialog(null,"Error","Error: Something Went Wrong",JOptionPane.ERROR_MESSAGE);

                }

            }

        }

        else if (e.getActionCommand().compareTo("help") == 0){
            JOptionPane.showMessageDialog(null,"1) Enter a phrase either in Morse-Code or in English in the text field\n2) Click Translate\n3) Save your results by clicking the file button","Morse - Help",JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
