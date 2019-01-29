package Forms;

import Model.JTableVentaModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ReportesEimpresion {
    
    private static final Utilidades utilidades = new Utilidades();
    static final DecimalFormat df = new DecimalFormat("$ 0.00");
    static final DecimalFormat dfd = new DecimalFormat("-$ 0.00");
    static final DecimalFormat dfi = new DecimalFormat("00000000");
    
    public ReportesEimpresion() {
    }
    
    public void crearFactura(ArrayList<JTableVentaModel> venta,Integer IdVenta,String NombreCliente,String ... Direccion) {
        String filename = "factura.pdf";
        Float ty = 660f;
        Double total = 0.0;
        Double descuento=0.00;
        Double subtotalSinDescuento=0.00;
        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);
            
            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(270, page.getMediaBox().getUpperRightY()-60);
                contents.showText(dfi.format(IdVenta));
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(260, ty+15);
                contents.showText(utilidades.getDate());
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(45, ty-22);
                contents.showText(NombreCliente);
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(45, ty-42);
                contents.showText(Direccion[0]);
                contents.endText();
                
                ty-=80;
                
                for (JTableVentaModel v : venta) {
                    
                    contents.beginText();
                    contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contents.newLineAtOffset(30, ty);
                    contents.showText(v.getCantidad() + "");
                    contents.endText();
                    
                    contents.beginText();
                    contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contents.newLineAtOffset(50, ty);
                    contents.showText(v.getNombre() + "");
                    contents.endText();
                    
                    contents.beginText();
                    contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contents.newLineAtOffset(200, ty);
                    contents.showText(df.format(v.getPreciounitario()) + "");
                    contents.endText();
                    
                    contents.beginText();
                    contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                    contents.newLineAtOffset(290, ty);
                    contents.showText(df.format(v.getSubtotalSinDescuento()) + "");
                    contents.endText();
                    
                    ty -= 20f;
                    total += v.getSubtotal();
                    descuento += v.getDescuento();
                    subtotalSinDescuento += v.getSubtotalSinDescuento();
                }
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(290, 340);
                contents.showText(df.format(subtotalSinDescuento) + "");
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(290, 320);
                contents.showText(dfd.format(descuento) + "");
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(290, 300);
                contents.showText(df.format(total) + "");
                contents.endText();
            }
            doc.save(filename);
            doc.close();
            Desktop des = Desktop.getDesktop();
            des.open(new File(filename));
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}
