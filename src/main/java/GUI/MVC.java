package GUI;

import GUI.ControllerPB;
import GUI.ViewPB;

import javax.swing.*;

public class MVC {

    public static void main(String[] args) {

        ViewPB view = new ViewPB();
        ControllerPB controller = new ControllerPB(view);
        view.setVisible(true);

    }

}
