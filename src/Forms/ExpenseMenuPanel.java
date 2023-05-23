/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Forms;

import java.awt.Container;
import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet; 
import java.util.Vector;
import javax.management.Query;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author windows-10
 */
public class ExpenseMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form ExpenseMenuPanel
     */
    public ExpenseMenuPanel() {
        initComponents();
        Connect(); 
        Fetch(); 
        fetchAndDisplayData1(); 
        fetchAndDisplayData2(); 
        fetchAndDisplayData3();
      
    }
    PreparedStatement pst; 
    ResultSet rs; 
    Connection con; 
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
    ResultSetMetaData rss;
    DefaultTableModel df; 
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM expenseTable");
            rs = pst.executeQuery();
            
            rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            df =(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 1 ; i <= q ; i++){
                    v2.add(rs.getString("expenses_id"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("budget_FK"));
                    v2.add(rs.getString("expenseAmount"));
                    v2.add(rs.getString("notes"));
                }
                df.addRow(v2);
            } 
                    } catch (SQLException ex) {
            Logger.getLogger(ExpenseMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fetchAndDisplayData1() {
        try {
            pst = con.prepareStatement("SELECT SUM(budgetAmount) AS sum FROM budgettable WHERE category = 'Savings'");
            rs = pst.executeQuery();

            if (rs.next()) {
                double SaveAve = rs.getDouble("sum");
                
                String sum = String.valueOf(SaveAve);
                misc.setText(sum);
                miscCat.setText("Savings");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Fetch();
    }
    private void fetchAndDisplayData2() {
        try {
            pst = con.prepareStatement("SELECT SUM(budgetAmount) AS sum FROM budgettable WHERE category = 'Daily'");
            rs = pst.executeQuery();

            if (rs.next()) {
                double DailyAve = rs.getDouble("sum");
                
                String sum = String.valueOf(DailyAve);
                
                daily.setText(sum);
                dailyCat.setText("Daily");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Fetch();
    }
    private void fetchAndDisplayData3() {
        try {
            pst = con.prepareStatement("SELECT SUM(budgetAmount) AS sum FROM budgettable WHERE category = 'Miscellaneous'");
            rs = pst.executeQuery();

            if (rs.next()) {
                double MiscAve = rs.getDouble("sum");
                
                String sum = String.valueOf(MiscAve);
                saving.setText(sum);
                savingCat.setText("Miscellaneous");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenseMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Fetch();
    }
    private void switchToMenuPanelE(){
        ExpenseMenuPanel emp = new ExpenseMenuPanel(); 
        Home home = (Home) SwingUtilities.getWindowAncestor(this);

        // Remove the current panel (AddExpensePanel)
        home.getMenuBoard().remove(this);

        // Add the ExpenseMenuPanel
        emp.setSize(900, 450);
        home.getMenuBoard().add(emp);
        home.getMenuBoard().revalidate();
        home.getMenuBoard().repaint();
        Fetch();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExpenseAddPanel = new javax.swing.JPanel();
        eMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        misc = new javax.swing.JLabel();
        miscCat = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        dailyCat = new javax.swing.JLabel();
        daily = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        savingCat = new javax.swing.JLabel();
        saving = new javax.swing.JLabel();
        DeleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ExpAddBtnPanel = new javax.swing.JPanel();
        ExpAddBtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TblBtnPanel = new javax.swing.JPanel();
        expTblBtn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 247, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExpenseAddPanel.setBackground(new java.awt.Color(248, 247, 242));

        eMenu.setBackground(new java.awt.Color(248, 247, 242));

        jTable1.setBackground(new java.awt.Color(248, 247, 242));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(107, 112, 92));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EXPENSES_ID", "DATE", "BUDGET", "AMOUNT", "NOTES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(107, 112, 92));
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 1));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(183, 183, 164));
        jTable1.setSelectionForeground(new java.awt.Color(248, 247, 242));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout eMenuLayout = new javax.swing.GroupLayout(eMenu);
        eMenu.setLayout(eMenuLayout);
        eMenuLayout.setHorizontalGroup(
            eMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        eMenuLayout.setVerticalGroup(
            eMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eMenuLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 165, 0));

        misc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        misc.setForeground(new java.awt.Color(248, 247, 242));
        misc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        misc.setText("0000");

        miscCat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        miscCat.setForeground(new java.awt.Color(248, 247, 242));
        miscCat.setText("Miscellanous");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addComponent(misc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(miscCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miscCat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(misc, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(198, 114, 118));
        kGradientPanel2.setkStartColor(new java.awt.Color(225, 77, 42));

        dailyCat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dailyCat.setForeground(new java.awt.Color(248, 247, 242));
        dailyCat.setText("Daily");

        daily.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        daily.setForeground(new java.awt.Color(248, 247, 242));
        daily.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        daily.setText("0000");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addComponent(daily, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dailyCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dailyCat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daily, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel3.setForeground(new java.awt.Color(158, 171, 228));
        kGradientPanel3.setkEndColor(new java.awt.Color(245, 115, 40));
        kGradientPanel3.setkStartColor(new java.awt.Color(244, 157, 26));

        savingCat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        savingCat.setForeground(new java.awt.Color(248, 247, 242));
        savingCat.setText("Savings");

        saving.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saving.setForeground(new java.awt.Color(248, 247, 242));
        saving.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saving.setText("0000");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(savingCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savingCat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        DeleteBtn.setBackground(new java.awt.Color(107, 112, 92));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setText("DELETE");
        DeleteBtn.setBorder(null);
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(107, 112, 92));
        jLabel1.setText("YOUR EXPENSE RECORDS");

        javax.swing.GroupLayout ExpenseAddPanelLayout = new javax.swing.GroupLayout(ExpenseAddPanel);
        ExpenseAddPanel.setLayout(ExpenseAddPanelLayout);
        ExpenseAddPanelLayout.setHorizontalGroup(
            ExpenseAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpenseAddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ExpenseAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExpenseAddPanelLayout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ExpenseAddPanelLayout.createSequentialGroup()
                        .addComponent(eMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpenseAddPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        ExpenseAddPanelLayout.setVerticalGroup(
            ExpenseAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpenseAddPanelLayout.createSequentialGroup()
                .addGroup(ExpenseAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(ExpenseAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(ExpenseAddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 810, 390));

        ExpAddBtnPanel.setBackground(new java.awt.Color(248, 247, 242));
        ExpAddBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpAddBtnPanelMouseClicked(evt);
            }
        });

        ExpAddBtn.setBackground(new java.awt.Color(248, 247, 242));
        ExpAddBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ExpAddBtn.setForeground(new java.awt.Color(107, 112, 92));
        ExpAddBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExpAddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/addDark.png"))); // NOI18N
        ExpAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpAddBtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExpAddBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ExpAddBtnPanelLayout = new javax.swing.GroupLayout(ExpAddBtnPanel);
        ExpAddBtnPanel.setLayout(ExpAddBtnPanelLayout);
        ExpAddBtnPanelLayout.setHorizontalGroup(
            ExpAddBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpAddBtnPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ExpAddBtn))
        );
        ExpAddBtnPanelLayout.setVerticalGroup(
            ExpAddBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpAddBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExpAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(ExpAddBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 50, 70));

        jPanel1.setBackground(new java.awt.Color(248, 247, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 440, 20));

        TblBtnPanel.setBackground(new java.awt.Color(248, 247, 242));
        TblBtnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblBtnPanelMouseClicked(evt);
            }
        });

        expTblBtn.setBackground(new java.awt.Color(248, 247, 242));
        expTblBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        expTblBtn.setForeground(new java.awt.Color(107, 112, 92));
        expTblBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expTblBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bTblLight.png"))); // NOI18N
        expTblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expTblBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TblBtnPanelLayout = new javax.swing.GroupLayout(TblBtnPanel);
        TblBtnPanel.setLayout(TblBtnPanelLayout);
        TblBtnPanelLayout.setHorizontalGroup(
            TblBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(expTblBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TblBtnPanelLayout.setVerticalGroup(
            TblBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TblBtnPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(expTblBtn))
        );

        add(TblBtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 50, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void ExpAddBtnPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpAddBtnPanelMouseClicked
        // TODO add your handling code here:
      
        
        AddExpensePanel aep = new AddExpensePanel();
        aep.setSize(740, 350);
        ExpenseAddPanel.removeAll();
        ExpenseAddPanel.add(aep).setVisible(true);
        ExpenseAddPanel.revalidate();
        ExpenseAddPanel.repaint();
        System.out.println("Panel visibility: " + aep.isVisible());
        System.out.println("Panel size: " + aep.getSize());
        System.out.println("Panel location: " + aep.getLocation());
        Fetch();
    }//GEN-LAST:event_ExpAddBtnPanelMouseClicked

    private void ExpAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpAddBtnMouseClicked
        // TODO add your handling code here:
        
        
        AddExpensePanel aep = new AddExpensePanel();
        aep.setSize(740, 350);
        ExpenseAddPanel.removeAll();
        ExpenseAddPanel.add(aep).setVisible(true);
          
        ExpenseAddPanel.revalidate();
        ExpenseAddPanel.repaint();
        System.out.println("Panel visibility: " + aep.isVisible());
        System.out.println("Panel size: " + aep.getSize());
        System.out.println("Panel location: " + aep.getLocation());
        Fetch();
    }//GEN-LAST:event_ExpAddBtnMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int[] x = jTable1.getSelectedRows();
        
        for (int i = 0 ; i < x.length ; i++){
            try {
                Object xz = df.getValueAt(x[i],0);
                pst = con.prepareStatement("DELETE FROM expenseTable WHERE expenses_id = ?");
               System.out.println(xz.toString());

                
                pst.setString(1, xz.toString());
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ExpenseMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Fetch();
    }//GEN-LAST:event_DeleteBtnActionPerformed
    
    private void expTblBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expTblBtnMouseClicked
        // TODO add your handling code here:
        //change pic for btns
       
        switchToMenuPanelE();
                Fetch();
    }//GEN-LAST:event_expTblBtnMouseClicked

    private void TblBtnPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblBtnPanelMouseClicked
        // TODO add your handling code here:
        
         
        switchToMenuPanelE();
                Fetch();
        
        
    }//GEN-LAST:event_TblBtnPanelMouseClicked

    private void ExpAddBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpAddBtnMousePressed
            //none
    }//GEN-LAST:event_ExpAddBtnMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel ExpAddBtn;
    private javax.swing.JPanel ExpAddBtnPanel;
    private javax.swing.JPanel ExpenseAddPanel;
    private javax.swing.JPanel TblBtnPanel;
    private javax.swing.JLabel daily;
    private javax.swing.JLabel dailyCat;
    private javax.swing.JPanel eMenu;
    private javax.swing.JLabel expTblBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel misc;
    private javax.swing.JLabel miscCat;
    private javax.swing.JLabel saving;
    private javax.swing.JLabel savingCat;
    // End of variables declaration//GEN-END:variables
}
