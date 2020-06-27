/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * @author  P203125
 */
public class Helper {

	/**
	 * @param   name
	 *
	 * @return
	 */
	public static ImageIcon getImage(String name) {
		URL url = Helper.class.getResource("images/" + name);

		// if (url != null) {
		// return new ImageIcon(url);
		// }
		try {
			BufferedImage img = ImageIO.read(url);

//          img = toGrayScale(img);
//          img = toSepia(img, 10);
			return new ImageIcon(img);

		} catch (Exception ex) {
			System.out.println("===========>>>> Image not found (" + name + ") " + url);
		}
		return null;
	}

	/**
	 * @param   master
	 *
	 * @return  BufferedImage
	 */
	public static BufferedImage toGrayScale(BufferedImage master) {
		BufferedImage gray = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);
		ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		op.filter(master, gray);
		return gray;
	}

	/**
	 * @param   image
	 * @param   sepiaIntensity
	 *
	 * @return  BufferedImage
	 */
	public static BufferedImage toSepia(BufferedImage image, int sepiaIntensity) {

		int width = image.getWidth();
		int height = image.getHeight();
		int sepiaDepth = 20;

		int[] imagePixels = image.getRGB(0, 0, width, height, null, 0, width);

		for (int i = 0; i < imagePixels.length; i++) {
			int color = imagePixels[i];

			int r = (color >> 16) & 0xff;
			int g = (color >> 8) & 0xff;
			int b = (color) & 0xff;
			int gry = (r + g + b) / 3;

			r = g = b = gry;
			r = r + (sepiaDepth * 2);
			g = g + sepiaDepth;

			if (r > 255) {
				r = 255;
			}
			if (g > 255) {
				g = 255;
			}
			if (b > 255) {
				b = 255;
			}

			// Darken blue color to increase sepia effect
			b -= sepiaIntensity;

			// normalize if out of bounds
			if (b < 0) {
				b = 0;
			}
			if (b > 255) {
				b = 255;
			}

			imagePixels[i] = (color & 0xff000000) + (r << 16) + (g << 8) + b;
		}

		BufferedImage res = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		res.setRGB(0, 0, width, height, imagePixels, 0, width);
		return res;
	}

	/**
	 * @return  Point
	 */
	public static Dimension getScreenSize() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		int w = 0;
		int h = 0;
		for (int i = 0; i < gs.length; i++) {
			DisplayMode dm = gs[i].getDisplayMode();
			w += dm.getWidth();
			h = Math.max(dm.getHeight(), h);
		}
		return new Dimension(w, h);
	}

	/**
	 * @param  size
	 */
	public static void setGlobalFontSize(int size) {
		for (Enumeration<Object> e = UIManager.getDefaults().keys(); e.hasMoreElements();) {
			Object key = e.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof Font) {
				Font f = (Font) value;
				UIManager.put(key, new FontUIResource(f.getName(), f.getStyle(), size));
			}
		}
	}

	/**
	 * @param   title
	 * @param   withPrefix
	 *
	 * @return
	 */
	public static JLabel createTitle(String title, boolean withPrefix, String prefix, Color color) {

		final int TITLE_FONTSIZE = 18;
		final Color TITLE_COLOT = new Color(100, 100, 100); //new Color(0, 148, 255);
		final String TITLE_PREFIX = " " + prefix;

		JLabel lab = new JLabel((withPrefix ? TITLE_PREFIX : " ") + " " + title);
		lab.setHorizontalAlignment(JLabel.LEFT);
		lab.setForeground(color == null ? TITLE_COLOT : color);
		lab.setFont(new Font("Arial", Font.BOLD, TITLE_FONTSIZE));
		return lab;
	}

	/**
	 * @return  String
	 */
	public static String getCurrentDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	/**
	 * @param  msg
	 * @param  art     (0=info,1=error,2=Prompt)
	 * @param  parent
	 */
	public static boolean showMessage(String msg, int art, Component parent) {
		int rc =
			JOptionPane.showOptionDialog(
				parent,
				msg,
				(art == 0 ? "Information" : art == 1 ? "Fehler" : "Eingabe"),
				(art == 0 || art == 1 ? JOptionPane.DEFAULT_OPTION : JOptionPane.OK_CANCEL_OPTION),
				(art == 0 ? JOptionPane.INFORMATION_MESSAGE
					: art == 1 ? JOptionPane.ERROR_MESSAGE : JOptionPane.OK_CANCEL_OPTION),
				null,
				null,
				null
			);

		return art == 2 && rc == JOptionPane.YES_OPTION;
	}

	/**
	 * @param  msg
	 * @param  parent
	 */
	public static String getUserInput(String msg, Component parent) {
		return JOptionPane.showInputDialog(parent, msg, "Eingabe", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * @param   progressAmount
	 * @param   totalAmount
	 *
	 * @return
	 */
	public static int calculateProgressPercentage(double progressAmount, double totalAmount) {
		if (totalAmount == 0) {
			return 0;
		}
		return (int) (progressAmount * 100.0 / totalAmount);
	}

	/**
	 * @param   name
	 *
	 * @return
	 */
	public static String trimName(String name) {
		String rc = name.trim();
		if (rc.endsWith("*")) {
			rc = rc.substring(0, rc.length() - 1);
		}
		return rc;
	}

	/**
	 * @param   st
	 *
	 * @return  String
	 */
	public static String toLowerFristChar(String st) {
		return st == null || st.isEmpty() ? "" : st.substring(0, 1).toLowerCase() + st.substring(1);
	}

	/**
	 * @param   st
	 *
	 * @return  String
	 */
	public static String toUpperFristChar(String st) {
		return st == null || st.isEmpty() ? "" : st.substring(0, 1).toUpperCase() + st.substring(1);
	}

	/**
	 * @param   st
	 *
	 * @return  String
	 */
	public static String toLowerAfterChar(String st, String ch) {

		String s0 = toLowerFristChar(st);

		int x = s0.indexOf(ch);
		if (x != -1) {
			String s1 = s0.substring(0, x);
			String s2 = s0.substring(x + 1);

			s1 += ch + toLowerAfterChar(s2, ch);
			return s1;
		}
		return s0;
	}

	/**
	 * @param   txt
	 * @param   oldChar
	 * @param   newChar
	 * @param   start
	 * @param   end
	 *
	 * @return  String
	 */
	public static String replaceBetween(String txt, String oldChar, String newChar, String start, String end) {

		String startMarker = "<<";
		String endMarker = ">>";

		String rc = txt;
		int x = rc.indexOf(start);
		while (x != -1) {
			String p1 = rc.substring(0, x);
//          int y = rc.indexOf(end);  <== so kommt zu einer Exception
			int y = rc.lastIndexOf(end);
			if (y == -1) {
				return null;
			}

			String p2 = rc.substring(x, y + 1);
			String p3 = rc.substring(y + 1);

			p2 = p2.replace(start, startMarker).replace(end, endMarker).replace(oldChar, newChar);

			rc = p1 + p2 + p3;
			x = rc.indexOf(start);
		}
		return rc.replace(startMarker, start).replace(endMarker, end);
	}

	/**
	 * @param   s
	 *
	 * @return  boolean
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * @param   path
	 * @param   searchTerm
	 *
	 * @return  boolean
	 */
	public static boolean searchInFile(String path, String searchTerm) {

		//=== first fastes way
		try {
			return new String(Files.readAllBytes(Paths.get(path))).contains(searchTerm);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		//=== second fastes way

//      try(Stream<String> streamOfLines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
//          Optional<String> line = streamOfLines.filter(l -> l.contains(searchTerm)).findFirst();
//          return line.isPresent();
//      } catch (Exception e) {
//      }

		//=== third fastes way

//      File srcFile = new File(path);
//      try(BufferedReader br = new BufferedReader(new FileReader(srcFile))) {
//          for (String line; (line = br.readLine()) != null;) {
//              if (line.contains("addAnlage(" + brief)) {
//                  refs += file.substring(0, file.indexOf(".")) + " ";
//                  break;
//              }
//          }
//          br.close();
//      } catch (IOException ex) {
//          // ex.printStackTrace();
//      }

		return false;
	}

	public static String getPath(String name, String def) {
		if (name != null && !name.isEmpty()) {
			File f = new File(name);
			if (f.exists() && !f.isDirectory()) {
				return f.getAbsoluteFile().getParent();
			}
			return name;
		}
		return def;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
