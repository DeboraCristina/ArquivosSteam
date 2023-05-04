package view;

import view.control.SteamController;

public class Main
{
    public static void main(String[] args) {
        SteamController steam = new SteamController();
        String dataGames = null;
        int year = 2020;
        String month = "January";
        double m = 501196;
        String path = "C:\\Users\\dti\\Downloads\\";
        String file = "AAAAH.csv";

        try {
            dataGames = steam.findGames(year, month, m);
            steam.generateFile(year, month, path, file, dataGames);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
