package hotel.pro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit,back;
    JComboBox cbjob;
    
    AddEmployee(){
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblage);
        
         tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 80, 20);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblgender);
        
         rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130,170, 30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(270, 130,170, 30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
         JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 180, 120, 30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblsalary);
        
         tfsalary = new JTextField();
        tfsalary.setBounds(200, 180, 150, 30);
        add(tfsalary);
        
         JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 230, 120, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblphone);
        
         tfphone = new JTextField();
        tfphone.setBounds(200, 230, 150, 30);
        add(tfphone);
        
         JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 280, 120, 30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblemail);
        
         tfemail = new JTextField();
        tfemail.setBounds(200, 280, 150, 30);
        add(tfemail);
        
         JLabel lblaadhar = new JLabel("AAdhar no");
        lblaadhar.setBounds(60, 330, 120, 30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lblaadhar);
        
        tfaadhar = new JTextField();
         tfaadhar.setBounds(200, 330, 150, 30);
        add(tfaadhar);
        
         JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 380, 120, 30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));     
        add(lbljob);
        
        String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen","Room Service","Manager","Accountant"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(200, 380, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
         submit = new JButton ("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit .setBounds(50, 450, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton ("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back .setBounds(250, 450, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(380,60,450,370);
        add(image);
                
        getContentPane().setBackground(Color.WHITE);
        setBounds(250,120,700,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
        String name = tfname.getText();
        String age = tfage.getText();
        
        String gender = null;
        
        
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }
        
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfphone.getText();
        String aadhar = tfaadhar.getText();
        
        
        
        
        String job = (String)cbjob.getSelectedItem();   
        
        try{
            Conn conn = new Conn();
            
            String query = "Insert into employee values('"+name+"','"+age+"','"+gender+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"','"+job+"')";
            
            conn.s.executeUpdate(query);
            System.out.println("Database connected");
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
         else{
            setVisible(false);
            new Reception();
        }
    }
    

    
    public static void main(String[] args) {
        new AddEmployee();
        //System.out.println("yes");
        
    }
}