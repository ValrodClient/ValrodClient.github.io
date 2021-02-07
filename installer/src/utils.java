import java.awt.Color;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class utils {

	final static String clientFolder = System.getProperty("user.home")+"\\AppData\\Roaming\\.minecraft\\versions\\ValrodClient";
	
	final static String serverJarPath = "https://valrodclient.github.io/client/ValrodClient.jar";
	final static String serverJSONpath = "https://valrodclient.github.io/client/ValrodClient.json";
	
	final static String clientJarPath = clientFolder + "\\ValrodClient.jar";
	final static String clientJSONpath = clientFolder + "\\ValrodClient.json";
	
	static int windowHeight = 180;
	static int windowWidth = 310;
	
	static String discordLink = "https://discord.gg/JWKFwgxR4p";
	static String channelLink = "https://www.youtube.com/channel/UCRqTYd6ozEp91KZxyEFLKrw?sub_confirmation=1";

	static void downloadJar() {
		GUI.lbl.setText("Downloading JAR");
		try(
				ReadableByteChannel in = Channels.newChannel(new URL(serverJarPath).openStream());
				FileChannel out = new FileOutputStream(clientJarPath).getChannel() ) {
			out.transferFrom(in, 0, Long.MAX_VALUE);
		} catch(Exception m) {
			setErrorMessage(m);
		}
		GUI.lbl.setText("Downloaded JAR");
	}

	static void downloadJson() {
		GUI.lbl.setText("Downloading JSON");
		try(
				ReadableByteChannel in=Channels.newChannel(new URL(serverJSONpath).openStream());
				FileChannel out = new FileOutputStream(clientJSONpath).getChannel() ) {
			out.transferFrom(in, 0, Long.MAX_VALUE);
		} catch(Exception m) {
			setErrorMessage(m);
		}
		GUI.lbl.setText("Downloaded JSON");
	}

	static void openDiscord() {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    try {
				Desktop.getDesktop().browse(new URI(discordLink));
			} catch (IOException e) {setErrorMessage(e);} catch (URISyntaxException e) {setErrorMessage(e);};
		}
		GUI.lbl.setText("Done!");
	}
	
	static void openChannel() {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    try {
				Desktop.getDesktop().browse(new URI(channelLink));
			} catch (IOException e) {setErrorMessage(e);} catch (URISyntaxException e) {setErrorMessage(e);}
		}
	}
	
	static void setErrorMessage(Exception e) {
		Throwable message = e.fillInStackTrace();
		System.out.println(message);
		GUI.lbl.setText("ERROR");
		GUI.lbl.setForeground(new Color(189, 0, 0));
		GUI.statue.setText(String.valueOf(message));
	}
	
	static void update() {
		downloadJar();
		downloadJson();
		openDiscord();
		openChannel();
	}
}
