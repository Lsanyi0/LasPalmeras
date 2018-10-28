package Forms;

import Model.jtableVentaModel;
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
    
    Utilidades utilidades = new Utilidades();
    DecimalFormat df = new DecimalFormat("#.00");

    public ReportesEimpresion() {
    }

    public void crearFactura(ArrayList<jtableVentaModel> venta) {
        String filename = "factura.pdf";
        Float ty = 660f;
        Double total = 0.0;
        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(270, page.getMediaBox().getUpperRightY()-60);
                contents.showText("ID");
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(260, ty+15);
                contents.showText(utilidades.getDate());
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(35, ty-22);
                contents.showText("Cliente");
                contents.endText();
                
                contents.beginText();
                contents.setFont(PDType1Font.TIMES_ROMAN, 12);
                contents.newLineAtOffset(45, ty-42);
                contents.showText("Direccion");
                contents.endText();
                
                ty-=80;
                
                for (jtableVentaModel v : venta) {
                    
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
                    contents.showText(df.format(v.getSubtotal()) + "");
                    contents.endText();
                    
                    ty -= 20f;
                    total += v.getSubtotal();
                }
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
        } catch (IOException ee) {
            //agregar mensaje emergente
        }
        System.out.println("Hecho!");
    }
}
