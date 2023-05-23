    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Forms;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author windows-10
 */
public class AddExpensePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddExpensePanel
     */
    public AddExpensePanel() {
        initComponents();
        Connect();
        LoadBudgetCat(); 
            ECalTF.setForeground(Color.GRAY);
            ECalTF.setText("MM/DD/YYYY");

            // Add focus listener to remove placeholder text
            ECalTF.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (ECalTF.getText().equals("MM/DD/YYYY")) {
                        ECalTF.setText("");
                        ECalTF.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (ECalTF.getText().isEmpty()) {
                        ECalTF.setForeground(Color.GRAY);
                        ECalTF.setText("MM/DD/YYYY");
                    }
                }
            });//focuslistener end 
            
            //Error handling
            ECalTF.addActionListener((ActionEvent e) -> {
                String dateInput = ECalTF.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                dateFormat.setLenient(false);
                try {
                    Date date = dateFormat.parse(dateInput);
                    System.out.println(date);
                    // Valid date format, do something with it
                } catch (ParseException ex) {
                    // Invalid date format, show error message
                    JOptionPane.showMessageDialog(null, "Invalid date format, please enter in MM/dd/yyyy format.");
                }
            });//ECalTF error handling
            
            //budget Textfield placeholder 
                Color WHITE = new Color(242, 242, 242);
                BCatTF.setForeground(WHITE);
                String placeholder = "Select Options";
                
                BCatTF.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (BCatTF.getSelectedItem().equals(placeholder)) {
                        BCatTF.setSelectedItem(null);
                        BCatTF.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (BCatTF.getSelectedItem() == null) {
                        BCatTF.setForeground(Color.GRAY);
                        BCatTF.setSelectedItem(placeholder);
                    }
                }
                });
                
                EAmTF.setForeground(Color.GRAY);
                EAmTF.setText("Enter Budget Amount");
                
                EAmTF.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (EAmTF.getText().equals("Enter Budget Amount")) {
                            EAmTF.setText("");
                            EAmTF.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
              
                            if (EAmTF.getText().isEmpty()) {
                                EAmTF.setForeground(Color.GRAY);
                                EAmTF.setText("Enter Budget Amount");
                            }
                    }
                });
    }
    
    //connect to server
    Connection con; 
    PreparedStatement pst;
    ResultSet rs; 
   public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cashcontrol_db", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddExpensePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddExpensePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   } 
   public void LoadBudgetCat() {
    try {
        String query = "SELECT category_name FROM categoriestable";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        BCatTF.removeAllItems();
        while (rs.next()) {
            BCatTF.addItem(rs.getString(1));
        }
    } catch (SQLException ex) {
        Logger.getLogger(AddExpensePanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ECalTF = new javax.swing.JTextField();
        EAmTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ExpNotes = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BCatTF = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(183, 183, 164));
        setPreferredSize(new java.awt.Dimension(780, 378));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add New Expense");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Period");

        ECalTF.setBackground(new java.awt.Color(242, 242, 242));

        EAmTF.setBackground(new java.awt.Color(242, 242, 242));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Budget");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amount");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Notes:");

        ExpNotes.setBackground(new java.awt.Color(242, 242, 242));

        jButton1.setBackground(new java.awt.Color(107, 112, 92));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
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

        BCatTF.setBackground(new java.awt.Color(242, 242, 242));
        BCatTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BCatTF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BCatTF.setBorder(null);
        BCatTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCatTFActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(ECalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EAmTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BCatTF, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ECalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCatTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EAmTF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ExpNotes))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ImageIcon errIcon = new ImageIcon("C:\\\\Users\\\\windows-10\\\\OneDrive\\\\Files-OD\\\\NetBeansProjects\\\\BetaExpenseManager\\\\src\\\\img\\\\err100.png");
        try {
            // TODO add your handling code here:
            
            String date = ECalTF.getText();
            String budget_fk_str =(String) BCatTF.getSelectedItem();
            String expenseAmount_str = EAmTF.getText();
            String notes = ExpNotes.getText(); 
            
            pst = con.prepareStatement("INSERT INTO expensetable (date, budget_fk, expenseAmount, notes) VALUES(?, ?, ?, ?)");
            
            if (!date.isEmpty() && !budget_fk_str.isEmpty() && !expenseAmount_str.isEmpty() && !notes.isEmpty()) {
                try {
                    
                    int exp_am = Integer.parseInt(expenseAmount_str);

                    pst.setString(1, date);
                    pst.setString(2, budget_fk_str);
                    pst.setInt(3, exp_am);
                    pst.setString(4, notes);

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Record Added Successfully");
                        // TODO: set text of labels here
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Failed to Save");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input a valid number for the amount", "Invalid Entry", JOptionPane.ERROR_MESSAGE, errIcon);
                } catch (SQLException ex) {
                    Logger.getLogger(AddBudgetPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill up all the required fields", "Incomplete Entry", JOptionPane.ERROR_MESSAGE, errIcon);
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(AddBudgetPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }//GEN-LAST:event_jButton1MouseClicked

    private void BCatTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCatTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCatTFActionPerformed

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
            // Redirect to ExpenseMenuPanel
            
            JOptionPane.showMessageDialog(null, "Add Expense Canceled", "Cancel", JOptionPane.ERROR_MESSAGE);
           
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
            JOptionPane.showMessageDialog(null, "Add Expense Canceled", "Cancel", JOptionPane.ERROR_MESSAGE);
           
        } else {
            //none because the user will continue the process
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BCatTF;
    private javax.swing.JTextField EAmTF;
    private javax.swing.JTextField ECalTF;
    private javax.swing.JTextField ExpNotes;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
