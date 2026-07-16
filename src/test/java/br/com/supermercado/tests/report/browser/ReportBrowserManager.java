package br.com.supermercado.tests.report.browser;


import java.awt.Desktop;
import java.io.File;


public class ReportBrowserManager {


    public static void abrir(File arquivo) {


        try {


            if (Desktop.isDesktopSupported()) {


                Desktop.getDesktop()
                        .browse(
                                arquivo.toURI()
                        );

            }


        } catch (Exception e) {


            System.out.println(
                    "Não foi possível abrir relatório automaticamente"
            );

        }

    }

}