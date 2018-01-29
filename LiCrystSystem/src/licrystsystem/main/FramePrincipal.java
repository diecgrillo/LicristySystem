/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package licrystsystem.main;

import licrystsystem.main.Splash;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import licrystsystem.consignacao.BaixaConsignacao;
import licrystsystem.vendedora.CadastrarVendedora1;
import licrystsystem.consignacao.DevolverSacola;
import licrystsystem.produto.InserirProduto1;
import licrystsystem.produto.InserirProduto1_2;
import licrystsystem.produto.TabelaProdutos;
import licrystsystem.vendedora.TabelaVendedora;
import licrystsystem.consignacao.VendaConsignacao;
import licrystsystem.consignacao.VendaVarejo;
import licrystsystem.menu.Consignacao1;
import licrystsystem.menu.MenuPrincipal;

/**
 *
 * @author Diego
 */
public class FramePrincipal extends JFrame {

    private Toolkit toolkit = this.getToolkit();//conjunto de elementos básicos de uma GUI    
    private CadastrarVendedora1 cadastrarVendedora1 = new CadastrarVendedora1(this);
    private VendaConsignacao vendaConsignacao = new VendaConsignacao(this);
    private VendaVarejo vendaVarejo = new VendaVarejo(this);
    private Consignacao1 consignacao1 = new Consignacao1(this);
    private Image imagem = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/licrystsystem/images/Licristy.jpg"));
    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;
    private InserirProduto1 inserirProduto1 = new InserirProduto1(this);
    private MenuPrincipal menuPrincipal = new MenuPrincipal(this);
    private InserirProduto1_2 inserirProduto1_2 = new InserirProduto1_2(this);
    private TabelaProdutos tabelaProdutos = new TabelaProdutos(this);
    private TabelaVendedora tabelaVendedora = new TabelaVendedora(this);
    private BaixaConsignacao baixaConsignacao = new BaixaConsignacao(this);
    private DevolverSacola devolverSacola = new DevolverSacola(this);
    private String diretorio = "C:/LicristySystem/LicristySystem/";

    public FramePrincipal() {

        Splash splash = new Splash();
        splash.setBarValue(10);
        splash.setBarValue(20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            splash.setBarValue(30);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar programa, erro 0");
        }
        try {
            conn = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:" + diretorio+"LICRYSTSYSTEM.GDB", "SYSDBA", "masterkey");
            splash.setBarValue(40);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar programa, erro 1");
        }
        try {
               stm = conn.createStatement();
               splash.setBarValue(50);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar programa, erro 2");
        }

        this.getContentPane().add(menuPrincipal);
        this.pack();
        splash.setBarValue(60);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.addWindowListener(new WindowListener() {


            public void windowClosing(WindowEvent e) {
                try {
                    getConn().close();
                    System.out.println("fechou");
                } catch (SQLException onConClose) {
                    System.out.println("error on closing");
                }
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowOpened(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });
        vendaConsignacao.setDiretorio(diretorio);
        vendaVarejo.setDiretorio(diretorio);
        tabelaProdutos.setDiretorio(diretorio);
        tabelaVendedora.setDiretorio(diretorio);
        baixaConsignacao.setDiretorio(diretorio);
        splash.setBarValue(100);
        splash.exit();
    }

    /**
     * @return the inserirProduto1
     */
    public InserirProduto1 getInserirProduto1() {
        return inserirProduto1;
    }

    /**
     * @param inserirProduto1 the inserirProduto1 to set
     */
    public void setInserirProduto1(InserirProduto1 inserirProduto1) {
        this.inserirProduto1 = inserirProduto1;
    }

    /**
     * @return the menuPrincipal
     */
    public MenuPrincipal getMenuPrincipal() {
        return menuPrincipal;
    }

    /**
     * @param menuPrincipal the menuPrincipal to set
     */
    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    /**
     * @return the inserirProduto1_2
     */
    public InserirProduto1_2 getInserirProduto1_2() {
        return inserirProduto1_2;
    }

    /**
     * @param inserirProduto1_2 the inserirProduto1_2 to set
     */
    public void setInserirProduto1_2(InserirProduto1_2 inserirProduto1_2) {
        this.inserirProduto1_2 = inserirProduto1_2;
    }

    /**
     * @return the tabelaProdutos
     */
    public TabelaProdutos getTabelaProdutos() {
        return tabelaProdutos;
    }

    /**
     * @param tabelaProdutos the tabelaProdutos to set
     */
    public void setTabelaProdutos(TabelaProdutos tabelaProdutos) {
        this.tabelaProdutos = tabelaProdutos;
    }

    /**
     * @return the tabelaVendedora
     */
    public TabelaVendedora getTabelaVendedora() {
        return tabelaVendedora;
    }

    /**
     * @param tabelaVendedora the tabelaVendedora to set
     */
    public void setTabelaVendedora(TabelaVendedora tabelaVendedora) {
        this.tabelaVendedora = tabelaVendedora;
    }

    /**
     * @return the cadastrarVendedora1
     */
    public CadastrarVendedora1 getCadastrarVendedora1() {
        return cadastrarVendedora1;
    }

    /**
     * @param cadastrarVendedora1 the cadastrarVendedora1 to set
     */
    public void setCadastrarVendedora1(CadastrarVendedora1 cadastrarVendedora1) {
        this.cadastrarVendedora1 = cadastrarVendedora1;
    }

    /**
     * @return the vendaConsignacao
     */
    public VendaConsignacao getVendaConsignacao() {
        return vendaConsignacao;
    }

    /**
     * @param vendaConsignacao the vendaConsignacao to set
     */
    public void setVendaConsignacao(VendaConsignacao vendaConsignacao) {
        this.vendaConsignacao = vendaConsignacao;
    }

    /**
     * @return the vendaVarejo
     */
    public VendaVarejo getVendaVarejo() {
        return vendaVarejo;
    }

    /**
     * @param vendaVarejo the vendaVarejo to set
     */
    public void setVendaVarejo(VendaVarejo vendaVarejo) {
        this.vendaVarejo = vendaVarejo;
    }

    /**
     * @return the consignacao1
     */
    public Consignacao1 getConsignacao1() {
        return consignacao1;
    }

    /**
     * @param consignacao1 the consignacao1 to set
     */
    public void setConsignacao1(Consignacao1 consignacao1) {
        this.consignacao1 = consignacao1;
    }

    /**
     * @return the imagem
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the tabelaConsignacao
     */
    public BaixaConsignacao getBaixaConsignacao() {
        return baixaConsignacao;
    }

    /**
     * @param tabelaConsignacao the tabelaConsignacao to set
     */
    public void setBaixaConsignacao(BaixaConsignacao tabelaConsignacao) {
        this.baixaConsignacao = tabelaConsignacao;
    }

    /**
     * @return the devolverSacola
     */
    public DevolverSacola getDevolverSacola() {
        return devolverSacola;
    }

    /**
     * @param devolverSacola the devolverSacola to set
     */
    public void setDevolverSacola(DevolverSacola devolverSacola) {
        this.devolverSacola = devolverSacola;
    }
}
