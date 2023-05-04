package view.control;

import java.io.*;
import java.util.Objects;

public class SteamController
{
    private String steamFile = "C:\\Users\\dti\\Downloads\\Exercicio_Arquivos_Steam\\SteamCharts.csv";
    public SteamController() {
    }

    private File openFile(String filePath) throws Exception
    {
        File openFile = new File(filePath);
        if (!openFile.isFile() && !openFile.exists())
            throw new Exception("Invalid File");
        return openFile;
    }

    public String findGames(int year, String month, double media) throws Exception
    {
        // TODO validar ano
        // TODO validar mes
        String line;
        File file = openFile(steamFile);
        String[] lines;
        double dataAVG = -1;

        FileReader readFile = new FileReader(file);
        BufferedReader buffer = new BufferedReader(readFile);
        StringBuilder result = new StringBuilder();

        line = buffer.readLine();

        while (line != null)
        {
            lines = line.split(",");
            try {
                dataAVG = Double.parseDouble(lines[3]);
            }
            catch (Exception e)
            {
                dataAVG = -1;
            }
            if (Objects.equals(lines[2], month) && lines[1].equals(Integer.toString(year)) && dataAVG >= media)
            {
                String selectedLine = lines[0] + " | " + dataAVG + "\n";
                result.append(selectedLine);
                System.out.print(selectedLine);
            }
            line = buffer.readLine();
        }
        return result.toString();
    }

    public void generateFile(int year, String month, String path, String fileName, String data) throws Exception
    {
        //TODO validate year
        //TODO validate month
        //TODO validate path
        //TODO validate fileName

        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File file = new File(path, fileName);
            FileWriter openFile = new FileWriter(file, file.exists());

            PrintWriter escreveArq = new PrintWriter(openFile);
            escreveArq.write(data);
            escreveArq.flush();
            escreveArq.close();
            openFile.close();
        }
        else
            throw new Exception("Diretório invalido");
    }
}
