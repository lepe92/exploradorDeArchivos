package buscador;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingWorker;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JButton;

public class BuscarPorNombre extends SwingWorker<Integer, File>
{
    
    private final JList Lista;
    private final DefaultListModel modelo;
    private final Random generator = new Random();
    private final String nombreArchivo;
    private final File directorio;
    private final JLabel mensaje;
    private final JButton buscarPorContenido, buscarPorNombre, borrar;
    private final Interfaz_Buscador inter;
    
    public BuscarPorNombre(JList list, DefaultListModel model, JLabel label, String fichero, File file,
            JButton contenido, JButton nombre, JButton borrar, Interfaz_Buscador interfaz)
    {
        Lista = list;
        modelo = model;
        nombreArchivo = fichero;
        directorio = file;
        mensaje = label;
        buscarPorContenido = contenido;
        buscarPorNombre = nombre;
        this.borrar = borrar;
        inter = interfaz;
    }
    
     public void buscarPorNombre(String argFichero, File argFile)
    {        
        File[] lista = argFile.listFiles();

        if (lista != null)
        {            
            if(isCancelled())
                return;
            for (File elemento : lista) 
                if (elemento.isDirectory())
                {
                    if(elemento.getPath().length() < 150)
                        mensaje.setText(elemento.getPath());
                    buscarPorNombre(argFichero, elemento);
                }
                else if (elemento.getName().contains(argFichero)) 
                {
                    modelo.addElement(elemento);
                }
        }
    }

    @Override
     protected void process(List< File > publishedVals )
     {
        
     }
     
    @Override
    protected Integer doInBackground() throws Exception 
    {
       int x = 0;
       
       File[] lista = directorio.listFiles();
       
       if (lista != null)
       {
            for (File elemento : lista)
            {
                setProgress(100*(x++)/lista.length);
                if(isCancelled())
                    return null;
                try
                {
                    Thread.sleep(generator.nextInt(5));
                }catch(InterruptedException e)
                {
                    
                }
                
                if (elemento.isDirectory())
                {
                    if(elemento.getPath().length() < 150)
                        mensaje.setText(elemento.getAbsolutePath());
                    buscarPorNombre(nombreArchivo, elemento);
                }
                else if (elemento.getName().contains(nombreArchivo)) 
                {
                    modelo.addElement(elemento);
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
            inter.CancelarPorNombre = false;
            
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
            Lista.setModel(modelo);
        }
        finally
        {
            //Lista.setModel(modelo);
            buscarPorNombre.setEnabled(true);
            buscarPorNombre.setText("Buscar");
            buscarPorContenido.setEnabled(true);
            borrar.setEnabled(true);
            inter.CancelarPorNombre = false;
        }
    }
}
