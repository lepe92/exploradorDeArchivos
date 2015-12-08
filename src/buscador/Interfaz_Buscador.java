package buscador;

import java.awt.Color;
import java.io.File;
import javax.swing.DefaultListModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Interfaz_Buscador extends javax.swing.JFrame
{
    Buscador objBuscarFichero;
    BuscarPorNombre objBuscarpornombre;
    DefaultListModel modelo;
    opciones seleccion = new opciones();
    
    boolean CancelarPorContenido = false;
    boolean CancelarPorNombre = false;

    public Interfaz_Buscador()
    {
        initComponents();
        jFileChooser1.setControlButtonsAreShown(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        FileName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Contenido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBusquedaContenido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();
        rbDocX = new javax.swing.JRadioButton();
        rbDoc = new javax.swing.JRadioButton();
        rbTxt = new javax.swing.JRadioButton();
        rbPdf = new javax.swing.JRadioButton();
        rbRtf = new javax.swing.JRadioButton();
        rbJava = new javax.swing.JRadioButton();
        rbCpp = new javax.swing.JRadioButton();
        btnBorrar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jFileChooser1.setFileFilter(null);
        jFileChooser1.setFileHidingEnabled(false);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.setName(""); // NOI18N

        FileName.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N

        jLabel1.setText("Archivo a buscar");

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mensaje.setForeground(new java.awt.Color(0, 0, 204));
        mensaje.setText(">>");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Contenido.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N

        jLabel2.setText("Búsqueda por contenido");

        btnBusquedaContenido.setText("Buscar");
        btnBusquedaContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaContenidoActionPerformed(evt);
            }
        });

        Lista.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 14)); // NOI18N
        Lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Archivos" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        rbDocX.setText(".docx");
        rbDocX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbDocXStateChanged(evt);
            }
        });

        rbDoc.setText(".doc");
        rbDoc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbDocStateChanged(evt);
            }
        });

        rbTxt.setText(".txt");
        rbTxt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbTxtStateChanged(evt);
            }
        });

        rbPdf.setText(".pdf");
        rbPdf.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbPdfStateChanged(evt);
            }
        });

        rbRtf.setText(".rtf");
        rbRtf.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbRtfStateChanged(evt);
            }
        });

        rbJava.setText(".java");
        rbJava.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbJavaStateChanged(evt);
            }
        });

        rbCpp.setText(".c / .cpp");
        rbCpp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbCppStateChanged(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbTxt)
                                    .addComponent(rbDocX)
                                    .addComponent(rbDoc)
                                    .addComponent(rbPdf)
                                    .addComponent(rbJava)
                                    .addComponent(rbRtf)
                                    .addComponent(rbCpp))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel2))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBusquedaContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBorrar))))
                            .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(rbDoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbDocX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbPdf))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(rbRtf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBusquedaContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbJava)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCpp)
                            .addComponent(btnBorrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    if(CancelarPorNombre)
    {
        objBuscarpornombre.cancel(true);
        CancelarPorNombre = false;
        jButton1.setText("Buscar");
    }
    else{
    jProgressBar1.setValue(0);
    modelo = new DefaultListModel();
    String fichero = FileName.getText().trim();
    File directorio = jFileChooser1.getSelectedFile();

    if(directorio == null)
        directorio = jFileChooser1.getCurrentDirectory();

    ///////////////////////////////////////////////////////////////////////////////////////
    mensaje.setText("");
    mensaje.setForeground(Color.blue);
    ///////////////////////////////////////////////////////////////////////////////////////

    if(fichero.equalsIgnoreCase(""))
    {
        mensaje.setForeground(Color.red);
        mensaje.setText(" Error : Debes introducir un nombre de archivo");
    }
    else
    {
        CancelarPorNombre = true;
        jButton1.setText("Cancelar");
        btnBusquedaContenido.setEnabled(false);
        btnBorrar.setEnabled(false);
        
        objBuscarpornombre = new BuscarPorNombre(Lista, modelo, mensaje, fichero, directorio,
            btnBusquedaContenido, jButton1, btnBorrar, this);

        objBuscarpornombre.addPropertyChangeListener(
                new PropertyChangeListener()
                {
                    @Override
                    public void propertyChange( PropertyChangeEvent e)
                    {
                        if(e.getPropertyName().equals("progress"))
                        {
                            int porcentaje = (Integer)e.getNewValue();
                            jProgressBar1.setValue(porcentaje);
                        }
                    }
                });
        try
        {
            objBuscarpornombre.execute();
        }catch(Exception ex){}
    }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBusquedaContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaContenidoActionPerformed
        
        if(CancelarPorContenido)
        {
            objBuscarFichero.cancel(true);
            CancelarPorContenido = false;
            btnBusquedaContenido.setText("Buscar");
        }
        else{
        jProgressBar1.setValue(0);
        modelo = new DefaultListModel();
        String match = Contenido.getText().trim();
        File directorio = jFileChooser1.getSelectedFile();

        if(directorio == null)
            directorio = jFileChooser1.getCurrentDirectory();

        ///////////////////////////////////////////////////////////////////////////////////////
        mensaje.setText("");
        mensaje.setForeground(Color.blue);
        ///////////////////////////////////////////////////////////////////////////////////////
        boolean seleccionVacia = !(seleccion.DocSelected || seleccion.DocXselected ||
                                   seleccion.PDFselected || seleccion.RTFselected  ||
                                   seleccion.TXTselected || seleccion.JavaSelected ||
                                   seleccion.cppSelected);

        if(seleccionVacia)
        {
            mensaje.setForeground(Color.red);
            mensaje.setText(" Error : Debes seleccionar un tipo de archivo");
            return ;
        }
        if(match.equalsIgnoreCase(""))
        {
            mensaje.setForeground(Color.red);
            mensaje.setText(" Error : Debes introducir una cadena de texto");
        }
        else
        {
            btnBorrar.setEnabled(false);
            jButton1.setEnabled(false);
            btnBusquedaContenido.setText("Cancelar");
            CancelarPorContenido = true;
            
            objBuscarFichero = new Buscador(Lista, modelo, mensaje, match, directorio, seleccion,
                btnBusquedaContenido, jButton1, btnBorrar, this);
            
            objBuscarFichero.addPropertyChangeListener(
                new PropertyChangeListener()
                {
                    @Override
                    public void propertyChange( PropertyChangeEvent e)
                    {
                        if(e.getPropertyName().equals("progress"))
                        {
                            int porcentaje = (Integer)e.getNewValue();
                            jProgressBar1.setValue(porcentaje);
                        }
                    }
                });
        try
        {
            objBuscarFichero.execute();
        }catch(Exception ex){}


        }
        }
    }//GEN-LAST:event_btnBusquedaContenidoActionPerformed

    private void rbDocStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbDocStateChanged
            seleccion.DocSelected = !seleccion.DocSelected;
    }//GEN-LAST:event_rbDocStateChanged

    private void rbDocXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbDocXStateChanged
            seleccion.DocXselected = !seleccion.DocXselected;
    }//GEN-LAST:event_rbDocXStateChanged

    private void rbTxtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbTxtStateChanged
            seleccion.TXTselected = !seleccion.TXTselected;
    }//GEN-LAST:event_rbTxtStateChanged

    private void rbPdfStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbPdfStateChanged
            seleccion.PDFselected = !seleccion.PDFselected;
    }//GEN-LAST:event_rbPdfStateChanged

    private void rbRtfStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbRtfStateChanged
            seleccion.RTFselected = !seleccion.RTFselected;
    }//GEN-LAST:event_rbRtfStateChanged

    private void rbJavaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbJavaStateChanged
            seleccion.JavaSelected = !seleccion.JavaSelected;
    }//GEN-LAST:event_rbJavaStateChanged

    private void rbCppStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbCppStateChanged
            seleccion.cppSelected = !seleccion.cppSelected;
    }//GEN-LAST:event_rbCppStateChanged

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked
        try
        {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + Lista.getSelectedValue());
        }catch(Exception e){}
    }//GEN-LAST:event_ListaMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        mensaje.setText(">>");
        FileName.setText(" ");
        Contenido.setText(" ");
        Lista.setModel(new DefaultListModel());
        jProgressBar1.setValue(0);
    }//GEN-LAST:event_btnBorrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Buscador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contenido;
    private javax.swing.JTextField FileName;
    public javax.swing.JList Lista;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBusquedaContenido;
    private javax.swing.JButton jButton1;
    public javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JRadioButton rbCpp;
    private javax.swing.JRadioButton rbDoc;
    private javax.swing.JRadioButton rbDocX;
    private javax.swing.JRadioButton rbJava;
    private javax.swing.JRadioButton rbPdf;
    private javax.swing.JRadioButton rbRtf;
    private javax.swing.JRadioButton rbTxt;
    // End of variables declaration//GEN-END:variables
}
