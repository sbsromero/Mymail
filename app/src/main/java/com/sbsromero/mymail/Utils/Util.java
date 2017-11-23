package com.sbsromero.mymail.Utils;

import com.sbsromero.mymail.models.Mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sumset on 27/10/17.
 */

public class Util {

    public static String[] colors = new String[]
            {
              "#EC122F","#223651","#2FE347","#77614F","#77614F","#302F88"
                    ,"#A3F17F","#F6520B"
            };

    public static List<Mail> getDummyData(){
        return new ArrayList<Mail>() {{
            add(new Mail("Presupuesto 2017", "Hola usuarios este es el presupuesto del año 2017", "presupuesto@gmail.com"));
            add(new Mail("Cena empresa", "Queridos amigos la cena de esta año se llevara a cabo en tal lugar", "cenaempresa@gmail.com"));
            add(new Mail("Oferta de empleo: Android developer", "Hola estamos buscando desarrolladores android sin experiencia alguna", "ofertaempleo@gmail.com"));
        }};
    }

    public static String getRandomColor(){
        int randomColor = new Random().nextInt(colors.length)+0;
        return colors[randomColor];
    }
}
