package Personagem;

public class PersonagemMedic extends Personagem {

    public PersonagemMedic(String name) {
        super(name);
        inventory = new String[] { "3x Bandage", "1x Adrenaline", "1x Antidote" };
    }

}
