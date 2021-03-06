package org.naj.java.ui.comps;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.PlainView;
import javax.swing.text.Segment;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.Utilities;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 * 
 * @author Admin
 *
 */
public class JXmlTextPane extends JTextPane {

	private static final long serialVersionUID = 1L;

	public JXmlTextPane() {

		// Set editor kit
		this.setEditorKitForContentType("text/xml", new XmlEditorKit());
		this.setContentType("text/xml");
	}

	static class XmlEditorKit extends StyledEditorKit {

		private static final long serialVersionUID = 2969169649596107757L;
		private ViewFactory xmlViewFactory;

		public XmlEditorKit() {
			xmlViewFactory = new XmlViewFactory();
		}

		@Override
		public ViewFactory getViewFactory() {
			return xmlViewFactory;
		}

		@Override
		public String getContentType() {
			return "text/xml";
		}
	}

	static class XmlViewFactory extends Object implements ViewFactory {

		/**
		 * @see javax.swing.text.ViewFactory#create(javax.swing.text.Element)
		 */
		public View create(Element element) {

			return new XmlView(element);
		}

	}

	/**
	 * Thanks: http://groups.google.com/group/de.comp.lang.java/msg/2bbeb016abad270
	 * 
	 * IMPORTANT NOTE: regex should contain 1 group.
	 * 
	 * Using PlainView here because we don't want line wrapping to occur.
	 * 
	 * @author kees
	 * @date 13-jan-2006
	 *
	 */
	static class XmlView extends PlainView {

		private static HashMap<Pattern, Color> patternColors;
		private static String TAG_PATTERN = "(</?[a-z]*)\\s?>?";
		private static String TAG_END_PATTERN = "(/>)";
		private static String TAG_ATTRIBUTE_PATTERN = "\\s(\\w*)\\=";
		private static String TAG_ATTRIBUTE_VALUE = "[a-z-]*\\=(\"[^\"]*\")";
		private static String TAG_COMMENT = "(<!--.*-->)";
		private static String TAG_CDATA_START = "(\\<!\\[CDATA\\[).*";
		private static String TAG_CDATA_END = ".*(]]>)";

		static {
			// NOTE: the order is important!
			patternColors = new HashMap<Pattern, Color>();
			patternColors.put(Pattern.compile(TAG_CDATA_START), Color.ORANGE);
			patternColors.put(Pattern.compile(TAG_CDATA_END), Color.ORANGE);
			patternColors.put(Pattern.compile(TAG_PATTERN), Color.ORANGE);
			patternColors.put(Pattern.compile(TAG_ATTRIBUTE_PATTERN), new Color(127, 0, 127));
			patternColors.put(Pattern.compile(TAG_END_PATTERN), new Color(63, 127, 127));
			patternColors.put(Pattern.compile(TAG_ATTRIBUTE_VALUE), new Color(42, 0, 255));
			patternColors.put(Pattern.compile(TAG_COMMENT), Color.GREEN);
		}

		public XmlView(Element element) {

			super(element);

			// Set tabsize to 4 (instead of the default 8)
			getDocument().putProperty(PlainDocument.tabSizeAttribute, 4);
		}

		@Override
		protected int drawUnselectedText(Graphics graphics, int x, int y, int p0, int p1) throws BadLocationException {

			Document doc = getDocument();
			String text = doc.getText(p0, p1 - p0);

			Segment segment = getLineBuffer();

			SortedMap<Integer, Integer> startMap = new TreeMap<Integer, Integer>();
			SortedMap<Integer, Color> colorMap = new TreeMap<Integer, Color>();

			// Match all regexes on this snippet, store positions
			for (Map.Entry<Pattern, Color> entry : patternColors.entrySet()) {

				Matcher matcher = entry.getKey().matcher(text);

				while (matcher.find()) {
					startMap.put(matcher.start(1), matcher.end());
					colorMap.put(matcher.start(1), entry.getValue());
				}
			}

			// TODO: check the map for overlapping parts

			int i = 0;

			// Colour the parts
			for (Map.Entry<Integer, Integer> entry : startMap.entrySet()) {
				int start = entry.getKey();
				int end = entry.getValue();

				if (i < start) {
					graphics.setColor(Color.black);
					doc.getText(p0 + i, start - i, segment);
					x = Utilities.drawTabbedText(segment, x, y, graphics, this, i);
				}

				graphics.setColor(colorMap.get(start));
				i = end;
				doc.getText(p0 + start, i - start, segment);
				x = Utilities.drawTabbedText(segment, x, y, graphics, this, start);
			}

			// Paint possible remaining text black
			if (i < text.length()) {
				graphics.setColor(Color.black);
				doc.getText(p0 + i, text.length() - i, segment);
				x = Utilities.drawTabbedText(segment, x, y, graphics, this, i);
			}

			return x;
		}
	}
}
