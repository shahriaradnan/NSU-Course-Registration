import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Adnan on 25/11/2015.
 */
public class RegistrationJFrame extends JFrame implements ActionListener,ListSelectionListener {
    private JPanel panel_root;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JButton resetButton;
    //private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    JTextField textField5;
    private JButton addButton;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;

    private JList list;
    private JScrollPane listScroll;
    private JPanel panel6;
    //private JRadioButton radioButton1;
    //private JRadioButton radioButton2;
    private JList list2;
    private JScrollPane listScroll2;
    private JPanel panel7;
    private  JButton discountButton;


    ArrayList<String> strategies = new ArrayList<>();
    ArrayList<Integer> listIndices = new ArrayList<>();
    ArrayList<String> stratList = new ArrayList<>();
    RegisterCourseController rcc = new RegisterCourseController();
    int sl = 0;
    String gtot;

    public RegistrationJFrame(){
        setTitle("Course Registration");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //panel_root = new JPanel(new GridLayout(5,1));
        //panel_root = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));

        //RESET BUTTON
        //panel1 = new JPanel(new BorderLayout());
        resetButton = new JButton("New Registration");
        resetButton.addActionListener(this);
        resetButton.setBounds(100, 10, 150, 30);
        //panel1.add(resetButton, BorderLayout.WEST);
        //panel1.setSize(10,10);
        //panel_root.add(panel1);

        //ADD TEXT LABEL AND TEXT FIELD
        //panel2 = new JPanel(new BorderLayout());
      //  label = new JLabel("Course ID");
       // label.setBounds(10, 60, 200, 30);
        //panel2.add(label,BorderLayout.WEST);
        textField = new JTextField();
        textField.setBounds(100, 60, 200, 30);
        //panel2.add(textField,BorderLayout.CENTER);
        //panel_root.add(panel2);


        //ADD BUTTON
        //panel3 = new JPanel(new BorderLayout());
        addButton = new JButton("Add Course");
        addButton.addActionListener(this);
        addButton.setBounds(100,110,150,30);
        //panel3.add(addButton, BorderLayout.WEST);
        //panel_root.add(panel3);

        //TABLE
        String []headings = {"SL#","Course Title","Credit","Tuition/credit","Sub total"};
        //String []headings = {"SL#","Course ID","Course Title","Credit","Tuition/credit","Sub total"};
        String [][]data = {};
        table = new JTable(data,headings);
        panel4 = new JPanel(new BorderLayout());
        //getContentPane().add(panel);
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("SL#");
       // model.addColumn("Course ID");
        model.addColumn("Course Title");
        model.addColumn("Credit");
        model.addColumn("Tuition/Credit");
        model.addColumn("Sub Total");

        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);

        scrollPane = new JScrollPane(table);
        panel4.add(scrollPane, BorderLayout.CENTER);
        panel4.setBounds(100,170,500,100);
        //panel_root.add(panel4);

        //ADD TEXT LABEL AND TEXT FIELD(SUB TOTAL)
        //panel5 = new JPanel(new BorderLayout());
        label2 = new JLabel("Total");
        label2.setBounds(350,300,50,50);
        //panel5.add(label2, BorderLayout.WEST);
        textField2 = new JTextField();
        textField2.setBounds(500,300,100,50);
        //textField2.setPreferredSize(new Dimension(40,40));
        textField2.setText("00.00");
        //panel5.add(textField2,BorderLayout.CENTER);
        //panel_root.add(panel5);

        label3 = new JLabel("Development Fee/BD TAX");
        label3.setBounds(350,350,150,50);
        textField3 = new JTextField();
        textField3.setBounds(500, 350, 100, 50);
        textField3.setText("00.00");

        label4 = new JLabel("Discount");
        label4.setBounds(350, 400, 150, 50);
        textField4 = new JTextField();
        textField4.setBounds(500, 400, 100, 50);
        textField4.setText("00.00");

        label5 = new JLabel("Grand Total");
        label5.setBounds(350, 450, 150, 50);
        textField5 = new JTextField();
        textField5.setBounds(500, 450, 100, 50);
        textField5.setText("00.00");

