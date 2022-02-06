/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.model;

import br.com.sistema.view.FrmTema;
import br.com.sistema.view.FrmMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Tampelini
 */
public class Utilitarios {

    // Método para limpar campos das telas
    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);

            }
        }
    }

    public double converterVirgulaParaPontoReturn(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }

        return (float) Double.parseDouble(retorno);
    }

    // Método e atributos para escolher imagem para o sistema
    public void escolheImagem(JTextField txtFile) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurar imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png");

        fileChooser.setFileFilter(filter);

        int retorno = fileChooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            txtFile.setText(file.getPath());
        }
    }
    // Métodos para alterar cores do sistema
    public void escolheCor(JTextField txtTema){
        JColorChooser escolheCor = new JColorChooser();
        
        Color cor = JColorChooser.showDialog(null, "Escolha uma cor ", Color.blue);
                
        if(cor != null){            
            String red = Integer.toHexString(cor.getRed());
            String green = Integer.toHexString(cor.getGreen());
            String blue = Integer.toHexString(cor.getBlue());
            
            String corRGB = red + green + blue;
            
            
            txtTema.setText(corRGB);
        }
    }

    // Gerenciamento de tema do sistema
    public String[] getConfigJson() {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();

        String arquivo = "./src/config/config.json";
        String[] tema = new String[6];
        try {
            try ( FileReader f = new FileReader(arquivo)) {
                jsonObject = (JSONObject) parser.parse(f);
            }
            tema[0] = (String) jsonObject.get("Logo");
            tema[1] = (String) jsonObject.get("Nome");
            tema[2] = (String) jsonObject.get("CorPrimaria");
            tema[3] = (String) jsonObject.get("CorSecundaria");
            tema[4] = (String) jsonObject.get("LetraPrimaria");
            tema[5] = (String) jsonObject.get("LetraSecundaria");

            return tema;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // public static void setConfigJson(String fundo, String logo, Color corPrimaria, Color corSecundaria){
    public void setConfigJson(String imagem, String nome, String corPrimaria, String corSecundaria,
                                String letraPrimaria, String letraSecundaria) {
        FileWriter writeJson = null;
        String arquivo = "./src/config/config.json";
        JSONObject jsonObject = new JSONObject();

        try {
            //preenche o objeto com os campos do tema
            jsonObject.put("Logo", imagem);
            jsonObject.put("Nome", nome);
            jsonObject.put("CorPrimaria",corPrimaria);
            jsonObject.put("CorSecundaria",corSecundaria);
            jsonObject.put("LetraPrimaria",letraPrimaria);
            jsonObject.put("LetraSecundaria",letraSecundaria);
            
            writeJson = new FileWriter(arquivo);
            writeJson.write(jsonObject.toString());
        } catch (IOException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writeJson.close();
            } catch (IOException ex) {
                Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
