/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package licrystsystem.impressora;

/**
 *
 * @author Diego
 */
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.*;

// instalada, recebe o texto e o imprime.   
public class GerenciadorImpressora {

    // variavel estatica porque serÃ¡ utilizada por inumeras threads
    private static PrintService impressora;
    private static SerialPort port;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public GerenciadorImpressora() {
        try {
            detectaImpressoras();

        } catch (Exception ex) {
            Logger.getLogger(GerenciadorImpressora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // O metodo verifica se existe impressora conectada e a
    // define como padrao.
    @SuppressWarnings("CallToThreadDumpStack")
    public void detectaImpressoras() {

        try {

            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);

            for (PrintService p : ps) {
                if (p.getName().contains("MP-4200 TH")) {                    
                    impressora = p;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int imprimeCabecalho(String cpf, String venc, String nome) {
        imprime("Licristy Com. Lingerie LTDA-ME\n");
        imprime("R: Benedito da S. Franco n.18 Itatiba-SP\n");
        imprime("Fone:(11) 4524-3871 (11) 99239-0406\n");
        imprime("CNPJ 10.202.096/0001-24 IE 382.151.038-110\n");
        imprime("__________________________________________\n");

        //Pega a data atual
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance(); // today

        //Pega a hora atual
        Locale locale = new Locale("pt", "BR");
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm", locale);
        imprime("Data:" + sdf1.format(c1.getTime()) + "   Hora:" + sdf2.format(c2.getTime()) + "\n");
        
        if (nome != null){
            imprime("Nome: " + nome + "\n");
        }
        if (cpf != null) {
            imprime("CPF: " + cpf + "\n");
        }
        if (venc != null){
            imprime("Vencimento: " + venc + "\n");
        }
        imprime("__________________________________________\n");
        return 1;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public synchronized boolean imprime(String texto) {

        // se nao existir impressora, entao avisa usuario
        // senao imprime o texto
        if (impressora == null) {
            String msg = "Nenhuma impressora foi encontrada. "
                    + "Instale uma impressora padrão \r\n"
                    + "(Generic Text Only) e reinicie o programa.";
            
        } else {
            byte[] bytes = new byte[texto.length()];
            for (int i = 0; i < texto.length(); i++) {
                switch (texto.charAt(i)) {
                    case 'ç':
                        bytes[i] = (byte) 0x87;
                        break;
                    case 'Ç':
                        bytes[i] = (byte) 0x80;
                        break;
                    case 'á':
                        bytes[i] = (byte) 0xA0;
                        break;
                    case 'Á':
                        bytes[i] = (byte) 0x41;
                        break;
                    case 'ã':
                        bytes[i] = (byte) 0x61;
                        break;
                    case 'Ã':
                        bytes[i] = (byte) 0x41;
                        break;
                    case 'â':
                        bytes[i] = (byte) 0x83;
                        break;
                    case 'Â':
                        bytes[i] = (byte) 0x41;
                        break;
                    case 'à':
                        bytes[i] = (byte) 0x85;
                        break;
                    case 'À':
                        bytes[i] = (byte) 0x41;
                        break;
                    case 'é':
                        bytes[i] = (byte) 0x82;
                        break;
                    case 'ê':
                        bytes[i] = (byte) 0x88;
                        break;
                    case 'É':
                        bytes[i] = (byte) 0x90;
                        break;
                    case 'Ê':
                        bytes[i] = (byte) 0x45;
                        break;
                    case 'í':
                        bytes[i] = (byte) 0xA1;
                        break;
                    case 'Í':
                        bytes[i] = (byte) 0x49;
                        break;
                    case 'ô':
                        bytes[i] = (byte) 0x93;
                        break;
                    case 'Ô':
                        bytes[i] = (byte) 0x4F;
                        break;
                    case 'ó':
                        bytes[i] = (byte) 0xA2;
                        break;
                    case 'Ó':
                        bytes[i] = (byte) 0x4F;
                        break;
                    case 'õ':
                        bytes[i] = (byte) 0x6F;
                        break;
                    case 'Õ':
                        bytes[i] = (byte) 0x4F;
                        break;
                    case 'ú':
                        bytes[i] = (byte) 0xA3;
                        break;
                    case 'Ú':
                        bytes[i] = (byte) 0x55;
                        break;
                    default:
                        bytes[i] = (byte) texto.charAt(i);
                        break;
                }
            }
            try {
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream(bytes);

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);
                return true;

            } catch (PrintException e) {
                e.printStackTrace();
            }



        }
        return false;
    }

    public void imprimeRodape(String total) {
        imprime("__________________________________________\n");
        imprime("                   VALOR TOTAL " + total + "\n\n");
        imprime("              Cupom Comum    \n");
        imprime("               Obrigado!  \n");
        imprime("\"O Senhor é meu Pastor e nada me faltará.\"\n\n\n\n\n");
        
    }

    public boolean cortaPapel() {

        // se nao existir impressora, entao avisa usuario
        // senao imprime o texto
        if (impressora == null) {
            String msg = "Nenhuma impressora foi encontrada. "
                    + "Instale uma impressora padrão \r\n"
                    + "(Generic Text Only) e reinicie o programa.";
            
        } else {

            try {
                DocPrintJob dpj = impressora.createPrintJob();
                byte[] bytes = new byte[2];
                imprime("\n");
                imprime("\n");
                imprime("\n");
                bytes[0] = 0x1b;
                bytes[1] = 0x6D;
                InputStream stream = new ByteArrayInputStream(bytes);

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);
                return true;

            } catch (PrintException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}