        String []listData = {"Academic Excellence","Freedom Fighter","Aboriginal/Minority Group"};
        list = new JList(listData);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        //list.setVisibleRowCount(-1);
        list.addListSelectionListener(this);
        panel6 = new JPanel(new BorderLayout());
        listScroll = new JScrollPane(list);
        panel6.add(listScroll, BorderLayout.CENTER);
        panel6.setBounds(50, 300, 250, 60);

        //radioButton1 = new JRadioButton("Best for NSU");
        //radioButton1.setBounds(50, 350, 250, 20);
        //radioButton2 = new JRadioButton("Best for STUDENT");
        //radioButton2.setBounds(50,370,250,30);

        String []listData2 = {"Best for NSU","Best for STUDENT"};
        list2 = new JList(listData2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setLayoutOrientation(JList.VERTICAL);
        list2.setVisibleRowCount(-1);
        list2.setSelectedIndex(0);
        list2.addListSelectionListener(this);
        panel7 = new JPanel(new BorderLayout());
        listScroll = new JScrollPane(list2);
        panel7.add(listScroll,BorderLayout.CENTER);
        panel7.setBounds(50, 370, 250, 40);

        discountButton = new JButton("Calculate Button");
        discountButton.addActionListener(this);
        discountButton.setBounds(100,420,150,30);

        //getContentPane().add(panel_root);
        add(resetButton);
      //  add(label);
        add(textField);
        add(addButton);
        add(panel4);
        add(label2);
        add(textField2);
        add(label3);
        add(textField3);
        add(label4);
        add(textField4);
        add(label5);
        add(textField5);
        add(panel6);
        add(panel7);
        add(discountButton);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == resetButton){
            //reset();
            rcc.makeNewRegistration();
            reset();
            sl=0;
        }
        else if(e.getSource() == addButton){
            //String []data = {"1","CSE 327","Software Engineering","3.0","4500",""};
            //addCourse(data);
            //Registration reg = rcc.addCourse(label.getText());
            Course crs = rcc.addCourse(textField.getText().toUpperCase());
            addCourse(crs);
        }
        else if(e.getSource() == discountButton){
            String []strat = {"DiscountCGPA","DiscountFF","DiscountMinority"};
            stratList.clear();
            for(int i=0;i<list.getSelectedIndices().length;i++){
                stratList.add(strat[list.getSelectedIndices()[i]]);
                System.out.println(strat[list.getSelectedIndices()[i]]);
            }
            String []policies = {"DiscountBestForNSU","DiscountBestForStudent"};
            String choosenPolicy = policies[list2.getSelectedIndex()];
            System.out.println(choosenPolicy);
            int discount = 0;
            try {
                discount = rcc.getDiscount(stratList,choosenPolicy);
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            double gt = Math.max(Double.parseDouble(gtot) - discount, 0);
            textField4.setText(Integer.toString(discount));
            textField5.setText(Double.toString(gt));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == list){
            //strategies = new ArrayList<>();
            //strategies.add((String) list.getSelectedValue());
        }
        else if(e.getSource() == list2){

        }
    }


    public void createRow(String []data){
        model.addRow(data);
    }

    public void reset(){
        while(model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++)
                model.removeRow(i);
        }
        textField2.setText("00.00");
        textField3.setText("00.00");
        textField4.setText("00.00");
        textField5.setText("00.00");
        strategies.clear();
        stratList.clear();
    }

    public void addCourse(Course crs){

        if(!crs.id.equals("-1")) {
            sl++;
            String []data = {Integer.toString(sl),crs.title,Integer.toString(crs.credit),Double.toString(crs.tuitionPerCredit),Double.toString(crs.getSubTotal())};
            model.addRow(data);
            String tot = Double.toString(rcc.getRegistration().getTotal());
            textField2.setText(tot);
            try{
                String extra = Double.toString(rcc.getRegistration().getExtraFeeAmount());
                textField3.setText(extra);

                gtot = Double.toString(rcc.getRegistration().getGrandTotal());
                textField5.setText(gtot);
            }catch (Exception e){
                System.out.println(e);
            }

        }
        else {
            JOptionPane.showMessageDialog(this,"Wrong Course ID","Wrong Input",JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String args[]){
        RegistrationJFrame sample = new RegistrationJFrame();
        String []data = {"1","CSE 327","Software Engineering","3.0","4500",""};
        sample.setVisible(true);
        //sample.createRow(data);
    }


}
