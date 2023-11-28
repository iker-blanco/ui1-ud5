package webexercise;

import java.io.*;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebServiceImpl extends UnicastRemoteObject implements WebService {

    private static final String FILE_NAME = "webContent.txt";

    public WebServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void consultarWeb(String url) throws RemoteException {
        try {

            URL webUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(webUrl.openStream()));

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                writer.write(inputLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            throw new RemoteException("Error fetching web content: " + e.getMessage());
        }
    }

    @Override
    public void borrarDatos() throws RemoteException {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public List<String> consultarWebLinks(String url) throws RemoteException {
        List<String> links = new ArrayList<>();
        try {
            URL webUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(webUrl.openStream()));

            String inputLine;
            Pattern pattern = Pattern.compile("href=\"(.*?)\"");
            Matcher matcher;

            while ((inputLine = reader.readLine()) != null) {
                matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
                    links.add(matcher.group(1));
                }
            }

            reader.close();
        } catch (Exception e) {
            throw new RemoteException("Error fetching links: " + e.getMessage());
        }
        return links;
    }
}
