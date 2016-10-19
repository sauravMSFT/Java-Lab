package com.lab.applet;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

/**
 * Created by saurav_msft on 7/29/2016.
 */

/*

<applet code='com.lab.applet.Parameter'
    width=1366
    height=768>

    <param name='Font Name' value='Ubuntu Mono'/>
    <param name='Font Size' value='20' />

</applet>

 */


public class Parameter extends Applet
{
    String[] keys = new String[]{"Font Name", "Font Size"};
    String fontName = "Font Name", fontSize = "Font Size";
    private HashMap<String, String> setupData()
    {

        HashMap<String, String> dict = new HashMap<>();

        for (String key : keys)
        {
            String value = getParameter(key);
            if (value != null)
                dict.put(key, value);
        }

        dict.put("Code Base", getCodeBase().toString());
        dict.put("Document Base", getDocumentBase().toString());
        return dict;
    }

    public void paint(Graphics g)
    {
        HashMap<String, String> res = setupData();
        if (res.containsKey(fontName) && res.containsKey(fontSize))
        {
            try
            {
                Font font = new Font(res.get(fontName),
                                     Font.PLAIN,
                                     Integer.parseInt(res.get(fontSize)));
                g.setFont(font);
            }
            catch (Exception e) {}
        }
        Printer p = new Printer(g);
        for (String key : res.keySet())
        {
            p.print(String.format("%1$s: %2$s", key, res.get(key)));
        }
    }

}

