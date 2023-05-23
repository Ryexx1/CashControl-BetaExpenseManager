/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Forms;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author windows-10
 */
public class AddBudgetPanel extends javax.swing.JPanel {

    private String date;
    private String category;
    private String BudgetAmount;

    /**
     * Creates new form AddBudgetPanel
     */
    public AddBudgetPanel() {
        initComponents();
        Connect();
        LoadCategory();
        
        ImageIcon errIcon = new ImageIcon("C:\\\\Users\\\\windows-10\\\\OneDrive\\\\Files-OD\\\\NetBeansProjects\\\\BetaExpenseManager\\\\src\\\\img\\\\error.JPG");
       

        // Set placeholder text for textfields
       // Set placeholder text for text field DateTf
            DateTf.setForeground(Color.GRAY);
            DateTf.setText("MM/DD/YYYY");

            // Add focus listener to remove placeholder text
            DateTf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (DateTf.getText().equals("MM/DD/YYYY")) {
                        DateTf.setText("");
                        DateTf.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (DateTf.getText().isEmpty()) {
                        DateTf.setForeground(Color.GRAY);
                        DateTf.setText("MM/DD/YYYY");
                    }
                }
            });//focuslistener end 
            
            //Error handling
            DateTf.addActionListener((ActionEvent e) -> {
                String dateInput = DateTf.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                dateFormat.setLenient(false);
                try {
                    Date date = dateFormat.parse(dateInput);
                    System.out.println(date);
                    // Valid date format, do something with it
                } catch (ParseException ex) {
                    // Invalid date format, show error message
                    JOptionPane.showMessageDialog(null, "Please enter in MM/dd/yyyy format.", "Invalid Date Format", JOptionPane.ERROR_MESSAGE, errIcon);
                }
            });//DateTF error handling
            
            
            //category Textfield placeholder 
                Color WHITE = new Color(242, 242, 242);
                CatTf.setBackground(WHITE);
                String placeholder = "Select Options from Below";
            
                CatTf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (CatTf.getSelectedItem().equals(placeholder)) {
                        CatTf.setSelectedItem(null);
                        CatTf.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (CatTf.getSelectedItem() == null) {
                        CatTf.setForeground(Color.GRAY);
                        CatTf.setSelectedItem(placeholder);
                    }
                }
            });
                
                //AMOUNT Textfield placeholder 
             
                AmTf.setForeground(Color.GRAY);
                AmTf.setText("Enter Budget Amount");
                
                AmTf.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (AmTf.getText().equals("Enter Budget Amount")) {
                            AmTf.setText("");
                            AmTf.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
              
                            if (AmTf.getText().isEmpty()) {
                                AmTf.setForeground(Color.GRAY);
                                AmTf.setText("Enter Budget Amount");
                            }
                    }
                });
    }

    //build connection to server 
    Connection con; 
    ResultSet rs; 
    PreparedStatement pst;
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cashcontrol_db", "root", "");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    public void LoadCategory(){
        try {
            pst = con.prepareStatement("SELECT category_name FROM categoriestable");
            rs = pst.executeQuery(); 
            CatTf.removeAllItems(); 
            while(rs.next()){
                CatTf.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddBudgetPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        BudgetPlusPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DateTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AmTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CatTf = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();

        BudgetPlusPanel.setBackground(new java.awt.Color(183, 183, 164));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add New Budget");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Period");

        DateTf.setBackground(new java.awt.Color(242, 242, 242));
        DateTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateTf.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category");

        AmTf.setBackground(new java.awt.Color(242, 242, 242));
        AmTf.setToolTipText(" ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount");

        jButton1.setBackground(new java.awt.Color(107, 112, 92));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CatTf.setBackground(new java.awt.Color(242, 242, 242));
        CatTf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cancelBtn.setBackground(new java.awt.Color(107, 112, 92));
        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("CANCEL");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BudgetPlusPanelLayout = new javax.swing.GroupLayout(BudgetPlusPanel);
        BudgetPlusPanel.setLayout(BudgetPlusPanelLayout);
        BudgetPlusPanelLayout.setHorizontalGroup(
            BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BudgetPlusPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmTf, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(BudgetPlusPanelLayout.createSequentialGroup()
                        .addGroup(BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateTf, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addComponent(CatTf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        BudgetPlusPanelLayout.setVerticalGroup(
            BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BudgetPlusPanelLayout.createSequentialGroup()
                .addGroup(BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BudgetPlusPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BudgetPlusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BudgetPlusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CatTf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AmTf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BudgetPlusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BudgetPlusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ImageIcon errIcon = new ImageIcon("C:\\\\Users\\\\windows-10\\\\OneDrive\\\\Files-OD\\\\NetBeansProjects\\\\BetaExpenseManager\\\\src\\\\Img\\\\err100.png");
        ImageIcon okIcon = new ImageIcon("C:\\\\Users\\\\windows-10\\\\OneDrive\\\\Files-OD\\\\NetBeansProjects\\\\BetaExpenseManager\\\\src\\\\Img\\\\check100.png");
        try {
            // TODO add your handling code here:
            
            String date = DateTf.getText();
            String category =(String) CatTf.getSelectedItem();
            String BudgetAmount = AmTf.getText();
            pst = con.prepareStatement("INSERT INTO budgettable (date,category,BudgetAmount) VALUES(?, ?, ?)");
            if(!date.isEmpty() && !category.isEmpty() && !BudgetAmount.isEmpty()){
                try{
                    int b_am = Integer.parseInt(BudgetAmount); 
                    pst.setString(1, date);
                    pst.setString(2, category);
                    pst.setInt(3, b_am);
                   
                }catch(NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Please input a valid number for the amount", "Invalid Entry", JOptionPane.ERROR_MESSAGE, errIcon);
                }            
            }else if(date.isEmpty() || category.isEmpty() || BudgetAmount.isEmpty()){
                
                JOptionPane.showMessageDialog(null, "Please fill up all the necessary fields.", "Invalid input", JOptionPane.ERROR_MESSAGE, errIcon);
            }
            
            
            int k = pst.executeUpdate(); 
            if(k==1){
                JOptionPane.showMessageDialog(null, "Record Added Successfully", "Saved!", JOptionPane.ERROR_MESSAGE, okIcon);
                //TODO set text of labels here 
            }else{
                JOptionPane.showMessageDialog(null, "Record Failed to Save: Please Try Again", "Unsuccessfuly registration", JOptionPane.ERROR_MESSAGE, errIcon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddBudgetPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
        //add cancel

        int choice = JOptionPane.showOptionDialog(
            null,
            "Are you sure you want to cancel?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Yes", "No"},
            "No"
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Redirect to BudgetMenu

            JOptionPane.showMessageDialog(null, "Add Budget Canceled", "Cancel", JOptionPane.ERROR_MESSAGE);
           
        } else {
            //none because the user will continue the process
        }

        // More existing code...
    }//GEN-LAST:event_cancelBtnMouseClicked
 
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

        int choice = JOptionPane.showOptionDialog(
            null,
            "Are you sure you want to cancel?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Yes", "No"},
            "No"
        );

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Add Budget Canceled", "Cancel", JOptionPane.ERROR_MESSAGE);
            
        } else {
            //none because the user will continue the process
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmTf;
    private javax.swing.JPanel BudgetPlusPanel;
    private javax.swing.JComboBox<String> CatTf;
    private javax.swing.JTextField DateTf;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
