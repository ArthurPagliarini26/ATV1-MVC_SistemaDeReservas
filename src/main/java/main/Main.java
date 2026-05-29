package main;

import controller.*;
import model.repository.*;
import model.service.*;
import view.SistemaView;

public class Main {
    public static void main(String[] args) {

        SistemaView view = new SistemaView();
        view.iniciar();
    }
}