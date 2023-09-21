import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class testString {
    public static void main(String[] args) {
        String in = JOptionPane.showInputDialog(null, "In?");
        String out = "";
        char c;
        String s;

        for (int i = 0; i < in.length(); i++) {
            if (i % 2 != 0) {
                c = in.charAt(i);
                s = c + "";
                s = s.toUpperCase();
                out += s;
            } else {
                c = in.charAt(i);
                s = c + "";
                s = s.toLowerCase();
                out += s;
            }
        }
        System.out.println(out);

        //automatically put out as recent ctrl+c
        StringSelection stringSelection = new StringSelection(out);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
