/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DevolverSacola.java
 *
 * Created on 13/01/2011, 12:06:10
 */
package licrystsystem.consignacao;

import licrystsystem.main.FramePrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class DevolverSacola extends javax.swing.JPanel {

    private FramePrincipal framePrincipal;
    private DefaultTableModel modeloTabela;
    private float preco_total = 0;
    private List<Integer> quantidades_em_consignacao = new ArrayList<Integer>();
    private List<Integer> quantidades_em_estoque = new ArrayList<Integer>();
    private List<Integer> quantidades_c_vendedor = new ArrayList<Integer>();
    private int qtdProdutos = 0;

    /**
     * Creates new form DevolverSacola
     */
    public DevolverSacola(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        initComponents();
        modeloTabela = (DefaultTableModel) jTable1.getModel();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTotalUnidades = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(255, 51, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 51, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("Total:");

        jButton2.setBackground(new java.awt.Color(102, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Consultar tabela de produtos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Acertar contas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Cod. de barras", "Preço unitário", "Qtde"
            }
        ){

            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        });
        jTable1.setGridColor(new java.awt.Color(240, 240, 240));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 255));
        jLabel4.setText("Vendedor(a):");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 255));
        jLabel6.setText("teste");

        jLabelTotalUnidades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalUnidades.setForeground(new java.awt.Color(255, 204, 255));
        jLabelTotalUnidades.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 255));
        jLabel7.setText("Total de Unidades:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalUnidades)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabelTotalUnidades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        framePrincipal.setContentPane(framePrincipal.getConsignacao1());
        framePrincipal.pack();
        framePrincipal.setExtendedState(FramePrincipal.MAXIMIZED_BOTH);        // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            framePrincipal.getTabelaProdutos().setN(5);
            framePrincipal.getTabelaProdutos().getjTable1().setEnabled(false);
            framePrincipal.setContentPane(framePrincipal.getTabelaProdutos());
            framePrincipal.pack();
            framePrincipal.setExtendedState(FramePrincipal.MAXIMIZED_BOTH);
            if (framePrincipal.getInserirProduto1_2().isAtualizado()) {
                framePrincipal.setRs(framePrincipal.getStm().executeQuery("SELECT P.NOME, P.CODBARRAS, P.PRECO, P.QTDE, P.QTDECONS FROM PRODUTO P GROUP BY P.NOME, P.CODBARRAS, P.PRECO, P.QTDE, P.QTDECONS;"));
                int i = 0;
                while (framePrincipal.getRs().next()) {
                    if (framePrincipal.getTabelaProdutos().getModeloTabela().getRowCount() < i + 1) {
                        framePrincipal.getTabelaProdutos().getModeloTabela().addRow(new String[framePrincipal.getTabelaProdutos().getModeloTabela().getColumnCount()]);
                    }
                    framePrincipal.getTabelaProdutos().getModeloTabela().setValueAt(framePrincipal.getRs().getString("NOME"), i, 0);
                    framePrincipal.getTabelaProdutos().getModeloTabela().setValueAt(framePrincipal.getRs().getString("CODBARRAS"), i, 1);
                    framePrincipal.getTabelaProdutos().getModeloTabela().setValueAt("R$ " + framePrincipal.getRs().getString("PRECO"), i, 2);
                    framePrincipal.getTabelaProdutos().getModeloTabela().setValueAt(framePrincipal.getRs().getString("QTDE"), i, 3);
                    framePrincipal.getTabelaProdutos().getModeloTabela().setValueAt(framePrincipal.getRs().getString("QTDECONS"), i, 4);
                    i++;
                }
                framePrincipal.getTabelaProdutos().getjTable1().repaint();
                framePrincipal.getInserirProduto1_2().setAtualizado(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaVarejo.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int aux = JOptionPane.showConfirmDialog(null, "Deseja encerrar a consignação da vendedora " + jLabel6.getText());
        if (aux == 0) {
            int linha = getjTable1().getRowCount();
            int qtde_produto_estoque;
            int qtde_produto_consignacao;

            for (int i = 0; i < linha; i++) {

                qtde_produto_estoque = getQuantidades_em_estoque().get(i) - getQuantidades_c_vendedor().get(i);
                qtde_produto_consignacao = getQuantidades_em_consignacao().get(i) - getQuantidades_c_vendedor().get(i);

                try {
                    framePrincipal.getStm().executeUpdate("UPDATE PRODUTO SET QTDE = " + qtde_produto_estoque + ", QTDECONS = " + qtde_produto_consignacao + "WHERE CODBARRAS = " + getjTable1().getValueAt(i, 1).toString() + ";");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque");
                }

                try {
                    framePrincipal.getStm().executeUpdate("DELETE FROM CONSIGNACAO WHERE CODBARRAS = " + getjTable1().getValueAt(i, 1).toString() + " AND NOME = '" + getjLabel6().getText() + "';");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar produto");
                }
                framePrincipal.getInserirProduto1_2().setAtualizado(true);
            }
            try {
                framePrincipal.getStm().executeUpdate("UPDATE VENDEDORA SET DATAVENC = " + null + ", QTDE = " + 0 + " WHERE NOME = '" + getjLabel6().getText() + "';");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar produto3");
            }
            JOptionPane.showMessageDialog(null, "Total da fatura: " + jLabel3.getText());
            framePrincipal.setContentPane(framePrincipal.getMenuPrincipal());
            framePrincipal.pack();
            framePrincipal.setExtendedState(FramePrincipal.MAXIMIZED_BOTH);        // TODO add your handling code here:

        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
}//GEN-LAST:event_jTable1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTotalUnidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the preco_total
     */
    public float getPreco_total() {
        return preco_total;
    }

    /**
     * @param preco_total the preco_total to set
     */
    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the jLabel6
     */
    public javax.swing.JLabel getjLabel6() {
        return jLabel6;
    }

    /**
     * @param jLabel6 the jLabel6 to set
     */
    public void setjLabel6(javax.swing.JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    /**
     * @return the jLabelTotalUnidades
     */
    public javax.swing.JLabel getjLabelTotalUnidades() {
        return jLabelTotalUnidades;
    }

    /**
     * @param jLabelTotalUnidades the jLabelTotalUnidades to set
     */
    public void setjLabelTotalUnidades(javax.swing.JLabel jLabelTotalUnidades) {
        this.jLabelTotalUnidades = jLabelTotalUnidades;
    }

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    /**
     * @param jTable1 the jTable1 to set
     */
    public void setjTable1(javax.swing.JTable jTable1) {
        this.jTable1 = jTable1;
    }

    /**
     * @return the modeloTabela
     */
    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    /**
     * @param modeloTabela the modeloTabela to set
     */
    public void setModeloTabela(DefaultTableModel modeloTabela) {
        this.modeloTabela = modeloTabela;
    }

    /**
     * @return the quantidades_em_consignacao
     */
    public List<Integer> getQuantidades_em_consignacao() {
        return quantidades_em_consignacao;
    }

    /**
     * @param quantidades_em_consignacao the quantidades_em_consignacao to set
     */
    public void setQuantidades_em_consignacao(List<Integer> quantidades_em_consignacao) {
        this.quantidades_em_consignacao = quantidades_em_consignacao;
    }

    /**
     * @return the quantidades_em_estoque
     */
    public List<Integer> getQuantidades_em_estoque() {
        return quantidades_em_estoque;
    }

    /**
     * @param quantidades_em_estoque the quantidades_em_estoque to set
     */
    public void setQuantidades_em_estoque(List<Integer> quantidades_em_estoque) {
        this.quantidades_em_estoque = quantidades_em_estoque;
    }

    /**
     * @return the quantidades_c_vendedor
     */
    public List<Integer> getQuantidades_c_vendedor() {
        return quantidades_c_vendedor;
    }

    /**
     * @param quantidades_c_vendedor the quantidades_c_vendedor to set
     */
    public void setQuantidades_c_vendedor(List<Integer> quantidades_c_vendedor) {
        this.quantidades_c_vendedor = quantidades_c_vendedor;
    }

    /**
     * @return the qtdProdutos
     */
    public int getQtdProdutos() {
        return qtdProdutos;
    }

    /**
     * @param qtdProdutos the qtdProdutos to set
     */
    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
    // End of variables declaration
}
