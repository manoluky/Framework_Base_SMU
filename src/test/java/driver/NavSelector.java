package driver;

import constants.Navegador;

import static constants.Navegador.*;

public class NavSelector {


    static Navegador nav;

    public static Navegador seleccionNavegador(String navegador) {
        switch (navegador.trim()) {
            case "Chrome" -> {
                nav = Chrome;
                return nav;
            }
            case "ChromeBS" -> {
                nav = ChromeBS;
                return nav;
            }
            case "Edge" -> {
                nav = Edge;
                return nav;
            }
            case "Firefox" -> {
                nav = Firefox;
                return nav;
            }
            case "Safari" -> {
                nav = Safari;
                return nav;
            }
        }
        return Chrome;
    }

}
