package buscador;

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.io.BufferedReader;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.text.rtf.*;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;

public class Buscador 
{

    JList Lista;
    DefaultListModel modelo;
    
    public void buscarArchivoporContenido(File argFile, String match)
    {
        int tipo;
        
        File[] lista = argFile.listFiles();

        if (lista != null)
        {
            lista = reordenar(lista);

            for (File elemento : lista) 
                if (elemento.isDirectory())
                {
                    buscarArchivoporContenido(elemento, match);
                }
                else if ((tipo = DocumentoBrowseable(elemento.getName())) > 0)
                {
                    buscarContenidoenelArchivo(elemento, match, tipo);
                }
        }
        Lista.setModel(modelo);
    }
    
    
    public void buscarContenidoenelArchivo(File f, String match, int tipo)
    {
        boolean found;
        String contenido;
        
        switch(tipo)
        {
            case 1 : // docx
                try
                {
                    XWPFDocument docx = new XWPFDocument(new FileInputStream(f));
                    XWPFWordExtractor we = new XWPFWordExtractor(docx);
                    
                    contenido = we.getText();
                    
                    if(contenido.contains(match))
                    {
                        found = true;
                        modelo.addElement(f.getAbsoluteFile());
                        //Lista.setModel(modelo);
                        System.out.println(f.getAbsoluteFile());
                    }
                }catch(Exception e){}
                break;
            case 2 : // doc
                try
                {
                    HWPFDocument doc = new HWPFDocument(new FileInputStream(f));
                    WordExtractor we = new WordExtractor(doc);
                    
                    contenido = we.getText();
                    
                    if(contenido.contains(match))
                    {
                        found = true;
                        modelo.addElement(f.getAbsoluteFile());
                        //Lista.setModel(modelo);
                        System.out.println(f.getAbsoluteFile());
                    }
                }catch(Exception e){}
                break;
            case 3 : // txt
                try
                {
                    BufferedReader in = new BufferedReader(new FileReader(f));
                    contenido = in.readLine();
                    
                    int c=0;
                    
                    while(contenido != null)
                    {
                        contenido = in.readLine();
                        if(contenido.contains(match))
                        {
                            modelo.addElement(f.getAbsoluteFile());
                            //Lista.setModel(modelo);
                            System.out.println(f.getAbsoluteFile());
                            break;
                        }
                    }
                }catch(Exception e){}
                break;
            case 4 : // pdf
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
                            found = true;
                            modelo.addElement(f.getAbsoluteFile());
                            //Lista.setModel(modelo);
                            System.out.println(f.getAbsoluteFile());
                        }
                    }
                    documento.close();
                }catch(Exception e){}
                break;
            case 5 : // rtf
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
                            found = true;
                            modelo.addElement(f.getAbsoluteFile());
                            //Lista.setModel(modelo);
                        }
                }catch(Exception e){}
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
        
        return browseable;
    }
    
    public void buscarPorNombre(String argFichero, File argFile)
    {        
        File[] lista = argFile.listFiles();

        if (lista != null)
        {
            lista = reordenar(lista);
            
            for (File elemento : lista) 
                if (elemento.isDirectory())
                {
                    buscarPorNombre(argFichero, elemento);
                }
                else if (elemento.getName().contains(argFichero)) 
                {
                    modelo.addElement(elemento.getAbsoluteFile());
                    Lista.removeAll();
                    Lista.setModel(modelo);
                }
        }
    }
    
    public File[] reordenar(File[] m)
    {
        int i=0, j=m.length-1, k=m.length;
        
        File[] x = new File[k];
        
        for(File a : m)
            if(a.isDirectory())
                x[j--] = a;
            else
                x[i++] = a;
        return x;
    }
}