package buscador;

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.util.Random;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
//import javax.swing.text.rtf.*;
import javax.swing.JEditorPane;
//import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.SwingWorker;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Buscador extends SwingWorker<Integer, File>
{
    private final JList Lista;
    private final DefaultListModel modelo;
    private final Random generator = new Random();
    private final String match;
    private final File directorio;
    private final JLabel mensaje;
    private final opciones seleccion;
    private final JButton buscarPorContenido;
    private final JButton buscarPorNombre;
    private final JButton btnBorrar;
    private final Interfaz_Buscador inter;
    
    public Buscador(JList list, DefaultListModel model, JLabel label, String match, File directorio,
            opciones sel, JButton contenido, JButton nombre, JButton borrar, Interfaz_Buscador interfaz)
    {
        Lista = list;
        mensaje = label;
        modelo = model;
        this.match = match;
        this.directorio = directorio;
        seleccion = sel;
        buscarPorContenido = contenido;
        buscarPorNombre = nombre;
        btnBorrar = borrar;
        inter = interfaz;
    }
    
    public void buscarArchivoporContenido(File argFile, String match)
    {
        int tipo;
        
        File[] lista = argFile.listFiles();

        if (lista != null)
        {
            for (File elemento : lista) 
            {
                if(isCancelled())
                    return ;
                if (elemento.isDirectory())
                {
                    if(elemento.getPath().length() < 150)
                        mensaje.setText(elemento.getPath());
                    buscarArchivoporContenido(elemento, match);
                }
                else if ((tipo = DocumentoBrowseable(elemento.getName())) > 0)
                {
                    buscarContenidoenelArchivo(elemento, match, tipo);
                }
            }
        }
    }
    
    
    public void buscarContenidoenelArchivo(File f, String match, int tipo)
    {
        String contenido;
        
        switch(tipo)
        {
            case 1 : // docx
                if(seleccion.DocXselected)
                try
                {
                    XWPFDocument docx = new XWPFDocument(new FileInputStream(f));
                    XWPFWordExtractor we = new XWPFWordExtractor(docx);
                    
                    contenido = we.getText();
                    
                    if(contenido.contains(match))
                    {
                        modelo.addElement(f.getAbsoluteFile());
                    }
                }catch(Exception e){}
                break;
            case 2 : // doc
                if(seleccion.DocSelected)
                try
                {
                    HWPFDocument doc = new HWPFDocument(new FileInputStream(f));
                    WordExtractor we = new WordExtractor(doc);
                    
                    contenido = we.getText();
                    
                    if(contenido.contains(match))
                    {
                        modelo.addElement(f.getAbsoluteFile());
                    }
                }catch(Exception e){}
                break;
            case 3 : // txt
                if(seleccion.TXTselected)
                try
                {
                    BufferedReader in = new BufferedReader(new FileReader(f));
                    contenido = in.readLine();
                    
                    int c=0;
                    
                    while(contenido != null)
                    {
                        if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                            break;
                        }
                        contenido = in.readLine();
                    }
                }catch(Exception e){}
                break;
            case 4 : // pdf
                if(seleccion.PDFselected)
                try
                {
                    PDDocument documento = null;
                    documento = PDDocument.load(f);

                    if(!documento.isEncrypted())
                    {
                        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                        stripper.setSortByPosition(true);
                        PDFTextStripper Tstripper = new PDFTextStripper();
                        contenido = Tstripper.getText(documento);
                        
                        if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                        }
                    }
                    documento.close();
                }catch(Exception e){}
                break;
            case 5 : // rtf
                if(seleccion.RTFselected)
                try
                {
                    JEditorPane p = new JEditorPane();
                    p.setContentType("text/rtf");
                    EditorKit rtfKit = p.getEditorKitForContentType("text/plain");
                    rtfKit.read(new FileReader(f.getAbsolutePath()), p.getDocument(), 1);
                    rtfKit = null;
                    
                    EditorKit txtKit = p.getEditorKitForContentType("text/plain");
                    Writer writer = new StringWriter();
                    txtKit.write(writer, p.getDocument(), 0, p.getDocument().getLength());
                    contenido = writer.toString();
                    
                    if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                        }
                }catch(Exception e){}
                break;
            case 6 : // java
                if(seleccion.JavaSelected)
                try
                {
                    BufferedReader in = new BufferedReader(new FileReader(f));
                    contenido = in.readLine();
                    
                    int c=0;
                    
                    while(contenido != null)
                    {
                        if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                            break;
                        }
                        contenido = in.readLine();
                    }
                }catch(Exception e){}
                break;
            case 7 : // C / C++
                if(seleccion.cppSelected)
                try
                {
                    BufferedReader in = new BufferedReader(new FileReader(f));
                    contenido = in.readLine();
                    
                    int c=0;
                    
                    while(contenido != null)
                    {
                        if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                            break;
                        }
                        contenido = in.readLine();
                    }
                }catch(Exception e){}
                break;
        } 
    }
    
    public int DocumentoBrowseable(String argFichero)
    {
        int browseable = 0;
        
        if(argFichero.endsWith(".docx"))
            browseable = 1;
        else if(argFichero.endsWith(".doc"))
            browseable = 2;
        else if(argFichero.endsWith(".txt"))
            browseable = 3;
        else if(argFichero.endsWith(".pdf"))
            browseable = 4;
        else if(argFichero.endsWith(".rtf"))
            browseable = 5;
        else if(argFichero.endsWith(".java"))
            browseable = 6;
        else if(argFichero.endsWith(".c"))
            browseable = 7;
        else if(argFichero.endsWith(".cpp"))
            browseable = 7;
        
        return browseable;
    }
    

    @Override
    protected Integer doInBackground()
    {
        int x=0;
        
        int tipo;
        
        File[] lista = directorio.listFiles();

        if (lista != null)
        {
            for (File elemento : lista)
            {
                setProgress(100*(x++)/lista.length);
                if(isCancelled())
                    return x;
                try
                {
                    Thread.sleep(generator.nextInt(5));
                }catch(InterruptedException e)
                {
                    
                }
                
                if (elemento.isDirectory())
                {
                    if(elemento.getPath().length() < 150)
                        mensaje.setText(elemento.getPath());
                    buscarArchivoporContenido(elemento, match);
                }
                else if ((tipo = DocumentoBrowseable(elemento.getName())) > 0)
                {
                    buscarContenidoenelArchivo(elemento, match, tipo);
                }
            }
        }
        
        return x;
    }   
    
    @Override
    protected void done()
    {
        int EndProcess, n=0;
        try
        {
            n = modelo.getSize();
            EndProcess = get();
            Lista.setModel(modelo);
            setProgress(100);

            if(n == 0)
                mensaje.setText(" No se encontró ninguna coincidencia");
            else if(n == 1)
                mensaje.setText(" Listo!! se encontró 1 archivo");
            else
                mensaje.setText(" Listo!! se encontraron " + n + " archivos");
        }
        catch(InterruptedException ex)
        {
            mensaje.setText(" Proceso interrumpido ");
        }
        catch(ExecutionException ex)
        {
            mensaje.setText(" Proceso fallido");
        }
        catch(CancellationException ex)
        {
            mensaje.setText(" Proceso cancelado; " + n + " archivos encontrados");
        }
        Lista.setModel(modelo);
        buscarPorNombre.setEnabled(true);
        buscarPorContenido.setText("Buscar");
        btnBorrar.setEnabled(true);
        inter.CancelarPorContenido = false;
    }
}