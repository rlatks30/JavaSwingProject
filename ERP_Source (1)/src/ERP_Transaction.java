
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tksml
 */
public class ERP_Transaction extends javax.swing.JFrame {
    static javax.swing.JFrame User;
    static javax.swing.JFrame Salary;
    static javax.swing.JFrame Transaction;
    static javax.swing.JFrame Goods;
    static javax.swing.JFrame Order;
    DBMan DBM = new DBMan();
    String strSQL = "Select * From transaction ";
    int iCntRow = 0;
    ArrayList pay = new ArrayList();
    SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		
    Date time1 = new Date();
		
    String time = format.format(time1);
    /**
     * Creates new form ERP
     */
    public ERP_Transaction() {
        initComponents();
        try{
            DBM.dbOpen();
            setTableIncomeDB(strSQL);
            setTableExpenditureDB(strSQL);
            DBM.dbClose();
        }catch (Exception e){
            System.out.println("SQLException: "+ e.getMessage());
        }
    }
//    public void getDBData(String strQuery){
//        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//        model.setNumRows(0);
//        model.setNumRows(31);
//        iCntRow = 0;
//        try{
//            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);
//            while(DBM.DB_rs.next()){
//                jTable1.setValueAt(DBM.DB_rs.getString("transaction_no"), iCntRow, 0);
//                jTable1.setValueAt(DBM.DB_rs.getString("goods_code"), iCntRow, 1);
//                jTable1.setValueAt(DBM.DB_rs.getString("quantity"), iCntRow, 2);
//                jTable1.setValueAt(DBM.DB_rs.getString("transaction_date"), iCntRow, 3);
//                jTable1.setValueAt(DBM.DB_rs.getString("transaction_type"), iCntRow, 4);
//                iCntRow++;
//            }
//            DBM.DB_rs.close();
//        }catch (Exception e){
//            System.out.println("SQLException: "+ e.getMessage());
//        }
//    }
   
