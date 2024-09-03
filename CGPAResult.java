import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGPAResult {

    private JFrame frame;
    private JTextField nameTextField;
    private JButton enterButton,exit;

    private JFrame subjectFrame;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private JTextField cosmTextField, oopjTextField, oopjlTextField, dsTextField, dslTextField, coaTextField, deTextField, sdlTextField, gslTextField;
    private JButton computeButton,exit1;

    private JFrame resultFrame;
    private JTextArea resultTextArea;
    private JTable resultTable;

    private int totalCredits = 20; // Total number of credits

    public CGPAResult() {
        initializeFirstPage();
    }

    private void initializeFirstPage() {
        frame = new JFrame("Enter Student Name");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.magenta);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setFont(new Font("Corbel",Font.ITALIC,25));
        nameTextField = new JTextField(20);
        enterButton = new JButton("Enter");

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                initializeSecondPage();
            }
        });
        exit=new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(nameTextField);
        frame.getContentPane().add(enterButton);
        frame.getContentPane().add(exit);
        frame.setVisible(true);
    }

    private void initializeSecondPage() {
        subjectFrame = new JFrame("Enter Subject Marks");
        subjectFrame.setBounds(100, 100, 400, 400);
        subjectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        subjectFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        subjectFrame.getContentPane().setLayout(new FlowLayout());

        l1=new JLabel("COSM:");
        l1.setFont(new Font("Verdana",Font.ITALIC,20));
        l2=new JLabel("COA:");
        l2.setFont(new Font("Verdana",Font.ITALIC,20));
        l3=new JLabel("DE:");
        l3.setFont(new Font("Verdana",Font.ITALIC,20));
        l4=new JLabel("DS:");
        l4.setFont(new Font("Verdana",Font.ITALIC,20));
        l5=new JLabel("DSL:");
        l5.setFont(new Font("Verdana",Font.ITALIC,20));
        l6=new JLabel("OOPJ:");
        l6.setFont(new Font("Verdana",Font.ITALIC,20));
        l7=new JLabel("OOPJL:");
        l7.setFont(new Font("Verdana",Font.ITALIC,20));
        l8=new JLabel("SDL:");
        l8.setFont(new Font("Verdana",Font.ITALIC,20));
        l9=new JLabel("GSL:");
        l9.setFont(new Font("Verdana",Font.ITALIC,20));

        cosmTextField = new JTextField(5);
        oopjTextField = new JTextField(5);
        oopjlTextField = new JTextField(5);
        dsTextField = new JTextField(5);
        dslTextField = new JTextField(5);
        coaTextField = new JTextField(5);
        deTextField = new JTextField(5);
        sdlTextField = new JTextField(5);
        gslTextField = new JTextField(5);

        computeButton = new JButton("Compute");
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                subjectFrame.dispose();
                calculateCGPA(subjectFrame);
            }
        });
         exit1=new JButton("Exit");
        exit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                subjectFrame.dispose();
            }
        });

        subjectFrame.getContentPane().add(l1);
        subjectFrame.getContentPane().add(cosmTextField);
         subjectFrame.getContentPane().add(l2);
        subjectFrame.getContentPane().add(coaTextField);
         subjectFrame.getContentPane().add(l3);
        subjectFrame.getContentPane().add(deTextField);
         subjectFrame.getContentPane().add(l4);
        subjectFrame.getContentPane().add(dsTextField);
         subjectFrame.getContentPane().add(l5);
        subjectFrame.getContentPane().add(dslTextField);
         subjectFrame.getContentPane().add(l6);
        subjectFrame.getContentPane().add(oopjTextField);
         subjectFrame.getContentPane().add(l7);
        subjectFrame.getContentPane().add(oopjlTextField);
         subjectFrame.getContentPane().add(l8);
        subjectFrame.getContentPane().add(sdlTextField);
         subjectFrame.getContentPane().add(l9);
        subjectFrame.getContentPane().add(gslTextField);
        // Add similar lines for other subjects...

        subjectFrame.getContentPane().add(computeButton);
        subjectFrame.getContentPane().add(exit1);
        subjectFrame.setVisible(true);
    }

    private void calculateCGPA(JFrame subjectFrame) {
        double cosm = Double.parseDouble(cosmTextField.getText());
        double oopj = Double.parseDouble(oopjTextField.getText());
        double oopjl = Double.parseDouble(oopjlTextField.getText());
        double ds = Double.parseDouble(dsTextField.getText());
        double dsl = Double.parseDouble(dslTextField.getText());
        double coa = Double.parseDouble(coaTextField.getText());
        double de = Double.parseDouble(deTextField.getText());
        double sdl = Double.parseDouble(sdlTextField.getText());
        double gsl = Double.parseDouble(gslTextField.getText());
        if(cosm>=35 && oopj>=35 && oopjl>=35 && ds>=35 && dsl>=35 && coa>=35 && de>=35 && sdl>=35 ){
        double totalMarks = Math.ceil(cosm/10) * 4 + Math.ceil(oopj/10) * 3 + Math.ceil(oopjl/10) * 1.5 + Math.ceil(ds/10) * 3
                + Math.ceil(dsl/10) * 1.5 + Math.ceil(coa/10) * 3 + Math.ceil(de/10) * 3 + Math.ceil(sdl/10) * 1 + Math.ceil(gsl/10) * 0;

        double cgpa = totalMarks / totalCredits;
       
        initializeResultPage(cgpa,cosm,coa,de,ds,dsl,oopj,oopjl,sdl,gsl);
        
        }
        else{
            double cgpa=-1;
            initializeResultPage(cgpa,cosm,coa,de,ds,dsl,oopj,oopjl,sdl,gsl);
        }
    
    }

    private void initializeResultPage(double cgpa,double cosm,double coa,double de,double ds,double dsl,double oopj,double oopjl,double sdl,double gsl) {
        resultFrame = new JFrame("CGPA Result");
        resultFrame.setBounds(100, 100, 400, 200);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.getContentPane().setLayout(new BorderLayout());
        resultFrame.getContentPane().setBackground(Color.WHITE);
        
        resultTextArea = new JTextArea("CGPA Result:\n\n");
        resultTextArea.append("Student Name: " + nameTextField.getText().toUpperCase() + "\n");
        if(cgpa==-1){
            resultTextArea.append("Failed\n");
        }
        else{
        resultTextArea.append("CGPA: " + cgpa + "\n");
        resultTextArea.append("Credits earned:"+totalCredits+"\n");
        }
        resultTextArea.setLineWrap(true);
        Font font=new Font("Bookman Old Style",Font.BOLD,20);
        resultTextArea.setFont(font);
        resultTextArea.setForeground(Color.BLACK);
        resultTextArea.setEditable(false);
         String[][] data={{"Computer Oriented Statistical Methods","4",Double.toString(cosm)},{"Computer Organisation and Architecture","3",Double.toString(coa)},{"Digital Electronics","3",Double.toString(de)},{"Data Structures","3",Double.toString(ds)},{"Data Structures Lab","1.5",Double.toString(dsl)},{"Object Oriented Programming using Java","3",Double.toString(oopj)},{"Object Oriented Programming using Java Lab","1.5",Double.toString(oopjl)},{"Skill Development Lab","1",Double.toString(sdl)},{"Gender Sensitization Lab","0",Double.toString(gsl)}};
        String[] colNames={"Subject"," Subject credits","Marks"};
        resultTable=new JTable(data,colNames);
        resultTable.setBounds(50,50,250,249);
        resultTable.setRowHeight(44);
        resultTable.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        resultTable.setEnabled(false);
        JScrollPane sp=new JScrollPane(resultTable);
        resultFrame.getContentPane().add(resultTextArea,BorderLayout.PAGE_START);
        resultFrame.getContentPane().add(sp,BorderLayout.CENTER);
        resultFrame.setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CGPAResult();
            }
        });
    }
}
