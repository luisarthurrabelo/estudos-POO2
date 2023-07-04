package PersonagemFactory;

import Personagem.*;

public class PersonagemFactory {

    public static Personagem getPersonagem(String classePersonagem, String name) {

        if (classePersonagem == null)
            return null;
        else if (classePersonagem.equals("Assault"))
            return new PersonagemAssault(name);
        else if (classePersonagem.equals("Engineer"))
            return new PersonagemEngineer(name);
        else if (classePersonagem.equals("Medic"))
            return new PersonagemMedic(name);
        else if (classePersonagem.equals("Soldier"))
            return new PersonagemSoldier(name);
        else
            return null;
    }
}
