import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacky
 */
public class Login extends javax.swing.JFrame {
    //Global variable ThisUsername. Which is the username login
    static String ThisUsername;
    public static final String strLower = "abcdefghijklmnopqrstuvwxyz";
    public static final String strUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public Login() {
        initComponents();
        
        
    }
    public static String Encrypt(String PlainT, int key){
        String ciphert = "";
        //for statement which checks every letter of my string
        for (int i = 0; i < PlainT.length(); i++){
            //if statement which checks if the letter is a capital letter 
            if (Character.isUpperCase(PlainT.charAt(i))){
               int CharacterPositionUpper = strUpper.indexOf(PlainT.charAt(i));
               int ShiftLetters = (CharacterPositionUpper + key) % strLower.length();
               char replaceval = strUpper.charAt(ShiftLetters);
               ciphert = ciphert + replaceval;
            }
            //else if statement which checks whether the letter is a lower case or not
            else if(Character.isLowerCase(PlainT.charAt(i))){
            int CharacterPosition = strLower.indexOf(PlainT.charAt(i));
            int ShiftLetters = (CharacterPosition + key) % strLower.length();
            char replaceval = strLower.charAt(ShiftLetters);
            ciphert = ciphert + replaceval;
            }
            else{
                ciphert += PlainT.charAt(i);
            }
        }      
        return ciphert;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegisterButton = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        LoginLabel = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        UsernameLabel = new javax.swing.JLabel();
        UsernameTF = new javax.swing.JTextField();
        PasswordTF = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setFocusable(false);
        setLocation(new java.awt.Point(400, 310));

        RegisterButton.setText("Don't have an account? Register here");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        PasswordLabel.setText("Password:");

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        LoginLabel.setText("Login:");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        UsernameLabel.setText("Username:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ClearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PasswordLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PasswordTF))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLabel)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel)
                    .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OKButton)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RegisterButton)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        //Disposes current form
        this.dispose();
        //Creating login link to registration object
        Registration LinkLoginToRegistration = new Registration();
        //Set Registration page visible
        LinkLoginToRegistration.setVisible(true);
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
    //Used to check if textfields are empty. If so, pop up informing user textfield textfields are all clear.
    if (UsernameTF.getText().equals("") && PasswordTF.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "All fields are clear.", "Clear Error", JOptionPane.INFORMATION_MESSAGE);
    }
        
    //Otherwise clear them
    else{
    UsernameTF.setText("");
    PasswordTF.setText("");
    }
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        //Calculates current time stamp in this format
        String CurrentTimeStamp = new SimpleDateFormat("yyyy/MM/dd      HH:mm:ss").format(new java.util.Date());
        //If statement which checks whether either fields are emtpty or not
        if (UsernameTF.getText().equals("") || PasswordTF.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "There are empty fields. Please fill these in.", "Empty field error", JOptionPane.INFORMATION_MESSAGE);
        }
        //Else loop which checks whether username and password entered from user is in the textfile or not
        else{
            mainLoop:
            //for loop which loops around the accpassarray that i created from reading through the account password text file
            for (int i = 0; i < Registration.AccPassArray.size(); i+=2){
                //If statement which checks whether username and password match in the array
                int ShiftLetters = 5;
                String getUsername = UsernameTF.getText();
                String getPassword = PasswordTF.getText();
                String EncryptedUsername;
                String EncryptedPassword;
                EncryptedUsername = Encrypt(getUsername, ShiftLetters);
                EncryptedPassword = Encrypt(getPassword, ShiftLetters);
                //If statement checks the username and password in the textfile
                if(EncryptedUsername.equals(Registration.AccPassArray.get(i)) && EncryptedPassword.equals(Registration.AccPassArray.get(i+1))){
                        JOptionPane.showMessageDialog(rootPane, "You have successfully logged in as '" + UsernameTF.getText() + "'.");
                        ThisUsername = UsernameTF.getText();
                        
                        //Try and catch happens when the user logs in successful, and then it will log this in the userLog text file
                        try{
                            BufferedWriter out = new BufferedWriter(new FileWriter("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\UserLog.txt", true));                            
                            out.write(Encrypt("The user: " + UsernameTF.getText() + " logged in at the date/time: [" + CurrentTimeStamp + "]." + "\r\n" , 7));       
                            out.close();
                        }
                        //Catch catches error
                        catch (IOException ex) {
                            JOptionPane.showMessageDialog(rootPane, "Could not locate file");
                        }
                        //Disposes current frame
                        this.dispose();
                        //Creates link from login to search
                        Search LinkLoginToSearch = new Search();
                        //Makes the Search page visible
                        LinkLoginToSearch.setVisible(true);
                        //This will break out of the whole loop and continue on
                        break mainLoop;
                }
                //If statement for validation. Used to securely check if username matches but password doesnt. then my program will not allow access to this account
                if(EncryptedUsername.equals(Registration.AccPassArray.get(i)) && !EncryptedPassword.equals(Registration.AccPassArray.get(i+1))){
                    JOptionPane.showMessageDialog(rootPane, "Sorry. You have entered an incorrect username or password. Please try again.");
                    break;
                }
                //if statement used to check if we reached the end of the array,and if nothing matches, then it will display the error message
                if (i == Registration.AccPassArray.size()-2 && !EncryptedUsername.equals(Registration.AccPassArray.get(i)) && (!EncryptedPassword.equals(Registration.AccPassArray.get(i+1)) || EncryptedPassword.equals(Registration.AccPassArray.get(i+1)))){
                    JOptionPane.showMessageDialog(rootPane, "Sorry. You have entered an incorrect username or password. Please try again.");
                }
            }
        }
    }//GEN-LAST:event_OKButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        //Temporary space in array. Change if ever necessary
        int TemporarySpace = 2;
        //Creates a new array to temporarily store account and passwords
        String MyAccPassArray[] = new String[TemporarySpace];
        //Define string line which reads line
        String line;
        try{
        //"H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Tutorial1\\AccountPasswords.txt" UNI
        //"C:\\Users\\Jay\\Desktop\\Jacky\\Tutorial1v0.3\\Tutorial1\\AccountPasswords.txt" Home
        BufferedReader in = new BufferedReader(new FileReader("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\AccountPasswords.txt"));
        //Reads first line
        line = in.readLine();
        
        //If line does not = to null, split the line with ":" into two strings and then store it into my static arraylist "AccPassArray" in the registration form
        while(line != null){
            //splits the line by : and then puts it in the accpassarray
            MyAccPassArray = line.split(":");
            //For statement which adds myaccpassarray into registration.accpassarray in registration form
            for(int i = 0; i < TemporarySpace; i++){
                Registration.AccPassArray.add(MyAccPassArray[i]);
            }
            //reads next line
            line = in.readLine();
        }
        
        }
        //catches error with textfile or pathing
        catch(IOException e){
            Component myForm = null;
            JOptionPane.showMessageDialog(myForm, "Could not load textfile ", "Error loading textfile", JOptionPane.INFORMATION_MESSAGE);
        }

        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTF;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