    public void setTableIncomeDB(String strQuery) {
        DefaultTableModel modelIncome = (DefaultTableModel)tableIncome.getModel();
        modelIncome.setNumRows(0);
        String IncomeSQL = "select goods.goods_code, goods_name, goods_price, quantity, trasaction_date, transaction_type\n" +
"from goods, transaction where goods.goods_code = transaction.goods_code";
        try{
            DBM.DB_rs = DBM.DB_stmt.executeQuery(IncomeSQL);
            while(DBM.DB_rs.next()) {
                if(DBM.DB_rs.getString("transaction_type").equals("P")){
                    Vector<String> myVC = new Vector<String>();
                    myVC.addElement(DBM.DB_rs.getString("goods_code"));
                    myVC.addElement(DBM.DB_rs.getString("goods_name"));
                    myVC.addElement(DBM.DB_rs.getString("goods_price"));
                    myVC.addElement(DBM.DB_rs.getString("quantity"));
                    myVC.addElement(DBM.DB_rs.getString("trasaction_date"));
                    myVC.addElement(DBM.DB_rs.getString("transaction_type"));
                    modelIncome.addRow(myVC);
                }
            }
            DBM.DB_rs.close();
        } catch(Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    public void setTableExpenditureDB(String strQuery) {
        DefaultTableModel modelExpenditure = (DefaultTableModel)tableExpenditure.getModel();
        modelExpenditure.setNumRows(0);
        String ExpenditureSQL = "select goods.goods_code, goods_name, goods_price, quantity, trasaction_date, transaction_type\n" +
"from goods, transaction where goods.goods_code = transaction.goods_code";
        try{
            DBM.DB_rs = DBM.DB_stmt.executeQuery(ExpenditureSQL);
            while(DBM.DB_rs.next()) {
                if(DBM.DB_rs.getString("transaction_type").equals("S")){
                    Vector<String> myVC = new Vector<String>();
                    myVC.addElement(DBM.DB_rs.getString("goods_code"));
                    myVC.addElement(DBM.DB_rs.getString("goods_name"));
                    myVC.addElement(DBM.DB_rs.getString("goods_price"));
                    myVC.addElement(DBM.DB_rs.getString("quantity"));
                    myVC.addElement(DBM.DB_rs.getString("trasaction_date"));
                    myVC.addElement(DBM.DB_rs.getString("transaction_type"));
                    modelExpenditure.addRow(myVC);
                }
            }
            DBM.DB_rs.close();
        } catch(Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    public String makeSQLWhere(String strQuery) {
        switch(comboSelect.getSelectedIndex()) {
            case 0:
                strQuery += " and goods.goods_code = " + selectProductCode.getText();
                break;
            case 1:
                strQuery += " and goods_name = '" + selectProductName.getText() + "'";
                break;
            case 2:
                strQuery += " and goods_price = " + selectProductPrice.getText();
                break;
            case 3:
                strQuery += " and trasaction_date between '" + selectPurchaseDateStart.getText() + "' and '" + selectPurchaseDateEnd.getText() + "'";
                break;
            default:
                strQuery = "select goods.goods_code, goods_name, goods_price, quantity, trasaction_date, transaction_type\n" +
"from goods, transaction where goods.goods_code = transaction.goods_code";
                break;
        }
        return strQuery;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtnSal = new javax.swing.JRadioButton();
        rbtnTrans = new javax.swing.JRadioButton();
        rbtnEmp = new javax.swing.JRadioButton();
        rbtnGoods = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        selectLabelProductPrice = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableExpenditure = new javax.swing.JTable();
        selectProductPrice = new javax.swing.JTextField();
        comboSelect = new javax.swing.JComboBox<>();
        btnSelect = new javax.swing.JButton();
        btnSelectAll = new javax.swing.JButton();
        selectLabelProductCode = new javax.swing.JLabel();
        selectProductCode = new javax.swing.JTextField();
        selectLabelPurchaseDate = new javax.swing.JLabel();
        selectPurchaseDateStart = new javax.swing.JTextField();
        selectLabelProductName = new javax.swing.JLabel();
        selectProductName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIncome = new javax.swing.JTable();
        selectPurchaseDateEnd = new javax.swing.JTextField();
        rbtnExpenses = new javax.swing.JRadioButton();
        rbtnPS = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel9.setText("거래관리 테이블");

        buttonGroup1.add(rbtnSal);
        rbtnSal.setText("급여");
        rbtnSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSalActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnTrans);
        rbtnTrans.setText("거래");
        rbtnTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTransActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnEmp);
        rbtnEmp.setText("사원");
        rbtnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEmpActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnGoods);
        rbtnGoods.setText("상품");
        rbtnGoods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnGoodsActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("발주");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        selectLabelProductPrice.setText("상품단가");

        tableExpenditure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "상풐코드", "상품명", "상품단가", "수량", "판매일자", "구분"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableExpenditure);

        comboSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "상품코드", "상품명", "상품단가", "날짜" }));
        comboSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectActionPerformed(evt);
            }
        });

        btnSelect.setText("조회");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnSelectAll.setText("전체 검색");
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });

        selectLabelProductCode.setText("상품코드");

        selectLabelPurchaseDate.setText("날짜");

        selectLabelProductName.setText("상품명");

        tableIncome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "상품코드", "상품명", "상품단가", "수량", "구입일자", "구분"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableIncome);

        rbtnExpenses.setText("지출");
        rbtnExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnExpensesActionPerformed(evt);
            }
        });

        rbtnPS.setText("구매/판매");
        rbtnPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPSActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectLabelProductCode)
                                .addGap(18, 18, 18)
                                .addComponent(selectProductCode))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectLabelPurchaseDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectPurchaseDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectPurchaseDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectLabelProductName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectLabelProductPrice)
                                .addGap(18, 18, 18)
                                .addComponent(selectProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 299, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnSal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnTrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnGoods)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnPS, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(509, 509, 509)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnSal)
                    .addComponent(rbtnTrans)
                    .addComponent(rbtnEmp)
                    .addComponent(rbtnGoods)
                    .addComponent(jRadioButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnExpenses)
                        .addComponent(rbtnPS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(793, 793, 793))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectLabelProductCode)
                            .addComponent(selectProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectLabelProductName)
                            .addComponent(selectProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectLabelProductPrice)
                            .addComponent(selectProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectLabelPurchaseDate)
                            .addComponent(selectPurchaseDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectPurchaseDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSalActionPerformed
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(true);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_rbtnSalActionPerformed

    private void rbtnTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTransActionPerformed
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(true);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_rbtnTransActionPerformed

    private void rbtnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEmpActionPerformed
        Login1.User.setVisible(true);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_rbtnEmpActionPerformed

    private void rbtnGoodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnGoodsActionPerformed
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(true);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_rbtnGoodsActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(true);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void comboSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSelectActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(selectPurchaseDateStart.getText()) <= Integer.parseInt(selectPurchaseDateEnd.getText())){
            DefaultTableModel modelIncome = (DefaultTableModel)tableIncome.getModel();
            modelIncome.setNumRows(0);
            DefaultTableModel modelExpenditure = (DefaultTableModel)tableExpenditure.getModel();
            modelExpenditure.setNumRows(0);
            strSQL = "select goods.goods_code, goods_name, goods_price, quantity, trasaction_date, transaction_type\n" +
            "from goods, transaction where goods.goods_code = transaction.goods_code";
            strSQL = makeSQLWhere(strSQL);
            try{
                DBM.dbOpen();
                DBM.DB_rs = DBM.DB_stmt.executeQuery(strSQL);
                while(DBM.DB_rs.next()) {
                    if(DBM.DB_rs.getString("transaction_type").equals("P")){
                        Vector myVC = new Vector();
                        myVC.addElement(DBM.DB_rs.getString("goods_code"));
                        myVC.addElement(DBM.DB_rs.getString("goods_name"));
                        myVC.addElement(DBM.DB_rs.getString("goods_price"));
                        myVC.addElement(DBM.DB_rs.getString("quantity"));
                        myVC.addElement(DBM.DB_rs.getString("trasaction_date"));
                        myVC.addElement(DBM.DB_rs.getString("transaction_type"));
                        modelIncome.addRow(myVC);
                    } else {
                        Vector myVC = new Vector();
                        myVC.addElement(DBM.DB_rs.getString("goods_code"));
                        myVC.addElement(DBM.DB_rs.getString("goods_name"));
                        myVC.addElement(DBM.DB_rs.getString("goods_price"));
                        myVC.addElement(DBM.DB_rs.getString("quantity"));
                        myVC.addElement(DBM.DB_rs.getString("trasaction_date"));
                        myVC.addElement(DBM.DB_rs.getString("transaction_type"));
                        modelExpenditure.addRow(myVC);
                    }
                }
                DBM.DB_rs.close();
                DBM.dbClose();
            } catch(Exception e) {
                System.out.println("SQLException : " + e.getMessage());
            }
        } else {
            try{
                DBM.dbOpen();
                setTableIncomeDB(strSQL);
                setTableExpenditureDB(strSQL);
                DBM.dbClose();
            } catch(Exception e) {
                System.out.println("SQLException : " + e.getMessage());
            }
//            dialogError.setLocation(350, 350);
//            dialogError.setSize(300, 300);
//            dialogError.show();
            System.out.println("날짜 입력이 잘못되었습니다.");

        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        // TODO add your handling code here:
        try{
            DBM.dbOpen();
            setTableIncomeDB(strSQL);
            setTableExpenditureDB(strSQL);
            DBM.dbClose();
        } catch(Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSelectAllActionPerformed

    private void rbtnExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnExpensesActionPerformed
        // TODO add your handling code here:
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(false);
        Login1.Expenses.setVisible(true);
    }//GEN-LAST:event_rbtnExpensesActionPerformed

    private void rbtnPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPSActionPerformed
        // TODO add your handling code here:
        Login1.User.setVisible(false);
        Login1.Salary.setVisible(false);
        Login1.Transaction.setVisible(false);
        Login1.Goods.setVisible(false);
        Login1.Order.setVisible(false);
        Login1.PS.setVisible(true);
        Login1.Expenses.setVisible(false);
    }//GEN-LAST:event_rbtnPSActionPerformed

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
            java.util.logging.Logger.getLogger(ERP_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ERP_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ERP_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ERP_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User = new ERP_User();
                Salary = new ERP_Salary();
                Transaction = new ERP_Transaction();
                Goods = new ERP_Goods();
                User.setVisible(false);
                Salary.setVisible(false);
                Transaction.setVisible(true);
                Goods.setVisible(false);
                Order = new ERP_Order();
                Order.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSelectAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboSelect;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbtnEmp;
    private javax.swing.JRadioButton rbtnExpenses;
    private javax.swing.JRadioButton rbtnGoods;
    private javax.swing.JRadioButton rbtnPS;
    private javax.swing.JRadioButton rbtnSal;
    private javax.swing.JRadioButton rbtnTrans;
    private javax.swing.JLabel selectLabelProductCode;
    private javax.swing.JLabel selectLabelProductName;
    private javax.swing.JLabel selectLabelProductPrice;
    private javax.swing.JLabel selectLabelPurchaseDate;
    private javax.swing.JTextField selectProductCode;
    private javax.swing.JTextField selectProductName;
    private javax.swing.JTextField selectProductPrice;
    private javax.swing.JTextField selectPurchaseDateEnd;
    private javax.swing.JTextField selectPurchaseDateStart;
    private javax.swing.JTable tableExpenditure;
    private javax.swing.JTable tableIncome;
    // End of variables declaration//GEN-END:variables
}
