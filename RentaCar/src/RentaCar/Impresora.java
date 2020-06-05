/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chema
 * @version 1.0
 * @since 2020-06-02
 *
 */
public class Impresora implements Printable {

    final Component comp;

    /**
     * Contructor con parámetros
     *
     * @param comp componente a imprimir
     */
    public Impresora(Component comp) {
        this.comp = comp;

    }

    /**
     * Método que permitirá imprimir los componentes.
     *
     * @param comp
     */
    public static void imprimir(Component comp) {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.PORTRAIT);
        PageFormat postformat = pjob.pageDialog(preformat);
        // Si el usuario no pulsa cancelar, entonces imprimirá.
        if (preformat != postformat) {
            // Permite imprimir el comoponente
            pjob.setPrintable(new Impresora(comp), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Interfaz_Reservas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Dibuja el componente seleccionado para plasmarlo en un archivo pdf
     *
     * @param g componente a retocar
     * @param format formato de página a usar, PORTRAIT o LANDSCAPE
     * @param page_index índice de página
     * @return devuelve el componente dibujado
     * @throws PrinterException
     */
    @Override
    public int print(Graphics g, PageFormat format, int page_index)
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // Obtiene los bounds del componente
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // Obtiene los bounds del area imprimible
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        // Ratio, lo divido entre 2 para que no se vea tan grande
        double xRatio = pWidth / cWidth;
        double yRatio = (pHeight / cHeight) / 2;

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);

        comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }
}
