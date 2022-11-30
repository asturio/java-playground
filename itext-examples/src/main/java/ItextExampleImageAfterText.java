import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ItextExampleImageAfterText {

    public static void main(String[] args) throws IOException, DocumentException {
        Document document =  new Document(PageSize.A4);
        PdfWriter.getInstance(document, Files.newOutputStream(Paths.get("example.pdf")));

        document.open();
        Paragraph p = new Paragraph();
        p.add("Some text before");
        p.add(createTextWithImage());
        p.add("Some text after");
        document.add(p);
        document.close();
    }

    private static PdfPTable createTextWithImage() throws IOException, DocumentException {
        URL resource = ItextExampleImageAfterText.class.getResource("/cc.png");
        Image image = Image.getInstance(resource);

        PdfPCell textCell = new PdfPCell();
        textCell.setBorder(0);
        textCell.setPaddingBottom(10);
        Paragraph text = new Paragraph("Text");
        text.setAlignment(Element.ALIGN_RIGHT);
        textCell.addElement(text);

        PdfPTable table = new PdfPTable(2);
        PdfPCell defaultCell = table.getDefaultCell();
        defaultCell.setBorder(0);
        defaultCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.setTotalWidth(48);
        table.setLockedWidth(true);
        table.setWidths(new int[] {3,2});

        table.addCell(textCell);
        table.addCell(image);
        return table;
    }
}
