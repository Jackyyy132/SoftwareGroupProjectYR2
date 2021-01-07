import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w1546167
 */
public class Search extends javax.swing.JFrame {
    //defines a default table
    DefaultTableModel model;
    Login LoginUsername = new Login();
    double Correlation;
    //Shift letters is different from the login to increase security. Takes longer for hackers to hack
    int ShiftLetters = 7;
    public static final String strLower = "abcdefghijklmnopqrstuvwxyz";
    public static final String strUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    

    
    
    //search filter
    private void filter(String UserInput){
        //Use tablerowsorter methods on our defaulttablemodel 
        TableRowSorter<DefaultTableModel>sorter = new TableRowSorter<>(((DefaultTableModel) SearchTable.getModel())); 
        //Sorts the rows, ?i ignores case sensitive
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + UserInput));
        //Apply the new row sorter on the new table
        SearchTable.setRowSorter(sorter);
    
     
    
    }
    
    
    public void CorrelationCalculator(ArrayList Column1TMale, ArrayList Column2TFemale){
        //Temporary variable which holds column1
        double TempColumn1 = 0;
        //Mean value for column 1
        double MeanColumn1 = 0;
        //For statement which looks at current tables row and gets how many rows there are, then adds calculates mean of column1
        for (int i = 0; i < SearchTable.getRowCount() ; i++){            
            TempColumn1 += Integer.parseInt((String) Column1TMale.get(i));
            MeanColumn1 = TempColumn1/Column1TMale.size();                       
        }
        //Used for testing purposes
        System.out.println("Mean for first column is " + MeanColumn1);
        
        //Temp variable for column2
        double TempColumn2 = 0;
        //Mean of column 2
        double MeanColumn2 = 0;
        
        //For which calculates the mean of column2
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            TempColumn2 += Integer.parseInt((String) Column2TFemale.get(i));
            MeanColumn2 = TempColumn2/Column2TFemale.size();
            
        }
        //Testing purposes
        System.out.println("Mean for second column is " + MeanColumn2);
        
        
        //Creates new arraylist which holds double values called column1Subtractmean
        ArrayList<Double> Column1SubtractMean = new ArrayList<>();
        //for statement which subtracts every value by the mean
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            Column1SubtractMean.add(Integer.parseInt((String) Column1TMale.get(i)) - MeanColumn1);
        }
        //Testing purposes
        System.out.println("Column 1 Mean subtractor: " + Column1SubtractMean);
        
        //Creates new arraylist which holds double values called column2Subtractmean
        ArrayList<Double> Column2SubtractMean = new ArrayList<>();
        //for statement which subtracts every value by the mean
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            Column2SubtractMean.add(Integer.parseInt((String) Column2TFemale.get(i)) - MeanColumn2);
        }
        //Testing purposes
        System.out.println("Column 2 Mean subtractor: " + Column2SubtractMean);
        
        
        
        
        
        
        //Creates new arraylist which holds double values called Column1xColumn2
        ArrayList<Double> Column1xColumn2 = new ArrayList<>();
        //for statement which multiplies every data from column1 by column2
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            Column1xColumn2.add(Column1SubtractMean.get(i) * Column2SubtractMean.get(i));
        }
        //Testing purposes
        System.out.println("Column1 x Column2 " + Column1xColumn2);
        
        
        //Creates new arraylist which holds double values called Column1Squared
        ArrayList<Double> Column1Squared = new ArrayList<>();
        //For statement which squares the values of column1
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            Column1Squared.add(Column1SubtractMean.get(i)*Column1SubtractMean.get(i));
        }
        //Testing purposes
        System.out.println("Column1 squared = " + Column1Squared);
        
        //Creates new arraylist which holds double values called column2Squared
        ArrayList<Double> Column2Squared = new ArrayList<>();
        //For statment which squares the value of column2
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            Column2Squared.add(Column2SubtractMean.get(i)*Column2SubtractMean.get(i));
        }
        //Testing purposes
        System.out.println("Column2 squared = " + Column2Squared);
        
        
        
        
        
        
        //Variable to hold sum of column1xcolumn2
        double SumOfColumn1xColumn2 = 0;
        //For statement which calculates sum of column1 x column2
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            SumOfColumn1xColumn2 += Column1xColumn2.get(i);
        }
        //Testing purposes
        System.out.println("Sum of Column1 x Column2 = " + SumOfColumn1xColumn2);
        
        
        double SumOfColumn1Squared = 0;
        //For statement which calculates sum of A squared values
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            SumOfColumn1Squared += Column1Squared.get(i);
        }
        System.out.println("Sum of A Squared = " + SumOfColumn1Squared);
        
        double SumOfColumn2Squared = 0;
        //For statement which calculates sum of B squared values
        for (int i = 0; i < SearchTable.getRowCount(); i++){
            SumOfColumn2Squared += Column2Squared.get(i);
        }
        System.out.println("Sum of B Squared = " + SumOfColumn2Squared);
        
        //Bottom half of the equation
        double BottomHalf = (double) Math.sqrt((SumOfColumn1Squared * SumOfColumn2Squared));
        
        Correlation = SumOfColumn1xColumn2/BottomHalf;
        System.out.println("Correlation = " + Correlation);
        String StringCorrelation = Double.toString(Correlation);
        CorrelationResultsTF.setText(StringCorrelation);
        
        //I added a message box to inform the user that the correlation has been complete. This is because my data when calculating correlation
        //is mostly 0.9 correlation. Therefore i added a message for the user to see that the calculation did indeed happen.
        JOptionPane.showMessageDialog(rootPane, "Correlation Calculation complete. Result is displayed below");
        
        
    }

    
    

    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
        //This code sets my search table to uneditable. Although my group feedback was that i should not be able to move the columns, i disagree with this.
        //The reason i disagree with this is because we have a huge set of data with many columns. It would be very convenient if the user, is able to
        //move necessary columns together so that they could see the data all in one place, instead of scrolling and scrolling to find relevant information.
        //Therefore i left the columns to be movable, whereas the data inside the table could not be editable.
        SearchTable.setEnabled(false);
        Correlation1Label.setVisible(false);
        Correlation0Label.setVisible(false);
        CorrelationMinus1Label.setVisible(false);
        
        //Set correlation text field uneditable
        CorrelationResultsTF.setEditable(false);
        
        
        //A problem i faced with the HCI was that the columns were not able to be resized. This is very unprofessional and doesnt look nice. User could not see the data properly
        //However it has been fixed now. The user is able to do analysis clearly as the columns and row datas are able to be displayed clearly
        String line;
        model = (DefaultTableModel) SearchTable.getModel();
        //Defining column names
        String[] ColumnNames = {"GP_PRACTICE_CODE","POSTCODE","CCG_CODE","ONS_CCG_CODE","NHSE_REGION_CODE","ONS_REGION_CODE","NHSE_COMM_REGION_CODE","ONS_COMM_REGION_CODE","Total_All","Total_Male","Total_Female","Male_0-4","Male_5-9","Male_10-14","Male_15-19","Male_20-24","Male_25-29","Male_30-34","Male_35-39","Male_40-44","Male_45-49","Male_50-54","Male_55-59","Male_60-64","Male_65-69","Male_70-74","Male_75-79","Male_80-84","Male_85-89","Male_90-94","Male_95+","Female_0-4","Female_5-9","Female_10-14","Female_15-19","Female_20-24","Female_25-29","Female_30-34","Female_35-39","Female_40-44","Female_45-49","Female_50-54","Female_55-59","Female_60-64","Female_65-69","Female_70-74","Female_75-79","Female_80-84","Female_85-89","Female_90-94","Female_95+"};
        //for statement which adds the columns into the column
        for (String ColumnName : ColumnNames) {
            model.addColumn(ColumnName);
            //Sets table to autoresize so i can have the scroller on the bottom
            SearchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        
        
        //try statement which adds all the data rows 
        try{
            BufferedReader in = new BufferedReader(new FileReader("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\GP Patients.csv"));
            //reads line
            line = in.readLine();


            //while to check if line is empty or not
            while(line != null){
                
                String[] DataRow = line.split(",");
                model.addRow(DataRow);
                line = in.readLine(); 
            }
                           
            
            
        }

        catch(IOException e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CalculateButton = new javax.swing.JButton();
        SearchTF = new javax.swing.JTextField();
        LogOutButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SearchTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserLogButton = new javax.swing.JButton();
        CorrelationResultsTF = new javax.swing.JTextField();
        GraphPanel = new javax.swing.JPanel();
        Correlation1Label = new javax.swing.JLabel();
        Correlation0Label = new javax.swing.JLabel();
        CorrelationMinus1Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search");
        setLocation(new java.awt.Point(0, 0));

        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        SearchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTFKeyReleased(evt);
            }
        });

        LogOutButton.setText("Log out");
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        SearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        SearchTable.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(SearchTable);

        jLabel1.setText("Correlation results:");

        jLabel2.setText("Graphical representation");

        UserLogButton.setText("Check user log");
        UserLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLogButtonActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CorrelationResultsTF, org.jdesktop.beansbinding.ELProperty.create("${editable}"), CorrelationResultsTF, org.jdesktop.beansbinding.BeanProperty.create("editable"));
        bindingGroup.addBinding(binding);

        CorrelationResultsTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrelationResultsTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        Correlation1Label.setText("1");

        Correlation0Label.setText("0");

        CorrelationMinus1Label.setText("-1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LogOutButton)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UserLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CorrelationResultsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Correlation1Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Correlation0Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CorrelationMinus1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(127, 127, 127))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateButton)
                    .addComponent(UserLogButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Correlation1Label)
                                .addGap(129, 129, 129)
                                .addComponent(Correlation0Label)
                                .addGap(129, 129, 129)
                                .addComponent(CorrelationMinus1Label))
                            .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CorrelationResultsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(LogOutButton)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        //Current time and date
        String CurrentTimeStamp = new SimpleDateFormat("yyyy/MM/dd      HH:mm:ss").format(new java.util.Date());
        int LogOutSelection = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?", "Log out?", JOptionPane.YES_NO_OPTION); 
        //If to check if user wants to log out or not
        if (LogOutSelection == JOptionPane.YES_OPTION) {            
            JOptionPane.showMessageDialog(rootPane, "You have successfully logged out.", "Log out successful", JOptionPane.INFORMATION_MESSAGE);
            //This will add a logout in the userlog text file
            try{
                String thisText;
                BufferedWriter in = new BufferedWriter(new FileWriter("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\UserLog.txt", true));
                in.write(Registration.Encrypt("Username:" + LoginUsername.ThisUsername + " logged out at the date/time: [" + CurrentTimeStamp + "]." + "\r\n", ShiftLetters));
                in.write("______________________________________________________________." + "\r\n");
                in.close();
            }
   
    catch (IOException ex) {
        JOptionPane.showMessageDialog(rootPane, "Could not locate file");
    }
            
            
            
            //dispose this form
            this.dispose();
            //make link between search and login
            Login LinkSearchToLogin = new Login();
            //set login to true
            LinkSearchToLogin.setVisible(true);
        }
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void SearchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTFKeyReleased
        //When key is released, search rows
        String UserInput = SearchTF.getText().toLowerCase();
        filter(UserInput);
    }//GEN-LAST:event_SearchTFKeyReleased

    private void CorrelationResultsTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrelationResultsTFActionPerformed
        
    }//GEN-LAST:event_CorrelationResultsTFActionPerformed

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
    //Creating two arraylists, 1 for column 1 male and 1 for column 2 female
    ArrayList<String> Column1TMale = new ArrayList<>();
    ArrayList<String> Column2TFemale = new ArrayList<>();
    
    
    //This variable is used to define the amount of rows we need to do the correlation calculation
    int MinimumRowNumbers = 5;
    
    //Calculate the current time and date
    String CurrentTimeStamp = new SimpleDateFormat("yyyy/MM/dd      HH:mm:ss").format(new java.util.Date());

    //Total Male Column is in row 9
    int Total_MaleColumn = 9;
    //Total Female column is in row 10
    int Total_FemaleColumn = 10;

    //For loop which gets the tables current row count, gets the total male data and adds it into the column 1 male arraylist
    for (int i = 0; i < SearchTable.getRowCount(); i++){
        Column1TMale.add((String) SearchTable.getValueAt(i, Total_MaleColumn));
    }
    System.out.println(Column1TMale);
    
    //For loop which gets the tables current row count, gets the total female data and adds it into the column 2 female arraylist    
    for (int i = 0; i < SearchTable.getRowCount(); i++){
        Column2TFemale.add((String) SearchTable.getValueAt(i, Total_FemaleColumn));
    }
    System.out.println(Column2TFemale);
    System.out.println("Total rows = " + SearchTable.getRowCount());
    //If statement which checks whether there is less than 2 rows
    if(SearchTable.getRowCount() < MinimumRowNumbers){
        JOptionPane.showMessageDialog(rootPane, "You need at least 5 rows of data to use the correlation calculation", "Row error", JOptionPane.INFORMATION_MESSAGE);
    }

    else{
    //Calls the Correlation calculation method which performs the correlation calculation
    //Takes in 2 arraylist parameters
    CorrelationCalculator(Column1TMale, Column2TFemale);
    
        Graphics g = GraphPanel.getGraphics();
        g.drawLine(0, 150, 300, 150);
        g.setColor(Color.red);
        //x1 y1 x2 y2
        Correlation1Label.setVisible(true);
        Correlation0Label.setVisible(true);
        CorrelationMinus1Label.setVisible(true);

        //If statements which check the correlation and then makes graph according
        if (Correlation == 1.0){                                //1
            g.drawLine(150, 150, 150, 0);
        }
        if (Correlation >= 0.8 && Correlation < 1){    // 0.8 to 0.99
            g.drawLine(150, 150, 150, 15);
        }
        if (Correlation >= 0.6 && Correlation < 0.8){  // 0.6 to 0.79
            g.drawLine(150, 150, 150, 45);
        }
        if (Correlation >= 0.4 && Correlation < 0.6){  //0.4 to 0.59
            g.drawLine(150, 150, 150, 75);
        }
        if (Correlation >= 0.2 && Correlation < 0.4){  // 0.2 to 0.39
            g.drawLine(150, 150, 150, 105);
        }
        if (Correlation > 0 && Correlation < 0.2){     // 0.01 to 0.19
            g.drawLine(150, 150, 150, 135);
        }
        if (Correlation == 0.0){                                // 0
            g.drawLine(150, 150, 150, 150);
        }
        if (Correlation > -0.2  && Correlation < 0){     // -0.01 to -0.19
            g.drawLine(150, 150, 150, 165);
        }
        if (Correlation > -0.4 && Correlation <= -0.2){ // -0.2 to -0.39
            g.drawLine(150, 150, 150, 195);
        }
        if (Correlation > -0.6 && Correlation <= -0.4){ //-0.4 to -0.59
            g.drawLine(150, 150, 150, 225);
        }
        if (Correlation > -0.8 && Correlation <= -0.6){ //-0.6 to -0.79
            g.drawLine(150, 150, 150, 255);
        }
        if (Correlation > -1 && Correlation <= -0.8){   //-8 to -0.99
            g.drawLine(150, 150, 150, 285);
        }
        if (Correlation == -1.0){                   //-1
            g.drawLine(150, 150, 150, 300);
        }

                                                                                                                
                    
    
    
    
    }
    
    //Print out the user logs and what they done at what time in the userlog textfile
    try{
        BufferedWriter in = new BufferedWriter(new FileWriter("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\UserLog.txt", true));
        in.write(Registration.Encrypt("Searched for: '" + SearchTF.getText() + "', at the date/time: [" + CurrentTimeStamp + "]." + "\r\n", ShiftLetters));
        in.write(Registration.Encrypt("Correlation results: " + CorrelationResultsTF.getText() + "." + "\r\n", ShiftLetters));
        in.write("");
        in.close();
    }
   
    catch (IOException ex) {
        JOptionPane.showMessageDialog(rootPane, "Could not locate file");
    }
    
    
    


    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void UserLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLogButtonActionPerformed
    //The reason why i put the user log in another form is to avoid the user pressing user log button many times. Also, to not allow the user to open
    //up many user logs and then get confused which one is which. This addresses the issue of users with disability.
    //For example a user could have a nerve problem which makes their hand uncontrollable,
    //and as they are clicking the user log they could click on it many times accidently, opening up many user logs. 


        //current date and time
        String CurrentTimeStamp = new SimpleDateFormat("yyyy/MM/dd      HH:mm:ss").format(new java.util.Date());
        //Checks when the user has checked the logs and puts in textfile
        try{
            BufferedWriter in = new BufferedWriter(new FileWriter("H:\\SECOND YEAR COMPUTER SCIENCE\\Term2\\Software\\Software CW\\Software edit files\\Tutorialv1.4\\UserLog.txt", true));
            in.write(Registration.Encrypt(LoginUsername.ThisUsername + " checked the logs at: date/time: [" + CurrentTimeStamp + "]." + "\r\n", ShiftLetters));
            in.close();
    }
   
    catch (IOException ex) {
        JOptionPane.showMessageDialog(rootPane, "Could not locate file");
    }
        
        //A problem i had with HCI was that when a user log would appear, the user could still go back on the search form and fiddle about and open up multiple windows
        //Therefore i disposed of the search form and left them with only this form to play with. 
        //This was highlighted to me by Farhaan as an improvement to my system. This will allow my users to be less confused with 2 forms in their face.
        
        //dispose this form
        this.dispose();
        //Links search to user log
        UserLog LinkSearchToUserLog = new UserLog();
        //sets it to visible
        LinkSearchToUserLog.setVisible(true);
    }//GEN-LAST:event_UserLogButtonActionPerformed

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
        
        
        
        
        
        
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Search().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculateButton;
    private javax.swing.JLabel Correlation0Label;
    private javax.swing.JLabel Correlation1Label;
    private javax.swing.JLabel CorrelationMinus1Label;
    private javax.swing.JTextField CorrelationResultsTF;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JTextField SearchTF;
    private javax.swing.JTable SearchTable;
    private javax.swing.JButton UserLogButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
