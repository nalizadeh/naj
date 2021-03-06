/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  P203125
 */
public class FileUtility {

	/**
	 * @param   srcDir
	 * @param   dstDir
	 * @param   type
	 * @param   oldText
	 * @param   newText
	 *
	 * @return  Count of replaced files
	 */
	public static int replace(String srcDir, String dstDir, String type, String[] oldTexts, String[] newTexts) {

		List<String> files = new ArrayList<String>();
		int count = 0;

		try {
			File dir = new File(srcDir);
			if (dir.exists()) {
				for (final File fi : dir.listFiles()) {
					if (fi.isDirectory()) {
						replace(fi.getAbsolutePath(), null, type, null, null);
					} else if (fi.getName().endsWith(type)) {
						files.add(fi.getAbsolutePath());
					}
				}
			}

			if (dstDir != null) {
				for (String name : files) {
					File srcFile = new File(name);
					File dstFile = new File(dstDir, srcFile.getAbsolutePath().replace(srcDir, ""));

					if (!dstFile.getParentFile().exists()) {
						dstFile.getParentFile().mkdirs();
					}

					Files.copy(srcFile.toPath(), dstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					System.out.println("copy: " + srcFile.getAbsolutePath() + " --> " + dstFile.getAbsolutePath());

					String content = new String(Files.readAllBytes(dstFile.toPath()), StandardCharsets.ISO_8859_1);

					if (content.indexOf(oldTexts[0]) != -1) {
						for (int i = 0; i < oldTexts.length; i++) {
							content = content.replaceAll(oldTexts[i], newTexts[i]);
						}
						Files.write(dstFile.toPath(), content.getBytes(StandardCharsets.ISO_8859_1));
						count++;
						System.out.println("replaced: " + dstFile.getAbsolutePath());
					}

				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return count;
	}

	/**
	 * @param   srcDir
	 * @param   dstDir
	 * @param   type
	 * @param   oldText
	 * @param   newText
	 *
	 * @return  Count of replaced files
	 */
	public static int replaceXX(String srcDir, String dstDir) {

		List<String> files = new ArrayList<String>();
		
		int count = 0;

		try {
			File dir = new File(srcDir);
			if (dir.exists()) {
				for (final File fi : dir.listFiles()) {
					if (fi.isDirectory()) {
						replaceXX(fi.getAbsolutePath(), null);
					} else if (fi.getName().endsWith(".java")) {
						files.add(fi.getAbsolutePath());
					}
				}
			}

			for (String name : files) {

				String replaced = "";
				boolean found = false;

				File file = new File(name);

				BufferedReader reader;
				try {
					reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
					String line = reader.readLine();

					boolean oo = false;
					boolean ss = false;
					while (line != null) {
						if (line.indexOf("concat(") != -1) {

							found = true;

							while (!oo && line.indexOf("new Object[]") == -1) {
								line = reader.readLine();
							}
							oo = true;
							String f = line;
							while (line != null && line.indexOf("),") == -1) {
								line = reader.readLine();
								f += line;
							}
							f = f.substring(f.indexOf("{") + 1);
							f = f.substring(0, f.lastIndexOf("}")).trim();
							replaced +=
								"new Object[] {"
								+ f
								+ (f.endsWith(",") ? "" : ",")
								+ "fachdaten},"
								+ System.lineSeparator();

							while (!ss && line.indexOf("new String[]") == -1) {
								line = reader.readLine();
							}
							ss = true;
							f = line;
							while (line != null && line.indexOf(");") == -1) {
								line = reader.readLine();
								f += line;
							}
							f = f.substring(f.indexOf("{") + 1);
							f = f.substring(0, f.lastIndexOf("}")).trim();
							replaced +=
								"new String[] {"
								+ f
								+ (f.endsWith(",") ? "" : ",")
								+ " \"fachdaten\"});"
								+ System.lineSeparator();
						} else {
							replaced += line + System.lineSeparator();
						}

						line = reader.readLine();
					}
					reader.close();

					if (found) {
						BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
						writer.write(replaced);
						writer.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	public static void find(String srcDir, String type, String text, List<String> files) {

		try {
			File dir = new File(srcDir);
			if (dir.exists()) {
				for (final File fi : dir.listFiles()) {
					if (fi.isDirectory()) {
						find(fi.getAbsolutePath(), type, null, files);
					} else if (fi.getName().endsWith(type)) {
						files.add(fi.getAbsolutePath());
					}
				}
			}

			if (text != null) {
				for (String name : files) {
					File srcFile = new File(name);

					String content = new String(Files.readAllBytes(srcFile.toPath()), StandardCharsets.ISO_8859_1);

					if (content.indexOf(text) != -1) {
						System.out.println("replaced: " + srcFile.getAbsolutePath());
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static int copyFiles(String srcDir, String dstDir, String type, List<String> files) {
		int count = 0;
		try {
			File dir = new File(srcDir);
			if (dir.exists()) {
				for (final File fi : dir.listFiles()) {
					if (fi.isDirectory()) {
						copyFiles(fi.getAbsolutePath(), null, type, files);
					} else if (fi.getName().endsWith(type)) {
						files.add(fi.getAbsolutePath());
						System.out.println("Lesen: " + fi.getName());
					}
				}
			}
			if (dstDir != null) {
				for (String name : files) {
					File srcFile = new File(name);
					File dstFile = new File(dstDir, srcFile.getAbsolutePath().replace(srcDir, ""));

					if (!dstFile.getParentFile().exists()) {
						dstFile.getParentFile().mkdirs();
					}

					Files.copy(srcFile.toPath(), dstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					count++;


					System.out.println(srcFile.getAbsolutePath() + " --> " + dstFile.getAbsolutePath());
				}
			}
		} catch (IOException ex) {
			count = 0;
			ex.printStackTrace();
		}

		return count;
	}
	
	//===============
	
	void copyYY(File srcDir, File dstDir, File wasteDir, String type) throws Exception {
		for (final File fi : srcDir.listFiles()) {
			if (fi.isDirectory()) {
				if (fi.getName().endsWith("x") || fi.getName().endsWith("y")) continue;
				copyYY(fi, dstDir, wasteDir, type);
			} else if (fi.getName().endsWith(type)) {
				System.out.println("copy: " + fi.getName());

				if (fi.length() < 50000) {
					File wasteFile = new File(wasteDir.getAbsoluteFile() + "\\" + fi.getName());
					Files.move(fi.toPath(), wasteFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				}
				else { 
					File dstFile = new File(dstDir.getAbsoluteFile() + "\\" + fi.getName());
					Files.move(fi.toPath(), dstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				}
			}
		}
	}
	
	void copyXX() {
		
		String fname = "D:\\software\\system\\Tomoe Yamanaka\\";
		int nn = 46;
		
		while(true) {
			try {
				File dir = new File(fname + "" + nn);
				if (!dir.exists()) break;
				
				File dstDir = new File(dir.getAbsolutePath() + "\\x");
				File waste = new File(dir.getAbsolutePath() + "\\y");
				if (!dstDir.exists()) {
					Files.createDirectory(dstDir.toPath());
					Files.createDirectory(waste.toPath());
				}
				copyYY(dir, dstDir, waste, "jpg");
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			nn++;
		}
	}

	public static void main(String[] args) {

		new FileUtility().copyXX();
		
//      FileContentReplacer.replace(
//         "D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\ui\\treetable",
//         "D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\ui\\treetable",
//         ".java",
//         new String[] {
//             "package org.naj.java.ui.treetable;"
//         }, //
//         new String[] {
//             "package org.naj.java.ui.comps.treetable;"
//         } //
//      );
//
//      =================
//
//      FileContentReplacer.replace(
//          "C:\\SPU\\pwe\\tkeasyBriefvorlagenTest\\master\\git-repos\\korrespondenz-vorlagen-qs\\korrespondenz-vorlagen.qs\\src\\de\\tk\\biz\\comp\\korrespondenz\\vorlagenqs",
//          "C:\\SPU\\pwe\\tkeasyBriefvorlagenTest\\master\\git-repos\\korrespondenz-vorlagen-qs\\korrespondenz-vorlagen.qs\\src\\de\\tk\\biz\\comp\\korrespondenz\\vorlagenqs",
//          ".java",
//          new String[] {
//              "de.tk.biz.comp.korrespondenz.vorlagenbasis.KorrespondenzTestdatenKnoten", //
//              "implements KorrespondenzTestdatenKnoten", //
//          },
//          new String[] {
//              "de.tk.biz.comp.korrespondenz.vorlagenbasis.AbstractKorrespondenzTestdatenKnoten", //
//              "extends AbstractKorrespondenzTestdatenKnoten", //
//          }
//      );
//      FileContentReplacer.replace(
//              "C:\\SPU\\pwe\\tkeasyBriefvorlagenTest\\int\\git-repos\\korrespondenz-vorlagen-qs\\korrespondenz-vorlagen.qs\\src\\",
//              "C:\\SPU\\pwe\\tkeasyBriefvorlagenTest\\int\\git-repos\\korrespondenz-vorlagen-qs\\korrespondenz-vorlagen.qs\\src\\",
//              ".java",
//              new String[] {
//                  "de.tk.biz.comp.korrespondenz.KorrespondenzTestdatenKnoten",
//              },
//              new String[] {
//                  "de.tk.biz.comp.korrespondenz.vorlagenbasis.KorrespondenzTestdatenKnoten", //
//              }
//          );
//
//      =================
//
//      FileContentReplacer.find(
//              "C:\\SPU\\pwe\\tkeasyBriefvorlagenTest\\int\\git-repos\\korrespondenz-vorlagen-qs\\korrespondenz-vorlagen.qs\\src\\de\\tk\\biz\\comp\\korrespondenz\\vorlagenqs\\",
//              ".java",
//              "Arrays.toString"
//          );
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
